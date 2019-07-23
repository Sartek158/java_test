package ru.stqa.pft.mantis.appmanager;

public class NavigationHelper extends HelperBase {

    NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void toLoginPage() {
        wd.get(app.getProperty("web.BaseUrl"));
    }
}