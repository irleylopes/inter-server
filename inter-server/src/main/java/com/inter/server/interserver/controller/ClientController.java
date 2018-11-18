package com.inter.server.interserver.controller;

import com.inter.server.interserver.domain.Client;
import com.inter.server.interserver.domain.response.ClientResponse;
import com.inter.server.interserver.service.implement.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
@RequestMapping(value="client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value="/")
    public ModelAndView login() {

        ModelAndView mv = new ModelAndView("/login");
        return mv;
    }

    @GetMapping(value="/home")
    public ModelAndView home(Client client) {

        ModelAndView mv = new ModelAndView("/home");
        return mv;
    }

    @GetMapping(value="/add")
    public ModelAndView add(Client client) {

        ModelAndView mv = new ModelAndView("/client");
        mv.addObject("client", client);
        return mv;
    }

    @PostMapping(value="/save")
    public ModelAndView save(@Valid @RequestBody Client client, BindingResult result) {

        if(result.hasErrors()) {
            return add(client);
        }
        //,
        // ClientResponse clientResponse = clientService.create(client);

        return home(client);
    }

//    @PostMapping()
//    public ResponseEntity create(@Valid @RequestBody ClientRequest clientRequest) {
//        ClientResponse clientResponse = clientService.create(clientRequest);
//        return new ResponseEntity<>(clientResponse, HttpStatus.CREATED);
//    }
//
//    @PutMapping()
//    public ResponseEntity update(@Valid @RequestBody ClientRequest clientRequest) {
//        ClientResponse clientResponse = clientService.update(clientRequest);
//        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity get(@PathVariable("clientId") Long clientId) {
//        ClientResponse clientResponse = clientService.findById(clientId);
//        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity delete(@Valid @RequestBody ClientRequest clientRequest) {
//        clientService.delete(clientRequest);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
