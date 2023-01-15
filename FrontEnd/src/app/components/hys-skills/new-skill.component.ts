import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { skill } from 'src/app/model/skills';
import { skillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-new-skill',
  templateUrl: './new-skill.component.html',
  styleUrls: ['./new-skill.component.css']
})
export class NewSkillComponent implements OnInit{

  nombre: string;
  porcentaje: number;

  constructor(private skillservice: skillService, private router: Router){}
  ngOnInit(): void {
    
  }

  onCreate(): void{
    const Skill = new skill(this.nombre, this.porcentaje);
    this.skillservice.save(Skill).subscribe(
      data =>{
        alert("Skill agregado correctamente");
        this.router.navigate(['']);
      }, err =>{
        alert("Error al agregar el skill, probar nuevamente");
        this.router.navigate(['']);
      }
    )
  }
}
