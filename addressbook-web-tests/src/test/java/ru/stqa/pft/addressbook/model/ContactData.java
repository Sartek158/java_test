package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String id;
  private final String firstname;
  private final String lastname;
  private final String company;
  private final String phone;
  private final String email;
  private final String bday;
  private final String bmonth;
  private final String byear;
  private final String group;

  public ContactData(String firstname, String lastname, String company, String phone, String email, String bday, String bmonth, String byear, String group) {
    this.id = null;
    this.firstname = firstname;
    this.lastname = lastname;
    this.company = company;
    this.phone = phone;
    this.email = email;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public ContactData(String id, String firstname, String lastname, String company, String phone, String email, String bday, String bmonth, String byear, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.company = company;
    this.phone = phone;
    this.email = email;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.group = group;
  }

  public String getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getCompany() {
    return company;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getGroup() {
    return group;
  }
}
