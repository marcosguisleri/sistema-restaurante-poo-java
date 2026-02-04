package guisleri.exercicios.aula13.stringbuilder.exe02;

public class Main {

    public static void main(String[] args) {
        Coordenada c1 = new Coordenada(2, 3);
        Coordenada c2 = new Coordenada(5, 7);

        System.out.println("Coordenada 1: " + c1);
        System.out.println("Coordenada 2: " + c2);
        System.out.println("Distância entre elas: " + c1.distancia(c2));
    }
}
