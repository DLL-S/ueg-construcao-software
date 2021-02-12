import { ProdutoService } from './services/produto-service';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { TableModule } from 'primeng/table';
import { CardModule } from 'primeng/card';
import { SidebarModule } from 'primeng/sidebar';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { ToolbarModule } from 'primeng/toolbar';
import { DialogModule } from 'primeng/dialog';
import { InputNumberModule } from 'primeng/inputnumber'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './componentes/login/login.component';
import { DropdownModule } from 'primeng/dropdown';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { CabecalhoComponent } from './componentes/cabecalho/cabecalho.component';
import { BarraLateralComponent } from './componentes/sistema/barra-lateral/barra-lateral.component';
import { CategoriasComponent } from './componentes/sistema/categorias/categorias.component';
import { CategoriaService } from './services/categoria-service';
import { ProdutosComponent } from './componentes/sistema/produtos/produtos.component';
import { MensagensComponent } from './componentes/utils/mensagens/mensagens.component';
import { PaginaConstrucaoComponent } from './componentes/utils/pagina-construcao/pagina-construcao.component';
import { PaginaNaoEncontradaComponent } from './componentes/utils/pagina-nao-encontrada/pagina-nao-encontrada.component';
import { MarcasComponent } from './componentes/sistema/marcas/marcas.component';
import { MarcaService } from './services/marca-service';
import { RodapeComponent } from './componentes/rodape/rodape.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BarraLateralComponent,
    CabecalhoComponent,
    CategoriasComponent,
    ProdutosComponent,
    MensagensComponent,
    PaginaConstrucaoComponent,
    PaginaNaoEncontradaComponent,
    MarcasComponent,
    RodapeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    InputTextModule,
    FormsModule,
    ButtonModule,
    TableModule,
    CardModule,
    DropdownModule,
    SidebarModule,
    MessagesModule,
    MessageModule,
    ToolbarModule,
    DialogModule,
    InputNumberModule
  ],
  providers: [
    CategoriaService,
    ProdutoService,
    MarcaService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
