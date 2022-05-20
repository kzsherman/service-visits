package vip.almaty.servicevisits.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.almaty.servicevisits.entities.Manufacturer;

public interface ManufacturersRepository extends JpaRepository<Manufacturer, Long> {

}
