package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;


@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

    @XStreamOmitField
    @Expose
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name = "firstname")
    private String firstname;

    @Expose
    @Column(name = "lastname")
    private String lastname;

    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String firstphone;

    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private String firstemail;

    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String secondphone;

    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String thirdphone;

    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Expose
    @Column(name = "email2")
    @Type(type = "text")
    private String secondemail;

    @Expose
    @Column(name = "email3")
    @Type(type = "text")
    private String thirdemail;

    @Transient
    private String phones;

    @Transient
    private String emails;

    @Transient
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (firstphone != null ? !firstphone.equals(that.firstphone) : that.firstphone != null) return false;
        if (firstemail != null ? !firstemail.equals(that.firstemail) : that.firstemail != null) return false;
        if (secondphone != null ? !secondphone.equals(that.secondphone) : that.secondphone != null) return false;
        if (thirdphone != null ? !thirdphone.equals(that.thirdphone) : that.thirdphone != null) return false;
        if (secondemail != null ? !secondemail.equals(that.secondemail) : that.secondemail != null) return false;
        if (thirdemail != null ? !thirdemail.equals(that.thirdemail) : that.thirdemail != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (firstphone != null ? firstphone.hashCode() : 0);
        result = 31 * result + (firstemail != null ? firstemail.hashCode() : 0);
        result = 31 * result + (secondphone != null ? secondphone.hashCode() : 0);
        result = 31 * result + (thirdphone != null ? thirdphone.hashCode() : 0);
        result = 31 * result + (secondemail != null ? secondemail.hashCode() : 0);
        result = 31 * result + (thirdemail != null ? thirdemail.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
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


}
