public class Driver {
    public static void main(String[] args) {
        // int[][] grid = {{0, 0, 3, 4},
        //                 {3, 4, 1, 2},
        //                 {0, 1, 4, 0},
        //                 {0, 3, 0, 0}};

        int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 3, 0, 0, 0, 0, 1, 6, 0},
                        {0, 6, 7, 0, 3, 5, 0, 0, 4},
                        {6, 0, 8, 1, 2, 0, 9, 0, 0},
                        {0, 9, 0, 0, 8, 0, 0, 3, 0},
                        {0, 0, 2, 0, 7, 9, 8, 0, 6},
                        {8, 0, 0, 6, 9, 0, 3, 5, 0},
                        {0, 2, 6, 0, 0, 0, 0, 9, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        
        Sudoku sudoku = new Sudoku(grid);
        Solver solver = new Solver(sudoku);

        long startTime = System.nanoTime();
        solver.solve();
        long endTime = System.nanoTime();

        System.out.println(sudoku);

        System.out.print("Solve Time: ");
        System.out.print((endTime-startTime) * Math.pow(10, -6));
        System.out.println(" ms");
    }
}
