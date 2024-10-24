package Tests.ObjectModels;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginModel {
    private AccountModel account;
    private String userError;
    private String passwordError;

    public LoginModel() {    } //NoArgsConstructor

    //AllArgsConstructor - used for csv data provider
    public LoginModel(String username, String password, String userError, String passwordError) {
        AccountModel ac = new AccountModel();
        ac.setUsername(username);
        ac.setPassword(password);

        this.account = ac;
        this.userError = userError;
        this.passwordError = passwordError;
    }

    public AccountModel getAccount() {return account;}
    @XmlElement
    public void setAccount(AccountModel account) {
        this.account = account;
    }
    @XmlElement
    public String getUserError() {return userError;}
    @XmlElement
    public void setUserError(String userError) {
        this.userError = userError;
    }
    public String getPasswordError() {return passwordError;}
    @XmlElement
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "account={username:" + account.getUsername() + ",password:" + account.getPassword() +
                "}, userError='" + userError + '\'' +
                ", passwordError='" + passwordError + '\'' +
                '}';
    }
}
