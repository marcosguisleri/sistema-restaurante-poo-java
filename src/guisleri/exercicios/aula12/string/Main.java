package guisleri.exercicios.aula12.string;

public class Main {

    void main() {

        String nomeCompleto = IO.readln("Informe seu nome completo: ");

        String[] nomeSobrenome = nomeCompleto.split(" ");

        IO.println("Olá, " + nomeSobrenome[0] + " " + nomeSobrenome[nomeSobrenome.length - 1]);

        IO.println("--------------------------------");

        String urlDigitada = IO.readln("Digite uma URL: ");

        if ((urlDigitada.startsWith("http://") || urlDigitada.startsWith("https://") || urlDigitada.startsWith("HTTP://"))
                && (urlDigitada.endsWith(".com") || urlDigitada.endsWith(".com.br"))) {
            IO.println("URL válida");
        } else {
            IO.println("URL inválida");
        }
    }

}
