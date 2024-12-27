package io.acordi.mscards.domain.service;

import io.acordi.mscards.domain.model.ClientCard;
import io.acordi.mscards.domain.repository.ClientCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCardService {

    private final ClientCardRepository clientCardRepository;

    public ClientCardService(ClientCardRepository clientCardRepository) {
        this.clientCardRepository = clientCardRepository;
    }

    public List<ClientCard> getCardsByCpf(String cpf){
        return clientCardRepository.findAllByCpf(cpf);
    }
}
