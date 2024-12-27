package io.acordi.mscards.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CardBrand brand;

    private BigDecimal income;

    @Column(name="card_limit")
    private BigDecimal limit;

    public Card() {
    }

    public Card(String name, CardBrand brand, BigDecimal income, BigDecimal limit) {
        this.name = name;
        this.brand = brand;
        this.income = income;
        this.limit = limit;
    }

    public Card(Long id, String name, CardBrand brand, BigDecimal income, BigDecimal limit) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.income = income;
        this.limit = limit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardBrand getBrand() {
        return brand;
    }

    public void setBrand(CardBrand brand) {
        this.brand = brand;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
