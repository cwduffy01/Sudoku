public class Sudoku {
    
    private Cell[][] grid;
    private int size, wSplit, hSplit;

    public Sudoku() {   // calls second constructor
        this(9);
    }

    public Sudoku(int size) {   // calls third constructor
        this(new int[size][size]);
    }

    public Sudoku(int[][] grid) {   // creates multi-dimensional array of cells
        size = grid.length;
        
        this.grid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                this.grid[i][j] = new Cell(grid[i][j]);
            }
        }

        // finds closest two factors, determine width and height of sections
        hSplit = (int) Math.sqrt(size);
        while (size % hSplit != 0) {     // get first factor
            hSplit--;
        }
        wSplit = size / hSplit;          // get second factor
    }

    /**
     * Fills a specific (target) cell with a specified number
     * 
     * @param r     row of target cell
     * @param c     column of target cell
     * @param num   number to change cell to 
     */
    public void setCell(int r, int c, int num) {
        grid[r][c].setNum(num);;
    }

    public int[] getRow(int r) {
        int[] row = new int[size];
        for (int i = 0; i < row.length; i++) {
            row[i] = grid[r][i].getNum();   // add all row cell numbers to array
        }
        return row;
    }

    public int[] getCol(int c) {
        int[] col = new int[size];
        for (int i = 0; i < col.length; i++) {
            col[i] = grid[i][c].getNum();   // add all column cell numbers to array
        }
        return col;
    }

    /**
     * Returns an arraylist of the numbers in any cell given by 
     * its index. Cells for a standard sudoku are indexed as:
     * 
     * [1] [2] [3]
     * [4] [5] [6]
     * [7] [8] [9]
     * 
     * @param s
     * @return
     */
    public int[] getSect(int s) {
        int[] sect = new int[size];
        int r = (s / hSplit) * hSplit;
        int c = (s % hSplit) * wSplit;
        int count = 0;
        for (int i = r; i < r + hSplit; i++) {
            for (int j = c; j < c + wSplit; j++) {
                sect[count++] = grid[i][j].getNum();
            }
        }
        return sect;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    @Override
    public String toString() {

        String rtn = "";

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rtn += grid[i][j];
                if ((j + 1) % wSplit == 0) {    // split columns
                    rtn += "  ";
                }
            }
            rtn += '\n';
            if ((i + 1) % hSplit == 0) {    // split rows
                rtn += '\n';
            }
        }
        return rtn;
    }
}
