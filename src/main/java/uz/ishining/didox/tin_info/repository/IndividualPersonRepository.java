package uz.ishining.didox.tin_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ishining.didox.tin_info.model.IndividualPerson;

@Repository
public interface IndividualPersonRepository extends JpaRepository<IndividualPerson, Long> {
}
