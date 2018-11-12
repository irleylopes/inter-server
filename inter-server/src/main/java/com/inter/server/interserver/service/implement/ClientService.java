package com.inter.server.interserver.service.implement;

import com.inter.server.interserver.domain.Client;
import com.inter.server.interserver.domain.response.ClientResponse;
import com.inter.server.interserver.service.interfaces.ClientServiceI;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService implements ClientServiceI {

    @Override
    public ClientResponse create(Client client) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Client findById(Long id) {
        return null;
    }

    @Override
    public ClientResponse update(Client client) {
        return null;
    }

    @Override
    public String delete(Client client) {
        return null;
    }
}
