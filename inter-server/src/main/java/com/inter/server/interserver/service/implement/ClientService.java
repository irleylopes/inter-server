package com.inter.server.interserver.service.implement;

import com.inter.server.interserver.domain.Client;
import com.inter.server.interserver.domain.response.ClientResponse;
import com.inter.server.interserver.exception.BusinessRuleException;
import com.inter.server.interserver.repository.ClientRepository;
import com.inter.server.interserver.service.interfaces.ClientServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements ClientServiceI {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientResponse create(Client client) {
        clientExist(client);
        Client clientSave = clientRepository.save(client);
        clientSaved(clientSave);
        return new ClientResponse(clientSave.getId(), clientSave.getName());
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

    private void clientSaved(Client clientSave) {
        if(clientSave.getId()==null) {
            throw new BusinessRuleException("INVALID_REGISTER", "Can Not Register Client");
        }
    }

    private void clientExist(Client client) {
        Client clientE = clientRepository.findByCpf(client.getCpf());
        if(clientE!=null) {
            throw new BusinessRuleException("INVALID_REGISTER", "Client Already Has Registration");
        }
    }
}
