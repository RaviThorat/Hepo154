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
	LoanRepository lr;	
	
	//Shubham's API
	@Override
	public GitDemo saveP(GitDemo p) {
		return null;
	}

	//Ravi's API
	@Override
	public List<GitDemo> getLoans() {
		
		return lr.findAll();
	}

}
