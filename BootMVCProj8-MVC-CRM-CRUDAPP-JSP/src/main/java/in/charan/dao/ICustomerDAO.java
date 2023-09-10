package in.charan.dao;

import org.springframework.data.repository.CrudRepository;

import in.charan.model.Customer;

public interface ICustomerDAO extends CrudRepository<Customer, Integer> {

}
