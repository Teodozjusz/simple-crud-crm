package online.adambem.simplecrudcrm.service;

import online.adambem.simplecrudcrm.entity.Customer;
import online.adambem.simplecrudcrm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findById(int id) {
        Optional<Customer> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        else {
            throw new RuntimeException("Did not find customer id - " + id);
        }
    }

    public void save(Customer customer) {
        repository.save(customer);
    }

    public void delete(Customer customer) {
        repository.delete(customer);
    }

}
