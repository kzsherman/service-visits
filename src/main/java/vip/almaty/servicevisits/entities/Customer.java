package vip.almaty.servicevisits.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {

    @Id
    Long customerId;
    String name;
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
}
