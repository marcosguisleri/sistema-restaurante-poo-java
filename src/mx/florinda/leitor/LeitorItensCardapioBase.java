package mx.florinda.leitor;

import mx.florinda.modelo.ItemCardapio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class LeitorItensCardapioBase implements  LeitorItensCardapio {

    private final String nomeArquivo;

    public LeitorItensCardapioBase(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException {

        Path arquivo = Path.of(nomeArquivo);
        String conteudoArquivo = Files.readString(arquivo);

        String[] linhasArquivo = conteudoArquivo.split("\n");
        ItemCardapio[] itens = new ItemCardapio[linhasArquivo.length];

        for (int i = 0; i < linhasArquivo.length; i++) {

            String linha = linhasArquivo[i].strip();

            if (linha.isEmpty()) {
                continue;
            }

            ItemCardapio item = processaLinha(linha);

            itens[i] = item;

        }

        return itens;

    }

    protected abstract ItemCardapio processaLinha(String linha) throws IOException;

}
