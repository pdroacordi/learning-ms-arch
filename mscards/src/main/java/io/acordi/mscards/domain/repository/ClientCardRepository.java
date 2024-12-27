package io.acordi.mscards.domain.repository;

import io.acordi.mscards.domain.model.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {
    List<ClientCard> findAllByCpf(String cpf);
}
