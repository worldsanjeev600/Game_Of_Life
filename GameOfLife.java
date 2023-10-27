import java.util.Scanner;

/**
 * @author
 * Sanjeev.Gupta
 * Game Of Life
 */

public class GameOfLife {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        int[][] inputMatrix = new int[row][col];
        int[][] outputMatrix = new int[row][col];

        // Read the input matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                inputMatrix[i][j] = scanner.nextInt();
            }
        }

        // Define directions for neighboring cells
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        // Apply the rules of Game of Life
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;

                for (int[] direction : directions) {
                    int newRow = i + direction[0];
                    int newCol = j + direction[1];

                    if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
                        count += inputMatrix[newRow][newCol];
                    }
                }

                if (inputMatrix[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        outputMatrix[i][j] = 0;
                    } else {
                        outputMatrix[i][j] = 1;
                    }
                } else {
                    if (count == 3) {
                        outputMatrix[i][j] = 1;
                    }
                }
            }
        }

        // Print the output matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(outputMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
