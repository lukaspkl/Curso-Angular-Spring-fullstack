import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente'
import {ClientesService} from '../../clientes.service'

@Component({
  selector: 'app-clientesform',
  templateUrl: './clientesform.component.html',
  styleUrls: ['./clientesform.component.css']
})
export class ClientesformComponent implements OnInit {

  cliente: Cliente;

  constructor(private service: ClientesService) {
    this.cliente = service.getCliente();
     
   }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(this.cliente)
  }

}
