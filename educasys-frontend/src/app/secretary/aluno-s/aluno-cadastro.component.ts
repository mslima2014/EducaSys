import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs/Subscription";
import {Observable} from "rxjs/Observable";
import {ActivatedRoute, Router} from "@angular/router";
import {SecretariaService} from "../secretaria.service";
import {Aluno} from "./aluno-s.model";

@Component({
  selector: 'aluno-cadastro-component',
  templateUrl: './aluno-cadastro.component.html',
  styleUrls: ['./aluno-cadastro.component.css']
})
export class AlunoCadastroComponent implements OnInit {

  private timer;
  private sub: Subscription;
  open: boolean = true;
  opened: string = 'open';
  closed: string = 'content';
  disabledEdit: boolean = false;
  title: string;
  id: number;
  aluno: Aluno;

  constructor(private router: Router, private route:ActivatedRoute, private secretariaService: SecretariaService) {
    this.aluno = new Aluno();
    if(route.snapshot.params['type'] == 1){
      this.title = "Cadastrar"
    }else if(route.snapshot.params['type'] == 2){
      this.disabledEdit = true;
      this.title= 'Visualizar';
      this.id = route.snapshot.params['id'];
      this.getAluno();
    }else if(route.snapshot.params['type'] == 3){
      this.title= 'Editar';
      this.id = route.snapshot.params['id'];
      this.getAluno();
    }
  }

  getAluno(){
    this.secretariaService.getAlunoById(this.id).subscribe(
      aluno => {
        this.aluno = aluno;
      }
    );
  }

  ngOnInit() {
    this.timer = Observable.timer(500);
    this.sub = this.timer.subscribe(t => this.changeOpt());
  }

  changeOpt(){
    this.open = !this.open;
  }

  goBack(){
    this.router.navigate(['aluno-s']);
  }

}