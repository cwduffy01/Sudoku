public class Solver {

    private Sudoku sudoku;

    public Solver(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public void singleCandidate(int r, int c){
        Cell cell = sudoku.getCell(r, c);

        int[] row = sudoku.getRow(r);
        int[] col = sudoku.getCol(c);
        int[] sect = sudoku.getSect(r, c);

        for (int i = 0; i < row.length; i++) {
            cell.removeAnswer(row[i]);
            cell.removeAnswer(col[i]);
            cell.removeAnswer(sect[i]);
        }
        sudoku.update();
    }
}
