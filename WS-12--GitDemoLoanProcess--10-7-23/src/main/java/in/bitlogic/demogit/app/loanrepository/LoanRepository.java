package in.bitlogic.demogit.app.loanrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bitlogic.demogit.app.model.GitDemo;

@Repository
public interface LoanRepository extends JpaRepository<GitDemo, Integer>{

public 	GitDemo save(int gitId);

}
