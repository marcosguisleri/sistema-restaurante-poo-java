package mx.florinda.leitor;

import mx.florinda.modelo.CategoriaCardapio;
import mx.florinda.modelo.ItemCardapio;
import mx.florinda.modelo.ItemCardapioBebida;
import mx.florinda.modelo.ItemCardapioSemGluten;
import mx.florinda.modelo.isento.ItemCardapioIsento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeitorItensCardapioXML implements LeitorItensCardapio {

    @Override
    public ItemCardapio[] processaArquivo(String nomeArquivo) {

        try {
            Path arquivo = Path.of(nomeArquivo);
            String conteudoArquivo = Files.readString(arquivo);

            String[] linhasArquivo = conteudoArquivo.split("\n");

            int quantidadeItens = 0;
            for (String linha : linhasArquivo) {
                if (linha.trim().contains("<item>")) {
                    quantidadeItens++;
                }
            }

            ItemCardapio[] itens = new ItemCardapio[quantidadeItens];

            Long id = null;
            String nome = null;
            String descricao = null;
            Double preco = null;
            CategoriaCardapio categoria = null;
            Boolean emPromocao = null;
            String precoComDescontoStr = null;
            Boolean impostoIsento = null;
            Boolean semGluten = null;

            int indiceItem = 0;

            for (String linha : linhasArquivo) {
                linha = linha.trim();

                if (linha.isEmpty()) {
                    continue;
                }

                if (linha.contains("<item>")) {
                    id = null;
                    nome = null;
                    descricao = null;
                    preco = null;
                    categoria = null;
                    emPromocao = null;
                    precoComDescontoStr = null;
                    impostoIsento = null;
                    semGluten = null;
                } else if (linha.contains("</item>")) {
                    if (id != null && nome != null && descricao != null && preco != null && categoria != null) {
                        ItemCardapio item;


                        if (impostoIsento != null && impostoIsento) {
                            item = new ItemCardapioIsento(id, nome, descricao, preco, categoria);
                        } else if (semGluten != null && semGluten) {
                            item = new ItemCardapioSemGluten(id, nome, descricao, preco, categoria);
                        } else if (categoria == CategoriaCardapio.BEBIDAS) {
                            item = new ItemCardapioBebida(id, nome, descricao, preco, categoria);
                        } else {
                            item = new ItemCardapio(id, nome, descricao, preco, categoria);
                        }


                        if (emPromocao != null && emPromocao && precoComDescontoStr != null && !precoComDescontoStr.isBlank()) {
                            double precoComDesconto = Double.parseDouble(precoComDescontoStr);
                            item.setPromocao(precoComDesconto);
                        }

                        itens[indiceItem] = item;
                        indiceItem++;
                    }
                } else {
                    id = extrairValorLong(linha, "<id>", id);
                    nome = extrairValorString(linha, "<nome>", nome);
                    descricao = extrairValorString(linha, "<descricao>", descricao);
                    preco = extrairValorDouble(linha, "<preco>", preco);
                    categoria = extrairValorCategoria(linha, "<categoria>", categoria);
                    emPromocao = extrairValorBoolean(linha, "<emPromocao>", emPromocao);
                    precoComDescontoStr = extrairValorString(linha, "<precoComDesconto>", precoComDescontoStr);
                    impostoIsento = extrairValorBoolean(linha, "<impostoIsento>", impostoIsento);
                    semGluten = extrairValorBoolean(linha, "<semGlutem>", semGluten);
                }
            }

            return itens;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String extrairConteudoTag(String linha, String tagAbertura, String tagFechamento) {
        int inicio = linha.indexOf(tagAbertura);
        int fim = linha.indexOf(tagFechamento);

        if (inicio != -1 && fim != -1 && fim > inicio) {
            return linha.substring(inicio + tagAbertura.length(), fim).trim();
        }
        return null;
    }

    private Long extrairValorLong(String linha, String tag, Long valorAtual) {
        if (valorAtual != null) return valorAtual;
        String tagFechamento = tag.replace("<", "</");
        String conteudo = extrairConteudoTag(linha, tag, tagFechamento);
        return conteudo != null && !conteudo.isEmpty() ? Long.parseLong(conteudo) : null;
    }

    private String extrairValorString(String linha, String tag, String valorAtual) {
        if (valorAtual != null) return valorAtual;
        String tagFechamento = tag.replace("<", "</");
        String conteudo = extrairConteudoTag(linha, tag, tagFechamento);
        return conteudo != null ? conteudo : null;
    }

    private Double extrairValorDouble(String linha, String tag, Double valorAtual) {
        if (valorAtual != null) return valorAtual;
        String tagFechamento = tag.replace("<", "</");
        String conteudo = extrairConteudoTag(linha, tag, tagFechamento);
        return conteudo != null && !conteudo.isEmpty() ? Double.parseDouble(conteudo) : null;
    }

    private Boolean extrairValorBoolean(String linha, String tag, Boolean valorAtual) {
        if (valorAtual != null) return valorAtual;
        String tagFechamento = tag.replace("<", "</");
        String conteudo = extrairConteudoTag(linha, tag, tagFechamento);
        return conteudo != null && !conteudo.isEmpty() ? Boolean.parseBoolean(conteudo) : null;
    }

    private CategoriaCardapio extrairValorCategoria(String linha, String tag, CategoriaCardapio valorAtual) {
        if (valorAtual != null) return valorAtual;
        String tagFechamento = tag.replace("<", "</");
        String conteudo = extrairConteudoTag(linha, tag, tagFechamento);
        return conteudo != null && !conteudo.isEmpty() ? CategoriaCardapio.valueOf(conteudo) : null;
    }
}
