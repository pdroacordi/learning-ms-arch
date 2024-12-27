package io.acordi.mscards.application.dto;

import io.acordi.mscards.domain.model.CardBrand;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

public class CardRequestDTO {

    private String name;

    @Enumerated(EnumType.STRING)
    private CardBrand brand;

    private BigDecimal income;

    private BigDecimal limit;

    public CardRequestDTO() {
    }

    public CardRequestDTO(String name, CardBrand brand, BigDecimal income, BigDecimal limit) {
        this.name = name;
        this.brand = brand;
        this.income = income;
        this.limit = limit;
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
