package ru.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactRemoveFromGroupTest extends TestBase {

        private ContactData contactToRemove;
        private GroupData groupToRemoveFrom;

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

            for (ContactData contact : app.db().contacts()){
                if (contact.getGroups().size() == 1){
                    contactToRemove = contact;
                }
            }

            if (contactToRemove == null){
                app.goTo().homePage();
                contactToRemove = app.db().contacts().iterator().next().inGroup(app.db().groups().iterator().next());
                app.contact().addToGroup(contactToRemove);
            }

            groupToRemoveFrom = contactToRemove.getGroups().iterator().next();
        }

        @Test
        public void removeContactFromGroup(){
            app.goTo().homePage();
            app.contact().removeContactFromGroup(contactToRemove);
            app.db().refreshContact(contactToRemove);
            app.db().refreshGroup(groupToRemoveFrom);
            assertThat(contactToRemove.getGroups(), CoreMatchers.not(hasItem(groupToRemoveFrom)));
            assertThat(groupToRemoveFrom.getContacts(), CoreMatchers.not(hasItem(contactToRemove)));
        }
    }

