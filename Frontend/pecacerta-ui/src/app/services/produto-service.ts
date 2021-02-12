import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, EMPTY } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { Produto } from '../models/produto';

@Injectable()
export class ProdutoService {

    private baseUrl = "http://localhost:8080/api/v1/produto";

    constructor( private http: HttpClient) { }

    create(produto: Produto): Observable<any> {
        return this.http.post<Produto>(this.baseUrl, produto).pipe(
          map((obj) => obj)
        );
      }

      read(): Observable<Produto[]>{
        return this.http.get<Produto[]>(this.baseUrl+"s")

      }

      readById(id: number): Observable<Produto> {
        const url = `${this.baseUrl}/${id}`;
        return this.http.get<Produto>(url).pipe(
          map((obj) => obj)
        );
      }

      update(produto: Produto): Observable<Produto> {
        const url = `${this.baseUrl}/${produto.codigo}`;
        return this.http.put<Produto>(url, produto);
      }
}
