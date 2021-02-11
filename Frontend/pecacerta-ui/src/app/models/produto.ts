import { Marca } from './marca';
import { Categoria } from 'src/app/models/categoria';
export class Produto{
  categoria: Categoria;
  codigo?:number;
  codigoDeBarras: string;
  nome: string;
  marca: Marca;
  descricao: string;
  preco: DoubleRange;
  quantidade: number
}
