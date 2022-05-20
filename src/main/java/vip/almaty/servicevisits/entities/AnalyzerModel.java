package vip.almaty.servicevisits.entities;

import javax.persistence.*;

@Entity
public class AnalyzerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long analyzermodelId;
    String analyzerProductNumber;
    @OneToOne
    AnalyzerType anlzType;
    @OneToOne
    Manufacturer manufact;
    String analyzerName;



    public Long getAnalyzermodelId() {
        return analyzermodelId;
    }

    public void setAnalyzermodelId(Long analyzermodelId) {
        this.analyzermodelId = analyzermodelId;
    }

    public String getAnalyzerProductNumber() {
        return analyzerProductNumber;
    }

    public void setAnalyzerProductNumber(String analyzerProductNumber) {
        this.analyzerProductNumber = analyzerProductNumber;
    }

    public AnalyzerType getAnlzType() {
        return anlzType;
    }

    public void setAnlzType(AnalyzerType analyzerType) {
        this.anlzType = analyzerType;
    }

    public Manufacturer getManufact() {
        return manufact;
    }

    public void setManufact(Manufacturer manufacturer) {
        this.manufact = manufacturer;
    }

    public String getAnalyzerName() {
        return analyzerName;
    }

    public void setAnalyzerName(String analyzerName) {
        this.analyzerName = analyzerName;
    }

    @Override
    public String toString() {
        return "AnalyzerModel{" +
                "analyzermodelId=" + analyzermodelId +
                ", analyzerProductNumber='" + analyzerProductNumber + '\'' +
                ", analyzerType=" + anlzType +
                ", manufacturer=" + manufact +
                ", analyzerName='" + analyzerName + '\'' +
                '}';
    }
}
