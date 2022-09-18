export class Sobremi {
    id?: number;
    nombreS: string;
    descripcionS: string;
    img_url: string;

    constructor(nombreS: string, descripcionS: string, img_url: string){
        
        this.nombreS = nombreS;
        this.descripcionS = descripcionS;
        this.img_url = img_url;
    }
}
