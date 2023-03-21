package palmeira.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import palmeira.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {

    public static LoginPO loginPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC201_naoDeveLogarComCredenciaisVazias(){
    
        loginPage.executarLogin("", "");
        String mensagemEmail = loginPage.obterMensagemEmail();
        String mensagemSenha = loginPage.obterMensagemSenha();

        assertEquals(mensagemEmail, "E-mail é obrigatório");
        assertEquals(mensagemSenha, "Senha é obrigatoria");
    }

    @Test
    public void TC202_naoDeveLogarComEmailIncorretoESenhaVazia(){
        loginPage.executarLogin("TESTE", "");
        String mensagemEmail = loginPage.obterMensagemEmail();
        String mensagemSenha = loginPage.obterMensagemSenha();

        assertEquals(mensagemEmail, "E-mail inválido");
        assertEquals(mensagemSenha, "Senha é obrigatótia");

    }

    @Test
    public void TC203_naoDeveLogarComEmailVazioESenhaIncorreta(){
    
        loginPage.executarLogin("", "TESTE");
        String mensagemEmail = loginPage.obterMensagemEmail();
        String mensagemSenha = loginPage.obterMensagemSenha();

        assertEquals(mensagemEmail, "E-mail é obrigatório");
        assertEquals(mensagemSenha, "Senha deve conter no minímo 6 caracteres");
    }

    @Test
    public void TC204_naoDeveLogarComCredenciaisInvalidas(){
    
        loginPage.executarLogin("TESTE", "TESTE");
        String mensagemEmail = loginPage.obterMensagemEmail();
        String mensagemSenha = loginPage.obterMensagemSenha();

        assertEquals(mensagemEmail, "E-mail inválido");
        assertEquals(mensagemSenha, "Senha deve conter no minímo 6 caracteres");
    }
    
    @Test
    public void TC205_naoDeveLogarSemPreencherSenha(){
    
        loginPage.executarLogin("pc@gmail.com", "");
        String mensagemEmail = loginPage.obterMensagemEmail();
        String mensagemSenha = loginPage.obterMensagemSenha();

        assertEquals(mensagemEmail, "");
        assertEquals(mensagemSenha, "Senha é obrigatória");
    }

    @Test
    public void TC206_naoDeveLogarSemPreencherEmail(){
    
        loginPage.executarLogin("", "TESTE12");
        String mensagemEmail = loginPage.obterMensagemEmail();
        String mensagemSenha = loginPage.obterMensagemSenha();

        assertEquals(mensagemEmail, "E-mail é obrigatório");
        assertEquals(mensagemSenha, "");
    }

    @Test
    public void TC207_naoDeveLogarComEmailESenhaIncorretos(){
    
        loginPage.executarLogin("pc@gmail.com", "TESTE12");
        String mensagemEmail = loginPage.obterMensagemEmail();
        String mensagemSenha = loginPage.obterMensagemSenha();

        assertEquals(mensagemEmail, "");
        assertEquals(mensagemSenha, "E-Mail ou senha inválidos");
    }

    @Test
    public void TC208_naoDeveLogarComSenhaIncorreta(){
    
        loginPage.executarLogin("pedrocelso.palmeira@gmail.com", "Admin@12");
        String mensagemEmail = loginPage.obterMensagemEmail();
        String mensagemSenha = loginPage.obterMensagemSenha();

        assertEquals(mensagemEmail, "");
        assertEquals(mensagemSenha, "E-Mail ou senha inválidos");
    }

    @Test
    public void TC209_naoDeveLogarComEmailIncorreto(){
    
        loginPage.executarLogin("pedrocelso.palmeira@gmail.co", "Admin@123");
        String mensagemEmail = loginPage.obterMensagemEmail();
        String mensagemSenha = loginPage.obterMensagemSenha();

        assertEquals(mensagemEmail, "");
        assertEquals(mensagemSenha, "E-Mail ou senha inválidos");
    }

    @Test
    public void TC210_naoDeveLogarComEmailEmLetraMaiuscula(){
    
        loginPage.executarLogin("PEDROCELSO.PALMEIRA@GMAIL.COM", "Admin@123");
        String mensagemEmail = loginPage.obterMensagemEmail();
        String mensagemSenha = loginPage.obterMensagemSenha();

        assertEquals(mensagemEmail, "");
        assertEquals(mensagemSenha, "E-Mail ou senha inválidos");
    }

    @Test
    public void TC211_DeveLogarComEmailESenhaCorretos(){
    
        loginPage.executarLogin("pedrocelso.palmeira@gmail.com", "Admin@123");
        
        assertEquals(loginPage.obterTituloPagina(), "Delivery");
    }
}


