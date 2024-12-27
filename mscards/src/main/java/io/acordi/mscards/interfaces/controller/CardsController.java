package io.acordi.mscards.interfaces.controller;

import io.acordi.mscards.application.dto.CardRequestDTO;
import io.acordi.mscards.domain.model.Card;
import io.acordi.mscards.domain.model.ClientCard;
import io.acordi.mscards.domain.service.CardService;
import io.acordi.mscards.domain.service.ClientCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cards")
public class CardsController {

    private final CardService cardService;
    private final ClientCardService clientCardService;

    public CardsController(CardService cardService, ClientCardService clientCardService) {
        this.cardService = cardService;
        this.clientCardService = clientCardService;
    }

    @PostMapping
    public ResponseEntity<?> addCard(@RequestBody CardRequestDTO dto) {
        Card card = cardService.save(dto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(card.getId())
                .toUri()
        ).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCardById(@PathVariable Long id) {
        Card card = cardService.findById(id);
        return card == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(card);
    }

    @GetMapping(params="income")
    public ResponseEntity<?> getCardsByIncomeLessThan(@RequestParam(name="income") Long income) {
        List<Card> cards = cardService.findAllByIncomeLessThan(income);
        return cards.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(cards);
    }

    @GetMapping(params="cpf")
    public ResponseEntity<?> getCardsByCpf(@RequestParam(name="cpf") String cpf) {
        List<ClientCard> clientCards = clientCardService.getCardsByCpf(cpf);
        List<Card> cards = clientCards.stream().map(ClientCard::getCard).collect(Collectors.toList());
        return cards.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(cards);
    }
}
