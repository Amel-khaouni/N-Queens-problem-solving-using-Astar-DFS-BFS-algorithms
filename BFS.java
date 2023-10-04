package ProjetP1;
import java.util.*;

public class BFS {
	   public static void main(String[] args) {

		   Scanner sc = new Scanner(System.in);
	       System.out.println("Entrer la taille de l'echequier :  ");
	       int n = sc.nextInt();
	       
	       int[] count = {0, 0}; // initialisation du compteur des n�uds g�n�r�s et d�velopp�s
	       long startTime = System.currentTimeMillis();
	       List<Integer> solution = solveNQueens(n, count);
	       long endTime = System.currentTimeMillis();
	       if (solution != null) {
	           System.out.println("Une solution a �t� trouv�e ! "+solution);
	           printSolution(solution);
	       } else {
	           System.out.println("Aucune solution n'a �t� trouv�e.");
	       }
	       
	       System.out.println("Temps d'ex�cution : " + (endTime - startTime) + " ms");
	       System.out.println("Le nombre de noeuds g�n�r�s est : " + count[0]);
	       System.out.println("Le nombre de noeuds d�velopp�s est : " + count[1]);

	   }

	   // R�solution du probl�me des N-reines avec BFS
	   public static List<Integer> solveNQueens(int n, int[] count) {
	       List<Integer> solution = null;
	       Queue<List<Integer>> queue = new LinkedList<>();
	       queue.offer(new ArrayList<>());
	       count[0]++; // incr�menter le compteur de noeuds g�n�r�s
	       while (!queue.isEmpty() && solution == null) {
	           List<Integer> state = queue.poll();
	           count[1]++; // incr�menter le compteur de noeuds d�velopp�s
	           if (state.size() == n) {
	               solution = state;
	           } else {
	               for (int col = 0; col < n; col++) {
	                   if (!isAttacking(state, col)) {
	                       List<Integer> nextState = new ArrayList<>(state);
	                       nextState.add(col);
	                       queue.offer(nextState);
	                       count[0]++; // incr�menter le compteur de noeuds g�n�r�s
	                   }
	               }
	           }
	       }
	       return solution;
	   }

	   // V�rification de la validit� du placement d'une nouvelle reine
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
