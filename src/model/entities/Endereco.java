package model.entities;

import java.io.Serializable;

public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id_Endereco;
    private String cidade;
    private String numero;
    private String estado;
    private String bairro;
    private String cep;
    private String complemento;


    public Endereco(Integer id_Endereco, String cidade, String numero, String estado, String bairro, String cep, String complemento) {
        this.id_Endereco = id_Endereco;
        this.cidade = cidade;
        this.numero = numero;
        this.estado = estado;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
    }

    public Endereco(){

    }

    public Integer getId_Endereco() {
        return id_Endereco;
    }

    public void setId_Endereco(Integer id_Endereco) {
        this.id_Endereco = id_Endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_Endereco == null) ? 0 : id_Endereco.hashCode());
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
        Endereco other = (Endereco) obj;
        if (id_Endereco == null) {
            if (other.id_Endereco != null)
                return false;
        } else if (!id_Endereco.equals(other.id_Endereco))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id_Endereco=" + id_Endereco +
                ", cidade='" + cidade + '\'' +
                ", numero='" + numero + '\'' +
                ", estado='" + estado + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }

}
