

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ConeTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static final List<int[]> pointTestPassed = new ArrayList<>();
    public static List<int[]> pointTestFailed = new ArrayList<>();

    private static Cone figureTestPassed;
    private static Cone figureTestFailed;

    @BeforeAll
    public static void addElement() {
        pointTestPassed.add(new int[]{0, 0, 0});
        pointTestPassed.add(new int[]{1, 0, 0});
        pointTestPassed.add(new int[]{0, 0, 1});

        pointTestFailed.add(new int[]{0, 0, 0});
        pointTestFailed.add(new int[]{1, 1, 1});
        pointTestFailed.add(new int[]{0, 0, 1});

        figureTestPassed = new Cone(pointTestPassed);
        figureTestFailed = new Cone(pointTestFailed);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void figureIsValidTest() {
        assertEquals(true, figureTestPassed.figureIsValid());
        assertEquals( false, figureTestFailed.figureIsValid());
    }


    @Test
    public void figureAreaTest() {
        figureTestPassed.figureArea();
        assertEquals("The figure area 7.0", outputStreamCaptor.toString().trim());
    }

    @Test
    public void perimeterFigureTest() {
        figureTestPassed.perimeterFigure();
        assertEquals("The figure has no perimeter", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
