package in.bitlogic.demogit.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bitlogic.demogit.app.Service.LoanService;
import in.bitlogic.demogit.app.model.GitDemo;

@RestController
public class LoanController{
	
	@Autowired
	LoanService ls;	
	
	// Post API => http://localhost:9090/getLoans
	@GetMapping("/getLoans")
	public List<GitDemo> getLoans(){
		return ls.getLoans();
	}
	
}
