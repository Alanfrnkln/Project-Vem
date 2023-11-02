import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import { CadastroComponent } from './components/pages/cadastro/cadastro.component';
import { LoginComponent } from './components/pages/login/login.component';
import { MeusCartoesComponent } from './components/pages/meus-cartoes/meus-cartoes.component';
import { AdicionarCartaoComponent } from './components/pages/adicionar-cartao/adicionar-cartao.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'cadastro', component: CadastroComponent },
  { path: 'login', component: LoginComponent },
  { path: ':id/meusCartoes', component: MeusCartoesComponent },
  { path: ':id/adicionarCartao', component: AdicionarCartaoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
