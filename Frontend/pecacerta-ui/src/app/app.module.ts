import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './componentes/login/login.component'
import { CabecalhoComponent } from './componentes/cabecalho/cabecalho.component';
import { BarraLateralComponent } from './componentes/sistema/barra-lateral/barra-lateral.component';
import { CategoriasComponent } from './componentes/sistema/categorias/categorias.component';
import { CategoriaService } from './services/categoria-service';
import { MensagensComponent } from './componentes/utils/mensagens/mensagens.component';
import { PaginaConstrucaoComponent } from './componentes/utils/pagina-construcao/pagina-construcao.component';
import { PaginaNaoEncontradaComponent } from './componentes/utils/pagina-nao-encontrada/pagina-nao-encontrada.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BarraLateralComponent,
    CabecalhoComponent,
    CategoriasComponent,
    MensagensComponent,
    PaginaConstrucaoComponent,
    PaginaNaoEncontradaComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    InputTextModule,
    FormsModule,
    ButtonModule,
    TableModule
  ],
  providers: [CategoriaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
