package in.rtech.loansanctionletter.app.serviceimpl;

import java.io.ByteArrayInputStream;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import in.rtech.loansanctionletter.app.model.LoanApplication;
import in.rtech.loansanctionletter.app.repository.LoanRepository;
import in.rtech.loansanctionletter.app.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	JavaMailSender sender;
	
	@Autowired
	LoanRepository lr;
	

	@Value(value="${spring.mail.username}")
	String gfromEmail;
	
	
	@Override
	public void sendEmail(String fromEmail, int loanId) {
		
		Optional<LoanApplication> ola= lr.findById(loanId);
		
		LoanApplication la=ola.get();
		
		byte[] pdf=la.getSanctionDetails().getSanLetterPdf();
				InputStreamSource input=new ByteArrayResource(pdf);
				
			MimeMessage m = sender.createMimeMessage();
			
			try {
				MimeMessageHelper helper=new MimeMessageHelper(m,true);
				helper.setTo(la.getCustEmailId());
				helper.setFrom(gfromEmail);
				helper.setText("Congratulations "+la.getCustFirstName()+" "+la.getCustLastName());
				helper.setSubject("Loan proposal approved..!");
				helper.addAttachment("SanctionLetter.pdf", input);
				sender.send(m);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		
	}
}
