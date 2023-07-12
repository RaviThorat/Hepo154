package in.rtech.loansanctionletter.app.service;

import java.io.ByteArrayInputStream;

public interface EmailService {

	public void sendEmail(String fromEmail, int loanId);

}
