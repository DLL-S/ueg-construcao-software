import { Categoria } from 'src/app/models/categoria';
import { CategoriaService } from 'src/app/services/categoria-service';
import { Component, OnInit } from '@angular/core';
import { Produto } from 'src/app/models/produto';

@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html',
  styleUrls: ['./produtos.component.css']
})
export class ProdutosComponent implements OnInit {
  categorias: Categoria[] = [];
  produtos: Produto[] = [];
  clonedProdutos : {
    [s:string]:Produto;
  } = {};
  constructor(private categoriaService : CategoriaService) { }

  ngOnInit(): void {
    this.categoriaService.read().subscribe(Response => {this.categorias = Response});
  }

  onRowEditInit(produto: Produto) {
    if(produto.codigo)
    this.clonedProdutos[produto.codigo] = {...produto};
  }

  onRowEditSave(produto: Produto) {
      if (produto.codigo)
          delete this.clonedProdutos[produto.codigo];
        this.categoriaService.update(produto);

  }

  onRowEditCancel(produto: Produto, index: number) {
    if(produto.codigo){
      this.produtos[index] = this.clonedProdutos[produto.codigo];
      delete this.produtos[produto.codigo];
    }
  }
}
