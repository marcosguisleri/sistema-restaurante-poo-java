import mx.florinda.modelo.Cardapio;
import mx.florinda.modelo.ItemCardapio;
import mx.florinda.modelo.Restaurante;

void main() throws Exception {

    Restaurante restaurante = new Restaurante("Florinda", "Av. 123 - Araras/SP");

    String nomeArquivo = IO.readln("Digite o nome do arquivo: ");
    Cardapio cardapio = new Cardapio(nomeArquivo);

    restaurante.setCardapio(cardapio);

    restaurante.apresentarRestaurante();

    IO.println("----------------------------------------------");

    String linha = IO.readln("Digite um id de um item de cardápio: ");
    long idSelecionado = Long.parseLong(linha);

    ItemCardapio item = restaurante.getCardapio().getItensPorId(idSelecionado);

    IO.println("== Item do Cardápio ==");
    IO.println("Id: " + item.getId());
    IO.println("Nome: " + item.getNome());
    IO.println("Descrição: " + item.getDescricao());
    if (item.isEmPromocao()) {
        IO.println("Item em promoção! 🤑");
        double porcentagemDesconto = item.getPorcentagemDesconto();
        IO.println("Preco: de " + item.getPreco() + " por " + item.getPrecoComDesconto());
        IO.println("Porcentagem de desconto: " + porcentagemDesconto);
    } else {
        IO.println("Preco: " + item.getPreco());
        IO.println("Item não está em promoção");
    }
    IO.println("Categoria: " + item.getCategoria());
    IO.println("Imposto: " + item.getImposto());

    if (item.ehSemGluten()) {
        IO.println("Este item não contém glúten.");
    }

    IO.println("----------------------------------------------");

    IO.println("Soma dos preços: " + cardapio.getSomaDosPrecos());
    IO.println("Total de itens em promoção: " + cardapio.getTotalDeItensEmPromocao());

    double precoLimite = 10.0;
    IO.println("O primeiro preço que é maior que " + precoLimite + ": " + cardapio.getPrimeiroPrecoMaiorQueLimite(precoLimite));

    IO.println("----------------------------------------------");

    for (ItemCardapio itens : cardapio.getItens()) {
        if (itens.getPreco() <= precoLimite) {        // ← use "itens" aqui
            IO.println("Preço menor que " + precoLimite + ": " + itens.getNome());
        }
    }

}
