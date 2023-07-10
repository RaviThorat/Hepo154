package in.bitlogic.demogit.app.ServiceImpl;

import java.util.List;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======

import org.springframework.beans.factory.annotation.Autowired;

>>>>>>> branch 'main' of https://github.com/RaviThorat/Hepo154.git
import org.springframework.stereotype.Service;

import in.bitlogic.demogit.app.Service.LoanService;
import in.bitlogic.demogit.app.loanrepository.LoanRepository;
import in.bitlogic.demogit.app.model.GitDemo;

@Service
public class LoanServiceImpl implements LoanService 
<<<<<<< HEAD
{
	@Autowired
	LoanRepository loanrepo;
=======

	@Autowired
	LoanRepository lr;	
	


	public GitDemo saveP(GitDemo p) {
		return null;
	}

>>>>>>> branch 'main' of https://github.com/RaviThorat/Hepo154.git

	@Override
	public List<GitDemo> getLoans() {
		
		return lr.findAll();

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
