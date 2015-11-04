import java.util.Scanner;

public class DijkstraMyTry {
	public static void main(String[] args) {
		int MAX = 6;
		Scanner scan = new Scanner(System.in);
		// int[][] matrix = new int[MAX][MAX];
		int[] distance = new int[MAX];
		int[] visited = new int[MAX];
		int[] preD = new int[MAX];
		int min;
		int nextNode = 0;

		System.out.println("Enter the matrix!::");

		// int[][] matrix = { { 0, 1, 8, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0 },
		// { 0, 0, 0, 1, 3, 0 }, { 0, 0, 0, 0, 1, 10 },
		// { 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 } };
		int[][] matrix = { { 0, 2, 0, 0, 1, 6 }, { 0, 0, 2, 0, 4, 4 },
				{ 0, 0, 0, 3, 1, 0 }, { 1, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 2, 0, 0 }, { 0, 0, 3, 0, 0, 0 } };

		for (int i = 0; i < MAX; i++) {

			for (int j = 0; j < MAX; j++) {

				if (matrix[i][j] == 0)
					matrix[i][j] = 999;
			}
		}

		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println("\n");
		}

		for (int i = 0; i < MAX; i++) {

			visited[i] = 0;
			preD[i] = 0;

			// for (int j = 0; j < MAX; j++) {
			// matrix[i][j] = scan.nextInt();
			// if (matrix[i][j] == 0)
			// matrix[i][j] = 999;
			// }
		}

		distance = matrix[0];
		distance[0] = 0;
		visited[0] = 1;

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
					if (min + matrix[nextNode][c] < distance[c]) {
						distance[c] = min + matrix[nextNode][c];
						preD[c] = nextNode;
					}
				}
			}

		}

		for (int i = 0; i < MAX; i++) {
			System.out.print("|" + distance[i]);
		}
		System.out.println("|");
		// printing the paths:

		for (int i = 0; i < MAX; i++) {
			int j;
			System.out.print("Path = " + i);
			j = i;
			do {
				j = preD[j];
				System.out.print(" <- " + j);

			} while (j != 0);
			System.out.println();

		}

	}
}
