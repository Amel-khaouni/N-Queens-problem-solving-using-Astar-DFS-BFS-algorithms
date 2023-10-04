package ProjetP1;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import ProjetP1.principal;

public class secondaire extends JFrame {
    //récupérer les valeurs envoyées par l'autre fenêtre
    private static List<Integer> maList = principal.getList();
    // Dimensions de l'échiquier
    private static final int DIMENSION = maList.size();
    int[] tableau = maList.stream().mapToInt(Integer::intValue).toArray();

    public secondaire() {
        super("Echiquier");

        // Création du plateau
        JPanel plateau = new JPanel(new GridLayout(DIMENSION, DIMENSION));

        // Parcours des cases
        for (int ligne = 0; ligne < DIMENSION; ligne++) {
            for (int colonne = 0; colonne < DIMENSION; colonne++) {
                // Création de la case
                JPanel caseEchiquier = new JPanel();

                // Coloration de la case en noir ou blanc
                if ((ligne + colonne) % 2 == 0) {
                    caseEchiquier.setBackground(new Color(210, 180, 140));
                } else {
                    caseEchiquier.setBackground(new Color(139, 69, 19));
                }

                // Ajout de la case sur le plateau
                plateau.add(caseEchiquier);

                // Si la case contient une reine, ajout de l'image de la reine
                if (tableau[ligne] == colonne) {
                    ImageIcon iconeReine = new ImageIcon(getClass().getResource("img/../../crown(1).png"));
                    Image imageReine = iconeReine.getImage();
                    Image imageRedimensionnee = imageReine.getScaledInstance(65, 55, Image.SCALE_SMOOTH);
                    ImageIcon iconeReineRedimensionnee = new ImageIcon(imageRedimensionnee);
                    JLabel labelReine = new JLabel(iconeReineRedimensionnee);
                    caseEchiquier.add(labelReine);
                }
            }
        }

        // Création du JScrollPane contenant le plateau
        JScrollPane scrollPane = new JScrollPane(plateau);

        // Ajout du JScrollPane à la fenêtre
        add(scrollPane);

        // Configuration de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new secondaire();
    }
}
