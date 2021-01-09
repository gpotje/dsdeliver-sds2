import ProductsCard from "./ProductsCard";
import {Product} from './types';

type Props = {
        products: Product[];
}

function ProductsList({products}:Props){
        return(
                <div className="orders-list-container">
                   <div className="orders-list-items">
                  {products.map(products =>(
                        <ProductsCard key={products.id} product={products}/>
                  )) }
                 
               </div>
               </div>
               
            
        )

}

export default ProductsList;