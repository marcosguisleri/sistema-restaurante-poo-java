package mx.florinda.leitor;

import mx.florinda.modelo.ItemCardapio;

import java.io.IOException;

public interface LeitorItensCardapio {

    public abstract ItemCardapio[] processaArquivo(String nomeArquivo) throws IOException;

    static LeitorItensCardapio criaLeitor(String nomeArquivo) {

        LeitorItensCardapio leitor = null;

        if (nomeArquivo.endsWith(".csv")) {
            leitor = new LeitorItensCardapioCSV(nomeArquivo);
        } else if (nomeArquivo.endsWith(".json")) {
            leitor = new LeitorItensCardapioJSON(nomeArquivo);
        } else if (nomeArquivo.endsWith(".xml")) {
            leitor = new LeitorItensCardapioXML();
        }
        return leitor;
    }

}
