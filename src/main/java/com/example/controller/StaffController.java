package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.StaffModel;
import com.example.service.StaffService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StaffController {
	
		@Autowired
		StaffModel staffModel;
		@Autowired
		StaffService staffService;
		
	    @RequestMapping("/addStaff")
	    public String addStaff(){
	    	staffModel = new StaffModel();
	    	staffModel.setId(6);
	    	staffModel.setName("產品F");
	    	staffModel.setPrice(1099);
	    	staffService.addStaff(staffModel);
	        return "New Staff added";
	    }

	    @GetMapping("/getStaff")
	    @CrossOrigin("http://localhost:3000")
	    public List<StaffModel> getStaff() {
	    	List<StaffModel> rows= new ArrayList<StaffModel>();
	    	rows=staffService.getStaff();
	    	System.out.println(rows);
	    	return rows;
	    }
	    
}