public class Solver {

    private Sudoku sudoku;

    public Solver(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public Sudoku solve() {
        while (!sudoku.isSolved()) {
            for (int i = 0; i < sudoku.getwSplit(); i++) {
                for (int j = 0; j < sudoku.gethSplit(); j++) {
                    scan(i*sudoku.gethSplit(), j*sudoku.getwSplit());
                }
            }
        }
        return sudoku;
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
    }

    public void scan(int r, int c) {
        r = r / sudoku.gethSplit() * sudoku.gethSplit();
        c = c / sudoku.getwSplit() * sudoku.getwSplit();

        for (int i = r; i < r + sudoku.gethSplit(); i++) {
            for (int j = c; j < c + sudoku.getwSplit(); j++) {
                if (sudoku.getCell(i, j).getNum() == 0){
                    singleCandidate(i, j);
                }
            }
        }

        for (int i = r; i < r + sudoku.gethSplit(); i++) {
            for (int j = c; j < c + sudoku.getwSplit(); j++) {
                int answers = sudoku.getCell(i, j).getAnswers();

                for (int k = r; k < r + sudoku.gethSplit(); k++) {
                    for (int l = c; l < c + sudoku.getwSplit(); l++) {
                        if (sudoku.getCell(i, j).getNum() == 0){
                            if (!(i == k && j == l)) {
                                answers = answers & (~sudoku.getCell(k, l).getAnswers());
                            }
                        }
                    }
                }

                if (Integer.bitCount(answers) == 1) {
                    sudoku.getCell(i, j).setAnswers(answers);
                }
            }
        }

        sudoku.update();
    }
}
