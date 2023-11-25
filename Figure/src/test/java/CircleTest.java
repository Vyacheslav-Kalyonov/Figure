import org.junit.jupiter.api.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class CircleTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static final List<int[]> pointTestPassed = new ArrayList<>();
    public static List<int[]> pointTestFailed = new ArrayList<>();

    private static Circle figureTestPassed;
    private static Circle figureTestFailed;

    @BeforeAll
    public static void addElement() {
        pointTestPassed.add(new int[]{0, 0});
        pointTestPassed.add(new int[]{3, 3});

        pointTestFailed.add(new int[]{1, 1});
        pointTestFailed.add(new int[]{1, 1});

        figureTestPassed = new Circle(pointTestPassed);
        figureTestFailed = new Circle(pointTestFailed);
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
    @DisplayName("check area of circle")
    public void figureAreaTest() {
        figureTestPassed.figureArea();
        assertEquals("The figure area 56.55", outputStreamCaptor.toString().trim());
    }

    @Test
    public void perimeterFigureTest() {
        figureTestPassed.perimeterFigure();
        assertEquals("The perimeter figure 26.66", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
