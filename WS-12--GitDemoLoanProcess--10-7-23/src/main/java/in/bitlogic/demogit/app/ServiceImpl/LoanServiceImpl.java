package in.bitlogic.demogit.app.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bitlogic.demogit.app.Service.LoanService;
import in.bitlogic.demogit.app.loanrepository.LoanRepository;
import in.bitlogic.demogit.app.model.GitDemo;

@Service
public class LoanServiceImpl implements LoanService 
{
	@Autowired
	LoanRepository loanrepo;

	@Override
	public void saveP(GitDemo p) {
		
	}

	@Override
	public void deleteLoan(int gitId) {
		
		loanrepo.deleteById(gitId);
	}

	@Override
	public List<GitDemo> getLoans() {
		// TODO Auto-generated method stub
		return null;
	}

}
