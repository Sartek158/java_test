package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {


    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContact(count);
        save(contacts, new File(file));
    }

    private void  save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s:%s:%s:%s:%s:%s:%s:%s:%s\n", contact.getFirstname(), contact.getLastname(), contact.getFirstPhone(), contact.getSecondPhone(), contact.getThirdPhone(), contact.getAddress(), contact.getFirstEmail(), contact.getSecondEmail(), contact.getThirdEmail()));
        }
        writer.close();
    }

    private List<ContactData> generateContact(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData()
                    .withFirstName(String.format("firstName %s", i))
                    .withLastName(String.format("lastName %s", i))
                    .withFirstPhone(String.format("+650 65 54 %s", i))
                    .withSecondPhone(String.format("+(99)66 421 564 %s", i))
                    .withThirdPhone(String.format("9851 3212 132%s", i))
                    .withAddress(String.format("Wall Stret 19, flat %s", i))
                    .withFirstEmail(String.format("john%s@smith.org", i))
                    .withSecondEmail(String.format("j.smith198%s@gmail.com", i))
                    .withThirdEmail(String.format("john198%s@gmail.com", i))
            );
        }
        return contacts;
    }
}
