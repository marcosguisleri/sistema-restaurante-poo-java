package mx.florinda.modelo;

public class ItemCardapioBebida extends ItemCardapio {

    public ItemCardapioBebida(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        super(id, nome, descricao, preco, categoria);
    }

    @Override
    public double getImposto() {
        double imposto = 0;
        if (getCategoria() == CategoriaCardapio.BEBIDAS) {
            if (isEmPromocao()) {
                imposto = getPrecoComDesconto() * 0.5;
            } else {
                imposto = getPreco() * 0.5;
            }
        }
        return imposto;
    }
}
