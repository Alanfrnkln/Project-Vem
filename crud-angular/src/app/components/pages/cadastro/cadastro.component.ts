import { Component } from '@angular/core';
import { HomeService } from 'src/app/services/home.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css'],
})
export class CadastroComponent {
  //form
  nome: string = '';
  email: string = '';
  senha: string = '';
  confirmarSenha: string = '';

  constructor(private _homeService: HomeService, private router: Router) {}

  cadastrarNovoUsuario() {
    if (!this.nome || !this.email || this.senha != this.confirmarSenha) return;

    return this._homeService
      .adicionarUsuario({
        nome: this.nome,
        email: this.email,
        senha: this.senha,
      })
      .subscribe((_) => this.router.navigate(['/']));
  }
}
