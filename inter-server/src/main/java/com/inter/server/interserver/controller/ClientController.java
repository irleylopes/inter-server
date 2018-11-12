package com.inter.server.interserver.controller;

import com.inter.server.interserver.domain.Client;
import com.inter.server.interserver.domain.response.ClientResponse;
import com.inter.server.interserver.service.implement.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@Valid @RequestBody Client clientRequest) {
        ClientResponse clientResponse = clientService.create(clientRequest);

        return new ResponseEntity<>(clientResponse, HttpStatus.CREATED);
    }
}
