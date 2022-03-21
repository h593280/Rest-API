package com.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.MatcherConfigurer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.CustomerEntity;
import com.customer.repo.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	
	@GetMapping("/testing")
	public String welcome() {
		return "testing testing..";
	}
	
	@GetMapping("/get-all-customers")
	public List<CustomerEntity> getAllCustomers(){
		List<CustomerEntity> allCustomers = customerRepository.findAll();
		return allCustomers;
		
	}
	
	@GetMapping("/get-customerPep")
	public Optional<CustomerEntity> getCustomerById(@RequestBody CustomerEntity customer){
      
		Example <CustomerEntity> ex = Example.of(customer);
		return customerRepository.findOne(ex);
	}
	
	@GetMapping("/get-customersPep")
	public List<CustomerEntity> getCustomersPep(@RequestBody CustomerEntity customer) {
	Example <CustomerEntity> ex = Example.of(customer);
	return customerRepository.findAll(ex);
	}
	
		
    @PostMapping("/create-customer")
    public CustomerEntity createCustomer(@RequestBody CustomerEntity customer) {
       
    	 CustomerEntity savedCustomer = customerRepository.save(customer);
    	 
    	 return savedCustomer;
    }
    
    @PutMapping("/update-customer/{id}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable(value = "id") Integer customerId,
         @RequestBody CustomerEntity customerDetails) {
        CustomerEntity customer = customerRepository.findById(customerId).get();

        customer.setFirstname(customerDetails.getFirstname());
        customer.setLastname(customerDetails.getLastname());
        customer.setBirthdate(customerDetails.getDateOfBirth());
        customer.setAddress(customerDetails.getAddress());
        customer.setMobil(customerDetails.getMobil());
        customer.setEmail(customerDetails.getEmail());
        customer.setPep(customerDetails.getPep());
        CustomerEntity updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }
    
    @DeleteMapping("/delete-customer/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer customerId)
    {
     CustomerEntity customer = customerRepository.findById(customerId).get();

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	      
    
}



