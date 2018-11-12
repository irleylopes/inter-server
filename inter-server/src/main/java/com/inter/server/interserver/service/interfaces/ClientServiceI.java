package com.inter.server.interserver.service.interfaces;

import com.inter.server.interserver.domain.Client;
import com.inter.server.interserver.domain.response.ClientResponse;

import java.util.List;

public interface ClientServiceI {

    ClientResponse create(Client client);

    List<Client> findAll();

    Client findById(Long id);

    ClientResponse update(Client client);

    String delete(Client client);
}
