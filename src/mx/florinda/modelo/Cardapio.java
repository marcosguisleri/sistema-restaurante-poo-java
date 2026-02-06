package mx.florinda.modelo;

import mx.florinda.modelo.isento.ItemCardapioIsento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cardapio {

    private ItemCardapio[] itens;

    public Cardapio(String nomeArquivo) throws IOException {
        Path arquivo = Path.of(nomeArquivo);
        String conteudoArquivo = Files.readString(arquivo);

        String[] linhasArquivo = conteudoArquivo.split("\n");
        itens = new ItemCardapio[linhasArquivo.length];

        for (int i = 0; i < linhasArquivo.length; i++) {

            String linha = linhasArquivo[i].strip();

            if (linha.isEmpty()) {
                continue;
            }

            if (nomeArquivo.endsWith(".csv")) {

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

                itens[i] = item;

            } else if (nomeArquivo.endsWith(".json")) {

                // Trata o JSON por posição, refatoração na próxima aula
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

                itens[i] = item;

            } else {
                IO.println("Nome do arquivo inválido! - " + nomeArquivo);
            }
        }
    }

    public double getSomaDosPrecos() {
        double totalDePrecos = 0.0;
        for (ItemCardapio item : itens) {
            totalDePrecos += item.getPreco();
        }
        return totalDePrecos;
    }

    public int getTotalDeItensEmPromocao() {
        int totalItensEmPromocao = 0;
        for (ItemCardapio item : itens) {
            if (item.isEmPromocao()) {
                totalItensEmPromocao++;
            }
        }
        return totalItensEmPromocao;
    }

    public double getPrimeiroPrecoMaiorQueLimite(double precoLimite) {
        double precoMaiorQueLimite = -1.0;
        for (ItemCardapio item : itens) {
            if (item.getPreco() > precoLimite) {
                precoMaiorQueLimite = item.getPreco();
                break;
            }
        }
        return precoMaiorQueLimite;
    }

    public ItemCardapio getItensPorId(long idSelecionado) {
        return itens[((int) idSelecionado) - 1];
    }

    public ItemCardapio[] getItens() {
        return itens;
    }

}