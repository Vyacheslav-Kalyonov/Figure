import org.junit.jupiter.api.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParallelogramTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static final List<int[]> pointTestPassed = new ArrayList<>();
    public static List<int[]> pointTestFailed = new ArrayList<>();

    private static Parallelogram figureTestPassed;
    private static Parallelogram figureTestFailed;

    @BeforeAll
    public static void addElement() {
        pointTestPassed.add(new int[]{0, 0});
        pointTestPassed.add(new int[]{1, 1});
        pointTestPassed.add(new int[]{2, 1});
        pointTestPassed.add(new int[]{1, 0});

        pointTestFailed.add(new int[]{0, 0});
        pointTestFailed.add(new int[]{1, 1});
        pointTestFailed.add(new int[]{1, 2});
        pointTestFailed.add(new int[]{1, 0});

        figureTestPassed = new Parallelogram(pointTestPassed);
        figureTestFailed = new Parallelogram(pointTestFailed);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void figureIsValidTest() {
        assertTrue(figureTestPassed.figureIsValid());
        assertNotEquals( true, figureTestFailed.figureIsValid());

    }


    @Test
    public void figureAreaTest() {
        figureTestPassed.figureArea();
        assertEquals("The figure area 1.0", outputStreamCaptor.toString().trim());
    }

    @Test
    public void perimeterFigureTest() {
        figureTestPassed.perimeterFigure();
        assertEquals("The perimeter figure 4.83", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
