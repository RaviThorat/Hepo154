package in.rtech.loansanctionletter.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailSender {
	private String fromEmail;
	private String toEmail;
	private String subject;
	private String textMessage;
}
