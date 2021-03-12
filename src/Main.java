import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {

    static double galao;
    static double sobra;
    static int nGarrafas;
    static ArrayList<Garrafa> garrafas = new ArrayList<>();
    static ArrayList<Garrafa> garrafasUtilizadas = new ArrayList<>();

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
        System.out.println("Galão - " + galao + "L");
        for (int i = 0; i < garrafas.size(); i++) {
            System.out.println(garrafas.get(i).getNome() + " - " + garrafas.get(i).getVolume() + "L");
        }
        encherGalao(garrafas);
        resposta();
    }

    private static void encherGalao(ArrayList<Garrafa> garrafas) {
        double diferenca = 0;
        boolean entrou = false;
        Garrafa g = null;
        int index = 0;

        while (volumeAtualGalao() > 0 && !garrafas.isEmpty()) {
            for (int i = 0; i < garrafas.size(); i++) {
                double aux;
                aux = Math.abs(volumeAtualGalao() - garrafas.get(i).getVolume());
                if (!entrou) {
                    diferenca = aux;
                    entrou = true;
                    g = new Garrafa(garrafas.get(i).getNome(), garrafas.get(i).getVolume());
                    index = i;

                } else if (diferenca > aux) {
                    diferenca = aux;
                    g = new Garrafa(garrafas.get(i).getNome(), garrafas.get(i).getVolume());
                    index = i;
                }
            }
            diferenca = 0;
            entrou = false;
            garrafasUtilizadas.add(g);
            garrafas.remove(index);
        }
    }


    private static void resposta() {
        String resp = "resposta:[ ";
        for (int i = 0; i < garrafasUtilizadas.size(); i++) {
            resp = (resp + garrafasUtilizadas.get(i).getVolume() + "L; ");
        }
        resp += "]";

        if (volumeAtualGalao() < 0) {
            resp += "; sobra " + (new DecimalFormat("#,##0.00").format(Math.abs(volumeAtualGalao())) + "L");
        } else if (volumeAtualGalao() > 0) {
            resp += "; falta " + new DecimalFormat("#,##0.00").format(volumeAtualGalao()) + "L";
        }
        System.out.println(resp);
    }

    private static double volumeAtualGalao() {
        double vAtual = galao;

        for (int i = 0; i < garrafasUtilizadas.size(); i++) {
            vAtual -= garrafasUtilizadas.get(i).getVolume();
        }
        return vAtual;
    }
}
