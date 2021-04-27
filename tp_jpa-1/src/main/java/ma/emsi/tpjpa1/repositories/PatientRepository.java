package ma.emsi.tpjpa1.repositories;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.tpjpa1.entities.patient;

public interface PatientRepository extends JpaRepository<patient, Long> {
public Page<patient> findByNomContains(String name, Pageable pageable);
public List<patient> findByMalade(boolean b);
public List<patient> findByNomContainsAndMalade(String name,boolean b);
}
