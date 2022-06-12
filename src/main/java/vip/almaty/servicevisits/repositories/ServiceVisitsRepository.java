package vip.almaty.servicevisits.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.almaty.servicevisits.entities.ServiceVisit;

public interface ServiceVisitsRepository extends JpaRepository<ServiceVisit, Long> {

}
