import java.util.List;

public class Triangle extends Figure {

    public static final int SIZE_POINTS_FOR_VALID = 3;
    private final List<int[]> points;

    public Triangle(List<int[]> points) {
        this.points = points;
    }

    @Override
    public boolean figureIsValid() {
        if (points.size() != SIZE_POINTS_FOR_VALID) {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        }

        double a = super.distance(points.get(Constants.INDEX_ZERO), points.get(Constants.INDEX_ONE));
        double b = super.distance(points.get(Constants.INDEX_ONE), points.get(Constants.INDEX_TWO));
        double c = super.distance(points.get(Constants.INDEX_ZERO), points.get(Constants.INDEX_TWO));

        if ((a + b > c) && (a + c > b) && (b + c > a)) {
            System.out.println(Constants.PATTERN_IS_VALID);
            return true;
        } else {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        }
    }

    @Override
    public void figureArea() {
        double area = super.area(points);
        System.out.println(Constants.PATTERN_AREA + area);
    }

    @Override
    public void perimeterFigure() {
        System.out.println(Constants.PATTERN_PERIMETER_FIGURE + super.perimeter(points));
    }
}
