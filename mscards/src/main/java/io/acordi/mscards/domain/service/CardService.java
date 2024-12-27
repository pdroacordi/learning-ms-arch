package io.acordi.mscards.domain.service;

import io.acordi.mscards.application.dto.CardRequestDTO;
import io.acordi.mscards.application.mapper.CardMapper;
import io.acordi.mscards.domain.model.Card;
import io.acordi.mscards.domain.repository.CardRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

import java.math.BigDecimal;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Transactional
    public Card save(CardRequestDTO request) {
        Card card = CardMapper.INSTANCE.toCard(request);
        return cardRepository.save(card);
    }

    @Transactional
    public List<Card> findAllByIncomeLessThan(Long income){
        BigDecimal value = BigDecimal.valueOf(income);
        return cardRepository.findAllByIncomeIsLessThanEqual(value);
    }

    @Transactional
    public Card findById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }
}
