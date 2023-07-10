package in.bitlogic.demogit.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import in.bitlogic.demogit.app.service.LoanService;


@RestController
public class ShubhamController 
{
	
	@Autowired
	LoanService ls;
	

}


