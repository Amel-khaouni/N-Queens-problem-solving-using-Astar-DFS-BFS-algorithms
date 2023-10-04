package ProjetP1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ProjetP1.principal;

public class JolieInterface extends JFrame {
    private static String nomMethod = principal.getNom();
    private static int nbrNoeudsGeneres = principal.getNbGen();
    private static int nbrNoeudsDevelopes = principal.getNbDev();
    private static List<Integer> sol = principal.getList();
    private static long time = principal.getTime();
    private JButton button;
    
    public JolieInterface() {
        super("Mesures de performance");
        // Création du JLabel pour le titre
        JLabel labelTitre = new JLabel("Mesures de performance de la méthode: " + nomMethod);
        labelTitre.setForeground(new Color(153,153,0));

        // Création d'un JPanel pour contenir le bouton
       /* JPanel panelButton = new JPanel();
        button = new JButton("Revenir");
        button.setBackground(new Color(139, 69, 19));
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        panelButton.add(button);*/
  
        
        
        
        // Création des labels pour les informations
        JLabel labelInfo1 = new JLabel("Le nombre de noeud généres : " + nbrNoeudsGeneres);
        JLabel labelInfo2 = new JLabel("Le nombre de noeud developpé : " + nbrNoeudsDevelopes);
        JLabel labelInfo3 = new JLabel("La solution : " + sol);
        JLabel labelInfo4 = new JLabel("Le temps d execution : " + time + " ms");

        // Création du JPanel contenant les labels d'information
        JPanel panelInfo = new JPanel(new GridLayout(4, 1));
        panelInfo.add(labelInfo1);
        panelInfo.add(labelInfo2);
        panelInfo.add(labelInfo3);
        panelInfo.add(labelInfo4);
        
        
        // Centrer les labels d'information
        labelInfo1.setHorizontalAlignment(JLabel.CENTER);
        labelInfo2.setHorizontalAlignment(JLabel.CENTER);
        labelInfo3.setHorizontalAlignment(JLabel.CENTER);
        labelInfo4.setHorizontalAlignment(JLabel.CENTER);
        
        // Ajouter un peu de coloration aux labels d'information
        labelInfo1.setForeground(Color.black);
        labelInfo2.setForeground(Color.black);
        labelInfo3.setForeground(Color.black);
        labelInfo4.setForeground(Color.black);
        panelInfo.setBackground(Color.WHITE);

        // Ajout du JPanel contenant les labels d'information à la région centre de la fenêtre
        add(panelInfo, BorderLayout.CENTER);

        // Création du JPanel contenant le titre et le bouton
        JPanel panelTitre = new JPanel(new BorderLayout());
        panelTitre.add(labelTitre, BorderLayout.NORTH);
       // panelTitre.add(panelButton, BorderLayout.SOUTH); // Ajout du panelButton en bas du panelTitre
        labelTitre.setFont(new Font("Arial", Font.BOLD, 18));
        labelTitre.setHorizontalAlignment(JLabel.CENTER);

        // Ajout du JPanel contenant le titre à la région nord de la fenêtre
        add(panelTitre, BorderLayout.NORTH);

        // Configuration de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        //setBackground(Color.BLACK);
        panelInfo.setBackground(new Color(210, 180, 140));

        setVisible(true);
    }
    /*
    public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
            	
                principal maFenetre = new principal();
            	maFenetre.setVisible(true);
            	
            	dispose();
        }
    }*/
    
 

    public static void main(String[] args) {
        new JolieInterface();
    }
}

