import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './componentes/login/login.component';
import { MarcasComponent } from './componentes/sistema/marcas/marcas.component';
import { PaginaConstrucaoComponent } from './componentes/utils/pagina-construcao/pagina-construcao.component';
import { PaginaNaoEncontradaComponent } from './componentes/utils/pagina-nao-encontrada/pagina-nao-encontrada.component';

const routes: Routes = [
  { path: "", component: MarcasComponent },
  { path: "login", component: LoginComponent },
  { path: "produtos", component: PaginaConstrucaoComponent },
  { path: "orcamentos", component: PaginaConstrucaoComponent },
  { path: "vendas", component: PaginaConstrucaoComponent },
  { path: "sistema/produtos", component: PaginaConstrucaoComponent },
  { path: "sistema/marcas", component: MarcasComponent },
  { path: "**", component: PaginaNaoEncontradaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
