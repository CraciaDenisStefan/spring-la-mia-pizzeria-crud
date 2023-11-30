package org.java.spring.db.repo;

import org.java.spring.db.pojo.Pizzeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzeriaRepository extends JpaRepository<Pizzeria, Integer>{

}
