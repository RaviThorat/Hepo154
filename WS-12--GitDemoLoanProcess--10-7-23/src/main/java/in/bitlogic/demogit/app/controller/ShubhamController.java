package in.bitlogic.demogit.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShubhamController 
{
	
//	@Autowired
//	LoanService ls;
//	
//
//	@Value(value="${spring.mail.username}")
//	String gfromEmail;
//	
//	@PostMapping("/applyLoan")
//	public LoanApplication saveDetails(@RequestBody LoanApplication la) throws Exception
//	{
//		//System.out.println(la.getEmail());
//	
//		return ls.saveDetails(la);
//
//	}
//	
//	@PostMapping("/email/{loanAppId}")
//	public String sendEmail( String fromEmail,@PathVariable("loanAppId") int id)
//	{
//	gfromEmail=fromEmail;
//		
//		try {
//			
//			ls.sendEmail(gfromEmail, id);
//			
//		} catch (Exception e2) {
//
//			return "Email can not be sent...";
//		
//		}
//		return "email successfully sent...";
//	}
//	
//
//}
//
//
}
