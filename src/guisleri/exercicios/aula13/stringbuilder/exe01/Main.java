package guisleri.exercicios.aula13.stringbuilder.exe01;

public class Main {

    void main() {

        Produto produto1 = new Produto("Refresco do Chaves", 2.99);
        Produto produto2 = new Produto("Torta de Frango da Dona Florinda", 12.99);
        Produto produto3 = new Produto("Pipoca do Quico", 4.99);
        Produto produto4 = new Produto("Coca-Cola", 3.50);
        Produto produto5 = new Produto("Doce", 5.90);

        Produto[] produtos = {produto1, produto2, produto3, produto4, produto5};

        System.out.println("Relatório com String:");
        System.out.println(Produto.relatorioComString(produtos));

        System.out.println("Relatório com StringBuilder:");
        System.out.println(Produto.relatorioComStringBuilder(produtos));

    }

}
