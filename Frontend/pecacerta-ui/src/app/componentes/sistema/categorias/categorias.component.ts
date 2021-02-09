import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/models/categoria';
import { CategoriaService } from 'src/app/services/categoria-service';
import { SelectItem } from 'primeng/api';

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent implements OnInit {

  categorias: Categoria[];
  clonedCategorias: { [s: string]: Categoria; } = {};

  constructor(private categoriaService: CategoriaService) {
  }

  ngOnInit(): void {
    this.categoriaService.read().subscribe(Response => { this.categorias = Response });
  }

  onRowEditInit(categoria: Categoria) {
    if (categoria.codigo)
      this.clonedCategorias[categoria.codigo] = { ...categoria };
  }

  onRowEditSave(categoria: Categoria) {
    if (categoria.codigo)
      delete this.clonedCategorias[categoria.codigo];
    this.categoriaService.update(categoria);

  }

  onRowEditCancel(categoria: Categoria, index: number) {
    if (categoria.codigo) {
      this.categorias[index] = this.clonedCategorias[categoria.codigo];
      delete this.categorias[categoria.codigo];
    }
  }

}
