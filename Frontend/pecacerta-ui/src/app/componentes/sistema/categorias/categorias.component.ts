import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/models/categoria';
import { CategoriaService } from 'src/app/services/categoria-service';
import { SelectItem } from 'primeng/api';
import { $, element } from 'protractor';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent implements OnInit {

  categoria : Categoria;
  submitted = false;
  textoBotao: String;


  categorias: Categoria[];


  constructor(private categoriaService : CategoriaService) {
   }

  ngOnInit(): void {
    this.categoria = new Categoria();
    this.textoBotao = "Salvar";
    this.categoriaService.read().subscribe(Response => {this.categorias = Response});    
  }

  salvarCategoria() {
    this.categoriaService
    .create(this.categoria).subscribe(data => {
      console.log(data)
      this.categoria = new Categoria();
    }, 
    error => console.log(error));
  }

  onSubmit(){
    this.submitted = true;
    if(this.categoria.codigo == null){
      this.salvarCategoria();
    } else{
      this.categoriaService.update(this.categoria).subscribe(
        response => { this.categorias[this.findIndexById(this.categoria.codigo)] = response });   
      }
      window.location.reload();

  }

findIndexById(codigo: number): number {
  let index = -1;
  for (let i = 0; i < this.categorias.length; i++) {
    if (this.categorias[i].codigo === codigo) {
      index = i;
      break;
    }
  }

  return index;
}


alteraCategoria(categoria: Categoria){
  this.textoBotao = "Alterar";
  this.categoria.codigo = categoria.codigo;
  this.categoria.nome = categoria.nome;
}

limpaFormulario(){
  window.location.reload();
  this.textoBotao = "Salvar";
}

}
