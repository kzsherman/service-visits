package vip.almaty.servicevisits.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Analyzer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long analyzerId;
    String serialNumber;
    @ManyToOne
    Customer customr;
    @OneToOne
    AnalyzerModel anlzModel;
    Date installationDate;
    Integer warrantyDuration;
    @OneToMany
    List<ServiceVisit> serviceVisits;
    Integer serviceVisitFrequency;
    Integer serviceSupportLife;

    public Long getAnalyzerId() {
        return analyzerId;
    }

    public void setAnalyzerId(Long analyzerId) {
        this.analyzerId = analyzerId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Customer getCustomr() {
        return customr;
    }

    public void setCustomr(Customer customer) {
        this.customr = customer;
    }

    public AnalyzerModel getAnlzModel() {
        return anlzModel;
    }

    public void setAnlzModel(AnalyzerModel analyzerModel) {
        this.anlzModel = analyzerModel;
    }

    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        this.installationDate = installationDate;
    }

    public Integer getWarrantyDuration() {
        return warrantyDuration;
    }

    public void setWarrantyDuration(Integer warrantyDuration) {
        this.warrantyDuration = warrantyDuration;
    }

    public List<ServiceVisit> getServiceVisits() {
        return serviceVisits;
    }

    public void setServiceVisits(List<ServiceVisit> serviceVisits) {
        this.serviceVisits = serviceVisits;
    }

    public Integer getServiceVisitFrequency() {
        return serviceVisitFrequency;
    }

    public void setServiceVisitFrequency(Integer serviceVisitFrequency) {
        this.serviceVisitFrequency = serviceVisitFrequency;
    }

    public Integer getServiceSupportLife() {
        return serviceSupportLife;
    }

    public void setServiceSupportLife(Integer serviceSupportLife) {
        this.serviceSupportLife = serviceSupportLife;
    }

    @Override
    public String toString() {
        return "Analyzer{" +
                "analyzerId=" + analyzerId +
                ", serialNumber='" + serialNumber + '\'' +
                ", customr=" + customr +
                ", anlzModel=" + anlzModel +
                ", installationDate=" + installationDate +
                ", warrantyDuration=" + warrantyDuration +
                ", serviceVisits=" + serviceVisits +
                ", serviceVisitFrequency=" + serviceVisitFrequency +
                ", serviceSupportLife=" + serviceSupportLife +
                '}';
    }
}
