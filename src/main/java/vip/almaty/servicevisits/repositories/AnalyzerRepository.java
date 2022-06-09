package vip.almaty.servicevisits.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import vip.almaty.servicevisits.entities.Analyzer;
import vip.almaty.servicevisits.entities.Customer;

import java.util.List;

public interface AnalyzerRepository extends JpaRepository<Analyzer, Long> {

    List <Analyzer> findAnalyzersByCustomr (Customer customer);

}
