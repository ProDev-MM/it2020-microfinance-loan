package com.mdls.microfinancesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mdls.microfinancesystem.constant.GlobalConstant;
import com.mdls.microfinancesystem.entity.Customer;

import com.mdls.microfinancesystem.pojo.CustomerPojo;
import com.mdls.microfinancesystem.response.BaseResponse;
import com.mdls.microfinancesystem.service.CustomerService;
import com.mdls.microfinancesystem.service.MemberService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	MemberService memberService;

	@GetMapping(value = "/customers")
	public BaseResponse getCustomer(Customer customer) {
		List<Customer> customers = customerService.getCustomer(customer);
		return new BaseResponse(GlobalConstant.SUCCESS, customers, GlobalConstant.Message.SUCCESS_MESSAGE);
	}

	@GetMapping(value = "/customers/search/{customerName}")
	@CrossOrigin
	public List<Customer> searchCustomerByName(String customerName) {
		return customerService.searchCustomer(customerName);
	}

	@PostMapping(value = "/customer")
	public BaseResponse addCustomer(@RequestBody CustomerPojo customerPojo) {

		try {

			customerPojo = customerService.save(customerPojo,false);
		} catch (Exception e) {
			System.out.println("Error occur " + e.getMessage());
			return new BaseResponse(GlobalConstant.FAIL, null, "Error cannot create customer");
		}
		return new BaseResponse(GlobalConstant.SUCCESS, customerPojo, "Successfully created ");
	}

	@DeleteMapping(value = "/customer/{id}")
	public void deleteById(@PathVariable Long id) {
		customerService.delete(id);
	}

	@PutMapping(value = "/customer")
	public CustomerPojo updateCustomer(@RequestBody CustomerPojo customerPojo) {

		Customer customer = customerService.findById(customerPojo.getId());
		if (customer == null) {
			return null;
		}
//		customer.setCustomerName(customerPojo.getCustomerName());
//		customer.setCustomerAddress(customerPojo.getCustomerAddress());
//		customer.setCustomerNRC(customerPojo.getCustomerNRCNo());
//		customer.setCustomerPhone(customerPojo.getCustomerPhone());
//		customer.setCustomerOccupation(customerPojo.getCustomerOccupation());

		return customerService.save(customerPojo,true);

	}

	@GetMapping(value = "/customers/{id}")
	public BaseResponse getById(@PathVariable Long id) {
		Customer customer;
		try {
			customer = customerService.findById(id);
		} catch (Exception e) {
			System.out.println("Error occur " + e.getMessage());
			return new BaseResponse(GlobalConstant.FAIL, null, "Error cannot create customer");
		}
		return new BaseResponse(GlobalConstant.SUCCESS, customer, "Successfully created ");
	}

	@GetMapping(value = "customers/members/{id}")
	@CrossOrigin
	public List<Customer> findByMemberId(@PathVariable Long id) {
		return customerService.findByMemberId(id);
	}
}
