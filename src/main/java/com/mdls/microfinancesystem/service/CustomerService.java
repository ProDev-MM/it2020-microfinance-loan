package com.mdls.microfinancesystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdls.microfinancesystem.entity.Customer;
import com.mdls.microfinancesystem.entity.Member;
import com.mdls.microfinancesystem.pojo.CustomerPojo;
import com.mdls.microfinancesystem.repository.CustomerRepository;
import com.mdls.microfinancesystem.repository.MemberRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	MemberRepository memberRepository;

	public List<Customer> getCustomer(Customer customer) {
		return customerRepository.findAll();
	}

	public CustomerPojo save(CustomerPojo  customerPojo , Boolean isUpdate) {
		
		Customer customer=new Customer();
		customer.setCustomerAddress(customerPojo.getCustomerAddress());
		customer.setCustomerName(customerPojo.getCustomerName());
		customer.setCustomerNRC(customerPojo.getCustomerNRCNo());
		customer.setCustomerOccupation(customerPojo.getCustomerOccupation());
		customer.setCustomerPhone(customerPojo.getCustomerPhone());
		
		
		Optional<Member> member= memberRepository.findById(customerPojo.getMember_id());
		if(member.isEmpty()) {
			return null;
		}
			
		customer.setMember(member.get());
		if(isUpdate) {
			customer.setId(customerPojo.getId());
		}
		customer=customerRepository.save(customer);
		
		customerPojo.setId(customer.getId());
		return customerPojo;
		
	}

	public void delete(Long id) {
		customerRepository.deleteById(id);

	}

	public Customer findById(long id) {
		return customerRepository.findById(id).orElse(null);
	}

	public List<Customer> searchCustomer(String customerName) {
		return customerRepository.searchCustomer(customerName);
	}

	public List<Customer> findByMemberId(Long memberId) {
		return customerRepository.findByMemberId(memberId);
	}
	
	public List<Customer> findbyNRC(String customerNRC){
		return customerRepository.findByNRC(customerNRC);
	}
}
