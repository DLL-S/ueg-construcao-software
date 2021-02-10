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

  categoria : Categoria = new Categoria();
  submitted = false;


  categorias: Categoria[] = [];
  clonedCategorias : {
    [s:string]:Categoria;
  } = {};

  constructor(private categoriaService : CategoriaService) {
   }

  ngOnInit(): void {
    this.categoriaService.read().subscribe(Response => {this.categorias = Response});    
  }

  save() {
    this.categoriaService
    .create(this.categoria).subscribe(data => {
      console.log(data)
      this.categoria = new Categoria();
    }, 
    error => console.log(error));
  }

  onSubmit(){
    this.submitted = true;
    this.save();
    this.categoriaService.read().subscribe(Response => {this.categorias = Response});    
  }

  onRowEditInit(categoria: Categoria) {
    if(categoria.codigo)
    this.clonedCategorias[categoria.codigo] = {...categoria};
}

onRowEditSave(categoria: Categoria) {
    if (categoria.codigo)
      this.categoriaService.update(categoria.codigo);
    
}

onRowEditCancel(categoria: Categoria, index: number) {
  if(categoria.codigo){
    this.categorias[index] = this.clonedCategorias[categoria.codigo];
    delete this.categorias[categoria.codigo];
  }
}

}
