package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;

import java.io.File;

public class ContactData {
    @Expose
    private int id = Integer.MAX_VALUE;
    @Expose
    private String firstname;
    @Expose
    private String lastname;
    @Expose
    private String company;
    @Expose
    private String firstphone;
    @Expose
    private String firstemail;
    @Expose
    private String secondphone;
    @Expose
    private String thirdphone;
    private String phones;
    @Expose
    private String secondemail;
    @Expose
    private String thirdemail;
    private String emails;
    @Expose
    private String address;
    private File photo;


    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }


    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withFirstPhone(String firstphone) {
        this.firstphone = firstphone;
        return this;
    }

    public ContactData withFirstEmail(String firstemail) {
        this.firstemail = firstemail;
        return this;
    }

    public ContactData withSecondPhone(String secondphone) {
        this.secondphone = secondphone;
        return this;
    }

    public ContactData withThirdPhone(String thirdphone) {
        this.thirdphone = thirdphone;
        return this;
    }

    public ContactData withPhones(String phones) {
        this.phones = phones;
        return this;
    }


    public ContactData withSecondEmail(String secondemail) {
        this.secondemail = secondemail;
        return this;
    }

    public ContactData withThirdEmail(String thirdemail) {
        this.thirdemail = thirdemail;
        return this;
    }

    public ContactData withEmails(String emails) {
        this.emails = emails;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }


    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public File getPhoto() {
        return photo;
    }

    public String getCompany() {
        return company;
    }


    public String getFirstPhone() {
        return firstphone;
    }

    public String getFirstEmail() {
        return firstemail;
    }


    public String getSecondPhone() {
        return secondphone;
    }

    public String getThirdPhone() {
        return thirdphone;
    }

    public String getPhones() {
        return phones;
    }

    public String getSecondEmail() {
        return secondemail;
    }

    public String getThirdEmail() {
        return thirdemail;
    }

    public String getEmails() {
        return emails;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

}
