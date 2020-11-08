public class Sudoku {
    
    private Cell[][] grid;

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

    public Cell[][] getGrid() {
        return grid;
    }

    @Override
    public String toString() {

        String rtn = "";

        // finds closest two factors, determine width and height of sections
        int hSplit = (int) Math.sqrt(grid.length);
        while (grid.length % hSplit != 0) {     // get first factor
            hSplit--;
        }
        int wSplit = grid.length / hSplit;      // get second factor

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
