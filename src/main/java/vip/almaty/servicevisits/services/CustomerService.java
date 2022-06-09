package vip.almaty.servicevisits.services;

import org.springframework.stereotype.Service;
import vip.almaty.servicevisits.entities.Analyzer;
import vip.almaty.servicevisits.entities.Customer;
import vip.almaty.servicevisits.repositories.AnalyzerRepository;
import vip.almaty.servicevisits.repositories.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AnalyzerRepository analyzerRepository;

    public CustomerService(CustomerRepository customerRepository, AnalyzerRepository analyzerRepository) {
        this.customerRepository = customerRepository;
        this.analyzerRepository = analyzerRepository;
    }

    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveNewCustomer(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    public Customer findCustomerById(long theId) {
        return customerRepository.findById(theId).get();
    }

    public Iterable<Analyzer> findAnalyzersByTheCustomer(Customer theCustomer) {
        return analyzerRepository.findAnalyzersByCustomr(theCustomer);
    }

    public void deleteCustomer(Customer theCustomer) {
        customerRepository.delete(theCustomer);
    }
}
