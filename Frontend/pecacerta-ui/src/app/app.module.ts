import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './componentes/login/login.component';

import {InputTextModule} from 'primeng/inputtext';
import { FormsModule } from '@angular/forms';
import {ButtonModule} from 'primeng/button';
import { BarraLateralComponent } from './componentes/sistema/barra-lateral/barra-lateral.component';
import { CabecalhoComponent } from './componentes/cabecalho/cabecalho.component';
import { CategoriasComponent } from './componentes/sistema/categorias/categorias.component';
import {TableModule} from 'primeng/table';
import { HttpClientModule } from '@angular/common/http';
import { CategoriaService } from './services/categoria-service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BarraLateralComponent,
    CabecalhoComponent,
    CategoriasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    InputTextModule,
    FormsModule,
    ButtonModule,
    TableModule,
    HttpClientModule
  ],
  providers: [CategoriaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
