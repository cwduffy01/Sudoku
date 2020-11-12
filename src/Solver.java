public class Solver {

    private Sudoku sudoku;

    public Solver(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public void scan(int i, int j){
        int[] row = sudoku.getRow(i);
        int[] col = sudoku.getCol(j);
        Cell cell = sudoku.getCell(i, j);
        for (int k = 0; k < row.length; k++) {
            cell.removeAnswer(row[k]);
            cell.removeAnswer(col[k]);
        }
        sudoku.update();
    }
}
