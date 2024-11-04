import requests
import json

hotel_id = 10
room_id = 10
reservation_id = 10
poi_id = 10
client_id = 10
room_id = 10
address_id = 10
base_url = "http://localhost:8080/v1"

def create_reservation():
    global reservation_id
    client_id = input("\nID del cliente: ")
    hotel_id = input("ID del hotel: ")
    room_id = input("ID de la habitacion: ")
    response = requests.post(f"{base_url}/reservations/{client_id}/{hotel_id}/{room_id}")
    print("Reserva creada:", response.json())

def create_client():
    global client_id
    client_id+=1
    client_name = input("Ingrese el nombre del cliente: ")
    client_lastname = input("Apellido: ")
    client_email = input("Correo electronico: ")
    phone_number = input("Numero telefonico: ")
    street_name = input("Nombre de calle: ")
    street_number = input("Numero de calle: ")
    city_name = input("Nombre de la ciudad: ")
    state_name = input("Nombre del estado/provincia: ")
    postal_code = input("Codigo postal: ")
    country_name = input("Nombre del pais: ")
   
    data = {
        "clientId": client_id,
        "name": client_name,
        "lastname": client_lastname,
        "email": client_email,
        "phone": phone_number,
        "address": {
            "id": address_id,
            "street": street_name,
            "number": street_number,
            "city": city_name,
            "state": state_name,
            "postalCode": postal_code,
            "country": country_name
        }
    }
    response = requests.post(f"{base_url}/clients", json=data)
    print("Cliente agregado:", response.json())

def create_hotel():
    global hotel_id, poi_id, address_id,room_id

    hotel_id += 1 
    poi_id += 1 
    address_id += 1 
    room_id += 1
    hotel_name = input("Ingrese el nombre del hotel ")
    street_name = input("Nombre de calle: ")
    street_number = input("Numero de calle: ")
    city_name = input("Nombre de la ciudad: ")
    state_name = input("Nombre del estado/provincia: ")
    postal_code = input("Codigo Postal: ")
    country_name = input("Nombre del pais: ")
    phone_number = input("Numero telefonico: ")
    email = input("Correo electronico: ")
    city_areas = input("Areas de la ciuidad: ")
    poi = input("Puntos de Interes: ")
    amenities = input("Amenities (separado por coma): ").split(",")
    r_price = input("Precio de habitacion: ")
    while True:
        opt = input("Esta disponible? Y/N: ")
        if opt =="Y":
            availability = True
            break
        elif opt =="N":
            availability = False
            break
        else:
            print("Opcion invalida. Elija nuevamente\n")
    price = input("Precio: ")

    data = {
        "id": hotel_id,
        "name": hotel_name,
        "address": {
            "id": address_id,
            "street": street_name,
            "number": street_number,
            "city": city_name,
            "state": state_name,
            "postalCode": postal_code,
            "country": country_name
        },
        "phone": [phone_number],
        "email": email,
        "cityAreas": city_areas,
        "poi": [
            {
                "poiId": poi_id,
                "poiName": poi
            }
        ],
        "rooms": [
            {
                "roomId": room_id,
                "amenities": amenities,
                "price": r_price,
                "available": availability
            }
        ],
        "price": price
    }
    response = requests.post(f"{base_url}/hotels", json=data)
    print("Hotel agregado:", response.json())

def create_room():
    global room_id
    room_id += 1
    
    amenities = input("Amenities de la habitacion(separado por coma): ").split(",")
    r_price = input("Precio de habitacion: ")
    while True:
        opt = input("Esta disponible? Y/N: ")
        if opt =="Y":
            availability = True
            break
        elif opt =="N":
            availability = False
            break
        else:
            print("Opcion invalida. Elija nuevamente\n")
    price = input("Precio: ")

    data = {
        "roomId": room_id,
        "amenities": amenities,
        "price": r_price,
        "available": availability
    }
    response = requests.post(f"{base_url}/rooms", json=data)
    print("Hotel agregado:", response.json())

def delete_hotel():
    id = input("Ingrese el ID del hotel a eliminar: ")
    response = requests.delete(f"{base_url}/hotels/{id}")
    print("Hotel eliminado!", response.status_code)

def delete_client():
    id = input("Ingrese el ID del cliente a eliminar: ")
    response = requests.delete(f"{base_url}/clients/{id}")
    print("Cliente eliminado!", response.status_code)

def delete_reservation():
    id = input("Ingrese el ID de la reserva a eliminar: ")
    response = requests.delete(f"{base_url}/bookings/{id}")
    print("Reserva eliminada!", response.status_code)

def delete_room():
    id = input("Ingrese el ID de la habitacion a eliminar: ")
    response = requests.delete(f"{base_url}/rooms/{id}")
    print("Habitacion eliminada!", response.status_code)

def update_reservation():
    reservation_id = input("Enter reservation ID to update: ")
    guest_name = input("Enter new guest name: ")
    room_type = input("Enter new room type: ")
    check_in_date = input("Enter new check-in date (YYYY-MM-DD): ")
    check_out_date = input("Enter new check-out date (YYYY-MM-DD): ")
    data = {
        "guestName": guest_name,
        "roomType": room_type,
        "checkInDate": check_in_date,
        "checkOutDate": check_out_date
    }
    response = requests.put(f"{base_url}/reservations/{reservation_id}", json=data)
    print("Reservation updated:", response.json())

def view_reservations():
    response = requests.get(f"{base_url}/reservations")
    reservations = response.json()
    for reservation in reservations:
        print(reservation)

def check_null_data(data, response):
     if response.status_code == 200:
        data = response.json()
        if data:
            print(json.dumps(data, indent=4))
        else:
            print("No se encontró lo buscado.")
     else:
        print(f"Error en la solicitud: {response.status_code}")

def fetch_hotel_poi():
    poi_name = input("\nIngrese el nombre del punto de interes: ")
    response = requests.get(f"{base_url}/hotels/by-pois/{poi_name}")
    data = response.json()
    check_null_data(data,response)

def fetch_bookings_cn():
    confirmation_number = input("\nIngrese el numero de confirmacion de la reserva: ")
    response = requests.get(f"{base_url}/bookings/confirmation/{confirmation_number}")
    data = response.json()
    check_null_data(data,response)

def fetch_poi_hotel():
    id = input("\nIngrese el ID del hotel: ")
    response = requests.get(f"{base_url}/hotels/pois/{id}")
    data = response.json()
    check_null_data(data,response)

def fetch_hotel():
    id = input("\nIngrese el ID del hotel: ")
    response = requests.get(f"{base_url}/hotels/{id}")
    data = response.json()
    check_null_data(data,response)

def fetch_amenities():
    id = input("\nIngrese el ID de la habitacion: ")
    response = requests.get(f"{base_url}/rooms/{id}/amenities")
    data = response.json()
    check_null_data(data,response)
def fetch_bookings_cn():
    confirmation_number = input("\nIngrese el numero de confirmacion de la reserva: ")
    response = requests.get(f"{base_url}/bookings/confirmation/{confirmation_number}")
    data = response.json()
    check_null_data(data,response)
    
def fetch_bookings_client():
    id = input("\nIngrese el id del cliente: ")
    response = requests.get(f"{base_url}/bookings/client/{id}")
    data = response.json()
    check_null_data(data,response)

def fetch_client():
    id = input("\nIngrese el ID del huesped: ")
    response = requests.get(f"{base_url}/clients/{id}")
    data = response.json()
    check_null_data(data,response)

def fetch_bookins_range():
    start_date = input("\nIngrese la fecha de inicio:YYYY-MM-DD  ")
    end_date = input("\nIngrese la fecha de fin: ")
    id = input("Ingrese el ID del hotel: ")
    response = requests.get(f"{base_url}/rooms/{id}/room-available?startDate={start_date}&endDate={end_date}")
    data = response.json()
    check_null_data(data,response)

def create_opt():
    while True:
        print("\nElija que elemento quiere agregar: ")
        print("1. Hotel")
        print("2. Cliente")
        print("3. Reserva")
        print("4. Habitacion")
        print("5. Salir")
        choice = input("Ingrese una opcion: ")
        
        if choice == "1":
            create_hotel()
        elif choice == "2":
            create_client()
        elif choice == "3":
            create_reservation()
        elif choice == "4":
            create_room()
        elif choice == "5":
            print("Saliendo...")
            break
        else:
            print("Opcion no reconocida. Elija otra\n")

def delete_opt():
    while True:
        print("\nElija que elemento quiere eliminar: ")
        print("1. Hotel")
        print("2. Cliente")
        print("3. Reserva")
        print("4. Habitacion")
        print("5. Salir")
        choice = input("Ingrese una opcion: ")
        
        if choice == "1":
            delete_hotel()
        elif choice == "2":
            delete_client()
        elif choice == "3":
            delete_reservation()
        elif choice == "4":
            delete_room()
        elif choice == "5":
            print("Saliendo...")
            break
        else:
            print("Opcion no reconocida. Elija otra\n")

def update_opt():
    while True:
        print("\nElija que elemento quiere modificar: ")
        print("1. Hotel")
        print("2. Cliente")
        print("3. Reserva")
        print("4. Habitacion")
        print("5. Salir")
        choice = input("Ingrese una opcion: ")
        
        if choice == "1":
            create_hotel()
        elif choice == "2":
            create_client()
        elif choice == "3":
            create_reservation()
        elif choice == "4":
            create_room()
        elif choice == "5":
            print("Saliendo...")
            break
        else:
            print("Opcion no reconocida. Elija otra\n")


def usecase_opt():
    while True:
        print("\nSeleccione una opcion: ")
        print("1. Traer hoteles cerca de un punto de interes")
        print("2. Traer puntos de interes cerca a un hotel")
        print("3. Traer amenities de una habitacion")
        print("4. Traer reservas por numero de confirmacion")
        print("5. Traer reservas por fecha de reserva en el hotel")
        print("6. Traer detalles de huesped")
        print("7. Traer reservas por rango de fecha en el hotel")
        print("8. Traer hotel")
        print("9. Traer reservas de huesped")
        print("0. Salir")
        choice = input("Ingrese una opcion: ")
        
        if choice == "1":
            fetch_hotel_poi()
        elif choice == "2":
            fetch_poi_hotel()
        elif choice == "3":
            fetch_amenities()
        elif choice == "4":
            fetch_bookings_cn()
        elif choice == "5":
            fetch_bookings_date()
        elif choice == "6":
            fetch_client()
        elif choice == "7":
            fetch_bookins_range()
        elif choice == "8":
            fetch_hotel()
        elif choice == "8":
            fetch_bookings_client()
        elif choice == "0":
            print("Saliendo...")
            break
        else:
            print("Opcion no reconocida. Elija otra\n")


def main_menu():
    while True:
        print("\nSistema de reserva de hoteles")
        print("1. Agregar")
        print("2. Eliminar")
        print("3. Actualizar")
        print("4. Casos de uso")
        print("5. Salir")

        choice = input("Ingrese una opcion: ")
        
        if choice == "1":
            create_opt()
        elif choice == "2":
            delete_opt()
        elif choice == "3":
            update_opt()
        elif choice == "4":
            usecase_opt()
        elif choice == "5":
            print("Saliendo...")
            break
        else:
            print("Opcion no reconocida. Elija otra\n")

if __name__ == "__main__":
    try:
        response = requests.get(f"{base_url}/bookings")
        if response.status_code == 200:
            print("Script conectado a API!\n")
        else:
            print("Received unexpected status code:", response.status_code)
    except requests.exceptions.ConnectionError:
        print("No se pudo conectar a la API. Fijate si esta corriendo springboot.\n")
    except Exception as e:
        print("Se encontro un error:", e)
    main_menu()
