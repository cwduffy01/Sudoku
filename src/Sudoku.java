public class Sudoku {
    
    private Cell[][] grid;
    private int wSplit, hSplit;

    public Sudoku() {   // calls second constructor
        this(9);
    }

    public Sudoku(int size) {   // calls third constructor
        this(new int[size][size]);
    }

    public Sudoku(int[][] grid) {   // creates multi-dimensional array of cells
        this.grid = new Cell[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                this.grid[i][j] = new Cell(grid[i][j]);
            }
        }

        // finds closest two factors, determine width and height of sections
        hSplit = (int) Math.sqrt(grid.length);
        while (grid.length % hSplit != 0) {     // get first factor
            hSplit--;
        }
        wSplit = grid.length / hSplit;          // get second factor
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
        int[] row = new int[grid.length];
        for (int i = 0; i < row.length; i++) {
            row[i] = grid[r][i].getNum();
        }
        return row;
    }

    public int[] getCol(int c) {
        int[] col = new int[grid.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = grid[i][c].getNum();
        }
        return col;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    @Override
    public String toString() {

        String rtn = "";

        for (int i = 0; i < grid.length; i++) {
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
