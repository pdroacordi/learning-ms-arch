package io.acordi.mscards.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    @ManyToOne()
    @JoinColumn(name = "card_id")
    private Card card;

    @Column(name="card_limit")
    private BigDecimal limit;


    public ClientCard() {
    }

    public ClientCard(Long id, String cpf, Card card, BigDecimal limit) {
        this.id = id;
        this.cpf = cpf;
        this.card = card;
        this.limit = limit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
