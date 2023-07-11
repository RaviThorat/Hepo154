package in.bitlogic.demogit.app.Service;

import java.util.List;

import in.bitlogic.demogit.app.model.GitDemo;

public interface LoanService{


	 public void deleteLoan(int gitId);

	public List<GitDemo> getLoans();

	public void saveP(GitDemo p);

	public List<GitDemo> getLoans();


	public GitDemo saveP(GitDemo p);
	
}
