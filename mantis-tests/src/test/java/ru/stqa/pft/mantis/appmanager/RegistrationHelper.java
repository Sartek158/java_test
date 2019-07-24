package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.User;

public class RegistrationHelper extends HelperBase {

    RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.BaseUrl") + "signup_page.php");
        type(By.name("username"), username);
        type(By.name("email"), email);
        click(By.cssSelector("input[value='Зарегистрироваться']"));
    }

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input.button"));
    }

    public RegistrationHelper selectUser(User user) {
        click(By.xpath(String.format("//td/a[text()='%s']", user.getUsername())));
        return this;
    }

    public void changePassword() {
        click(By.xpath("//input[@value='Сбросить пароль']"));
    }
}