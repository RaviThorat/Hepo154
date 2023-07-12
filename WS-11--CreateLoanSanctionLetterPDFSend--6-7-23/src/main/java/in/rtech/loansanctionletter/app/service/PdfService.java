package in.rtech.loansanctionletter.app.service;

import java.io.ByteArrayInputStream;

import in.rtech.loansanctionletter.app.model.SanctionDetails;

public interface PdfService {

	public ByteArrayInputStream createPdf(int loanId);

	

}
