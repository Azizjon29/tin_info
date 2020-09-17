package uz.ishining.didox.tin_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ishining.didox.tin_info.model.IndividualPersonUz;

@Repository
public interface IndividualPersonUzRepository extends JpaRepository<IndividualPersonUz, Long> {
}
