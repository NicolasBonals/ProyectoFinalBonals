package com.portfolionab.nab.Repository;

import com.portfolionab.nab.Entity.HySSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryHySSkills extends JpaRepository<HySSkills, Integer>{
    Optional<HySSkills> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
