package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        File photo = new File("src/test/resources/stru.jpg");
        list.add(new Object[] {new ContactData().withFirstName("Ivan").withLastName("Medvedev").withCompany("QA").withFirstPhone("+79269009911").withFirstEmail("root@goofle.com").withBday("1").withBmonth("April").withByear("1991").withGroup("test1").withPhoto(photo)});
        list.add(new Object[] {new ContactData().withFirstName("Petr").withLastName("Medvedev").withCompany("PA").withFirstPhone("+79569009925").withFirstEmail("root@goofle.ru").withBday("2").withBmonth("June").withByear("1992").withGroup("test2").withPhoto(photo)});
        list.add(new Object[] {new ContactData().withFirstName("Dmitriy").withLastName("Medvedev").withCompany("DA").withFirstPhone("+79169009935").withFirstEmail("root@goofle.org").withBday("3").withBmonth("July").withByear("1993").withGroup("test3").withPhoto(photo)});
        return list.iterator();
    }


    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}

