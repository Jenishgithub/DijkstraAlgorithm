import java.util.Scanner;

public class DijkstraMyTry {
	public static void main(String[] args) {
		int MAX = 6;
		Scanner scan = new Scanner(System.in);
		// int[][] actual_matrix = new int[MAX][MAX];
		// int[][] actual_matrix = { { 0, 1, 8, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0 },
		// { 0, 0, 0, 1, 3, 0 }, { 0, 0, 0, 0, 1, 10 },
		// { 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 } };

		int[][] actual_matrix = { { 0, 2, 0, 0, 1, 6 }, { 0, 0, 2, 0, 4, 4 },
				{ 0, 0, 0, 3, 1, 0 }, { 1, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 2, 0, 0 }, { 0, 0, 3, 0, 0, 0 } };
		int[] distance = new int[MAX];
		int[] visited = new int[MAX];
		int[] preD = new int[MAX];
		int min;
		int nextNode = 0;

		System.out.println("Enter the actual_matrix!::");

		for (int i = 0; i < MAX; i++) {

			for (int j = 0; j < MAX; j++) {

				if (actual_matrix[i][j] == 0)
					actual_matrix[i][j] = 999;
			}
		}

		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				System.out.print(actual_matrix[i][j] + "   ");
			}
			System.out.println("\n");
		}

		for (int i = 0; i < MAX; i++) {

			visited[i] = 0;
			// preD[i] = 0;
			preD[i] = 999;

			// actual_matrix[i][j] = scan.nextInt();

		}

		System.out.println("Enter the starting node:");
		int startingNode = scan.nextInt();

		distance = actual_matrix[startingNode];
		// i added
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] != 0 && distance[i] != 999) {
				preD[i] = startingNode;
			}
		}

		distance[startingNode] = 0;
		visited[startingNode] = 1;
		preD[startingNode] = startingNode;

		// start with the algorithm
		for (int i = 0; i < MAX; i++) {
			min = 999;
			for (int j = 0; j < MAX; j++) {
				if (min > distance[j] && visited[j] != 1) {
					min = distance[j];
					nextNode = j;

				}
			}

			visited[nextNode] = 1;
			// actual start of the algorithm
			for (int c = 0; c < MAX; c++) {
				if (visited[c] != 1) {
					if (min + actual_matrix[nextNode][c] < distance[c]) {
						distance[c] = min + actual_matrix[nextNode][c];
						preD[c] = nextNode;
					}
				}
			}

		}

		for (int i = 0; i < MAX; i++) {
			System.out.print("Minimum dist from startingnode " + startingNode
					+ " to " + i + ": " + distance[i]);
			System.out.println();
		}

		System.out.println();
		for (int i = 0; i < MAX; i++) {
			int j;
			System.out.print("Path from startingPoint " + startingNode + " to "
					+ i + ": " + i);
			j = i;
			do {
				j = preD[j];
				System.out.print(" <- " + j);
				if (j == 999)
					break;
			} while (j != startingNode);
			System.out.println();

		}

	}
}
