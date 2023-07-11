package in.bitlogic.demogit.app.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import in.bitlogic.demogit.app.Service.LoanService;
import in.bitlogic.demogit.app.loanrepository.LoanRepository;
import in.bitlogic.demogit.app.model.GitDemo;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	LoanRepository lr;

	@Override
	public GitDemo saveP(GitDemo p) {
		return lr.save(p);
	}

	@Override
	public List<GitDemo> getLoans() {
		
		return lr.findAll();

	}

	@Override
	public GitDemo updatedata(int gitId) {

		return lr.save(gitId);
	}

	@Override
	public void deleteLoan(int gitId) {
		
		lr.deleteById(gitId);
	}


}
