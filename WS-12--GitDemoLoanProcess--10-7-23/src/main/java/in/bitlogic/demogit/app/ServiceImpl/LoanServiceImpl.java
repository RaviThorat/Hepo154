package in.bitlogic.demogit.app.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import in.bitlogic.demogit.app.Service.LoanService;
import in.bitlogic.demogit.app.loanrepository.LoanRepository;
import in.bitlogic.demogit.app.model.GitDemo;

@Service
<<<<<<< HEAD
public class LoanServiceImpl implements LoanService {

=======
public class LoanServiceImpl implements LoanService 
{
>>>>>>> branch 'main' of https://github.com/RaviThorat/Hepo154.git
	@Autowired
	LoanRepository loanrepo;



	public GitDemo saveP(GitDemo p) {
		return null;
	}



	@Override
	public List<GitDemo> getLoans() {
		
		return lr.findAll();

	}

<<<<<<< HEAD

	@Override
	public GitDemo updatedata(int gitId) {

		return lr.save(gitId);
=======
	@Override
	public void deleteLoan(int gitId) {
		
		loanrepo.deleteById(gitId);
	}

	@Override
	public List<GitDemo> getLoans() {
		// TODO Auto-generated method stub
		return null;
>>>>>>> branch 'main' of https://github.com/RaviThorat/Hepo154.git
	}

}
