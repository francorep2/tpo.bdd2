import React, { useState } from 'react';
import './App.css';

function App() {
  const [activeTab, setActiveTab] = useState('crear');
  const [selectedOption, setSelectedOption] = useState('Hotel');
  const [hotel, setHotel] = useState({
    id: 0,
    name: '',
    address: { id: 0, street: '', number: '', city: '', state: '', postalCode: '', country: '' },
    phone: [''],
    email: '',
    cityAreas: '',
    poi: [{ poiId: 0, poiName: '' }],
    rooms: [{ roomId: 0, amenities: [''], price: 0, available: true }],
    price: 0
  });
  const [huesped, setHuesped] = useState({
    clientId: 0,
    name: '',
    lastName: '',
    email: '',
    phone: '',
    address: { id: 0, street: '', number: '', city: '', state: '', postalCode: '', country: '' }
  });

  const handleNestedChange = (event, setState, state) => {
    const { name, value, type, checked } = event.target;
    const inputValue = type === 'checkbox' ? checked : value;

    setState(prevState => {
      const newState = { ...prevState };
      const keys = name.split('.');

      let current = newState;
      while (keys.length > 1) {
        const key = keys.shift();
        if (!current[key]) current[key] = {};
        current = current[key];
      }
      current[keys[0]] = inputValue;

      return newState;
    });
  };

  const handleHotelChange = (event) => {
    handleNestedChange(event, setHotel, hotel);
  };

  const handleHuespedChange = (event) => {
    handleNestedChange(event, setHuesped, huesped);
  };

  const handleConfirmar = () => {
    alert("Exito!");
  };

  const handleCreateHotel = () => {
    const hotelJson = JSON.stringify(hotel);
    console.log(hotelJson); // Imprime el JSON en la consola

    const apiEndpoint = "http://localhost:8080/v1/hotels"; // Reemplaza con tu endpoint

    fetch(apiEndpoint, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: hotelJson,
    })
      .then(response => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error("Error al crear el hotel");
        }
      })
      .then(data => {
        console.log("Hotel creado exitosamente:", data);
        alert("Hotel creado exitosamente!");
      })
      .catch(error => {
        console.error("Error al crear el hotel:", error);
        alert("Error al crear el hotel.");
      });
  };

  const renderInputs = () => {
    if (selectedOption === 'Hotel') {
      return (
        <div>
          <h3>Crear Hotel</h3>
          <input type="text" name="name" placeholder="Nombre" onChange={handleHotelChange} />
          <input type="email" name="email" placeholder="Correo Electrónico" onChange={handleHotelChange} />

          <h4>Dirección</h4>
          <input type="text" name="address.street" placeholder="Calle" onChange={handleHotelChange} />
          <input type="text" name="address.number" placeholder="Número" onChange={handleHotelChange} />
          <input type="text" name="address.city" placeholder="Ciudad" onChange={handleHotelChange} />
          <input type="text" name="address.state" placeholder="Provincia/Estado" onChange={handleHotelChange} />
          <input type="text" name="address.postalCode" placeholder="Código Postal" onChange={handleHotelChange} />
          <input type="text" name="address.country" placeholder="País" onChange={handleHotelChange} />

          <h4>Teléfonos</h4>
          <input type="text" name="phone[0]" placeholder="Teléfono" onChange={handleHotelChange} />

          <h4>Áreas de la Ciudad</h4>
          <input type="text" name="cityAreas" placeholder="Áreas de la Ciudad" onChange={handleHotelChange} />

          <h4>Punto de Interés</h4>
          <input type="text" name="poi[0].poiName" placeholder="Nombre del Punto de Interés" onChange={handleHotelChange} />

          <h4>Habitaciones</h4>
          <input type="number" name="rooms[0].price" placeholder="Precio de la Habitación" onChange={handleHotelChange} />
          <input type="text" name="rooms[0].amenities[0]" placeholder="Amenidad de la Habitación" onChange={handleHotelChange} />
          <input type="number" name="price" placeholder="Precio del Hotel" onChange={handleHotelChange} />
        </div>
      );
    } else if (selectedOption === 'Huesped') {
      return (
        <div>
          <h3>Crear Huésped</h3>
          <input type="text" name="name" placeholder="Nombre" onChange={handleHuespedChange} />
          <input type="text" name="lastName" placeholder="Apellido" onChange={handleHuespedChange} />
          <input type="text" name="phone" placeholder="Teléfono" onChange={handleHuespedChange} />
          <input type="email" name="email" placeholder="Correo Electrónico" onChange={handleHuespedChange} />

          <h4>Dirección</h4>
          <input type="text" name="address.street" placeholder="Calle" onChange={handleHuespedChange} />
          <input type="text" name="address.number" placeholder="Número" onChange={handleHuespedChange} />
          <input type="text" name="address.city" placeholder="Ciudad" onChange={handleHuespedChange} />
          <input type="text" name="address.state" placeholder="Provincia/Estado" onChange={handleHuespedChange} />
          <input type="text" name="address.postalCode" placeholder="Código Postal" onChange={handleHuespedChange} />
          <input type="text" name="address.country" placeholder="País" onChange={handleHuespedChange} />
        </div>
      );
    } else {
      return <p>Seleccione una opción válida para crear.</p>;
    }
  };

  const renderContent = () => {
    switch (activeTab) {
      case 'crear':
        return (
          <div>
            <h2>Seleccione qué quiere crear:</h2>
            <select value={selectedOption} onChange={(e) => setSelectedOption(e.target.value)}>
              <option value="Hotel">Hotel</option>
              <option value="Punto de interes">Punto de Interés</option>
              <option value="Huesped">Huésped</option>
              <option value="Reserva">Reserva</option>
            </select>
            <div className="form-container">{renderInputs()}</div>
            <button 
              className="tabs-button confirm-button" 
              onClick={() => {
                if (selectedOption === 'Hotel') {
                  handleCreateHotel();
                } else {
                  handleConfirmar();
                }
              }}
            >
              Crear
            </button>
          </div>
        );
      // El resto del renderContent es igual
    }
  };

  return (
    <div className="App">
      <div className="tabs">
        {['crear', 'eliminar', 'editar', 'buscar'].map((tab) => (
          <button
            key={tab}
            className={activeTab === tab ? 'active' : ''}
            onClick={() => setActiveTab(tab)}
          >
            {tab.charAt(0).toUpperCase() + tab.slice(1)}
          </button>
        ))}
      </div>
      <div className="content">{renderContent()}</div>
    </div>
  );
}

export default App;
