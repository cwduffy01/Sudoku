public class Section {
    private Cell[][] cells;

    /**
     * Represents section of sudoku 
     * 
     * @param cells cells in section
     */
    public Section(Cell[][] cells) {
        this.cells = new Cell[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                this.cells[i][j] = cells[i][j];
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }
    
    public int[] getNums() {
        int[] temp = new int[cells.length * cells[0].length];   // amount of elements in multidim. array
        int count = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                temp[count++] = cells[i][j].getNum();     // fills one-dim. array with values of two-dim. array
            }
        }
        return temp;    // integer representation of each cell
    }
}
