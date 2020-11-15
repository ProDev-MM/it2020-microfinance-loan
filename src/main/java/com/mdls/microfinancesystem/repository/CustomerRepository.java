package com.mdls.microfinancesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mdls.microfinancesystem.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Query(value="Select c from Customer c where c.customerName like concat('%',concat(?1,'%'))")
	List<Customer> searchCustomer(String customerName);
	
	@Query (value="select * from customer c where c.member_id =?1" , nativeQuery = true)
	List<Customer> findByMemberId(Long memberId);
	
	@Query(value="select c from Customer c where c.customerNRC =?1")
	List<Customer> findByNRC(String customerNRC);
}
