import java.util.Scanner;

public class DijkstraMyTry {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] matrix = new int[6][6];
		int[] distance = new int[6];
		int[] visited = new int[6];
		int[] preD = new int[6];
		int min;
		int nextNode = 0;

		System.out.println("Enter the matrix!::");

		for (int i = 0; i < 6; i++) {

			visited[i] = 0;
			preD[i] = 0;

			for (int j = 0; j < 6; j++) {
				matrix[i][j] = scan.nextInt();
				if (matrix[i][j] == 0)
					matrix[i][j] = 999;
			}
		}

		distance = matrix[0];
		distance[0] = 0;
		visited[0] = 1;

		// start with the algorithm
		for (int i = 0; i < 6; i++) {
			min = 999;
			for (int j = 0; j < 6; j++) {
				if (min > distance[j] && visited[j] != 1) {
					min = distance[j];
					nextNode = j;
				}
			}

			visited[nextNode] = 1;
			// actual start of the algorithm
			for (int c = 0; c < 6; c++) {
				if (visited[c] != 1) {
					if (min + matrix[nextNode][c] < distance[c]) {
						distance[c] = min + matrix[nextNode][c];
						preD[c] = nextNode;
					}
				}
			}

		}

		for (int i = 0; i < 6; i++) {
			System.out.print("|" + distance[i]);
		}
		System.out.print("|");
		// printing the paths:

		for (int i = 0; i < 6; i++) {
			int j;
			System.out.println("Path = " + i);
			j = i;
			do {
				j = preD[j];
				System.out.println(" <- " + j);

			} while (j != 0);
			System.out.println();

		}

	}
}
