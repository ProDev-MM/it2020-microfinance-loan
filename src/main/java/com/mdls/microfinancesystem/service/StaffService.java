package com.mdls.microfinancesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdls.microfinancesystem.entity.Staff;
import com.mdls.microfinancesystem.repository.StaffRepository;

@Service
public class StaffService {
	@Autowired
	StaffRepository staffRepository;

	public List<Staff> getStaff(Staff staff) {
		return staffRepository.findAll();
	}

	public Staff save(Staff staff) {
		return staffRepository.save(staff);
	}

	public void delete(Long id) {
		staffRepository.deleteById(id);
	}

	public List<Staff> searchStaff(String staffName) {
		return staffRepository.searchStaff(staffName);
	}

	public Staff findById(Long id) {
		return staffRepository.findById(id).orElse(null);
	}

}
