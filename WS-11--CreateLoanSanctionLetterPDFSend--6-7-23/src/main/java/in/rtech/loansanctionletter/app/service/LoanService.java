package in.rtech.loansanctionletter.app.service;

import in.rtech.loansanctionletter.app.model.LoanApplication;

public interface LoanService {

	public LoanApplication saveLoanApplication(LoanApplication loanApp);
	
	public LoanApplication getLoanAppDetail(int laId);

}
