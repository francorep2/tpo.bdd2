package com.tpo.bdd2.tpo.bdd2.controller;

import java.time.LocalDate;
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

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.service.IRoomService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/v1/rooms")
public class RoomRestController {

    @Autowired
    private IRoomService roomService;

    @Operation(summary = "Crear nueva habitacion")
    @ApiResponse(responseCode = "201", description = "Habitacion creada")
    @PostMapping
    public RoomDTO createRoom(@RequestBody RoomDTO roomDTO){
        return roomService.createRoom(roomDTO);
    }

    @Operation(summary = "Obtener habitacion por id")
    @ApiResponse(responseCode = "200", description = "Habitacion encontrada")
    @GetMapping("/{roomId}")
    public RoomDTO getRoomById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }

    @Operation(summary = "Actualizar habitacion")
    @ApiResponse(responseCode = "200", description = "Habitacion actualizada")
    @PutMapping("/{roomId}")
    public RoomDTO updateRoom(@RequestBody RoomDTO roomDTO, @PathVariable Long id){
        return roomService.updateRoom(roomDTO, id);
    }

    @Operation(summary = "Eliminar habitacion")
    @ApiResponse(responseCode = "204", description = "Habitacion eliminada")
    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id){
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Obtener todas las habitaciones")
    @ApiResponse(responseCode = "200", description = "Habitaciones encontradas")
    @GetMapping
    public List<RoomDTO> getAllRooms(){
        return roomService.getAllRooms();
    }

    @Operation(summary = "Agregar amenidades a habitacion")
    @ApiResponse(responseCode = "200", description = "Amenidades agregadas")
    @PostMapping("/{roomId}/amenities")
    public RoomDTO addAmenitiesToRoom(@RequestBody List<String> amenities, @PathVariable Long id){
        return roomService.addAmenitiesToRoom(amenities, id);
    }

    @Operation(summary = "Eliminar amenidades de habitacion")
    @ApiResponse(responseCode = "200", description = "Amenidades eliminadas")
    @DeleteMapping("/{roomId}/amenities")
    public RoomDTO removeAmenitiesFromRoom(@RequestBody List<String> amenities, @PathVariable Long id){
        return roomService.removeAmenitiesFromRoom(amenities, id);
    }

    @Operation(summary = "Actualizar amenidades de habitacion")
    @ApiResponse(responseCode = "200", description = "Amenidades actualizadas")
    @PutMapping("/{roomId}/amenities")
    public RoomDTO updateRoomAmenities(@RequestBody List<String> amenities, @PathVariable Long id){
        return roomService.updateRoomAmenities(amenities, id);
    }

    
    @GetMapping("/available")
    public List<RoomDTO> findRoomByDateRange(@RequestBody LocalDate startDate, @RequestBody LocalDate endDate){
        return roomService.findRoomByDateRange(startDate, endDate);
    }

    @GetMapping("/{roomId}/amenities")
    public List<String> getAllAmenitiesByRoomId(@PathVariable Long id){
        return roomService.getAllAmenitiesByRoomId(id);
    }



}
