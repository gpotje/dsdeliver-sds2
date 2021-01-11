import { useIsFocused, useNavigation } from '@react-navigation/native';
import React, { useEffect, useState } from 'react';
import { StyleSheet, Text, View, Image , Alert} from 'react-native';
import { RectButton, ScrollView, TouchableWithoutFeedback } from 'react-native-gesture-handler';
import { fetcOrders } from '../api';
import Header from '../Header';
import OrderCrad from '../OrderCard';
import { Order } from '../types';



 function Orders() {

  const [Orders,setOrders] = useState<Order[]>([]);
  const [isLoading,setIsLoading] = useState(false);
  const navigation = useNavigation();
  const isFocused = useIsFocused();

  const fetchData = ()=>{
    setIsLoading(true);
    fetcOrders()
    .then(respose => setOrders(respose.data))
    .catch(error =>Alert.alert('erro nos pedidos'))
   .finally(()=>setIsLoading(false)) 

  }

    useEffect(()=>{
      if(isFocused){
        fetchData();
      }
        
    },[isFocused]);

   

    const handleOnPress = (order : Order) =>{
      navigation.navigate('OrderDetails',{
        order
      });

}

  return (
      <>
      <Header />
      <ScrollView  style={styles.container}>
           {isLoading ?(
             <Text>Buscando pedidos ...</Text>

           ):(
            Orders.map(order =>(
              <TouchableWithoutFeedback 
              key={order.id} 
              onPress={() => handleOnPress(order)}>
                  <OrderCrad order={order} />
             </TouchableWithoutFeedback>
                ))
           )}
      </ScrollView>

   
    </>
  );
}

const styles = StyleSheet.create({
    
      container:{

        paddingRight:'5%',
        paddingLeft:'5%',
      }
      

});
export default Orders;