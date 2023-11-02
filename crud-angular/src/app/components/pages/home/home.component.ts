import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { HomeService } from 'src/app/services/home.service';
import { Usuario } from 'src/app/usuario';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  usuarios$ = new Observable<Usuario[]>();

  constructor(private _homeService: HomeService) {
    this.getAll();
  }

  getAll() {
    this.usuarios$ = this._homeService.getTodosUsuarios();
  }

  // buttonClick() {
  //   if (!this.nome || !this.email || this.senha != this.confirmarSenha) return;

  //   if (this.id) {
  //     this.atualizar();
  //     return;
  //   }

  //   this._homeService
  //     .adicionarUsuario({
  //       nome: this.nome,
  //       email: this.email,
  //       senha: this.senha,
  //     })
  //     .subscribe((_) => this.getAll());
  // }

  // atualizar() {
  //   this._homeService
  //     .atualizarUsuario({
  //       id: this.id,
  //       nome: this.nome,
  //       email: this.email,
  //       cartoes: this.cartoes,
  //     })
  //     .subscribe((_) => this.getAll());
  // }

  deletar(id: number) {
    this._homeService.delete(id).subscribe((_) => this.getAll());
  }
}
