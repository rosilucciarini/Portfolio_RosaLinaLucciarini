import { Component, OnInit } from "@angular/core";
import { Sobremi } from "src/app/model/sobremi";
import { SobremiService } from "src/app/service/sobremi.service";
import { TokenService } from "src/app/service/token.service";


@Component({
  selector: 'app-sobremi',
  templateUrl: './sobremi.component.html',
  styleUrls: ['./sobremi.component.css']
 
  
})
export class SobremiComponent implements OnInit {
  sobremi: Sobremi[] = [];
  

  constructor(private sobremiService: SobremiService, private tokenService: TokenService) { }
isLogged= false;
 
  ngOnInit(): void {
    this.cargarSobremi();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
    
  }

  cargarSobremi(): void{
    this.sobremiService.lista().subscribe(
      data =>{
        this.sobremi = data;
      }
    )
  }

  delete(id?: number){
    if(id != undefined){
      this.sobremiService.delete(id).subscribe(
        (        data): void => {
          this.cargarSobremi();
        }, err => {
          alert("No se pudo borrar informacion");
        }
      )
    }
  }
}

