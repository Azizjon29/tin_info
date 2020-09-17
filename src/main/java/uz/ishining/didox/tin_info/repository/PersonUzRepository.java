package uz.ishining.didox.tin_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ishining.didox.tin_info.model.PersonUz;

@Repository
public interface PersonUzRepository extends JpaRepository<PersonUz, Long> {

    PersonUz findByTin(String tin);
}
