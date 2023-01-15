package com.portfolionab.nab.Controller;

import com.portfolionab.nab.Dto.dtoEducacion;
import com.portfolionab.nab.Entity.Educacion;
import com.portfolionab.nab.Security.Controller.Mensaje;
import com.portfolionab.nab.Service.ServiceEducacion;
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

@RestController //Lo marco como controller
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerEducacion {
    @Autowired
    ServiceEducacion serviceEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = serviceEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) { //se busca a partir del id
        if (!serviceEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID buscado"), HttpStatus.BAD_REQUEST);
        }    
        Educacion educacion = serviceEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){ //se elimina a partir del id
        if(!serviceEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID buscado"), HttpStatus.NOT_FOUND);
        }
        serviceEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada correctamente"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(serviceEducacion.existsByNombreE(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre seleccionado ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(
                dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE()
            );
        serviceEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion agregada correctamente"), HttpStatus.OK);
                
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!serviceEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID buscado"), HttpStatus.NOT_FOUND);
        }
        if(serviceEducacion.existsByNombreE(dtoeducacion.getNombreE()) && serviceEducacion.getByNombreE(dtoeducacion.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("El nombre seleccionado ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = serviceEducacion.getOne(id).get();
        
        educacion.setNombreE(dtoeducacion.getNombreE());
        educacion.setDescripcionE(dtoeducacion.getDescripcionE());
        
        serviceEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada correctamente"), HttpStatus.OK);
    }
    
}
