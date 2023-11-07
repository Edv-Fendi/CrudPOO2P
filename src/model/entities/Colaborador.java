package model.entities;

import java.io.Serializable;

public class Colaborador implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id_Colaborador;
    private String nome;
    private String telefone;
    private String email;
    private String funcao;
    private String setor;
    private boolean isAdmin;

    public Colaborador() {
    }

    public Colaborador(String nome, String telefone, String email, String funcao, String setor, boolean isAdmin) {
        this.id_Colaborador = id_Colaborador;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.funcao = funcao;
        this.setor = setor;
        this.isAdmin = isAdmin;
    }

    public void setId_Colaborador(Integer id_Colaborador) {this.id_Colaborador = id_Colaborador;
    }

    public Integer getId_Colaborador() {
        return id_Colaborador;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_Colaborador == null) ? 0 : id_Colaborador.hashCode());
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
        Colaborador other = (Colaborador) obj;
        if (id_Colaborador == null) {
            if (other.id_Colaborador != null)
                return false;
        } else if (!id_Colaborador.equals(other.id_Colaborador))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "id_Colaborador=" + id_Colaborador +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", funcao='" + funcao + '\'' +
                ", setor='" + setor + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public boolean getAdmin() {
        return isAdmin;
    }



    }
