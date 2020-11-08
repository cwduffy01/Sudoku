public class Cell {

    private int num;

    public Cell() {
        num = 0;
    }

    public Cell(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "[" + num + ']';
    }
}
