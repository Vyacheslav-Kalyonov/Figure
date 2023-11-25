import org.junit.jupiter.api.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PolygonTest {
    
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static final List<int[]> pointTestPassed = new ArrayList<>();
    public static List<int[]> pointTestFailed = new ArrayList<>();

    private static Polygon figureTestPassed;
    private static Polygon figureTestFailed;

    @BeforeAll
    public static void addElement() {
        pointTestPassed.add(new int[]{0, 0});
        pointTestPassed.add(new int[]{1, 1});
        pointTestPassed.add(new int[]{1, 2});
        pointTestPassed.add(new int[]{1, 0});

        pointTestFailed.add(new int[]{0, 0});
        pointTestFailed.add(new int[]{1, 1});
        pointTestFailed.add(new int[]{2, 2});
        pointTestFailed.add(new int[]{3, 3});

        figureTestPassed = new Polygon(pointTestPassed);
        figureTestFailed = new Polygon(pointTestFailed);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void figureIsValidTest() {
       assertTrue(figureTestPassed.figureIsValid());
        assertEquals( true, figureTestFailed.figureIsValid());
    }


    @Test
    public void figureAreaTest() {
        figureTestPassed.figureArea();
        assertEquals("The figure area 0.5", outputStreamCaptor.toString().trim());
    }

    @Test
    public void perimeterFigureTest() {
        figureTestPassed.perimeterFigure();
        assertEquals("The perimeter figure 5.41", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
