package com.tpo.bdd2.tpo.bdd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpo.bdd2.tpo.bdd2.domain.HotelDTO;
import com.tpo.bdd2.tpo.bdd2.domain.PoiDTO;
import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.service.IHotelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/v1/hotels")
public class HotelRestController {

    @Autowired
    private IHotelService hotelService;

    @Operation(summary = "Crear nuevo Hotel")
    @ApiResponse(responseCode = "201", description = "Hotel creado")
    @PostMapping
    public HotelDTO createHotel(@RequestBody HotelDTO hotelDTO){
        return hotelService.createHotel(hotelDTO);
    }

    @Operation(summary = "Obtener Hotel por ID")
    @ApiResponse(responseCode = "200", description = "Hotel encontrado")
    @GetMapping("/{hotelId}")
    public HotelDTO getHotelById(@PathVariable("hotelId") String id){
        return hotelService.getHotelById(id);
    }

    @Operation(summary = "Actualizar Hotel")
    @ApiResponse(responseCode = "200", description = "Hotel actualizado")
    @PutMapping("/{hotelId}")
    public HotelDTO updateHotel(@PathVariable("hotelId") String id, @RequestBody HotelDTO hotelDTO){
        return hotelService.updateHotel(id, hotelDTO);
    }

    @Operation(summary = "Eliminar Hotel")
    @ApiResponse(responseCode = "204", description = "Hotel eliminado")
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable("hotelId") String id){
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Agregar habitacion a Hotel")
    @ApiResponse(responseCode = "200", description = "Habitacion agregada")
    @PostMapping("/{hotelId}/rooms/{roomId}")
    public  ResponseEntity<Void> addRoomToHotel(@PathVariable("hotelId") String hotelId, @PathVariable("roomId") String roomId){
        hotelService.addRoomToHotel(hotelId, roomId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar habitacion de Hotel")
    @ApiResponse(responseCode = "204", description = "Habitacion eliminada")
    @DeleteMapping("/{hotelId}/rooms/{roomId}")
    public ResponseEntity<Void> removeRoomFromHotel(@PathVariable("hotelId") String hotelId, @PathVariable("roomId") String roomId){
        hotelService.removeRoomFromHotel(hotelId, roomId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Obtener todos los hoteles")
    @ApiResponse(responseCode = "200", description = "Hoteles encontrados")
    @GetMapping
    public List<HotelDTO> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @Operation(summary = "Obtener todas las habitaciones de un hotel")
    @ApiResponse(responseCode = "200", description = "Habitaciones encontradas")
    @GetMapping("/{hotelId}/rooms")
    public List<RoomDTO> getAllRoomsByHotelId(@PathVariable("hotelId") String hotelId){
        return hotelService.getAllRoomsByHotelId(hotelId);
    }

    @Operation(summary = "Obtener todos los hoteles por POI")
    @ApiResponse(responseCode = "200", description = "Hoteles encontrados")
    @GetMapping("/by-pois/{poiName}")
    public List<HotelDTO> getHotelsBypoiName(@PathVariable String poiName){
        return hotelService.getAllHotelsBypoiName(poiName);
    }

    @Operation(summary = "Obtener todos los POIs de un hotel")
    @ApiResponse(responseCode = "200", description = "POIs encontrados")
    @GetMapping("/pois/{hotelId}")
    public List<PoiDTO> getAllPoiInHotel(@PathVariable("hotelId") String hotelId){
        return hotelService.getAllPoiInHotel(hotelId);
    }

    @Operation(summary = "Agregar POI a un hotel")
    @ApiResponse(responseCode = "200", description = "POI agregado")
    @PostMapping("/{hotelId}/pois")
    public ResponseEntity<Void> addPOIToHotel(@PathVariable("hotelId") String hotelId, @RequestBody PoiDTO poiDTO){
        hotelService.addPOIToHotel(hotelId, poiDTO);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar POI de un hotel")
    @ApiResponse(responseCode = "204", description = "POI eliminado")
    @DeleteMapping("/{hotelId}/pois/{poiId}")
    public ResponseEntity<Void> removePOIFromHotel(@PathVariable("hotelId") String hotelId, @PathVariable("poiId") String poiId){
        hotelService.removePOIFromHotel(hotelId, poiId);
        return ResponseEntity.noContent().build();
    }


}
