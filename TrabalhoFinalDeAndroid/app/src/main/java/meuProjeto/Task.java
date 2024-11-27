package meuProjeto;

public class Task {
    private String nome;
    private String data;
    private boolean concluido;

    public Task(String nome, String data, boolean concluido) {
        this.nome = nome;
        this.data = data;
        this.concluido = false;
    }

    public Task(String nome, String data) {
        this.nome = nome;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
