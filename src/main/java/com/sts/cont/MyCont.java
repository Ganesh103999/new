package com.sts.cont;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entity.MyStudent;
import com.sts.repo.MyStudentRepo;

@RestController
public class MyCont {
	
	@Autowired
	MyStudentRepo myStudentRepo;
	
	
	@PostMapping("addData")
	public int myAddData (@RequestBody MyStudent myStudent) {
		try {			
			myStudentRepo.save(myStudent);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	@GetMapping("getData")
	public List<MyStudent> getDa()
	{
		try {			
			List<MyStudent> findAll = myStudentRepo.findAll();
			return findAll;
		} catch (Exception e) 
		{
			
			e.printStackTrace();
			return null;
		}
	}
	
	@DeleteMapping("delete{id}")
	public boolean delete (@PathVariable int id) 
	{
		try {			
			myStudentRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	@PutMapping("putid{id}")
	public MyStudent putmy (@PathVariable int id) 
	{
		try {
			MyStudent findById = myStudentRepo.findById(id).get();
			findById.setName("Prashant kapde");
			MyStudent save = myStudentRepo.save(findById);
			return save;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
			
		}
	}
	
	

}
