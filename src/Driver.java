import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        int[][] grid = {{2, 0, 0, 0},
                        {0, 1, 0, 2},
                        {0, 0, 3, 0},
                        {0, 0, 0, 4}};
        Sudoku sudoku = new Sudoku(grid);
        System.out.println(Arrays.toString(sudoku.getRow(1)));
        System.out.println(Arrays.toString(sudoku.getCol(3)));
    }
}
