package SnakeLadder;

public class Ladder implements BoardObject {

    private int start;
    private int end;

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int apply(int position) {
        if (position == start) {
            return end;
        }
        return position;
    }
}