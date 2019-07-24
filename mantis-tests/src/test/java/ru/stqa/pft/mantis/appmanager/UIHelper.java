package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.testng.Assert;

public class UIHelper extends HelperBase {

    public UIHelper(ApplicationManager app) {
        super(app);
    }

    public UIHelper loginAsAdmin() {
        app.navigate().toLoginPage();
        String adminLogin = app.getProperty("web.adminLogin");
        String adminPassword = app.getProperty("web.adminPassword");
        type(By.name("username"), adminLogin);
        type(By.name("password"), adminPassword);
        click(By.cssSelector("[value='Войти']"));
        Assert.assertTrue(element(By.xpath("/html//span[@id='logged-in-user']")).getText().equals(adminLogin));
        return this;
    }


    public UIHelper management() {
        click(By.cssSelector(".manage-menu-link"));
        return this;
    }

    public UIHelper users() {
        click(By.xpath("//li/a[text()='Управление пользователями']"));
        return this;
    }

}