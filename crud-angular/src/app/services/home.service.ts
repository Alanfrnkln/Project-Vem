import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Usuario } from '../usuario';
import { Observable } from 'rxjs';
import { Cartao } from '../cartao';

@Injectable({
  providedIn: 'root',
})
export class HomeService {
  api = `${environment.api}`;

  constructor(private _http: HttpClient) {}

  getTodosUsuarios(): Observable<Usuario[]> {
    return this._http.get<Usuario[]>(`${this.api}/users`);
  }

  getUsuarioId(id: number): Observable<Usuario> {
    return this._http.get<Usuario>(`${this.api}/users/${id}`);
  }

  adicionarUsuario(user: Usuario): Observable<Usuario> {
    return this._http.post<Usuario>(`${this.api}/users/adicionar`, user);
  }

  atualizarUsuario(usuario: Usuario): Observable<Usuario> {
    return this._http.put<Usuario>(`${this.api}/users/${usuario.id}`, usuario);
  }

  delete(id: number): Observable<void> {
    return this._http.delete<void>(`${this.api}/users/${id}`);
  }

  // Métodos do cartão

  getCartoes(id: number): Observable<Cartao[]> {
    return this._http.get<Cartao[]>(`${this.api}/${id}/meusCartoes`);
  }

  mudarStatus(numeroCartao: number): Observable<void> {
    return this._http.put<void>(
      `${this.api}/${numeroCartao}/changeStatus`,
      null
    );
  }

  deletarCartao(id: number, numeroCartao: number): Observable<void> {
    return this._http.delete<void>(`${this.api}/${id}/${numeroCartao}`);
  }

  adicionarCartao(id: number, cartao: Cartao): Observable<void> {
    return this._http.post<void>(`${this.api}/${id}/adicionarCartao`, cartao);
  }
}
