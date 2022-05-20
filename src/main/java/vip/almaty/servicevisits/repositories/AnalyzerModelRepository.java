package vip.almaty.servicevisits.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.almaty.servicevisits.entities.AnalyzerModel;

public interface AnalyzerModelRepository extends JpaRepository <AnalyzerModel, Long> {
}
