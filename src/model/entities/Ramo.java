package model.entities;

public class Ramo {
    private int id_Ramo;
    private String nome;

    public Ramo() {

    }

    @Override
    public String toString() {
        return "Ramo{" +
                "id_Ramo=" + id_Ramo +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Ramo(int id_Ramo, String nome) {
        this.id_Ramo = id_Ramo;
        this.nome = nome;
    }

    public int getId_Ramo() {
        return id_Ramo;
    }

    public void setId_Ramo(int id_Ramo) {
        this.id_Ramo = id_Ramo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
