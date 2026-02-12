package ru.job4j.chess.firuges.black;

import static java.lang.Math.abs;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return position;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return abs(dest.getX() - source.getX()) == abs(dest.getY() - source.getY());
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = abs(dest.getX() - position.getX());
        Cell[] steps = new Cell[size];
        int x = position.getX();
        int y = position.getY();
        int deltaX = dest.getX() > x ? 1 : -1;
        int deltaY = dest.getY() > y ? 1 : -1;
        for (int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
