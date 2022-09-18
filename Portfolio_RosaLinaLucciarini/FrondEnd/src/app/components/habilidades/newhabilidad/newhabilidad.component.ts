import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Habilidad } from 'src/app/model/habilidad';
import { HabilidadService } from 'src/app/service/habilidad.service';

@Component({
  selector: 'app-newhabilidad',
  templateUrl: './newhabilidad.component.html',
  styleUrls: ['./newhabilidad.component.css']
})
export class NewhabilidadComponent implements OnInit {
  nombreH: string = ''; 
  progreso: number
  
  

  constructor(private habilidadService: HabilidadService, private router: Router) { }

  ngOnInit(): void {

  }

  onCreate(): void{
    const habilidad = new Habilidad(this.nombreH, this.progreso);
    this.habilidadService.save(habilidad).subscribe(data=>{
      alert("Habilidad anadida");
      this.router.navigate(['']);

    }, err =>{
      alert("Falló");
      this.router.navigate(['']);
    } 
    )
  }

}
