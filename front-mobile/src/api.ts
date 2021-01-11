import axios from "axios";

const API_URL = 'https://gpot.herokuapp.com';



export function fetcOrders(){
    return axios(`${API_URL}/orders`);
}

export function confirDelivery(ordersId:number){
    return axios.put(`${API_URL}/orders/${ordersId}/delivered`)

}