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

  constructor(private marcaService: MarcaService, private messageService: MessageService, private confirmationService: ConfirmationService) { }

  ngOnInit() {
    this.marcaService.read().subscribe(Response => { this.marcas = Response });
  }

  editaMarca(marca: Marca) {
    this.marca = { ...marca };
  }

  salvaMarca() {
    this.submitted = true;

    if (this.marca.nome.trim()) {
      if (this.marca.codigo) {
        this.marcaService.update(this.marca).subscribe(
          response => { this.marcas[this.findIndexById(this.marca.codigo)] = response });
      }
      else {
        this.marcaService.create(this.marca).subscribe(
          response => { this.marcas.push(response) });
      }

      this.marcas = [...this.marcas];
      this.marca = {};
      window.location.reload();
    }
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
