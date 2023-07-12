package in.rtech.loansanctionletter.app.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rtech.loansanctionletter.app.model.SanctionDetails;
import in.rtech.loansanctionletter.app.service.PdfService;

@RestController
public class PdfController {
	
	@Autowired
	PdfService ps;
	
	//Post API => http://localhost:9090/getPdf
	@GetMapping("/getPdf/{loanId}")
	public ResponseEntity<InputStreamResource> getPdf(@PathVariable int loanId) {
		
		ByteArrayInputStream pdfArray=ps.createPdf(loanId);
		
		HttpHeaders header=new HttpHeaders();
		header.add("Conetnt-Disposition", "inline;filename=sactionletter.pdf");
		
		return ResponseEntity.ok().
				headers(header).
				contentType(MediaType.APPLICATION_PDF).
				body(new InputStreamResource(pdfArray));
	}
}
