import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './componentes/login/login.component';
import {DropdownModule} from 'primeng/dropdown';
import {InputTextModule} from 'primeng/inputtext';
import { FormsModule } from '@angular/forms';
import {ButtonModule} from 'primeng/button';
import { BarraLateralComponent } from './componentes/sistema/barra-lateral/barra-lateral.component';
import { CabecalhoComponent } from './componentes/cabecalho/cabecalho.component';
import { CategoriasComponent } from './componentes/sistema/categorias/categorias.component';
import {TableModule} from 'primeng/table';
import { HttpClientModule } from '@angular/common/http';
import { CategoriaService } from './services/categoria-service';
import { ProdutosComponent } from './componentes/sistema/produtos/produtos.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BarraLateralComponent,
    CabecalhoComponent,
    CategoriasComponent,
    ProdutosComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    InputTextModule,
    FormsModule,
    ButtonModule,
    TableModule,
    HttpClientModule,
    DropdownModule
  ],
  providers: [CategoriaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
