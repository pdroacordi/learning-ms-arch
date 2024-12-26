package io.acordi.msclients.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private LocalDate birthday;


    public Client() {
    }

    public Client(Long id, String name, String cpf, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthday = birthday;
    }

    public Client(String name, String cpf, LocalDate birthday) {
        this.name = name;
        this.cpf = cpf;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
