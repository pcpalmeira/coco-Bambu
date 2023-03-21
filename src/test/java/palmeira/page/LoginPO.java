package palmeira.page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(id="username")
    public WebElement inputEmail;

    @FindBy(id = "password")
    public WebElement inputSenha;

    @FindBy(id="content")
    public WebElement buttonEntrar;
    
    @FindBy(id="username")
    public WebElement spanMensagemEmail;

    @FindBy(id="formUserPass")
    public WebElement spanMensagemSenha;

    public LoginPO(WebDriver driver) {
        super(driver);
        
    }

    public String obterMensagemEmail(){
        return spanMensagemEmail.getText();
    }

    public String obterMensagemSenha(){
    return spanMensagemSenha.getText();
    }
    
    public void executarLogin(String email, String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        
        buttonEntrar.click();
    }

}
