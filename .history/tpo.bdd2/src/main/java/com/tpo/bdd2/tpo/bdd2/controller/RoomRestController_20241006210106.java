package com.tpo.bdd2.tpo.bdd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/rooms")
public class RoomRestController {

    @Autowired
    private IRoomService roomService;

}
