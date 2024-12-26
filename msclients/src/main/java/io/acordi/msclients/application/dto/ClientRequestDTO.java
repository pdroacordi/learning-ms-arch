package io.acordi.msclients.application.dto;

public class ClientRequestDTO {

    private String name;

    private String cpf;

    private String birthday;

    public ClientRequestDTO() {
    }

    public ClientRequestDTO(String name, String cpf, String birthday) {
        this.name = name;
        this.cpf = cpf;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
