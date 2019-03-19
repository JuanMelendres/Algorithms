/*
    Juan Antonio Melendres Villa A00369017
    Martín Giovanni Esquivel A01633334
*/

public class NQueenProblem {
	// Number of queens
    private static int N; // Switch to to 4, 5, 10
    // Chessboard
    private static int[][] board = new int[5][5]; // Switch to to 4, 5, 10

    // Function to check if the cell is attacked
    private static boolean isAttack(int i,int j) {
        // Check if there is a queen in row or column
        for(int k = 0; k < N; k++) {
            if((board[i][k] == 1) || (board[k][j] == 1)) {
                return true;
            }
        }
        // Check for diagonals
        for(int k = 0; k < N; k++) {
            for(int l = 0; l < N; l++) {
                if(((k + l) == (i + j)) || ((k - l) == (i - j))) {
                    if(board[k][l] == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean nQueen(int n) {
        // If n = 0 solution found
        if(n == 0) {
            return true;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                // Check if queen can placed here or not
                // Queen if not be placed if the cell is being attacked or already occupied
                if((!isAttack(i,j)) && (board[i][j] != 1 )) {
                    board[i][j] = 1;
                    if(nQueen(n - 1) == true) {
                        return true;
                    }
                    board[i][j] = 0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        N = 5;
        nQueen(N);
        // Print the solution
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.print("\n");
        }
        
    }
}
