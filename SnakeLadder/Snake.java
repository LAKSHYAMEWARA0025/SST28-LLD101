package SnakeLadder;

public class Snake implements BoardObject {

    private int head;
    private int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    public int apply(int position) {
        if (position == head) {
            return tail;
        }
        return position;
    }
}