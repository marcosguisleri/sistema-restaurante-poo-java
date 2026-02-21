package mx.florinda.leitor;

import mx.florinda.modelo.ItemCardapio;

import java.io.IOException;

public interface LeitorItensCardapio {

    public abstract ItemCardapio[] processaArquivo(String nomeArquivo);

    static LeitorItensCardapio criaLeitor(String nomeArquivo) {

        LeitorItensCardapio leitor;

        if (nomeArquivo.endsWith(".csv")) {
            leitor = new LeitorItensCardapioCSV(nomeArquivo);
        } else if (nomeArquivo.endsWith(".json")) {
            leitor = new LeitorItensCardapioGSON(nomeArquivo);
        } else if (nomeArquivo.endsWith(".xml")) {
            leitor = new LeitorItensCardapioXML();
        } else {
            throw new IllegalArgumentException("Extensão do arquivo é inválida: " + nomeArquivo + " - deve ser .csv, .json ou .xml");
        }
        return leitor;
    }

}
