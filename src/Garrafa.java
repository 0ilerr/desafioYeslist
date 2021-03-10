public class Garrafa {

    private String nome;
    private double volume;

    public Garrafa(String nome, double volume) {
        this.nome = nome;
        this.volume = volume;
    }

    public Garrafa() {
    }

    public String getNome() {
        return nome;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Garrafa{" +
                "nome='" + nome + '\'' +
                ", volume=" + volume +
                '}';
    }
}
