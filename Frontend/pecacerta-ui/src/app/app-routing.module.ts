import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './componentes/login/login.component';
import { PaginaConstrucaoComponent } from './componentes/utils/pagina-construcao/pagina-construcao.component';
import { PaginaNaoEncontradaComponent } from './componentes/utils/pagina-nao-encontrada/pagina-nao-encontrada.component';

const routes: Routes = [
  { path: "", component: LoginComponent },
  { path: "**", component: PaginaNaoEncontradaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
