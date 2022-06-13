package vip.almaty.servicevisits.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.almaty.servicevisits.entities.Analyzer;
import vip.almaty.servicevisits.entities.ServiceVisit;

import java.util.List;

public interface ServiceVisitsRepository extends JpaRepository<ServiceVisit, Long> {

    List<ServiceVisit> findServiceVisitsByAnlz(Analyzer analyzer);
}
