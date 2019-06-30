package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



    @BeforeMethod
    public void ensurePreconditions(){
        if (app.contact().count() == 0){
            app.contact().create(new ContactData()
                    .withFirstName("Ivan").withLastName("Medvedev")
                    .withFirstPhone("+799577").withSecondPhone("+7916020").withThirdPhone("+7965121")
                    .withAddress("Moscow, Arbat 19, flat 15")
                    .withFirstEmail("nagibator@mail.com").withSecondEmail("gg@gmail.com")
                    .withThirdEmail("chill@local.org"));
        }
    }

    @Test
    public void testContactPhone(){
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getFirstPhone(), equalTo(contactInfoFromEditForm.getFirstPhone()));
        assertThat(contact.getSecondPhone(), equalTo(contactInfoFromEditForm.getSecondPhone()));
        assertThat(contact.getThirdPhone(), equalTo(contactInfoFromEditForm.getThirdPhone()));
        assertThat(contact.getFirstEmail(), equalTo(contactInfoFromEditForm.getFirstEmail()));
        assertThat(contact.getSecondEmail(), equalTo(contactInfoFromEditForm.getSecondEmail()));
        assertThat(contact.getThirdEmail(), equalTo(contactInfoFromEditForm.getThirdEmail()));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));

    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getFirstEmail(), contact.getSecondEmail(), contact.getThirdEmail()).stream()
                .collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getFirstPhone(), contact.getSecondPhone(), contact.getThirdPhone()).stream()
                .filter((s) -> ! s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private static String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
