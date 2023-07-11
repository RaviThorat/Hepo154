package in.bitlogic.demogit.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bitlogic.demogit.app.Service.LoanService;
import in.bitlogic.demogit.app.model.GitDemo;
@RestController
public class RajController {

	
	@Autowired
	LoanService ls;
	
	
	@PutMapping(value="/bilogic/{gitId}")
	public GitDemo updateData(@PathVariable int gitId, @RequestBody GitDemo g)
	{		
		g.setLoanAppId(gitId);
		return ls.updatedata(g);	
	}

	

}
