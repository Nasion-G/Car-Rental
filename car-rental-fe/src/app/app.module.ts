import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentsLoginComponent } from './components-login/components-login.component';
import { ComponentsComponent } from './components/components.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { CostumersComponent } from './components/costumers/costumers.component';

@NgModule({
  declarations: [
    AppComponent,
    ComponentsLoginComponent,
    ComponentsComponent,
    LoginComponent,
    RegisterComponent,
    CostumersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
