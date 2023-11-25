import java.util.List;

public class Parallelogram extends Figure {

    public static final int SIZE_POINTS_FOR_VALID = 4;

    private final List<int[]> points;

    public Parallelogram(List<int[]> points) {
        this.points = points;
    }

    @Override
    public final boolean figureIsValid() {
        if (points.size() != SIZE_POINTS_FOR_VALID) {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        }

        if (points.get(Constants.INDEX_ZERO)[Constants.INDEX_ONE] == points.get(Constants.INDEX_THREE)[Constants.INDEX_ONE]
                && points.get(Constants.INDEX_ONE)[Constants.INDEX_ONE] == points.get(Constants.INDEX_TWO)[Constants.INDEX_ONE]
                && super.distance(points.get(Constants.INDEX_ZERO), points.get(Constants.INDEX_ONE))
                == super.distance(points.get(Constants.INDEX_TWO), points.get(Constants.INDEX_THREE))) {
            System.out.println(Constants.PATTERN_IS_VALID);
            return true;
        } else {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        }
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
