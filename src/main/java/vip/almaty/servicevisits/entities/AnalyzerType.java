package vip.almaty.servicevisits.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnalyzerType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long anlzTypeId;
    String anlzType;

    public Long getAnlzTypeId() {
        return anlzTypeId;
    }

    public void setAnlzTypeId(Long id) {
        this.anlzTypeId = id;
    }

    public String getAnlzType() {
        return anlzType;
    }

    public void setAnlzType(String analyzerType) {
        this.anlzType = analyzerType;
    }
}
