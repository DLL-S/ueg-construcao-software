import { Marca } from './marca';
import { Categoria } from 'src/app/models/categoria';

export class Produto{
  codigo?:number;
  codigoDeBarras: string;
  nome: string;
  descricao: string;
  categoria: Categoria;
  marca: Marca;
  preco: DoubleRange;
  qtdeEstoque: number
}
