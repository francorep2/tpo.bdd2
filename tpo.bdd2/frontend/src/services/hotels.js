import axios from 'axios';

const API_URL = 'http://localhost:8080/api/hotels'; // Ajustar al endpoint del backend

export const getHotels = () => axios.get(API_URL);
export const getHotelById = (id) => axios.get(`${API_URL}/${id}`);
export const createHotel = (data) => axios.post(API_URL, data);
export const updateHotel = (id, data) => axios.put(`${API_URL}/${id}`, data);
export const deleteHotel = (id) => axios.delete(`${API_URL}/${id}`);
