package vip.almaty.servicevisits.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.almaty.servicevisits.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
