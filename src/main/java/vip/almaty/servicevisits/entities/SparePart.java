package vip.almaty.servicevisits.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class SparePart {

    @Id
    Long partId;
    String sparepartNumber;
    String sparepartName;
    BigDecimal sparepartPrice;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name="service_sparepart",
            joinColumns=@JoinColumn(name="part_id"),
            inverseJoinColumns= @JoinColumn(name="visit_id")
    )
    List<ServiceVisit> serviceVisits;

    public Long getSparepartId() {
        return partId;
    }

    public void setSparepartId(Long sparepartId) {
        this.partId = sparepartId;
    }

    public String getSparepartNumber() {
        return sparepartNumber;
    }

    public void setSparepartNumber(String sparepartNumber) {
        this.sparepartNumber = sparepartNumber;
    }

    public String getSparepartName() {
        return sparepartName;
    }

    public void setSparepartName(String sparepartName) {
        this.sparepartName = sparepartName;
    }

    public BigDecimal getSparepartPrice() {
        return sparepartPrice;
    }

    public void setSparepartPrice(BigDecimal sparepartPrice) {
        this.sparepartPrice = sparepartPrice;
    }

    public List<ServiceVisit> getServiceVisits() {
        return serviceVisits;
    }

    public void setServiceVisits(List<ServiceVisit> serviceVisits) {
        this.serviceVisits = serviceVisits;
    }
}
