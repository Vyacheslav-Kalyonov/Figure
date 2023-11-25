import java.util.List;

public class Polygon extends Figure {

    public static final int SIZE_POINTS_FOR_VALID = 2;
    private final List<int[]> points;

    public Polygon(List<int[]> points) {
        this.points = points;
    }

    @Override
    public final boolean figureIsValid() {
        if (points.size() < SIZE_POINTS_FOR_VALID) {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        }
        for (int i = Constants.INDEX_ONE; i < points.size(); i++) {
            if (points.get(i)[Constants.INDEX_ZERO] == points.get(i - Constants.INDEX_ONE)[Constants.INDEX_ZERO]
                    && points.get(i)[Constants.INDEX_ONE] == points.get(i - Constants.INDEX_ONE)[Constants.INDEX_ONE]) {
                System.out.println(Constants.PATTERN_IS_INVALID);
                return false;
            }
        }
        System.out.println(Constants.PATTERN_IS_VALID);
        return true;
    }

    @Override
    public final void figureArea() {
        System.out.println(Constants.PATTERN_AREA + super.area(points));
    }

    @Override
    public final void perimeterFigure() {
        System.out.println(Constants.PATTERN_PERIMETER_FIGURE + super.perimeter(points));
    }
}
