package in.bitlogic.demogit.app.Service;

import java.util.List;


import in.bitlogic.demogit.app.model.GitDemo;

public interface LoanService{

	public GitDemo saveP(GitDemo p);

	 public void deleteLoan(int gitId);

	public List<GitDemo> getLoans();

	public GitDemo updatedata(int gitId);

}
