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

	

	public void delete(Long id) {
		staffRepository.deleteById(id);
	}

	public List<Staff> searchStaff(String staffName) {
		return staffRepository.searchStaff(staffName);
	}

	public Staff findById(Long id) {
		return staffRepository.findById(id).orElse(null);
	}

	public List<Staff> findByNRC(String staffNRCNo) {
return staffRepository.findByNRC(staffNRCNo);
	}



	public List<Staff> findByEmail(String staffEmail) {
		// TODO Auto-generated method stub
		return staffRepository.findByEmail(staffEmail);
	}



	public Staff save(Staff staff) {
		// TODO Auto-generated method stub
		return staffRepository.save(staff);
	}

}
