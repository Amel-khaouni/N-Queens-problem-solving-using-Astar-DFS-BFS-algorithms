package ProjetP1;

import java.util.*;

public class A {

    static int noeudsgénérés = 0;
    static int noeudsdeveloppés = 0;

    // Calcul de l'heuristique
    public static int heuristic(List<Integer> state) {
        int n = state.size();
        int conflicts = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (state.get(i) == state.get(j) || Math.abs(state.get(i) - state.get(j)) == j - i) {
                    conflicts++;
                }
            }
        }
        return conflicts;
    }

    // Recherche A*
    public static List<Integer> AStar(List<Integer> startState) {
        PriorityQueue<Noeud> frontier = new PriorityQueue<Noeud>();
        Set<List<Integer>> visited = new HashSet<List<Integer>>();
        int n = startState.size();
        Noeud start = new Noeud(startState, 0, heuristic(startState), null);
        frontier.add(start);
        noeudsgénérés++;
        while (!frontier.isEmpty()) {
        Noeud node = frontier.poll();
        noeudsdeveloppés++;
            if (node.heuristic == 0) {
                return node.state;
            }
            visited.add(node.state);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j != node.state.get(i)) {
                        List<Integer> newState = new ArrayList<Integer>(node.state);
                        newState.set(i, j);
                        if (!visited.contains(newState)) {
                        Noeud child = new Noeud(newState, node.cost + 1, heuristic(newState), node);
                            frontier.add(child);
                            noeudsgénérés++;
                        }
                    }
                }
            }
        }
        return null;
    }

    // Classe noeud
    private static class Noeud implements Comparable<Noeud> {
        List<Integer> state;
        int cost;
        int heuristic;
        Noeud parent;

        public Noeud(List<Integer> state, int cost, int heuristic, Noeud parent) {
            this.state = state;
            this.cost = cost;
            this.heuristic = heuristic;
            this.parent = parent;
        }

        public int compareTo(Noeud other) {
            int f = this.cost + this.heuristic;
            int otherF = other.cost + other.heuristic;
            return Integer.compare(f, otherF);
        }
    }

    // Fonction d'affichage
    public static void printSolution(List<Integer> solution) {
        int n = solution.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (solution.get(i) == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrer la taille de l'echequier : ");
        int n = scanner.nextInt();
        
        long startTime = System.currentTimeMillis();
        List<Integer> startState = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            startState.add(0);
        }
        List<Integer> solution = AStar(startState);
        long endTime = System.currentTimeMillis();
       
        if (solution != null) {
            System.out.println("Une solution a été trouvée !"+solution);
            printSolution(solution);
        } else {
            System.out.println("Aucune solution n'a été trouvée.");
        }
       
            System.out.println("le nombres des noeuds générés est: " +noeudsgénérés);
            System.out.println("le nombres des noeuds developpés est:" +noeudsdeveloppés);
            System.out.println("Temps d'exécution : " + (endTime - startTime) + " ms");
           
        }
     
    }