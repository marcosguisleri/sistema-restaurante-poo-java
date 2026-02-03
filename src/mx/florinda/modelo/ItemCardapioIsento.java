package mx.florinda.modelo;

public class ItemCardapioIsento extends ItemCardapio {

    //construtor
    ItemCardapioIsento(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        super(id, nome, descricao, preco, categoria);
    }

    // reescrita de metodo (override)
    @Override // anotacao opcional
    public double getImposto() {
        return 0.0;
    }

}