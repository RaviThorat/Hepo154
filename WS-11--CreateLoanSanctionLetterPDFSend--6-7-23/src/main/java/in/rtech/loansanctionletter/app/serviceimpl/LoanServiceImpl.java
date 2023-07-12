package in.rtech.loansanctionletter.app.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rtech.loansanctionletter.app.model.LoanApplication;
import in.rtech.loansanctionletter.app.repository.LoanRepository;
import in.rtech.loansanctionletter.app.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService{

	@Autowired
	LoanRepository lr;
	
	@Override
	public LoanApplication saveLoanApplication(LoanApplication loanApp) {
		
		// Loan Sanction Details carry forwarded as loan details.
		loanApp.getSanctionDetails().setAmountSan(loanApp.getLoanDetails().getLoanAmount());
		loanApp.getSanctionDetails().setLoanType(loanApp.getLoanDetails().getLoanType());
		loanApp.getSanctionDetails().setTenureSan(loanApp.getLoanDetails().getTenure());
		
		
		//EMI Calculation
		// Principal or Loan Sanctioned Amount = P, Rate of Interest = R (R = 8.75/12/100 = 0.00729166666666667)
		// Repayment Period (Total no. of months Or No. of installments) = N
		
		// Formula => [P*R*(1+R)^N]/[(1+R)^N-1]
		
		double p = loanApp.getSanctionDetails().getAmountSan(); // Principal
		double rate = 8.75; // Rate of Interest
		double r = rate/12/100; // ROI for EMIs
		int years = loanApp.getSanctionDetails().getTenureSan(); // tenure in years
		int n = years*12; // tenure in months
		
		double emi = (p*r*Math.pow(1+r, n)) / (Math.pow(1+r, n)-1); // EMI calculation formula
		System.out.println(emi);
		
		double totalAmt=emi*n;
		double totalInt=totalAmt-p;
		
		
		loanApp.getSanctionDetails().setEmiSan(emi);
		loanApp.getSanctionDetails().setTotalAmount(totalAmt);
		loanApp.getSanctionDetails().setTotalIntrest(totalInt);
	
		
		return lr.save(loanApp);
	}

	@Override
	public LoanApplication getLoanAppDetail(int laId) {
		
		Optional<LoanApplication> op = lr.findById(laId);
		
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
		
	}

}
