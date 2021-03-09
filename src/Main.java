import javax.swing.*;
import java.util.ArrayList;

public class Main {

    static double galao;
    static int nGarrafas;
    static ArrayList<Garrafa> garrafas = new ArrayList<>();

    public static void main(String[] args) {
        try {
            galao = Double.parseDouble(JOptionPane.showInputDialog("Informe o volume do Galão"));
            nGarrafas = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de garrafas"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getLocalizedMessage());
        }
        for (int i = 0; i < nGarrafas; i++) {
            String nome = "Garrafa " + (i + 1);
            try {
                double volumeGarrafa = Double.parseDouble(JOptionPane.showInputDialog("Informe o volume da " + nome));
                Garrafa g = new Garrafa(nome, volumeGarrafa);
                garrafas.add(g);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getLocalizedMessage());
            }
        }
        for (int i = 0; i < garrafas.size(); i++) {
            System.out.println(garrafas.get(i).getNome()+" - "+garrafas.get(i).getVolume()+" L");
        }
    }
}
