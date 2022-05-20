package vip.almaty.servicevisits.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ServiceVisitType {

    @Id
    Long srvcVisitTypeId;
    String serviceVisitTypeName;

    public Long getSrvcVisitTypeId() {
        return srvcVisitTypeId;
    }

    public void setSrvcVisitTypeId(Long srvcVisitTypeId) {
        this.srvcVisitTypeId = srvcVisitTypeId;
    }

    public String getServiceVisitTypeName() {
        return serviceVisitTypeName;
    }

    public void setServiceVisitTypeName(String serviceVisitTypeName) {
        this.serviceVisitTypeName = serviceVisitTypeName;
    }
}
