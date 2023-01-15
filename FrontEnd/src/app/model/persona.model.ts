export class persona{ //atributos del objeto
    id?: number; //el ? le indica que el dato no es necesario, va a ser autogenerado
    nombre: string;
    apellido: string;
    descripcion: string;
    img: string;

    //constructor del objeto
    constructor(nombre: string,apellido: string, descripcion:string, img: string){ 
        this.nombre = nombre; //El "this.nombre" hace referencia al nombre de arriba, el segundo "nombre" es el que ingresa por parametro
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.img = img;  
        //el id no va porque es autogenerado
    }
}

//despues hago un servicio que utilice este modelo