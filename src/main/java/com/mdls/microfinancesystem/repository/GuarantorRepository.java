package com.mdls.microfinancesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mdls.microfinancesystem.entity.Guarantor;

@Repository
public interface GuarantorRepository extends JpaRepository<Guarantor, Long> {

	@Query(value = "Select g from Guarantor g where g.guarantorName like concat('%',concat(?1,'%'))")
	List<Guarantor> searchGuarantor(String guarantorName);
	
	@Query(value = "Select g from Guarantor g where g.guarantorNRC =?1")
	List<Guarantor> findByNRC(String guarantorNRC);
}
