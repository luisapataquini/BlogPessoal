import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  user: User = new User()
  senha: string

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  conferirSenha(event: any) {
    this.senha = event.target.value
  }

  cadastrar(){
    console.log("usuario usuario" + this.user.nome)
    console.log("usuario usuario" + this.user.usuario)
    console.log("usuario senha" + this.user.senha)
    console.log("senha variavel"+ this.senha)
    if(this.senha === this.user.senha){
     this.authService.cadastrar(this.user).subscribe((resp: User) =>{
      this.user = resp
      this.router.navigate(['/login'])
      alert('Usuário cadastrado com sucesso!!')
     })
    }else{
      alert('As senhas não conferem.')
    }
  }
}
