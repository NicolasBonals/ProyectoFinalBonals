import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "environments/environment";
import { Observable } from "rxjs";
import { skill } from "../model/skills";



@Injectable({
    providedIn:'root'
})

export class skillService{

    URL = environment.URL + '/skill/';
    constructor(private httpClient: HttpClient){}

    //metodos

    public lista():Observable<skill[]>{
        return this.httpClient.get<skill[]>(this.URL + 'lista');
    }

    public details(id: number): Observable<skill>{
        return this.httpClient.get<skill>(this.URL + `detail/${id}`);
    }

    public save(Skill: skill):Observable<any>{
        return this.httpClient.post<any>(this.URL + 'create', Skill);
    }

    public update(id: number, Skill: skill):Observable<any>{
        return this.httpClient.put<any>(this.URL + `update/${id}`, Skill);
    }
    public delete(id: number):Observable<any>{
        return this.httpClient.delete<any>(this.URL + `delete/${id}`);
    }
}