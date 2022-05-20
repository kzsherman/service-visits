package vip.almaty.servicevisits.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long manufactId;
    String manufacturerName;
    String supportNumber;
    String websiteURL;
    Boolean primaryVendor;
    @OneToMany (mappedBy = "analyzermodelId")
    Set<AnalyzerModel> analyzerModels = new TreeSet<>();

    public Long getManufactId() {
        return manufactId;
    }

    public void setManufactId(Long id) {
        this.manufactId = id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getSupportNumber() {
        return supportNumber;
    }

    public void setSupportNumber(String supportNumber) {
        this.supportNumber = supportNumber;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public Set<AnalyzerModel> getAnalyzerModels() {
        return analyzerModels;
    }

    public void setAnalyzerModels(Set<AnalyzerModel> analyzerModels) {
        this.analyzerModels = analyzerModels;
    }

    public Boolean getPrimaryVendor() {
        return primaryVendor;
    }

    public void setPrimaryVendor(Boolean primaryVendor) {
        this.primaryVendor = primaryVendor;
    }
}
