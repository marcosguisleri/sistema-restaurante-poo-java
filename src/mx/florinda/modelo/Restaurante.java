package mx.florinda.modelo;

public class Restaurante {

    private String nome;
    private String endereco;
    private Cardapio cardapio;

    public Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public void apresentarRestaurante() {
        IO.println("Restaurante: " + getNome());
        IO.println("Endereço: " + getEndereco());
    }

}
