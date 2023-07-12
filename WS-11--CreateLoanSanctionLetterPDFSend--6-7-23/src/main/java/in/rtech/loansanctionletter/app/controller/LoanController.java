package in.rtech.loansanctionletter.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rtech.loansanctionletter.app.model.LoanApplication;
import in.rtech.loansanctionletter.app.service.LoanService;

@RestController
public class LoanController {
	
	@Autowired
	LoanService ls;
	
	//Post API => http://localhost:9090/saveLoanApplication
	@PostMapping("/saveLoanApplication")
	public LoanApplication saveLoanApplication(@RequestBody LoanApplication loanApp) {
		return ls.saveLoanApplication(loanApp);
	}
	
	//Get API => Search API--> http://localhost:9090/getLoanAppDetail/{loanId}
	@GetMapping("/getLoanAppDetail/{loanId}")
	public LoanApplication getLoanAppDetail(@PathVariable int loanId) {
		return ls.getLoanAppDetail(loanId);
	}
}
