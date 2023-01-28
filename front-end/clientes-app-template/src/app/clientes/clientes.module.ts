import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientesRoutingModule } from './clientes-routing.module';
import { ClientesformComponent } from './clientesform/clientesform.component';
import {FormsModule} from '@angular/forms'


@NgModule({
  declarations: [ClientesformComponent],
  imports: [
    CommonModule,
    ClientesRoutingModule,
    FormsModule

  ], exports: [
    ClientesformComponent
  ]
})
export class ClientesModule { }
