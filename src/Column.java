public class Column {
    private Cell[] column;

    /**
     * Represents column of sudoku
     * 
     * @param cells cells in column
     */
    public Column(Cell[] cells) {
        column = new Cell[cells.length];
        for (int i = 0; i < cells.length; i++) {
            column[i] = cells[i];
        }
    }

    public Cell[] getColumn() {
        return column;
    }

    public int[] getNums() {
        int[] temp = new int[column.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = column[i].getNum();
        }
        return temp;    // integer representation of each cell
    }
}
