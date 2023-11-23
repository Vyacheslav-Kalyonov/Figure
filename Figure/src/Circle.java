import java.util.List;

public final class Circle extends Figure {

    public static final int SIZE_POINTS_FOR_VALID = 2;
    public static final int COEFFICIENT = 2;
    private int[] center;
    private int[] point;
    private final List<int[]> points;

    public Circle(List<int[]> points) {
        this.points = points;
    }

    @Override
    public boolean figureIsValid() {
        if (points.size() != SIZE_POINTS_FOR_VALID) {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        }

        center = points.get(Constants.INDEX_ZERO);
        point = points.get(Constants.INDEX_ONE);

        if ((center[Constants.INDEX_ZERO] != point[Constants.INDEX_ZERO]) && (center[Constants.INDEX_ONE] != point[Constants.INDEX_ONE])) {
            System.out.println(Constants.PATTERN_IS_VALID);
            return true;
        } else {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        }
    }

    @Override
    public void figureArea() {
        double r = super.distance(center, point);
        double area = (double) Math.round(Math.PI * r * r * Constants.NUMBER_FOR_ROUND) / Constants.NUMBER_FOR_ROUND;
        System.out.println(Constants.PATTERN_AREA + area);
    }

    @Override
    public void perimeterFigure() {
        double r = super.distance(center, point);
        double perimeter = (double) Math.round(Math.PI * r * COEFFICIENT * Constants.NUMBER_FOR_ROUND) / Constants.NUMBER_FOR_ROUND;
        System.out.println(Constants.PATTERN_PERIMETER_FIGURE + perimeter);
    }
}
