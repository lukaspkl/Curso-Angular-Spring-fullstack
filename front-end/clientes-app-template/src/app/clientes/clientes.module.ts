import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientesRoutingModule } from './clientes-routing.module';
import { ClientesformComponent } from './clientesform/clientesform.component';


@NgModule({
  declarations: [ClientesformComponent],
  imports: [
    CommonModule,
    ClientesRoutingModule
  ], exports: [
    ClientesformComponent
  ]
})
export class ClientesModule { }
