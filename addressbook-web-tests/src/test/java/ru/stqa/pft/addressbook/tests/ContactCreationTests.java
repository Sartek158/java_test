package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        app.contact().initContactCreation();
        ContactData contact = new ContactData().withFirstname("Ivan").withLastname("Medvedev").withCompany("QA").withPhone("+79269009911").withEmail("root@goofle.com").withBday("1").withBmonth("April").withByear("1991").withGroup("test1");
        app.contact().fillContactForm(contact, true);
        app.contact().submitContactCreation();
        app.contact().returnToHomePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);


        contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }

}

