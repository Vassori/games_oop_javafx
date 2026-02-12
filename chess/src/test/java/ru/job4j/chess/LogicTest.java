package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException() {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class,
                () -> logic.move(Cell.C1, Cell.H6));
        assertThat(exception.getMessage()).isEqualTo("The Figure not found on the board.");
    }

    @Test
    void whenMoveThanImpossibleMoveException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,
                () -> logic.move(Cell.C1, Cell.D1));
        assertThat(exception.getMessage()).isEqualTo(
                "Could not move by diagonal from C1 to D1");
    }

    @Test
    void whenMoveThanOccupiedCellException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.E3));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class,
                () -> logic.move(Cell.C1, Cell.G5));
        assertThat(exception.getMessage()).isEqualTo("The path occupied by the another figure");
    }
}
