import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserData} from "../../services/userdata.service";
import {TeacherService} from "../teacher.service";
import {Professor} from "../../secretary/professor-s/professor-s.model";
import {AuthService} from "../../auth.service";

@Component({
  selector: 'menup-component',
  templateUrl: './menu-p.component.html',
  styleUrls: ['./menu-p.component.css']
})
export class MenuPComponent implements OnInit {

  code: string;
  professor: Professor = new Professor(-1,"","","","","","","");
  cssType: string;
  constructor(private router: Router, private teacherService: TeacherService, private authService: AuthService) {
    this.code = UserData.getUserCode();
  }

  ngOnInit() {
    if(window.screen.width < 768){
      this.cssType = 'sidebar-mobile fixed-sidebar';
    }else{
      this.cssType = 'sidebar fixed-sidebar';
    }

    this.teacherService.getProfessorByCode(this.code).subscribe(
      professor =>{
        this.professor = professor;
      }
    );

  }

  goDisciplinas(){
    this.router.navigate(['disciplinas-p/'+this.code]);
  }

  goHome(){
    this.router.navigate(['home-professor/'+this.code]);
  }

  goPerfil(){
    this.router.navigate(['perfil-p/'+this.code]);
  }

  logout(){
    this.authService.logout();
    this.router.navigate(['/']);
  }
}
