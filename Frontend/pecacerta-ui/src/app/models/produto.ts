import { Categoria } from 'src/app/models/categoria';
export interface Produto{
  categoria: Categoria,
  codigo?:number,
  codigoDeBarras: string,
  nome: string,
  //marca: Marcas,
  descricao: string,
  preco: DoubleRange,
  quantidade: number
}
