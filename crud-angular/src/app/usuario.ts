import { Cartao } from './cartao';

export interface Usuario {
  id?: number;
  nome: string;
  email: string;
  senha?: string;
  cartoes?: Cartao[];
}

//Estilo type

// export type Usuario = {
//   id?: number;
//   nome: string;
//   email: string;
//   senha?: string;
//   cartoes?: Cartao[];
// };

// export type usuarioCadastro = Omit<Usuario, 'id'>;
