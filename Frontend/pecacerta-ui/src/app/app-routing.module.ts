import { ProdutosComponent } from './componentes/sistema/produtos/produtos.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './componentes/login/login.component';
import { MarcasComponent } from './componentes/sistema/marcas/marcas.component';
import { PaginaConstrucaoComponent } from './componentes/utils/pagina-construcao/pagina-construcao.component';
import { PaginaNaoEncontradaComponent } from './componentes/utils/pagina-nao-encontrada/pagina-nao-encontrada.component';
import { CategoriasComponent } from './componentes/sistema/categorias/categorias.component';

const routes: Routes = [
  { path: "", component: ProdutosComponent },
  { path: "login", component: LoginComponent },
  { path: "produtos", component: PaginaConstrucaoComponent },
  { path: "orcamentos", component: PaginaConstrucaoComponent },
  { path: "vendas", component: PaginaConstrucaoComponent },
  { path: "sistema/categorias", component: CategoriasComponent },
  { path: "sistema/produtos", component: ProdutosComponent },
  { path: "sistema/marcas", component: MarcasComponent },
  { path: "sistema/estoque", component: PaginaConstrucaoComponent },
  { path: "sistema/funcionarios", component: PaginaConstrucaoComponent },
  { path: "**", component: PaginaNaoEncontradaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
