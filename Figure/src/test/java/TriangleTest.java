import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static final List<int[]> pointTestPassed = new ArrayList<>();
    public static List<int[]> pointTestFailed = new ArrayList<>();

    private static Triangle figureTestPassed;
    private static Triangle figureTestFailed;

    @BeforeAll
    public static void addElement() {
        pointTestPassed.add(new int[]{0, 0});
        pointTestPassed.add(new int[]{3, 3});
        pointTestPassed.add(new int[]{1, 3});

        pointTestFailed.add(new int[]{0, 0});
        pointTestFailed.add(new int[]{1, 1});
        pointTestFailed.add(new int[]{2, 2});

        figureTestPassed = new Triangle(pointTestPassed);
        figureTestFailed = new Triangle(pointTestFailed);
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
    @DisplayName("check area of Triangle")
    public void figureAreaTest() {
        figureTestPassed.figureArea();
        assertEquals("The figure area 3.0", outputStreamCaptor.toString().trim());
    }

    @Test
    public void perimeterFigureTest() {
        figureTestPassed.perimeterFigure();
        assertEquals("The perimeter figure 9.4", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
