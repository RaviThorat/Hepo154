package in.bitlogic.demogit.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bitlogic.demogit.app.Service.LoanService;
import in.bitlogic.demogit.app.model.GitDemo;
import lombok.experimental.Delegate;

@RestController
public class UmeshConroller {
	@Autowired
	LoanService loanservice;
	
	@DeleteMapping("/deleteloan/{gitId}")
	public String deleteLoan(@PathVariable int gitId) {
		
     loanservice.deleteLoan(gitId);
     return "delete successfully";
	}

}
