package model;

public class Pessoa {
    private int id;
    private String nome;
    private String perfil;

    public Pessoa(String nome, String perfil){
        setNome(nome);
        setPerfil(perfil);
    }

    public Pessoa(String nome, String perfil, int id){
        setNome(nome);
        setPerfil(perfil);
        setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String pessoa = "ID: " + getId() + "\nNome: " + getNome() + "\nPerfil: " + getPerfil() + "\n\n";
        return pessoa;
    }
}
