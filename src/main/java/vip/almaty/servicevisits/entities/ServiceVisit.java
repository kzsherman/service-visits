package vip.almaty.servicevisits.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ServiceVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "visit_id")
    Long visitId;
    Date serviceVisitDate;
    @OneToOne
    ServiceVisitType srvcVisitType;

    @OneToOne
    User user;

   @ManyToOne
   Analyzer anlz;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name="service_sparepart",
            joinColumns=@JoinColumn(name="visit_id"),
            inverseJoinColumns= @JoinColumn(name="part_id")
    )
   List<SparePart> sparePartsInstalled;

    String note;


    public ServiceVisit() {
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Date getServiceVisitDate() {
        return serviceVisitDate;
    }

    public void setServiceVisitDate(Date serviceVisitDate) {
        this.serviceVisitDate = serviceVisitDate;
    }

    public ServiceVisitType getSrvcVisitType() {
        return srvcVisitType;
    }

    public void setSrvcVisitType(ServiceVisitType srvcVisitType) {
        this.srvcVisitType = srvcVisitType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Analyzer getAnlz() {
        return anlz;
    }

    public void setAnlz(Analyzer anlz) {
        this.anlz = anlz;
    }

    public List<SparePart> getSparePartsInstalled() {
        return sparePartsInstalled;
    }

    public void setSparePartsInstalled(List<SparePart> sparePartsInstalled) {
        this.sparePartsInstalled = sparePartsInstalled;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
