package SnakeLadder;

import java.util.List;

public class Board {

    private int size;
    private List<BoardObject> objects;

    public Board(int size, List<BoardObject> objects) {
        this.size = size;
        this.objects = objects;
    }

    public int applyMove(int position) {
        for (BoardObject obj : objects) {
            position = obj.apply(position);
        }
        return position;
    }

    public int getWinningPosition() {
        return size * size;
    }
}