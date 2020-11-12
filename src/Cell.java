public class Cell {

    private int num;
    private int answers;    // possible values for cell

    public Cell(int num, int size) {
        this.num = num;
        if (num != 0) {
            answers = 0;
        }
        else {
            answers = Integer.MAX_VALUE >> (Integer.bitCount(Integer.MAX_VALUE) - size);
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getAnswers() {
        return answers;
    }

    public void setAnswers(int answers) {
        this.answers = answers;
    }

    public void removeAnswer(int num) {
        int a = (answers >> num) << num;
        int b = answers & (int)(Math.pow(2, num-1) - 1);
        answers = a | b;
    }

    @Override
    public String toString() {
        return "[" + num + ']';
    }
}
