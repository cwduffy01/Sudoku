public class Column {
    private Cell[] cells;

    /**
     * Represents column of sudoku
     * 
     * @param cells cells in column
     */
    public Column(Cell[] cells) {
        this.cells = new Cell[cells.length];
        for (int i = 0; i < cells.length; i++) {
            this.cells[i] = cells[i];
        }
    }

    public Cell[] getCells() {
        return cells;
    }

    public int[] getNums() {
        int[] temp = new int[cells.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = cells[i].getNum();
        }
        return temp;    // integer representation of each cell
    }
}
