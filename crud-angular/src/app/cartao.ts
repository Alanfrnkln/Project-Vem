import { Usuario } from './usuario';

export interface Cartao {
  numeroCartao?: number;
  nome?: string;
  status: boolean;
  tipoCartao: string;
  usuario?: Usuario;
}
