package mx.florinda.leitor;

import mx.florinda.modelo.CategoriaCardapio;
import mx.florinda.modelo.ItemCardapio;
import mx.florinda.modelo.ItemCardapioBebida;
import mx.florinda.modelo.ItemCardapioSemGluten;
import mx.florinda.modelo.isento.ItemCardapioIsento;

import java.io.IOException;

public class LeitorItensCardapioCSV extends LeitorItensCardapioBase {

    public LeitorItensCardapioCSV(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    protected ItemCardapio processaLinha(String linha) throws IOException {

        String[] partes = linha.split(";", -1);

        if (partes.length < 9) {
            throw new IOException("Linha CSV inválida (esperado 9 colunas, veio " + partes.length + "): " + linha);
        }

        long id = Long.parseLong(partes[0]);
        String nome = partes[1];
        String descricao = partes[2];
        double preco = Double.parseDouble(partes[3]);
        CategoriaCardapio categoria = CategoriaCardapio.valueOf(partes[4]);

        ItemCardapio item;

        boolean impostoIsento = Boolean.parseBoolean(partes[7]);
        boolean ehSemGluten = Boolean.parseBoolean(partes[8]);

        if (impostoIsento) {
            item = new ItemCardapioIsento(id, nome, descricao, preco, categoria);
        } else if (ehSemGluten) {
            item = new ItemCardapioSemGluten(id, nome, descricao, preco, categoria);
        } else if (categoria == CategoriaCardapio.BEBIDAS) {
            item = new ItemCardapioBebida(id, nome, descricao, preco, categoria);
        } else {
            item = new ItemCardapio(id, nome, descricao, preco, categoria);
        }

        boolean emPromocao = Boolean.parseBoolean(partes[5]);
        if (emPromocao) {
            String descontoStr = partes[6];
            if (descontoStr == null || descontoStr.isBlank()) {
                throw new IOException("Item marcado em promoção, mas sem preço com desconto (coluna 6): " + linha);
            }
            double precoComDesconto = Double.parseDouble(descontoStr);
            item.setPromocao(precoComDesconto);
        }

        return item;
    }
}
