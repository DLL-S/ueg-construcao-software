import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, EMPTY } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { Categoria } from '../models/categoria';



@Injectable()
export class CategoriaService {

    private baseUrl = "http://localhost:8080/api/v1/categoria";

    constructor( private http: HttpClient) { }
    
    create(categoria: Categoria): Observable<any> {
        return this.http.post<Categoria>(this.baseUrl, categoria).pipe(
          map((obj) => obj)
        );
      }
    
      read(): Observable<Categoria[]>{
        return this.http.get<Categoria[]>(this.baseUrl)
 
      }
    
      readById(id: number): Observable<Categoria> {
        const url = `${this.baseUrl}/${id}`;
        return this.http.get<Categoria>(url).pipe(
          map((obj) => obj)
        );
      }
    
      update(categoria: Categoria): Observable<Categoria> {
        const url = `${this.baseUrl}/${categoria.codigo}`;
        return this.http.put<Categoria>(url, categoria);
      }
}