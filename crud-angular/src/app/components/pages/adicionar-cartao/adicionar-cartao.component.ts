import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Cartao } from 'src/app/cartao';
import { HomeService } from 'src/app/services/home.service';
import { Usuario } from 'src/app/usuario';
@Component({
  selector: 'app-adicionar-cartao',
  templateUrl: './adicionar-cartao.component.html',
  styleUrls: ['./adicionar-cartao.component.css'],
})
export class AdicionarCartaoComponent {
  id = Number(this.route.snapshot.paramMap.get('id'));
  user!: Usuario;
  cartaoTrabalhador: Cartao = {
    tipoCartao: 'TRABALHADOR',
    status: true,
    usuario: this.user,
  };

  cartaoComum: Cartao = {
    tipoCartao: 'COMUM',
    status: true,
  };

  cartaoEstudantil: Cartao = {
    tipoCartao: 'ESTUDANTIL',
    status: true,
  };

  constructor(
    private homeService: HomeService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.homeService.getUsuarioId(this.id).subscribe((u) => (this.user = u));
  }

  adicionarTrabalhador() {
    this.homeService
      .adicionarCartao(this.id, this.cartaoTrabalhador)
      .subscribe((_) => this.router.navigate([`${this.id}/meusCartoes`]));
  }

  adicionarComum() {
    this.homeService
      .adicionarCartao(this.id, this.cartaoComum)
      .subscribe((_) => this.router.navigate([`${this.id}/meusCartoes`]));
  }

  adicionarEstudantil() {
    this.homeService
      .adicionarCartao(this.id, this.cartaoEstudantil)
      .subscribe((_) => this.router.navigate([`${this.id}/meusCartoes`]));
  }
}
