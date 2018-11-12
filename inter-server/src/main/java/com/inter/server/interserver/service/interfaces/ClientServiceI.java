package com.inter.server.interserver.service.interfaces;

import com.inter.server.interserver.domain.Client;
import com.inter.server.interserver.domain.request.ClientRequest;
import com.inter.server.interserver.domain.response.ClientResponse;

import java.util.List;

public interface ClientServiceI {

    ClientResponse create(ClientRequest client);

    List<Client> findAll();

    ClientResponse findById(Long id);

    ClientResponse update(ClientRequest client);

    void delete(ClientRequest client);
}