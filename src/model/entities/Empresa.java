package model.entities;

import java.io.Serializable;

public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id_Empresa;
    private String email;
    private String razao_social;
    private String nome_fantasia;
    private String cnpj;
    private int qtd_funcionarios;
    private String telefone;
    private int pontuacao;

    // Metodos Construtores
    public Empresa() {
    }

    public Empresa(Integer id_Empresa, String email, String razao_social, String nome_fantasia, String cnpj, int qtd_funcionarios, String telefone, int pontuacao) {
        this.id_Empresa = id_Empresa;
        this.email = email;
        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
        this.cnpj = cnpj;
        this.qtd_funcionarios = qtd_funcionarios;
        this.telefone = telefone;
        this.pontuacao = pontuacao;
    }

    // Metodos get e set
    public Integer getId_Empresa() {
        return id_Empresa;
    }

    public void setId_Empresa(Integer id_Empresa) {
        this.id_Empresa = id_Empresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getQtd_funcionarios() {
        return qtd_funcionarios;
    }

    public void setQtd_funcionarios(int qtd_funcionarios) {
        this.qtd_funcionarios = qtd_funcionarios;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_Empresa == null) ? 0 : id_Empresa.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empresa other = (Empresa) obj;
        if (id_Empresa == null) {
            if (other.id_Empresa != null)
                return false;
        } else if (!id_Empresa.equals(other.id_Empresa))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id_Empresa=" + id_Empresa +
                ", email='" + email + '\'' +
                ", razao_social='" + razao_social + '\'' +
                ", nome_fantasia='" + nome_fantasia + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", qtd_funcionarios='" + qtd_funcionarios + '\'' +
                ", telefone='" + telefone + '\'' +
                ", pontuacao='" + pontuacao + '\'' +
                '}';
    }

}
