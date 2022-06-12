package vip.almaty.servicevisits.repositories;

import org.springframework.data.repository.CrudRepository;
import vip.almaty.servicevisits.entities.ServiceVisitType;

import java.util.concurrent.ThreadPoolExecutor;

public interface ServiceVisitTypeRepository extends CrudRepository <ServiceVisitType, Long> {
}
