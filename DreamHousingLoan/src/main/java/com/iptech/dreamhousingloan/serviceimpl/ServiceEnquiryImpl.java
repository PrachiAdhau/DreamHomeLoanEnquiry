package com.iptech.dreamhousingloan.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.iptech.dreamhousingloan.exception.InvalidAdharNoException;

import com.iptech.dreamhousingloan.model.Enquiry;
import com.iptech.dreamhousingloan.repository.EnquiryRepository;
import com.iptech.dreamhousingloan.serviceInt.ServiceEnquiryInt;

@Service
public class ServiceEnquiryImpl implements ServiceEnquiryInt {


	@Autowired
	EnquiryRepository er;



	@Override
	public Enquiry saveEnquiry(Enquiry e) {
		// Adhar number exception
		String adharNo= String.valueOf(e.getAdharNo());
		if(adharNo.length()==12)
		{
			
			System.out.println("valid adhar card no");
		}
		else {
			throw new InvalidAdharNoException("InvalidAdharNoException :"+adharNo);
		}

		Enquiry save = er.save(e);
		return save;
	}

	@Override

	public void deleteSingle(int applicant_Id) {
		er.deleteById(applicant_Id);

	}

	@Override

	public Enquiry getSingleDataMethod(int id) {
		Enquiry e = er.findById(id).get();
		return e;
	}

	public List<Enquiry> getAllData() {

		return er.findAll();

	}

	@Override
	public void editEnquiry(Enquiry e, int applicant_Id) {
		Enquiry eq = er.findById(applicant_Id).get();

		if (null != eq) {
			eq.setFirst_Name(e.getFirst_Name());
			eq.setLast_Name(e.getLast_Name());
			eq.setAge(e.getAge());
			eq.setEmail(e.getEmail());
			eq.setMobileNo(e.getMobileNo());
			eq.setAlternateMobileNo(e.getAlternateMobileNo());
			eq.setPancardNo(e.getPancardNo());
			eq.setAdharNo(e.getAdharNo());
			eq.setAddress(e.getAddress());
			eq.setCity(e.getCity());
			eq.setCibilScore(e.getCibilScore());
			er.save(eq);
		} else {
			System.out.println("Data is not present");
		}
	}


	

}
