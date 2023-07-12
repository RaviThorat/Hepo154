package in.rtech.loansanctionletter.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import in.rtech.loansanctionletter.app.model.SanctionDetails;

@Repository
public interface PdfRepository extends JpaRepository<SanctionDetails, Integer>{
=======
import in.rtech.loansanctionletter.app.model.LoanApplication;
import in.rtech.loansanctionletter.app.model.SanctionDetails;

@Repository
public interface PdfRepository extends JpaRepository<LoanApplication, Integer>{
>>>>>>> branch 'main' of https://github.com/RaviThorat/Hepo154.git

}
