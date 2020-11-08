public class Driver {
    public static void main(String[] args) {
        int[][] grid = {{2, 0, 0, 0},
                        {0, 1, 0, 2},
                        {0, 0, 3, 0},
                        {0, 0, 0, 4}};
        Sudoku sudoku = new Sudoku(grid);
        System.out.println(sudoku);
    }
}
