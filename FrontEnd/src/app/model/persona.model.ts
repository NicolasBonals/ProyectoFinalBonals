export class persona{
    id?: number; //el ? le indica que el dato no es necesario, va a ser autogenerado
    nombre: String;
    apellido: String;
    img: String;

    constructor(nombre: String,apellido: String, img: String){
        this.nombre = nombre; //El "this.nombre" hace referencia al nombre de arriba, el segundo "nombre" es el que ingresa por parametro
        this.apellido = apellido;
        this.img = img;  
        //el id no va porque es autogenerado
    }
}

//despues hago un servicio que utilice este modelo