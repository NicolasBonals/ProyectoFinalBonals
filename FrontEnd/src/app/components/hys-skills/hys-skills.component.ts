import { Component, OnInit } from '@angular/core';
import { skill } from 'src/app/model/skills';
import { skillService } from 'src/app/service/skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-hys-skills',
  templateUrl: './hys-skills.component.html',
  styleUrls: ['./hys-skills.component.css']
})
export class HysSkillsComponent implements OnInit{
  Skill: skill[]=[];

  constructor(private skillservice: skillService, private tokenService: TokenService){}
  isLogged = false;

  //metodos

  ngOnInit(): void {
    this.cargarSkill();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarSkill(): void{
    this.skillservice.lista().subscribe(
      data =>{
        this.Skill = data;
      }
    )
  }

  delete(id:number){
    if(id != undefined){
      this.skillservice.delete(id).subscribe(
        data =>{
          this.cargarSkill();
        }, err =>{
          alert("Error al borrar el skill, volver a intentar");
        }
      )
    }
  }
}
