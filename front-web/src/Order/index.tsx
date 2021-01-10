import { useEffect, useState } from 'react';

import { toast } from 'react-toastify';
import Footer from '../Footer';
import { fetchProducts, saveOrder} from './api';
import { checkIsSelected } from './Helpes';
import OrderLocation from './OrderLocation';
import OrderSumary from './OrderSumary';
import ProductsList from './ProductsList';
import StepsHeader from './StepsHeader';
import './styles.css';
import { OrderLocationData, Product } from './types';



function Orders(){
        const [product,setProducts] = useState<Product[]>([]);
        const [selectedproducts,setselectedProducts] = useState<Product[]>([]);
        const [orderLocation,setOrderLocation] = useState<OrderLocationData>();
        const totalPrice = selectedproducts.reduce((sum,item)=>{
                    return sum + item.price;
        },0);

        
/*
        useEffect(()=>{
            fetchProducts().
            then(response => setProducts(response.data)).
            catch(error => "deu ruim" )    
        },[]);
*/
        const handleSelectProduct = (product: Product) => {
            const isAlreadySelected  = checkIsSelected(selectedproducts,product);
          
            if (isAlreadySelected) {
              const selected = selectedproducts.filter(item => item.id !== product.id);
              setselectedProducts(selected);
            } else {
                setselectedProducts(previous => [...previous, product]);
            }
          }
          
         const handleSubmit = () => {
            const productsIds = selectedproducts.map(({ id }) => ({ id }));
            const payload = {
              ...orderLocation!,
              products: productsIds
            }
          
            saveOrder(payload).then((response) => {
              toast.error(`Pedido enviado com sucesso! Nº ${response.data.id}`);
              setselectedProducts([]);
            })
              .catch(() => {
                toast.warning('Erro ao enviar pedido');
              })
          }
          



        return(
            <>
                <div className="orders-container">
                   <StepsHeader/>
                   <ProductsList 
                   products={product}
                   onSelectProduct={handleSelectProduct}
                   selectedProducts={selectedproducts}
                   />
                   <OrderLocation onChangeLocation={location=>setOrderLocation(location)}
                   />
                   <OrderSumary 
                  amount={selectedproducts.length}
                  totalPrice={totalPrice}
                  onSubmit={handleSubmit}
                  />
               </div>
                <Footer />
            </>
        )

}

export default Orders;