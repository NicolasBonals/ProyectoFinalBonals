package com.portfolionab.nab.Service;

import com.portfolionab.nab.Entity.HySSkills;
import com.portfolionab.nab.Repository.RepositoryHySSkills;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ServiceHySSkills {
    @Autowired
    RepositoryHySSkills repositoryHySSkills;
    
        
    public List<HySSkills> list(){
        return repositoryHySSkills.findAll();
    }
    
    public Optional<HySSkills> getOne(int id){
        return repositoryHySSkills.findById(id);
    }
    
    public Optional<HySSkills> getByNombre(String nombre){
        return repositoryHySSkills.findByNombre(nombre);
    }
    
    public void save(HySSkills skill){
        repositoryHySSkills.save(skill);
    }
    
    public void delete(int id){
        repositoryHySSkills.deleteById(id);
    }
    
    public boolean existsById(int id){
        return repositoryHySSkills.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return repositoryHySSkills.existsByNombre(nombre);
    }
}
