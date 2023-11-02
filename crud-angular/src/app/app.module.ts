import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/pages/home/home.component';
import { CadastroComponent } from './components/pages/cadastro/cadastro.component';
import { LoginComponent } from './components/pages/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MeusCartoesComponent } from './components/pages/meus-cartoes/meus-cartoes.component';
import { AdicionarCartaoComponent } from './components/pages/adicionar-cartao/adicionar-cartao.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CadastroComponent,
    LoginComponent,
    MeusCartoesComponent,
    AdicionarCartaoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
