import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { IndexComponent } from './index/index.component';
import { ProduitComponent } from './produit/produit.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    IndexComponent,
    ProduitComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
