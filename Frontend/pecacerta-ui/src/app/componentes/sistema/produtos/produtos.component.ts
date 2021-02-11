import { MarcaService } from './../../../services/marca-service';
import { ProdutoService } from './../../../services/produto-service';
import { Marca } from './../../../models/marca';
import { Categoria } from 'src/app/models/categoria';
import { CategoriaService } from 'src/app/services/categoria-service';
import { Component, OnInit } from '@angular/core';
import { Produto } from 'src/app/models/produto';
import { SelectItem } from 'primeng/api';
import { $, element } from 'protractor';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html',
  styleUrls: ['./produtos.component.css']
})
export class ProdutosComponent implements OnInit {
  categorias: Categoria[] = [];
  marcas: Marca[] = []
  produtos: Produto[] = [];
  produto: Produto;
  submitted = false;
  textoBotao: String;
  constructor(private categoriaService : CategoriaService, private marcaService : MarcaService, private produtoService : ProdutoService) { }

  ngOnInit(): void {
    this.produto = new Produto();
    this.categoriaService.read().subscribe(Response => {this.categorias = Response});
    this.marcaService.read().subscribe(Response => {this.marcas = Response});
    this.produtoService.read().subscribe(Response => {this.produtos = Response});
  }

  salvarProduto() {
    this.produtoService
    .create(this.produto).subscribe(data => {
      console.log(data)
      this.produto = new Produto();
    },
    error => console.log(error));
  }

  onSubmit(){
    this.submitted = true;
    if(this.produto.codigo == null){
      this.salvarProduto();
    } else{
      this.produtoService.update(this.produto).subscribe(
        response => { this.categorias[this.findIndexById(this.produto.codigo)] = response });
      }
      window.location.reload();

  }

findIndexById(codigo: number): number {
  let index = -1;
  for (let i = 0; i < this.produtos.length; i++) {
    if (this.produtos[i].codigo === codigo) {
      index = i;
      break;
    }
  }

  return index;
}


alteraCategoria(produto: Produto){
  this.textoBotao = "Alterar";
  this.produto.codigo = produto.codigo;
  this.produto.nome = produto.nome;
}

limpaFormulario(){
  window.location.reload();
  this.textoBotao = "Salvar";
}

}
