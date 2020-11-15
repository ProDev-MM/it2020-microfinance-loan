package com.mdls.microfinancesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mdls.microfinancesystem.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>{

	

	@Query(value="Select s from Staff s where s.staffName like concat('%',concat(?1,'%'))")
	List<Staff> searchStaff(String staffName);
	
	@Query(value="Select s from Staff s where s.staffEmail = ?1")
	List<Staff> findByEmail(String staffEmail);
	
	@Query(value="Select s from Staff s where s.staffNRCNo = ?1")
	List<Staff> findByNRC(String staffNRCNo);

}
