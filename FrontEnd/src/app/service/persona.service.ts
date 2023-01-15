import { HttpClient } from '@angular/common/http'; //utiliza el observable para manejar las peticiones y respuestas
import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';


@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  //URL = 'http://localhost:8080/personas/';  
  URL = environment.URL + '/personas/';
  constructor(private httpClient: HttpClient) { }
  
  //Metodos
  public lista(): Observable<persona[]>{
    return this.httpClient.get<persona[]>(this.URL + 'lista');
  }

  public details(id: number): Observable<persona>{
    return this.httpClient.get<persona>(this.URL + `detail/${id}`);
  }
/*
  public save(Persona: persona): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'create', Persona);
  }
*/
  public update(id: number, Persona: persona): Observable<any>{
    return this.httpClient.put<any>(this.URL + `update/${id}`, Persona);
  }
/*
  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
  }
  */
}
