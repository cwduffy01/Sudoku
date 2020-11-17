public class Cell {
    private int num, row, column;
    private int answers;    // possible answers for that cell

    /**
     * Represents a cell in a sudoku grid
     * 
     * @param num       number of cell
     * @param size      size of sudoku 
     * @param row       index of row in sudoku
     * @param column    index of column in sudoku
     */
    public Cell(int num, int size, int row, int column) {
        this.num = num;
        this.row = row;
        this.column = column;

        if (num != 0) {     // cell is already filled
            answers = 0;    // no possible answers
        }
        else {
            // binary number of n ones, where n is the size of the puzzle
            answers = Integer.MAX_VALUE >> (Integer.bitCount(Integer.MAX_VALUE) - size);
        }
    }

    public int getNum() {
        return num;
    }

    public int getAnswers() {
        return answers;
    }

    public void setAnswers(int answers) {
        this.answers = answers;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    /**
     * Removes a 1 from the bit that represents the paramater,
     * eliminates a possibility for the answer for the cell
     * 
     * @param num   number to be removed
     */
    public void removeAnswer(int num) {
        int a = (answers >> num) << num;    // fill all bits right of target and target with zeros                
        int b = answers & (int)(Math.pow(2, num-1) - 1);    // bits left of target bit
        answers = a | b;    // add together (successfully removes target bit)
    }

    /**
     * If only one possibility for the cell, set the number to 
     * the only possible answer 
     * 
     * @return  true if successful
     */
    public boolean update() {
        if (Integer.bitCount(answers) == 1) {   // only one possible answer
            num = (int)(Math.log(answers) / Math.log(2)) + 1;   // calculate what number that bit represents
            answers = 0;    // no possible answers
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + num + ']';
    }
}
