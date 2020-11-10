import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 1, 0, 6},
                        {6, 0, 4, 0, 0, 0},
                        {1, 0, 2, 0, 0, 0},
                        {0, 0, 0, 5, 0, 1},
                        {0, 0, 0, 6, 0, 3},
                        {5, 0, 6, 0, 0, 0}};
        Sudoku sudoku = new Sudoku(grid);
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(sudoku.getSect(i)));
        }
    }
}
