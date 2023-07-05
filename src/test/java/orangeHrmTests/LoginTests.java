package orangeHrmTests;

import app.orangeHrm.Login;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    Login login;

    @BeforeMethod
    public void setup(){
        login = new Login();
    }
    @Test
    public void loginTest() throws InterruptedException {
        System.out.println(login.loginApplication("Admin","admin123"));
    }
}
