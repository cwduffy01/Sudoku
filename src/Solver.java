public class Solver {
    private Sudoku sudoku;

    /**
     * Represents a process of solving a sudoku
     * 
     * @param sudoku    sudoku to be solved
     */
    public Solver(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    /**
     * The method of single candidates checks the context (row, column, 
     * and section) of any particular cell and eliminates all possibilities
     * 
     * For the following sudoku:
     * 
     *   [3][ ]  [ ][ ]
     *   [ ][*]  [1][ ]
     * 
     *   [ ][ ]  [ ][ ]
     *   [ ][2]  [ ][ ]
     * 
     * The * cell has a single candidate of 4, since it shares a row with 1, 
     * a column with 2, and a section with 3
     * 
     * @param cell  cell to check for single candidates
     * @return  true if cell was filled, false otherwise
     */
    public boolean singleCandidate(Cell cell){
        int[] row = sudoku.getRows()[cell.getRow()].getNums();          // row at cell index
        int[] col = sudoku.getColumns()[cell.getColumn()].getNums();    // column at cell index
        int[] sect = sudoku.getSection(cell.getRow(), cell.getColumn()).getNums();  // section at cell index

        for (int i = 0; i < row.length; i++) {  // removes all numbers from cell possibilities
            cell.removeAnswer(row[i]);
            cell.removeAnswer(col[i]);
            cell.removeAnswer(sect[i]);
        }

        return cell.update();
    }

    /**
     * The method of scanning checks the context checks surrounding numbers
     * and fills a cell with that number if it is the only possible cell in
     * its section
     * 
     * For the following sudoku:
     * 
     *   [*][a]  [ ][ ]
     *   [b][2]  [1][ ]
     * 
     *   [ ][ ]  [ ][ ]
     *   [ ][1]  [ ][ ]
     * 
     * When scanning is done correctly, a and b are eliminated because they 
     * share a group with a 1, leaving the * cell as the only possible cell
     * 
     * @param section   section to scan
     * @return  true if cell was filled, false otherwise
     */
    public boolean scanSection(Section section) {
        int singles = 0;    // binary number for single occurances
        int nullify = 0;    // binary number for duplicates, one if duplicate, zero if not
        for (Cell[] cells: section.getCells()) {
            for(Cell cell: cells) {
                nullify |= (singles & cell.getAnswers());   // one if number occurs twice
                singles ^= cell.getAnswers();   // one if possibility is unique
            }
        }
        singles = singles & ~nullify;   // remove duplicates from

        boolean filled = false;     // true if single found and filled
        for (Cell[] cells: section.getCells()) {
            for(Cell cell: cells) {
                if ((cell.getAnswers() & singles) > 0) {    // if single, update cell
                    cell.setAnswers(cell.getAnswers() & singles);
                    filled |= cell.update();
                }
            }
        }

        return filled;
    }

    public boolean scanRow(Row row) {
        int singles = 0;    // binary number for single occurances
        int nullify = 0;    // binary number for duplicates, one if duplicate, zero if not
        for (Cell cell: row.getCells()) {
            nullify |= (singles & cell.getAnswers());   // one if number occurs twice
            singles ^= cell.getAnswers();   // one if possibility is unique
        }
        singles = singles & ~nullify;   // remove duplicates from

        boolean filled = false;     // true if single found and filled
        for(Cell cell: row.getCells()) {
            if ((cell.getAnswers() & singles) > 0) {    // if single, update cell
                cell.setAnswers(cell.getAnswers() & singles);
                filled |= cell.update();
            }
        }

        return filled;
    }

    public boolean scanColumn(Column column) {
        int singles = 0;    // binary number for single occurances
        int nullify = 0;    // binary number for duplicates, one if duplicate, zero if not
        for (Cell cell: column.getCells()) {
            nullify |= (singles & cell.getAnswers());   // one if number occurs twice
            singles ^= cell.getAnswers();   // one if possibility is unique
        }
        singles = singles & ~nullify;   // remove duplicates from

        boolean filled = false;     // true if single found and filled
        for(Cell cell: column.getCells()) {
            if ((cell.getAnswers() & singles) > 0) {    // if single, update cell
                cell.setAnswers(cell.getAnswers() & singles);
                filled |= cell.update();
            }
        }

        return filled;
    }

    /**
     * Process that solves a sudoku from start to finish
     * 
     * @return  the solved sudoku
     */
    public Sudoku solve() {
        while (!sudoku.isSolved()) {
            boolean restart = false;    // true if any method was successful, will restart loop

            if (!restart) {     // check each cell for single candidates
                for (Cell[] cells: sudoku.getGrid()) {
                    for (Cell cell: cells) {
                        restart |= singleCandidate(cell);
                    }
                }
            }

            if (!restart) {    // scan each section for correct answers
                for (Section[] sections: sudoku.getSections()) {
                    for (Section section: sections) {
                        restart |= scanSection(section);
                    }
                }
            }

            if (!restart) { 
                for (Row row: sudoku.getRows()) {
                    restart |= scanRow(row);
                }
            }

            if (!restart) { 
                for (Column column: sudoku.getColumns()) {
                    restart |= scanColumn(column);
                }
            }
        }

        return sudoku;
    }
}
