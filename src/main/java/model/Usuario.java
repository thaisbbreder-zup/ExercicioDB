package model;

//Tabela do nosso banco
public class Usuario {
    //Atributos = Colunas do banco
    private Long id_usuario;
    private String nome;

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
