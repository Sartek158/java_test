package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstName("Ivan").withLastName("Medvedev").withFirstPhone("+79269009911").withFirstEmail("root@goofle.com").withSecondPhone("+79167517733").withThirdPhone("+79035218822").withAddress("Veresaeva Street 10, flat 5").withSecondEmail("auto@yandex.ru").withThirdEmail("test@chrome.org"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Ivan").withLastName("Medvedev").withFirstPhone("+79269009911").withFirstEmail("root@goofle.com").withSecondPhone("+79167517733").withThirdPhone("+79035218822").withAddress("Veresaeva Street 10, flat 5").withSecondEmail("auto@yandex.ru").withThirdEmail("test@chrome.org");
        app.goTo().homePage();
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }

}
