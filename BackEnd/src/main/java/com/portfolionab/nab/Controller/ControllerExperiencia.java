package com.portfolionab.nab.Controller;

import com.portfolionab.nab.Dto.dtoExperiencia;
import com.portfolionab.nab.Entity.Experiencia;
import com.portfolionab.nab.Security.Controller.Mensaje;
import com.portfolionab.nab.Service.ServiceExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/explab")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerExperiencia {
    @Autowired
    ServiceExperiencia serviceExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = serviceExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!serviceExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("La experiencia consultada no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = serviceExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!serviceExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("La experiencia mencionada no existe"), HttpStatus.NOT_FOUND);
        }
        serviceExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("La experiencia se elimin?? correctamente"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){      
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("La experiencia requiere un nombre"), HttpStatus.BAD_REQUEST);
        if(serviceExperiencia.existsByNombreE(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("La experiencia ya existe, ingresar otra"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getDescripcionE());
        serviceExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("La experiencia fue agregada correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        if(!serviceExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID consultado no existe"), HttpStatus.BAD_REQUEST);
        if(serviceExperiencia.existsByNombreE(dtoexp.getNombreE()) && serviceExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("La experiencia requiere un nombre"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = serviceExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setDescripcionE((dtoexp.getDescripcionE()));
        
        serviceExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("La experiencia fue actualizada correctamente"), HttpStatus.OK);
             
    }
}
