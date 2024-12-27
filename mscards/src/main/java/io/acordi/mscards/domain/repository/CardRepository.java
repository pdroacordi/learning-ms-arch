package io.acordi.mscards.domain.repository;

import io.acordi.mscards.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findAllByIncomeIsLessThanEqual(BigDecimal income);

}
