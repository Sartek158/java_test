package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String company;
  private final String email;
  private final String bday;
  private final String bmonth;
  private final String byear;
  private String group;

  public ContactData(String firstname, String lastname, String company, String email, String bday, String bmonth, String byear, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.company = company;
    this.email = email;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.group = group;
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
