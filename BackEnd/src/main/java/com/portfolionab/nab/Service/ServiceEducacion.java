package com.portfolionab.nab.Service;

import com.portfolionab.nab.Entity.Educacion;
import com.portfolionab.nab.Repository.RepositoryEducacion;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //(persistencia)Para mantener la concordancia entre la base de datos y lo que se realiza
public class ServiceEducacion {
    @Autowired
    RepositoryEducacion repositoryEducacion;
    
    //metodos
    public List<Educacion> list(){ //Me trae una lista de educacion
        return repositoryEducacion.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return repositoryEducacion.findById(id);
    }
    
    public Optional<Educacion> getByNombreE(String nombreE){
        return repositoryEducacion.findByNombreE(nombreE);
    }
    
    public void save(Educacion educacion){ //se usa void cuando no devuelve nada
        repositoryEducacion.save(educacion);
    }
    
    public void delete(int id){
        repositoryEducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return repositoryEducacion.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return repositoryEducacion.existsByNombreE(nombreE);
    }
    
}
