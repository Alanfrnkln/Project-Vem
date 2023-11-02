import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Cartao } from 'src/app/cartao';
import { HomeService } from 'src/app/services/home.service';
import { Usuario } from 'src/app/usuario';

@Component({
  selector: 'app-meus-cartoes',
  templateUrl: './meus-cartoes.component.html',
  styleUrls: ['./meus-cartoes.component.css'],
})
export class MeusCartoesComponent {
  id = Number(this.route.snapshot.paramMap.get('id'));
  cartoes$ = new Observable<Cartao[]>();
  user!: Usuario;

  constructor(private homeService: HomeService, private route: ActivatedRoute) {
    this.getCartoes();
    this.homeService.getUsuarioId(this.id).subscribe((u) => (this.user = u));
  }

  getCartoes() {
    this.cartoes$ = this.homeService.getCartoes(this.id);
  }

  onClick(numeroCartao: number) {
    this.homeService
      .mudarStatus(numeroCartao)
      .subscribe((_) => this.getCartoes());
  }

  deletar(numeroCartao: number) {
    this.homeService
      .deletarCartao(this.id, numeroCartao)
      .subscribe((_) => this.getCartoes());
  }
}
