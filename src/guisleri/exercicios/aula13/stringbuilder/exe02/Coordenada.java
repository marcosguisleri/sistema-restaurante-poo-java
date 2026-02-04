package guisleri.exercicios.aula13.stringbuilder.exe02;

public final class Coordenada {

    private final double x;
    private final double y;

    // Construtor define os valores uma vez só
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Métodos de acesso (somente leitura)
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Método para calcular a distância euclidiana até outra coordenada
    public double distancia(Coordenada outra) {
        double dx = outra.x - this.x;
        double dy = outra.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
