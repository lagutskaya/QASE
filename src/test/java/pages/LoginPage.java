package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage {

    private final String EMAIL_CSS = "[name=email]";
    private final String PASSWORD_CSS = "[name=password]";

    public LoginPage openPage() {
        open("/login");
        return this;
    }

    public LoginPage login(String email, String password) {
        $(EMAIL_CSS).setValue(email);
        $(PASSWORD_CSS).setValue(password).submit();
        return this;
    }
}
