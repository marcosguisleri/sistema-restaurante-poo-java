package mx.florinda.leitor;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import mx.florinda.modelo.CategoriaCardapio;
import mx.florinda.modelo.ItemCardapio;
import mx.florinda.modelo.ItemCardapioBebida;
import mx.florinda.modelo.ItemCardapioSemGluten;
import mx.florinda.modelo.isento.ItemCardapioIsento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeitorItensCardapioGSON implements LeitorItensCardapio {

    private final String nomeArquivo;

    public LeitorItensCardapioGSON(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public ItemCardapio[] processaArquivo(String nomeArquivo) {
        try {

            String conteudoArquivo = Files.readString(Path.of(nomeArquivo));

            ItemCardapioJsonDTO[] dtos = new Gson().fromJson(conteudoArquivo, ItemCardapioJsonDTO[].class);

            ItemCardapio[] itens = new ItemCardapio[dtos.length];

            for (int i = 0; i < dtos.length; i++) {
                ItemCardapioJsonDTO dto = dtos[i];

                CategoriaCardapio categoria = CategoriaCardapio.valueOf(dto.categoria());

                ItemCardapio item;

                if (dto.impostoIsento()) {
                    item = new ItemCardapioIsento(dto.id(), dto.nome(), dto.descricao(), dto.preco(), categoria);
                } else if (dto.semGluten()) {
                    item = new ItemCardapioSemGluten(dto.id(), dto.nome(), dto.descricao(), dto.preco(), categoria);
                } else if (categoria == CategoriaCardapio.BEBIDAS) {
                    item = new ItemCardapioBebida(dto.id(), dto.nome(), dto.descricao(), dto.preco(), categoria);
                } else {
                    item = new ItemCardapio(dto.id(), dto.nome(), dto.descricao(), dto.preco(), categoria);
                }

                if (dto.emPromocao()) {
                    if (dto.precoComDesconto() == 0) {
                        throw new RuntimeException("Item " + dto.id() + " está em promoção mas precoComDesconto veio null");
                    }
                    item.setPromocao(dto.precoComDesconto());
                }

                itens[i] = item;
            }

            return itens;

        } catch (JsonSyntaxException e) {
            throw new RuntimeException("Erro de sintaxe no arquivo JSON", e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
