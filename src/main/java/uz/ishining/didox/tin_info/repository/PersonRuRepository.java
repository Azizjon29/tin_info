package uz.ishining.didox.tin_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ishining.didox.tin_info.model.PersonRu;

@Repository
public interface PersonRuRepository extends JpaRepository<PersonRu, Long> {

    PersonRu findByTin(String tin);
}
