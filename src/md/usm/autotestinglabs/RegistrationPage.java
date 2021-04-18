package md.usm.autotestinglabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationPage {

    private static final String URL = "Site";

    private String login;
    private String password;
    private String email;
    private ChromeDriver driver;

    public RegistrationPage(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get(URL);
    }

    public RegistrationPage() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get(URL);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ChromeDriver getDriver() {
        return driver;
    }

    public void setDriver(ChromeDriver driver) {
        this.driver = driver;
    }

    public void setLoginByInputName(String loginName) {
        driver.findElement(By.name(loginName)).sendKeys(this.login);
    }

    public void setPasswordByInputName(String passName1, String passName2) {
        driver.findElement(By.name(passName1)).sendKeys(this.password);

        driver.findElement(By.name(passName2)).sendKeys(this.password);
    }

    public void setEmailByInputName(String emailName) {
        driver.findElement(By.name(emailName)).sendKeys(this.email);
    }

    public void clickButtonByInputName(String buttonName) {
        driver.findElement(By.name(buttonName)).click();
    }

}