public class Section {
    private Cell[][] section;

    /**
     * Represents section of sudoku 
     * 
     * @param cells cells in section
     */
    public Section(Cell[][] cells) {
        section = new Cell[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                section[i][j] = cells[i][j];
            }
        }
    }

    public Cell[][] getSection() {
        return section;
    }
    
    public int[] getNums() {
        int[] temp = new int[section.length * section[0].length];   // amount of elements in multidim. array
        int count = 0;
        for (int i = 0; i < section.length; i++) {
            for (int j = 0; j < section.length; j++) {
                temp[count++] = section[i][j].getNum();     // fills one-dim. array with values of two-dim. array
            }
        }
        return temp;    // integer representation of each cell
    }
}
