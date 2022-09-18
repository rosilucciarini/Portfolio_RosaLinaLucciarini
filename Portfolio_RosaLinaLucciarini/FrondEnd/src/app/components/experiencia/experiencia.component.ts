import { Component, OnInit } from '@angular/core';
import { Experiencia } from 'src/app/model/experiencia';
import { ServExperienciaService } from 'src/app/service/serv-experiencia.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  expe: Experiencia[] = [];

  constructor(private servExperiencia: ServExperienciaService, private tokenServise: TokenService) { }

  isLogged = false;



  ngOnInit(): void {
    this.cargarExperiencia();
    if(this.tokenServise.getToken()){
      this.isLogged = true;

    }else{
      this.isLogged = false;
    }
  }
  cargarExperiencia(): void {
    this.servExperiencia.lista().subscribe(data => { this.expe = data; })
  }
  
  delete(id?: number){
    if(id != undefined){
      this.servExperiencia.delete(id).subscribe(
        (        data): void => {
          this.cargarExperiencia();
        }, err => {
          alert("No se pudo borrar la experiencia");
        }
      )
    }
  }
}



