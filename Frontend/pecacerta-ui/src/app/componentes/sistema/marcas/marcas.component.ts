import { Component, OnInit } from '@angular/core';
import { ConfirmationService } from 'primeng/api';
import { MessageService } from 'primeng/api';
import { Marca } from './../../../models/marca';
import { MarcaService } from './../../../services/marca-service';

@Component({
  selector: 'app-marcas',
  templateUrl: './marcas.component.html',
  styleUrls: ['./marcas.component.css'],
  providers: [MessageService, ConfirmationService]
})
export class MarcasComponent implements OnInit {

  marcas: Marca[];
  marca: Marca = {};;
  submitted: boolean;
  textoBotao: String;

  constructor(private marcaService: MarcaService) {
  }

  ngOnInit(): void {
    this.marca = {};
    this.textoBotao = "Salvar";
    this.marcaService.read().subscribe(Response => { this.marcas = Response });
  }

  salvarMarca() {
    this.marcaService
      .create(this.marca).subscribe(data => {
        console.log(data)
        this.marca = {};
      },
        error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    if (this.marca.codigo == null) {
      this.salvarMarca();
    } else {
      this.marcaService.update(this.marca).subscribe(
        response => { this.marcas[this.findIndexById(this.marca.codigo)] = response });
    }
    window.location.reload();

  }

  alteraMarca(marca: Marca) {
    this.textoBotao = "Alterar";
    this.marca.codigo = marca.codigo;
    this.marca.nome = marca.nome;
  }

  findIndexById(codigo: number): number {
    let index = -1;
    for (let i = 0; i < this.marcas.length; i++) {
      if (this.marcas[i].codigo === codigo) {
        index = i;
        break;
      }
    }

    return index;
  }
}
