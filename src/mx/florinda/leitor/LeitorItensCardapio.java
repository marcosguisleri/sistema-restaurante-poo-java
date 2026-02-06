package mx.florinda.leitor;

import mx.florinda.modelo.ItemCardapio;

import java.io.IOException;

public interface LeitorItensCardapio {

    public abstract ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException;

}
