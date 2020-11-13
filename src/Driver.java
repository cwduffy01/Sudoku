import java.util.Arrays;
import java.lang.Integer;

public class Driver {
    public static void main(String[] args) {
        int[][] grid = {{3, 4, 1, 0},
                        {0, 2, 0, 0},
                        {0, 0, 2, 0},
                        {0, 1, 4, 3}};
        Sudoku sudoku = new Sudoku(grid);
        Solver solver = new Solver(sudoku);

        long startTime = System.nanoTime();
        solver.solve();
        long endTime = System.nanoTime();

        System.out.print((endTime-startTime) * Math.pow(10, -6));
        System.out.println(" ms");

        System.out.println(sudoku);
    }
}
