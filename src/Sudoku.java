public class Sudoku {
    private Cell[][] grid;
    private int size, sectWidth, sectHeight;
    private Row[] rows;
    private Column[] columns;
    private Section[][] sections;

    /**
     * Represents a sudoku puzzle
     * 
     * @param grid  multidimensional array of integer values of each cell, 0 if empty
     */
    public Sudoku(int[][] grid) {   // creates multi-dimensional array of cells
        size = grid.length;

        // finds closest two factors, determine width and height of each section
        sectHeight = (int) Math.sqrt(size);
        while (size % sectHeight != 0) {     // get first factor
            sectHeight--;
        }
        sectWidth = size / sectHeight;          // get second factor

        this.grid = new Cell[size][size];
        rows = new Row[size];
        columns = new Column[size];
        sections = new Section[sectWidth][sectHeight];

        // fills grid with Cells with numbers of integer array argument
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                this.grid[i][j] = new Cell(grid[i][j], size, i, j);
            }
        }

        // fills rows and columns with same cells in grid
        for (int i = 0; i < size; i++) {
            rows[i] = new Row(this.grid[i]);
            Cell[] temp = new Cell[size];
            for (int j = 0; j < size; j++) {
                temp[j] = this.grid[j][i];
            }
            columns[i] = new Column(temp);
        }

        // fills sections with same cells in grid
        for (int i = 0; i < size; i+=sectHeight) {
            for (int j = 0; j < size; j+=sectWidth) {
                Cell[][] temp = new Cell[sectHeight][sectWidth];
                for (int r = 0; r < temp.length; r++) {
                    for (int c = 0; c < temp[0].length; c++) {
                        temp[r][c] = this.grid[i+r][j+c];
                    }
                }
                sections[i/sectHeight][j/sectWidth] = new Section(temp);
            }
        }
    }

    /**
     * Checks to see if sudoku is solved
     * 
     * @return  true if each cell is filled, false otherwise
     */
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

    public Cell[][] getGrid() {
        return grid;
    }

    public int gethSplit() {
        return sectHeight;
    }

    public int getwSplit() {
        return sectWidth;
    }

    public Row[] getRows() {
        return rows;
    }

    public Column[] getColumns() {
        return columns;
    }

    public Section[][] getSections() {
        return sections;
    }

    @Override
    public String toString() {
        String rtn = "";

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rtn += grid[i][j];
                if ((j + 1) % sectWidth == 0) {    // split columns
                    rtn += "  ";
                }
            }
            rtn += '\n';
            if ((i + 1) % sectHeight == 0 && (i + 1) < size) {    // split rows
                rtn += '\n';
            }
        }

        return rtn;
    }
}
