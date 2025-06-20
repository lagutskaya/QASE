package pages;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {

    private final String EMAIL_CSS = "[name=email]";
    private final String PASSWORD_CSS = "[name=password]";

    public LoginPage openPage() {
        log.info("Login page is opened");
        open("/login");
        return this;
    }

    public LoginPage login(String email, String password) {
        log.info("User has authorized with credentials : {} {}", email, password);
        $(EMAIL_CSS).setValue(email);
        $(PASSWORD_CSS).setValue(password).submit();
        return this;
    }
}
