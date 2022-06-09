package vip.almaty.servicevisits.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long customerId;
    String name;

    String zipCode;

    String address;

    Boolean isCustomerVip;
    @OneToMany (mappedBy = "analyzerId")
    List<Analyzer> analyzers;

    @OneToMany (mappedBy = "contactPersonId")
    List<ContactPerson> contactPersons;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Analyzer> getAnalyzers() {
        return analyzers;
    }

    public void setAnalyzers(List<Analyzer> analyzers) {
        this.analyzers = analyzers;
    }

    public List<ContactPerson> getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(List<ContactPerson> contactPersons) {
        this.contactPersons = contactPersons;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getCustomerVip() {
        return isCustomerVip;
    }

    public void setCustomerVip(Boolean customerVip) {
        isCustomerVip = customerVip;
    }
}
