package com.inter.server.interserver.service.interfaces;

import com.inter.server.interserver.domain.Client;
import com.inter.server.interserver.domain.request.ClientRequest;
import com.inter.server.interserver.domain.response.ClientResponse;

import java.util.List;

public interface ClientServiceI {

    ClientResponse create(ClientRequest client);

    ClientResponse findById(Long id);

    ClientResponse update(ClientRequest client, Long id);

    void cancelUser(ClientRequest client);

    void clientSaved(Client clientSave);

    void clientExist(Client client);

    void clientNotExist(Client client);

    Client buildClient(ClientRequest clientRequest);
}