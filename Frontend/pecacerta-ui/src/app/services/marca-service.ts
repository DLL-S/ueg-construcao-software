import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, } from 'rxjs/operators';
import { Marca } from '../models/marca';

@Injectable()
export class MarcaService {

	private baseUrl = "http://localhost:8080/api/v1/marcas";

	constructor(private http: HttpClient) { }

	create(marca: Marca): Observable<Marca> {
		return this.http.post<Marca>(this.baseUrl, marca).pipe(
			map((obj) => obj)
		);
	}

	read(): Observable<Marca[]> {
		return this.http.get<Marca[]>(this.baseUrl);

	}

	readById(id: number): Observable<Marca> {
		const url = `${this.baseUrl}/${id}`;
		return this.http.get<Marca>(url).pipe(
			map((obj) => obj)
		);
	}

	update(marca: Marca): Observable<Marca> {
		const url = `${this.baseUrl}/${marca.codigo}`;
		return this.http.put<Marca>(url, marca);
	}
}