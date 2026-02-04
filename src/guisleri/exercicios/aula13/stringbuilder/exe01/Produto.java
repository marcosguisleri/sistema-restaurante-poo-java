package guisleri.exercicios.aula13.stringbuilder.exe01;

public class Produto {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public static String relatorioComString(Produto[] produtos) {
        String relatorio = "";
        for (Produto produto : produtos) {
            relatorio += produto.getNome() + " - R$ " + produto.getPreco() + "\n";
        }
        return relatorio;
    }

    public static String relatorioComStringBuilder(Produto[] produtos) {
        StringBuilder sb = new StringBuilder();
        for (Produto produto : produtos) {
            sb.append(produto.getNome())
                    .append(" - R$ ")
                    .append(produto.getPreco())
                    .append("\n");
        }
        return sb.toString();
    }

}