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
                this.grid[i][j] = new Cell(grid[i][j], size);
            }
        }

        // finds closest two factors, determine width and height of sections
        hSplit = (int) Math.sqrt(size);
        while (size % hSplit != 0) {     // get first factor
            hSplit--;
        }
        wSplit = size / hSplit;          // get second factor
    }

    public void update() {
        for(Cell[] arrCells: grid) {
            for(Cell cell: arrCells) {
                if (Integer.bitCount(cell.getAnswers()) == 1) {
                    int num = (int)(Math.log(cell.getAnswers()) / Math.log(2)) + 1;
                    cell.removeAnswer(num);
                    cell.setNum(num);
                }
            }
        }
    }

    public boolean isSolved() {
        for(Cell[] arrCells: grid) {
            for(Cell cell: arrCells) {
                if (cell.getNum() == 0) {
                    return false;
                }
            }
        }
        return true;
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

    public Cell getCell(int i, int j){
        return grid[i][j];
    }

    public int getSize() {
        return size;
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
     * Returns an arraylist of the numbers in any section given by 
     * its row and column index
     * 
     * @param r     row of cell
     * @param c     column of cell
     * @return      integer array of numbers in section
     */
    public int[] getSect(int r, int c) {
        int[] sect = new int[size];
        r = r / hSplit * hSplit;
        c = c / wSplit * wSplit;
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
