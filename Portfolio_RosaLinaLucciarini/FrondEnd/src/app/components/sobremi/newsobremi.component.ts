import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Sobremi } from "src/app/model/sobremi";
import { SobremiService } from "src/app/service/sobremi.service";


@Component({
  selector: 'app-newsobremi',
  templateUrl: './newsobremi.component.html',
  styleUrls: ['./newsobremi.component.css']
})
export class NewsobremiComponent implements OnInit {
  nombreS: string = '';
  descripcionS: string = '';
  img_url: string = '';
 

  constructor(private sobremiService: SobremiService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const sobremi = new Sobremi(this.nombreS, this.descripcionS, this.img_url);
    this.sobremiService.save(sobremi).subscribe(data =>{
      alert("Información anadida");
      this.router.navigate(['']);
    }, err =>{
      alert("Falló");
      this.router.navigate(['']);
    })
  }


}
