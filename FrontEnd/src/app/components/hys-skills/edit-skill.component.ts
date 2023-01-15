import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { skill } from 'src/app/model/skills';
import { skillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-edit-skill',
  templateUrl: './edit-skill.component.html',
  styleUrls: ['./edit-skill.component.css']
})
export class EditSkillComponent implements OnInit{
  skill: skill = null;

  constructor(private skillservice: skillService, private activatedRouter: ActivatedRoute, private router: Router){}
  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.skillservice.details(id).subscribe(
      data =>{
        this.skill = data;

      }, err =>{
        alert("Error al modificar el skill, volver a intentar");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.skillservice.update(id, this.skill).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err =>{
        alert("Error al modificar el skill");
        this.router.navigate(['']);
      }
    )

  }

}
