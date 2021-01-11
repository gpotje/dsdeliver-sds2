
import React from 'react';
import { StyleSheet, Text, View, Image } from 'react-native';
import { RectButton, ScrollView } from 'react-native-gesture-handler';
import Header from '../Header';
import OrderCrad from '../OrderCard';

 function Orders() {


  return (
      <>
      <Header />
      <ScrollView  style={styles.container}>
        <OrderCrad />
        <OrderCrad />
        <OrderCrad />
        <OrderCrad />
        <OrderCrad />
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