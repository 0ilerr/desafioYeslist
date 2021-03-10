import javax.swing.*;
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
        encherGalao(galao, garrafas);
    }

    private static void encherGalao(double galao, ArrayList<Garrafa> garrafas) {
        Garrafa maior = null;
        double diferenca = 0;
        boolean entrou = false;

        for (int i = 0; i < garrafas.size(); i++) {
            double aux = galao - garrafas.get(i).getVolume();
            if (aux <= 0) {
                maior = new Garrafa(garrafas.get(i).getNome(), garrafas.get(i).getVolume());
                diferenca = aux;
                garrafasUtilizadas.add(maior);
                break;
            } else if (aux <= galao && aux >= 0) {
                if (!entrou) {
                    diferenca = aux;
                    maior = new Garrafa(garrafas.get(i).getNome(), garrafas.get(i).getVolume());
                    entrou = true;
                } else {
                    if (aux < diferenca) {
                        diferenca = aux;
                        maior = new Garrafa(garrafas.get(i).getNome(), garrafas.get(i).getVolume());
                    }
                }
                garrafasUtilizadas.add(maior);
            }

        }

        boolean disponivel = true;
        for (int i = 0; i < garrafas.size(); i++) {
            if (galao - maior.getVolume() != 0 && galao - maior.getVolume() > 0) {
                for (int j = 0; j < garrafasUtilizadas.size(); j++) {
                    if (!garrafas.get(i).getNome().equalsIgnoreCase(garrafasUtilizadas.get(j).getNome())) {
                        double vAtual = volumeGalao();
                        double aux = galao - garrafas.get(i).getVolume();


                    }
                }


            }
        }
        System.out.println("Maior: " + maior.toString());
        System.out.println("Diferença: " + diferenca);
        resposta();


    }

    private static void resposta() {
        String resp = "resposta:[ ";
        for (int i = 0; i < garrafasUtilizadas.size(); i++) {
            resp = (resp + garrafasUtilizadas.get(i).getVolume() + "L ");
        }
        System.out.println(resp);
    }

    private static double volumeGalao() {
        double vAtual = galao;

        for (int i = 0; i < garrafasUtilizadas.size(); i++) {
            vAtual -= garrafasUtilizadas.get(i).getVolume();
        }
        return vAtual;
    }
}
