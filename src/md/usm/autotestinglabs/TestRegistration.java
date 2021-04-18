package md.usm.autotestinglabs;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRegistration {

    private RegistrationPage registrationPage;

    @BeforeMethod
    public void setup() {
        registrationPage = new RegistrationPage("login", "password", "mail@example.com");
    }

    @Test
    public void positiveTest() {
        registrationPage.setLoginByInputName("name");
        registrationPage.setPasswordByInputName("passwordOne", "passwordTwo");
        registrationPage.setEmailByInputName("email");
    }

    @Test
    public void negativeTest() {
        registrationPage.setLogin("404");

        registrationPage.setLoginByInputName("name");
        registrationPage.setPasswordByInputName("passwordOne", "passwordTwo");
        registrationPage.setEmailByInputName("email");
    }

}