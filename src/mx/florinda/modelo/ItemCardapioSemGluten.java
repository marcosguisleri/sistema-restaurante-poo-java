package mx.florinda.modelo;

public class ItemCardapioSemGluten extends ItemCardapio {

    public ItemCardapioSemGluten(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        super(id, nome, descricao, preco, categoria);
    }

    @Override
    public boolean ehSemGluten() {
        return true;
    }
}
