package ru.job4j.chess.firuges.black;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

class BishopBlackTest {

    @Test
    void whenPositionThanTheSameCell() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.position()).isEqualTo(Cell.C1);
    }

    @Test
    void whenNotDiagonalThanImpossibleMoveException() {
        BishopBlack bishop = new BishopBlack(Cell.B1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,
                () -> bishop.way(Cell.G5));
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from B1 to G5");
    }

    @Test
    void whenBishopC1WayG5ThanD2E3F4G5() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] result = bishop.way(Cell.G5);
        assertThat(result).containsExactly(expected);
    }

    @Test
    void whenCopyThanTheCorrectPosition() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.copy(Cell.E3).position()).isEqualTo(Cell.E3);
    }
}