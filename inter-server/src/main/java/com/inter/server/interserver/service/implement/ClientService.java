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
        return new ClientResponse(clientSave.getId(), clientSave.getName());
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public ClientResponse findById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isEmpty()){
            throw new NonExistentException("CLIENT NOT EXISTS","Client Not Exists in Database");
        }
        Client client = clientOptional.get();
        return new ClientResponse(client.getId(), client.getName());
    }

    @Override
    public ClientResponse update(ClientRequest clientRequest) {
        Client client = clientRepository.findByCpf(clientRequest.getCpf());
        clientNotExist(client);
        Client clientUpdate = buildClient(clientRequest);
        clientUpdate.setId(client.getId());
        clientUpdate = clientRepository.save(clientUpdate);
        return new ClientResponse(clientUpdate.getId(), clientUpdate.getName());
    }

    @Override
    public void delete(ClientRequest clientRequest) {
        Client client = clientRepository.findByCpf(clientRequest.getCpf());
        clientNotExist(client);
        Client clientDelete = buildClient(clientRequest);
        clientDelete.setId(client.getId());
        clientRepository.save(clientDelete);
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

    private void clientNotExist(Client client) {
        if(client==null){
            throw new NonExistentException("CLIENT NOT EXISTS","Client Not Exists in Database");
        }
    }

    private Client buildClient(ClientRequest clientRequest) {
        return new Client(
                clientRequest.getName(),
                clientRequest.getCpf(),
                clientRequest.getEmail(),
                clientRequest.getPassword()
        );
    }
}
