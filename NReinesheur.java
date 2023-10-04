package ProjetP1;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class NReinesheur {
	public static int nbrNoeudsGeneres;
	public static int nbrNoeudsDevelopes;
    
    
    private static int heuristique(int[] configuration) {
        int nbConflits = 0;
        for (int i = 0; i < configuration.length; i++) {
            for (int j = i + 1; j < configuration.length; j++) {
                // Si deux reines sont sur la même ligne ou diagonale, il y a un conflit
                if (configuration[i] == configuration[j] || Math.abs(configuration[i] - configuration[j]) == j - i) {
                    nbConflits++;
                }
            }
        }
        return nbConflits;
    }

    public static int[] resoudre(int n) {
        PriorityQueue<int[]> ouverts = new PriorityQueue<>((a, b) -> (heuristique(a) - heuristique(b)));
        ouverts.offer(new int[n]); // Configuration initiale
        nbrNoeudsGeneres++;

        while (!ouverts.isEmpty()) {
            int[] config = ouverts.poll();
            nbrNoeudsDevelopes++;
            if (heuristique(config) == 0) {
                return config;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j != config[i]) {
                        int[] successeur = Arrays.copyOf(config, n);
                        successeur[i] = j;
                        ouverts.offer(successeur);
                        nbrNoeudsGeneres++;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrer le nombre de Reines:");
        int n = sc.nextInt();
        
        long startTime = System.currentTimeMillis();
        int[] solution = NReinesheur.resoudre(n);
        long endTime = System.currentTimeMillis();
        
        if (solution == null) {
            System.out.println("Pas de solution trouvée pour le problème des " + n + " reines.");
        } else {
            System.out.println("Solution pour le problème des " + n + " reines : " + Arrays.toString(solution));
        }
        
        System.out.println("nbrNoeudsGeneres " + nbrNoeudsGeneres+" \nnbrNoeudsDevelopes "+nbrNoeudsDevelopes);
        System.out.println("Temps d'exécution : " + (endTime - startTime) + " ms"); // Afficher le temps d'exécution
        
    }
}

