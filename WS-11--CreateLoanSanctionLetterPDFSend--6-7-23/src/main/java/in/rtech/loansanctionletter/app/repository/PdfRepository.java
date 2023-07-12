package in.rtech.loansanctionletter.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.rtech.loansanctionletter.app.model.SanctionDetails;

@Repository
public interface PdfRepository extends JpaRepository<SanctionDetails, Integer>{

}
