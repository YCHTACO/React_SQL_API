package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.StaffModel;
import com.example.repository.StaffRepository;

@Service
public class StaffService{
	
	@Autowired
	StaffRepository staffRepository;
	public void addStaff(StaffModel staffModel){
		staffRepository.addStaff(staffModel);
	}
	
	public List<StaffModel> getStaff(){
		return staffRepository.getStaff();
	}
}