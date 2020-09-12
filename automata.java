/*
 * Julio Hernandez
 * CS3350 Automata
 */

package automata_projects;

import java.util.Scanner;

public class automata {
	
	@SuppressWarnings("resource")
	public static void intro(int[] ans) {
		Scanner reader = new Scanner(System.in);
		System.out.println("************General Finite Automaton Emulation************" +
				"\nPlease enter the number of states your automata will have: ");
		ans[0] = reader.nextInt();
		
		System.out.println("Please enter the number of symbols: ");
		ans[1] = reader.nextInt();
	}
	
	@SuppressWarnings("resource")
	public static void endState(boolean[] finalState) {
		Scanner reader = new Scanner(System.in);
		System.out.println("What state in the automata is the final state: ");
		int ans = reader.nextInt();
		finalState[ans] = true;
	}
	
	@SuppressWarnings("resource")
	public static void behavior(int[][] state) {
		Scanner reader = new Scanner(System.in);
		
		for (int i = 0; i< state.length; i++) {
			for(int j = 0; j< state[1].length; j++) {
				System.out.println("When the automata is in state " + (i) + " Where should it go next when it encounters character '[" + j + "]': ");
				state[i][j] = reader.nextInt();
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void progression(int[][] state, boolean[] finalState) {
		Scanner reader = new Scanner(System.in);
		int curr = 0;
		
		System.out.println("Please provide characters to go through the automata: ");
		String word = reader.nextLine();
		
		System.out.println("State visited: " + curr);
		for(int i = 0; i< word.length(); i++) {
			System.out.println(curr);
			curr = state[curr][Integer.parseInt(word.substring(i , i+1))];
			System.out.println("State visited: " + curr);
		}
		
		if (finalState[curr]){
			System.out.println("Accepted!");
		}
		else {
			System.out.println("Rejected");
		}
	}
	
	public static void main(String[] args) {
		int[] ans = new int[2];
		intro(ans);
		int[][] state = new int[ans[0]][ans[1]];
		behavior(state);
		boolean[] finalState = new boolean[ans[0]];
		endState(finalState);
		progression(state, finalState);
		
	}
}
