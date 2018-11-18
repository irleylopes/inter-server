package com.inter.server.interserver.service.implement;

import com.inter.server.interserver.domain.Client;
import com.inter.server.interserver.domain.request.ClientRequest;
import com.inter.server.interserver.domain.response.ClientResponse;
import com.inter.server.interserver.exception.BusinessRuleException;
import com.inter.server.interserver.exception.NonExistentException;
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
    public ClientResponse create(ClientRequest clientRequest) {
        Client client = buildClient(clientRequest);
        clientExist(client);
        Client clientSave = clientRepository.save(client);
        clientSaved(clientSave);
        return new ClientResponse(clientSave.getId(), clientSave.getUsername());
    }

    @Override
    public ClientResponse findById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(!clientOptional.isPresent()) {
            throw new NonExistentException("CLIENT","Client not exists");
        }
        Client client = clientOptional.get();
        return new ClientResponse(client.getId(), client.getUsername());
    }

    @Override
    public ClientResponse update(ClientRequest clientRequest, Long id) {
        // FIELD'S UPDATE -> NAME
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(!clientOptional.isPresent()) {
            throw new NonExistentException("CLIENT","Client not exists");
        }
        Client client = clientOptional.get();
        client.setUsername(clientRequest.getUsername());
        Client clientSave = clientRepository.save(client);
        clientSaved(clientSave);
        return new ClientResponse(clientSave.getId(), clientSave.getUsername());
    }

    @Override
    public void cancelUser(ClientRequest clientRequest) {

        Client client = clientRepository.findByCpf(clientRequest.getCpf());
        clientNotExist(client);
        client.setEnabled(false);
        Client clientSave = clientRepository.save(client);
        clientSaved(clientSave);
    }

    @Override
    public void clientSaved(Client clientSave) {

        if(clientSave==null) {
            throw new BusinessRuleException("INVALID_REGISTER", "Can Not Register Client");
        }
    }

    @Override
    public void clientExist(Client client) {
        Client clientE = clientRepository.findByCpf(client.getCpf());
        if(clientE!=null) {
            throw new BusinessRuleException("INVALID_REGISTER", "Client Already Has Registration");
        }
    }

    @Override
    public void clientNotExist(Client client)  {
        if(client==null){
            throw new NonExistentException("CLIENT NOT EXISTS","Client Not Exists in Database");
        }
    }

    @Override
    public Client buildClient(ClientRequest clientRequest) {
        return new Client(
                clientRequest.getUsername(),
                clientRequest.getCpf(),
                clientRequest.getPassword()
        );
    }
}
