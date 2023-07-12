package in.rtech.loansanctionletter.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SanctionDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sanctionId;
	private String loanType;
	private double amountSan;
	private int tenureSan;
	private double emiSan;
	private double totalAmount;
	private double totalIntrest;
	@Lob
	private byte[] sanLetterPdf;
	
}
