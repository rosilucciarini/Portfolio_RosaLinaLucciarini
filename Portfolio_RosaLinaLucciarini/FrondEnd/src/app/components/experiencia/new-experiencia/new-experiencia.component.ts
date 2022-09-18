import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { ServExperienciaService } from 'src/app/service/serv-experiencia.service';

@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css']
})
export class NewExperienciaComponent implements OnInit {
  nombrE: string = '';
  descripcionE: string ='';


  constructor(private servExperiencia: ServExperienciaService, private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void{
    const expe = new Experiencia(this.nombrE, this.descripcionE);
    this.servExperiencia.save(expe).subscribe(data=>{
      alert("Experiencia anadida");
      this.router.navigate(['']);

    }, err =>{
      alert("Falló");
      this.router.navigate(['']);
    } 
    )
  }

}
