package vip.almaty.servicevisits.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ContactPerson {

    @Id
    Long contactPersonId;
    String name;
    String phoneNumber;
    Boolean vip;
    Boolean hasAuthority;
    String notes;

    @ManyToOne
    Customer customr;

    public Long getContactPersonId() {
        return contactPersonId;
    }

    public void setContactPersonId(Long contactpersonId) {
        this.contactPersonId = contactpersonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Customer getCustomr() {
        return customr;
    }

    public void setCustomr(Customer customer) {
        this.customr = customer;
    }
}
