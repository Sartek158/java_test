package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    initContactCreation();
    fillContactForm(new ContactData("Ivan", "Medvedev", "QA", "root@goofle.com", "1", "April", "1991"));
    submitContactCreation();
    returnToContactPage();
  }

}
