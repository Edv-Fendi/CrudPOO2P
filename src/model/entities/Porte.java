package model.entities;

public class Porte {
    private int id_Porte;
    private String nome;

    public Porte() {

    }

    public Porte(int id_Porte, String nome) {
        this.id_Porte = id_Porte;
        this.nome = nome;
    }

    public int getId_Porte() {
        return id_Porte;
    }

    public void setId_Porte(int id_Porte) {
        this.id_Porte = id_Porte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
