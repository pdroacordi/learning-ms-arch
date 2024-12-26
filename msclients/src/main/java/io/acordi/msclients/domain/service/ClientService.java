package io.acordi.msclients.domain.service;

import io.acordi.msclients.application.dto.ClientRequestDTO;
import io.acordi.msclients.application.exception.InvalidClientException;
import io.acordi.msclients.application.mapper.ClientMapper;
import io.acordi.msclients.domain.model.Client;
import io.acordi.msclients.domain.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Client save(ClientRequestDTO request) {
        Client client = ClientMapper.INSTANCE.toClient(request);

        if( getByCpf(request.getCpf()) != null ) throw new InvalidClientException("The given CPF is already registered by another client");

        return clientRepository.save(client);
    }

    @Transactional
    public Client getByCpf(String cpf){
        return clientRepository.findByCpf(cpf).orElse(null);
    }

    @Transactional
    public Client getById(Long id){
        return clientRepository.findById(id).orElse(null);
    }
}
