package mx.florinda.leitor;

import mx.florinda.modelo.CategoriaCardapio;
import mx.florinda.modelo.ItemCardapio;
import mx.florinda.modelo.ItemCardapioBebida;
import mx.florinda.modelo.ItemCardapioSemGluten;
import mx.florinda.modelo.isento.ItemCardapioIsento;

import java.io.IOException;

public class LeitorItensCardapioJSON extends LeitorItensCardapioBase {

    public LeitorItensCardapioJSON(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    protected ItemCardapio processaLinha(String linha) throws IOException {

        linha = linha.replace("[", "");
        linha = linha.replace("]", "");
        linha = linha.replace("{", "");
        linha = linha.replace("}", "");
        linha = linha.replace("\"", "");

        String[] partes = linha.split(",");

        String parteId = partes[0];
        String[] propriedadesEValorId = parteId.split(":");
        String valorId = propriedadesEValorId[1].trim();
        long id = Long.parseLong(valorId);

        String parteNome = partes[1];
        String[] propriedadesEValorNome = parteNome.split(":");
        String nome = propriedadesEValorNome[1].trim();

        String parteDescricao = partes[2];
        String[] propriedadesEValorDescricao = parteDescricao.split(":");
        String descricao = propriedadesEValorDescricao[1].trim();

        String partePreco = partes[3];
        String[] propriedadesEValorPreco = partePreco.split(":");
        String valorPreco = propriedadesEValorPreco[1].trim();
        double preco = Double.parseDouble(valorPreco);

        String parteCategoria = partes[4];
        String[] propriedadesEValorCategoria = parteCategoria.split(":");
        String valorCategoria = propriedadesEValorCategoria[1].trim();
        CategoriaCardapio categoria = CategoriaCardapio.valueOf(valorCategoria);

        ItemCardapio item;

        String parteImpostoIsento = partes[7];
        String[] propriedadesEValorImpostoIsento = parteImpostoIsento.split(":");
        String valorImpostoIsento = propriedadesEValorImpostoIsento[1].trim();
        boolean impostoIsento = Boolean.parseBoolean(valorImpostoIsento);

        String parteSemGluten = partes[8];
        String[] propriedadesEValorSemGluten = parteSemGluten.split(":");
        String valorSemGluten = propriedadesEValorSemGluten[1].trim();
        boolean ehSemGluten = Boolean.parseBoolean(valorSemGluten);

        if (impostoIsento) {
            item = new ItemCardapioIsento(id, nome, descricao, preco, categoria);
        } else if (ehSemGluten) {
            item = new ItemCardapioSemGluten(id, nome, descricao, preco, categoria);
        } else if (categoria == CategoriaCardapio.BEBIDAS) {
            item = new ItemCardapioBebida(id, nome, descricao, preco, categoria);
        } else {
            item = new ItemCardapio(id, nome, descricao, preco, categoria);
        }

        String parteEmPromocao = partes[5];
        String[] propriedadesEValorEmPromocao = parteEmPromocao.split(":");
        String valorEmPromocao = propriedadesEValorEmPromocao[1].trim();
        boolean emPromocao = Boolean.parseBoolean(valorEmPromocao);

        if (emPromocao) {
            String partePrecoComDesconto = partes[6];
            String[] propriedadesEValorPrecoComDesconto = partePrecoComDesconto.split(":");
            String valorPrecoComDesconto = propriedadesEValorPrecoComDesconto[1].trim();

            if (!valorPrecoComDesconto.equals("null") && !valorPrecoComDesconto.isBlank()) {
                double precoComDesconto = Double.parseDouble(valorPrecoComDesconto);
                item.setPromocao(precoComDesconto);
            }
        }
        return item;
    }

}
