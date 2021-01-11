    export type Order = {

         id:number ;
        address: string;
        latitude: number;
        longitude: number;
        moment: string;
        status: string;
        total: number,
        product: Product[];
    }

    export type Product = {
        id: number;
        name: String;
        price: number;
        description:String;
        imageUri: String;
    }

     
     
    