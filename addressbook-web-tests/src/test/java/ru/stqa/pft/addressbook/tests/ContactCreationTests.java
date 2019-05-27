package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.initContactCreation();
    app.fillContactForm(new ContactData("Ivan", "Medvedev", "QA", "root@goofle.com", "1", "April", "1991"));
    app.submitContactCreation();
    app.returnToContactPage();
  }

}
