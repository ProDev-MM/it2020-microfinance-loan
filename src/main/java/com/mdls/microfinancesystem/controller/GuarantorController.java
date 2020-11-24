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

import com.mdls.microfinancesystem.entity.Guarantor;
import com.mdls.microfinancesystem.entity.Staff;
import com.mdls.microfinancesystem.pojo.GuarantorPojo;
import com.mdls.microfinancesystem.pojo.StaffPojo;
import com.mdls.microfinancesystem.response.BaseResponse;
import com.mdls.microfinancesystem.service.GuarantorService;

@RestController
@CrossOrigin
public class GuarantorController {

	@Autowired
	GuarantorService guarantorService;

	@GetMapping(value = "/guarantors")
	public BaseResponse getGuarantor(Guarantor guarantor) {
		List<Guarantor> guarantors = guarantorService.getGuarantor(guarantor);
		return new BaseResponse(GlobalConstant.SUCCESS, guarantors, GlobalConstant.Message.SUCCESS_MESSAGE);
	}

	@PostMapping(value = "/guarantor")
	public BaseResponse addGuarantor(@RequestBody Guarantor guarantor) {
Guarantor guarantors;
		try {
			List<Guarantor> nrc= guarantorService.findByNRC(guarantor.getGuarantorNRC());
			
			if(nrc==null || !nrc.isEmpty()) {
				
				return new BaseResponse(1, null, "NRC already exists!");

			}
			guarantors = guarantorService.save(guarantor);
		} catch (Exception e) {
			System.out.println("Error occur " + e.getMessage());
			return new BaseResponse(1, null, "Error cannot create guarantor");
		}
		return new BaseResponse(0, guarantors, "Successfully created ");
	}

	@DeleteMapping(value = "/guarantors/{id}")
	public void deleteById(@PathVariable Long id) {
		guarantorService.delete(id);
	}

	@PutMapping(value = "/guarantors")
	public BaseResponse updateGuarantor(@RequestBody GuarantorPojo guarantorPojo) {
		
			Guarantor guarantors;
			try {
				Guarantor guarantor = guarantorService.findById(guarantorPojo.getGuarantorId());
				List<Guarantor> nrc = guarantorService.findByNRC(guarantorPojo.getGuarantorNRCNo());
				
				guarantor.setGuarantorAddress(guarantorPojo.getGuarnatorAddress());
				guarantor.setGuarantorName(guarantorPojo.getGuarantorName());
				guarantor.setGuarantorNRC(guarantorPojo.getGuarantorNRCNo());
				guarantor.setGuarantorOccupation(guarantorPojo.getGuarantorOccupation());
				guarantor.setGuarantorPhone(guarantorPojo.getGuarantorPhone());
				
	          if (guarantor==null || nrc==null || !nrc.isEmpty()) {
					
					return new BaseResponse(GlobalConstant.FAIL, null, "NRC already exists!");
				}
				guarantors = guarantorService.save(guarantor);
			} catch (Exception e) {
				System.out.println("Error occur " + e.getMessage());
				return new BaseResponse(GlobalConstant.FAIL, null, "Error cannot update staff");
			}
			return new BaseResponse(GlobalConstant.SUCCESS, guarantors, "Successfully created ");
		}


	@GetMapping(value = "/guarantors/{id}")
	public BaseResponse getById(@PathVariable Long id) {
		Guarantor guarantor;
		try {
			guarantor = guarantorService.findById(id);
		} catch (Exception e) {
			System.out.println("Error occur " + e.getMessage());
			return new BaseResponse(GlobalConstant.FAIL, null, "Error cannot create customer");
		}
		return new BaseResponse(GlobalConstant.SUCCESS, guarantor, "Successfully created ");
	}

	@GetMapping(value = "/guarantors/search")
	@CrossOrigin
	public List<Guarantor> searchGuarantor(String guarantorName) {
		return guarantorService.searchGuarantor(guarantorName);
	}
}
