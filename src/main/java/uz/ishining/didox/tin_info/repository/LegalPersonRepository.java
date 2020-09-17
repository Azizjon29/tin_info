package uz.ishining.didox.tin_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ishining.didox.tin_info.model.LegalPerson;

@Repository
public interface LegalPersonRepository extends JpaRepository<LegalPerson, Long> {

}
