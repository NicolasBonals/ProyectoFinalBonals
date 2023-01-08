import { HttpClient } from '@angular/common/http'; //utiliza el observable para manejar las peticiones y respuestas
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';


@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = 'http://localhost:8080/personas/';  
  
  constructor(private http: HttpClient) { }
  
  public getPersona(): Observable<persona>{
    return this.http.get<persona>(this.URL+'traer/perfil'); 
  }
}
