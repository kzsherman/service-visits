package vip.almaty.servicevisits.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.almaty.servicevisits.entities.SparePart;

public interface SparePartRepository extends JpaRepository<SparePart, Long> {
}
