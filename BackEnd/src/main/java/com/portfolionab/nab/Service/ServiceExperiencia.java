package com.portfolionab.nab.Service;

import com.portfolionab.nab.Entity.Experiencia;
import com.portfolionab.nab.Repository.RepositoryExperiencia;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //mantiene los datos
public class ServiceExperiencia {
     @Autowired
     RepositoryExperiencia repositoryExperiencia;
     
     public List<Experiencia> list(){
         return repositoryExperiencia.findAll();
     }
     
     public Optional<Experiencia> getOne(int id){
         return repositoryExperiencia.findById(id);
     }
     
     public Optional<Experiencia> getByNombreE(String nombreE){
         return repositoryExperiencia.findByNombreE(nombreE);
     }
     
     public void save(Experiencia expe){
         repositoryExperiencia.save(expe);
     }
     
     public void delete(int id){
         repositoryExperiencia.deleteById(id);
     }
     
     public boolean existsById(int id){
         return repositoryExperiencia.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return repositoryExperiencia.existsByNombreE(nombreE);
     }
}