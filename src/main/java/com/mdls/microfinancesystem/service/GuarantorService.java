package com.mdls.microfinancesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdls.microfinancesystem.entity.Guarantor;
import com.mdls.microfinancesystem.repository.GuarantorRepository;

@Service
public class GuarantorService {

	@Autowired
	GuarantorRepository guarantorRepository;

	public Guarantor save(Guarantor guarantor) {
		return guarantorRepository.save(guarantor);
	}

	public void delete(Long id) {
		guarantorRepository.deleteById(id);
	}

	public List<Guarantor> getGuarantor(Guarantor guarantor) {
		// TODO Auto-generated method stub
		return guarantorRepository.findAll();
	}

	public Guarantor findById(Long id) {
		// TODO Auto-generated method stub
		return guarantorRepository.findById(id).orElse(null);
	}

	public List<Guarantor> searchGuarantor(String guarantorName) {

		return guarantorRepository.searchGuarantor(guarantorName);
	}

}
