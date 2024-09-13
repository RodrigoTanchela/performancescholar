package com.performancescholar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.performancescholar.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

}
