public class Row {
    private Cell[] row;

    /**
     * Represents a row of a sudoku
     * 
     * @param cells cells in the row
     */
    public Row(Cell[] cells) {
        row = new Cell[cells.length];
        for (int i = 0; i < cells.length; i++) {
            row[i] = cells[i];
        }
    }

    public Cell[] getRow() {
        return row;
    }

    public int[] getNums() {
        int[] temp = new int[row.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = row[i].getNum();
        }
        return temp;    // integer representation of each cell
    }
}
