package io.acordi.msclients.interfaces.controller;

import io.acordi.msclients.application.dto.ClientRequestDTO;
import io.acordi.msclients.domain.model.Client;
import io.acordi.msclients.domain.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody ClientRequestDTO client) {
        Client createdClient = clientService.save(client);
        return ResponseEntity.created( ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdClient.getId())
                .toUri()
        ).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable Long id) {
        Client client = clientService.getById( id );
        return client == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(client);
    }

    @GetMapping()
    public ResponseEntity<?> getClientByCpf(@RequestParam String cpf) {
        Client client = clientService.getByCpf(cpf);
        return client == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(client);
    }

}
