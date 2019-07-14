package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {


    private static String cleaned(String phones) {
        return phones.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().count() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Ivan").withLastName("Medvedev")
                    .withFirstPhone("+7(995)77").withSecondPhone("916020").withThirdPhone("965 121 55")
                    .withFirstEmail("nagibator@mail.com").withSecondEmail("gg@gmail.com")
                    .withThirdEmail("chill@local.org")
                    .withAddress("Moscow, Arbat 19, flat 15"));
        }
    }

    @Test
    public void testContactPhone() {
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getFirstEmail(), contact.getSecondEmail(), contact.getThirdEmail()).stream()
                .filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getFirstPhone(), contact.getSecondPhone(), contact.getThirdPhone()).stream()
                .filter((s) -> !s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

}
