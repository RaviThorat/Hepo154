package in.rtech.loansanctionletter.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.rtech.loansanctionletter.app.model.LoanApplication;

@Repository
public interface LoanRepository extends JpaRepository<LoanApplication, Integer>{

}
