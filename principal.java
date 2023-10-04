package ProjetP1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import ProjetP1.secondaire;
import ProjetP1.BFS;
import ProjetP1.DFS;
import ProjetP1.A;
import ProjetP1.A2;


public class principal extends JFrame implements ActionListener {
	private static int n;
	private static int nbrNoeudsGeneres;
	private static int nbrNoeudsDevelopes;
	
	private static long startTime,endTime,time;

    private static int[] tab = new int[n];
	private static int[] count = new int[2];
	private static List<Integer> maListe = new ArrayList<Integer>();
	private static String nomMethod;
    private JTextField textField;
    private JTextArea textArea;
    private JButton btnChoix1, btnChoix2, btnChoix3, btnChoix4;
    private JTextField textField2;
    private JTextArea textArea2;
    
    
    

    public principal() {
        super("Jeux des n-reine");

        // création des composants de l'interface graphique
        textField = new JTextField(10);
        textArea = new JTextArea(20, 20);
        textArea.setEditable(false);
       // Ajout des marges au JTextArea
        Insets insets = new Insets(60, 80, 20, 20);
        textArea.setMargin(insets);
        textArea.setBackground(new Color(139, 69, 19));
        Font font = new Font("Arial", Font.BOLD, 14);
        textArea.setFont(font);
        textArea.setForeground(Color.WHITE);
        //textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


        String texte = "Bonjour à tous !\n\nVous etes la bien venu au jeux des N-reine.\n\nVous pouvez choisir n'importe quelle méthode pour afficher la solution a votre Taille préfére!\n\n Enjoy Your Time!!";
        // Afficher le texte dans le JTextArea
        textArea.setText(texte);
        
        
        btnChoix1 = new JButton("BFS");
        btnChoix1.addActionListener(this);
        btnChoix1.setBackground(new Color(139, 69, 19));
        btnChoix1.setForeground(Color.WHITE);
        btnChoix2 = new JButton("DFS");
        btnChoix2.addActionListener(this);
        btnChoix2.setBackground(new Color(139, 69, 19));
        btnChoix2.setForeground(Color.WHITE);
        btnChoix3 = new JButton("A*(1)");
        btnChoix3.addActionListener(this);
        btnChoix3.setBackground(new Color(139, 69, 19));
        btnChoix3.setForeground(Color.WHITE);
        btnChoix4 = new JButton("A*(2)");
        btnChoix4.addActionListener(this);
        btnChoix4.setBackground(new Color(139, 69, 19));
        btnChoix4.setForeground(Color.WHITE);
        
        
        
        
        

        
        // ajout des composants à la fenêtre
        JPanel panel = new JPanel();
        panel.add(new JLabel("Entrez la taille de l'échiquier :"));

        
        Border line = BorderFactory.createLineBorder(new Color(139, 69, 19), 2);
        Border margin = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border compound = BorderFactory.createCompoundBorder(line, margin);
        textField.setBorder(compound);
        panel.add(textField);
        panel.setBackground(new Color(245, 245, 220));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        panel.add(new JLabel("Choisissez une Methode :"));
        panel.add(btnChoix1);
        panel.add(btnChoix2);
        panel.add(btnChoix3);
        panel.add(btnChoix4);
        

        // configuration de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    //Appel au fonctions
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	//BFS
        if (e.getSource() == btnChoix1) {
            // récupération de la taille de la matrice
            n = Integer.parseInt(textField.getText());
            if (n < 5) {
                JOptionPane.showMessageDialog(null, "Erreur : La Taille doit être supérieur ou égal à 5", "Erreur", JOptionPane.ERROR_MESSAGE);
            }else {
            	startTime = System.currentTimeMillis();
                maListe = BFS.solveNQueens(n, count);
                endTime = System.currentTimeMillis();
                time = endTime - startTime;
                nomMethod="BFS";
                secondaire maFenetre = new secondaire();
            	maFenetre.setVisible(true);
            	
            	JolieInterface maFenetre2 = new JolieInterface();
    	        maFenetre2.setVisible(true); 
    	        dispose();
    	        
            }

            
        }
        
        
        
        //DFS
        if (e.getSource() == btnChoix2) {
        	// récupération de la taille de la matrice
            n = Integer.parseInt(textField.getText());
            if (n < 5) {
                JOptionPane.showMessageDialog(null, "Erreur : La Taille doit être supérieur ou égal à 5", "Erreur", JOptionPane.ERROR_MESSAGE);
            }else {
            	ArrayList<Integer> table = new ArrayList<Integer>();
                startTime = System.currentTimeMillis();
                maListe = DFS.solveNQueens(n, count);
                endTime = System.currentTimeMillis();
                time = endTime - startTime;
                //tab = maListe;
                nomMethod="DFS";
                secondaire maFenetre = new secondaire();
            	maFenetre.setVisible(true);
            	
            	JolieInterface maFenetre2 = new JolieInterface();
    	        maFenetre.setVisible(true);
    	        dispose();
            }
            
        }
        
        
      //HEUR1
        if (e.getSource() == btnChoix3) {
        	// récupération de la taille de la matrice
            n = Integer.parseInt(textField.getText());
            if (n < 5) {
                JOptionPane.showMessageDialog(null, "Erreur : La Taille doit être supérieur ou égal à 5", "Erreur", JOptionPane.ERROR_MESSAGE);
            }else {
            	List<Integer> startState = new ArrayList<Integer>();
                for (int i = 0; i < n; i++) {
                    startState.add(0);
                }
            	startTime = System.currentTimeMillis();
            	maListe = A.AStar(startState);
                endTime = System.currentTimeMillis();
                time = endTime - startTime;
                nbrNoeudsGeneres = A.noeudsgénérés;
                count[0]=nbrNoeudsGeneres;
                nbrNoeudsDevelopes = A.noeudsdeveloppés;
                count[1]=nbrNoeudsDevelopes;
                /*
                for (int element : tab) {
                    maListe.add(element);
                }*/
                nomMethod="Heuristique 1";
                secondaire maFenetre = new secondaire();
            	maFenetre.setVisible(true);
            	
            	JolieInterface maFenetre2 = new JolieInterface();
    	        maFenetre.setVisible(true);
    	        dispose();
            }
            
        }
        
      //HEUR2
        if (e.getSource() == btnChoix4) {
        	// récupération de la taille de la matrice
            n = Integer.parseInt(textField.getText());
            if (n < 5) {
                JOptionPane.showMessageDialog(null, "Erreur : La Taille doit être supérieur ou égal à 5", "Erreur", JOptionPane.ERROR_MESSAGE);
            }else {
            	List<Integer> startState = new ArrayList<Integer>();
                for (int i = 0; i < n; i++) {
                    startState.add(0);
                }
            	startTime = System.currentTimeMillis();
            	maListe = A2.AStar(startState);
                endTime = System.currentTimeMillis();
                time = endTime - startTime;
                nbrNoeudsGeneres = A.noeudsgénérés;
                count[0]=nbrNoeudsGeneres;
                nbrNoeudsDevelopes = A.noeudsdeveloppés;
                count[1]=nbrNoeudsDevelopes;
                /*
                for (int element : tab) {
                    maListe.add(element);
                }*/
                nomMethod="Heuristique 2";
                secondaire maFenetre = new secondaire();
            	maFenetre.setVisible(true);
            	
            	JolieInterface maFenetre2 = new JolieInterface();
    	        maFenetre.setVisible(true);
    	        dispose();
            }
            
        }
        

        
        
   
    }
    
    
    
    
    

    public static void main(String[] args) {
        new principal();
    }
    
    public static List<Integer> getList() {
        return maListe;
    }
    
    public static String getNom() {
    	return nomMethod;
    }
    
    public static int getNbGen() {
    	return count[0];
    }
    
    public static int getNbDev() {
    	return count[1];
    }
    
    
    public static int[] getSol() {
    	return tab;
    }
    
    public static long getTime() {
    	return time;
    }
    
    
    
}
