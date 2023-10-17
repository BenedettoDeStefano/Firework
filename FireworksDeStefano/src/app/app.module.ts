import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { ProdottiComponent } from './prodotti/prodotti.component';
import { VenditeComponent } from './vendite/vendite.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

const rotte: Routes = [
  {
    path: '',
    component:HomeComponent
  },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'prodotti',
    component: ProdottiComponent
  },
  {
    path : 'vendite',
    component: VenditeComponent
  }
]


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    ProdottiComponent,
    VenditeComponent
  ],
  imports: [
    RouterModule.forRoot(rotte),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
