package com.portfolionab.nab.Security.Repository;

import com.portfolionab.nab.Security.Entity.Rol;
import com.portfolionab.nab.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
