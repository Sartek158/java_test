package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddToGroupTest extends TestBase {


    @BeforeTest
    public void ensurePreconditions(){
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1").withHeader("test1").withFooter("test1"));
        }
        if (app.db().contacts().size() == 0){
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstName("Ivan").withLastName("Medvedev").withFirstPhone("+79269009911")
                    .withFirstEmail("root@goofle.com").withSecondPhone("+79167517733").withThirdPhone("+79035218822")
                    .withAddress("Veresaeva Street 10, flat 5").withSecondEmail("auto@yandex.ru").withThirdEmail("test@chrome.org"));
        }
    }

    @Test
    public void addContactToGroup(){
        app.goTo().homePage();
        ContactData contactToAdd = app.db().contacts().iterator().next();
        GroupData groupToAddTo = app.db().groups().iterator().next();
        app.contact().addToGroup(contactToAdd.inGroup(groupToAddTo));
        app.db().refreshContact(contactToAdd);
        app.db().refreshGroup(groupToAddTo);
        assertThat(contactToAdd.getGroups(), hasItem(groupToAddTo));
        assertThat(groupToAddTo.getContacts(), hasItem(contactToAdd));
    }
}