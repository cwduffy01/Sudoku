import java.util.Arrays;
import java.lang.Integer;

public class Driver {
    public static void main(String[] args) {
        int[][] grid = {{4, 3, 0, 0},
                        {1, 2, 3, 0},
                        {0, 0, 2, 0},
                        {2, 1, 0, 3}};
        Sudoku sudoku = new Sudoku(grid);
        Solver solver = new Solver(sudoku);
        
        while (!sudoku.isSolved()) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    solver.scan(i, j);
                }
            }
        }

        System.out.println(sudoku);
        
        // int num = 1;  // number to remove
        // int n = 0b1001;  // possible numbers
        
        // int a = (n >> num) << num;
        // int b = n & (int)(Math.pow(2, num-1) - 1);
        
        // n = a | b;
        // System.out.println(Integer.bitCount(n));

    }
}
