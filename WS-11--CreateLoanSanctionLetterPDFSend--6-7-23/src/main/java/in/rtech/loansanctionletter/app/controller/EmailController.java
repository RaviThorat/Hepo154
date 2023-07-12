package in.rtech.loansanctionletter.app.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rtech.loansanctionletter.app.model.LoanApplication;
import in.rtech.loansanctionletter.app.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	EmailService es;	
	
	@Value(value="${spring.mail.username}")
	String gfromEmail;
	
	//Post API => http://localhost:9090/sendEmail/{loanAppId}
	@GetMapping("/sendEmail/{loanAppId}")
	public String sendEmail( @PathVariable("loanAppId") int loanId) {
		
		
		es.sendEmail(gfromEmail,loanId);
		return "Email Send Successfully..!";
	}
	
}
