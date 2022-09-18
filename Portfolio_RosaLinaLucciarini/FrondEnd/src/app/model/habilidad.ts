export class Habilidad {
    id?: number;
    nombreH: string; 
    progreso: number;
    

    constructor(nombreH: string, progreso: number){

        this.nombreH = nombreH;
        this.progreso = progreso
        
    }
}
