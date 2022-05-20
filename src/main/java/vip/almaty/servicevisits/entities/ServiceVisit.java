package vip.almaty.servicevisits.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ServiceVisit {

    @Id
    Long servicevisitId;
    Date serviceVisitDate;
    @OneToOne
    @MapsId
    ServiceVisitType srvcVisitType;

    @OneToOne
    @MapsId
    User user;

   @ManyToOne
   Analyzer anlz;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name="service_sparepart",
            joinColumns=@JoinColumn(name="servicevisit_id"),
            inverseJoinColumns= @JoinColumn(name="sparepart_id")
    )
   List<SparePart> sparePartsInstalled;

    String note;

    public User getUser() {
        return user;
    }


    public Long getServicevisitId() {
        return servicevisitId;
    }

    public void setServicevisitId(Long servicevisitId) {
        this.servicevisitId = servicevisitId;
    }

    public Date getServiceVisitDate() {
        return serviceVisitDate;
    }

    public void setServiceVisitDate(Date date) {
        this.serviceVisitDate = date;
    }

    public Analyzer getAnlz() {
        return anlz;
    }

    public void setAnlz(Analyzer analyzer) {
        this.anlz = analyzer;
    }

    public List<SparePart> getSparePartsInstalled() {
        return sparePartsInstalled;
    }

    public void setSparePartsInstalled(List<SparePart> sparePartsInstalled) {
        this.sparePartsInstalled = sparePartsInstalled;
    }

    public ServiceVisitType getSrvcVisitType() {
        return srvcVisitType;
    }

    public void setSrvcVisitType(ServiceVisitType serviceVisitType) {
        this.srvcVisitType = serviceVisitType;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
