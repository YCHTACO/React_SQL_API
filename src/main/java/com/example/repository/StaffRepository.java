package com.example.repository;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.example.model.StaffModel;

@Repository
public class StaffRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addStaff(StaffModel staffModel){
		System.out.println("EXCUTE INSERT MEMBER");
	  jdbcTemplate.update("INSERT INTO productList(product_id, product_name, product_price) "
	  		+ "VALUES (?,?,?)",staffModel.getId(), staffModel.getName(),
	  		staffModel.getPrice());
	}
	
	public List<StaffModel> getStaff(){
		System.out.println("EXCUTE Get MEMBER");
		String sql ="SELECT product_id as id,product_name as name ,product_price as price FROM productlist";
		List<StaffModel> rows = new ArrayList<>(); 
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
		list.forEach(m -> {
			StaffModel staffmodel = new StaffModel();
			staffmodel.setId((int)m.get("id"));	
			staffmodel.setName((String)m.get("name"));
			staffmodel.setPrice((int)m.get("price"));
			rows.add(staffmodel);
		}); 
		System.out.println("EXCUTE Get MEMBER end");
		return rows;
	}
}