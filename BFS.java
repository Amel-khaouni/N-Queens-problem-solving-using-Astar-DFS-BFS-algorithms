package ProjetP1;
import java.util.*;

public class BFS {
	   public static void main(String[] args) {

		   Scanner sc = new Scanner(System.in);
	       System.out.println("Entrer la taille de l'echequier :  ");
	       int n = sc.nextInt();
	       
	       int[] count = {0, 0}; // initialisation du compteur des nœuds générés et développés
	       long startTime = System.currentTimeMillis();
	       List<Integer> solution = solveNQueens(n, count);
	       long endTime = System.currentTimeMillis();
	       if (solution != null) {
	           System.out.println("Une solution a été trouvée ! "+solution);
	           printSolution(solution);
	       } else {
	           System.out.println("Aucune solution n'a été trouvée.");
	       }
	       
	       System.out.println("Temps d'exécution : " + (endTime - startTime) + " ms");
	       System.out.println("Le nombre de noeuds générés est : " + count[0]);
	       System.out.println("Le nombre de noeuds développés est : " + count[1]);

	   }

	   // Résolution du problème des N-reines avec BFS
	   public static List<Integer> solveNQueens(int n, int[] count) {
	       List<Integer> solution = null;
	       Queue<List<Integer>> queue = new LinkedList<>();
	       queue.offer(new ArrayList<>());
	       count[0]++; // incrémenter le compteur de noeuds générés
	       while (!queue.isEmpty() && solution == null) {
	           List<Integer> state = queue.poll();
	           count[1]++; // incrémenter le compteur de noeuds développés
	           if (state.size() == n) {
	               solution = state;
	           } else {
	               for (int col = 0; col < n; col++) {
	                   if (!isAttacking(state, col)) {
	                       List<Integer> nextState = new ArrayList<>(state);
	                       nextState.add(col);
	                       queue.offer(nextState);
	                       count[0]++; // incrémenter le compteur de noeuds générés
	                   }
	               }
	           }
	       }
	       return solution;
	   }

	   // Vérification de la validité du placement d'une nouvelle reine
	   public static boolean isAttacking(List<Integer> state, int col) {
	       int row = state.size();
	       for (int i = 0; i < row; i++) {
	           int queenCol = state.get(i);
	           if (queenCol == col) {
	               return true;
	           }
	           if (queenCol - col == i - row) {
	               return true;
	           }
	           if (queenCol - col == row - i) {
	               return true;
	           }
	       }
	       return false;
	   }

	   // Affichage d'une solution
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

	}
