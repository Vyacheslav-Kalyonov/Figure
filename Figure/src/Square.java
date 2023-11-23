import java.util.List;

public class Square extends Figure {

    public static final int SIZE_POINTS_FOR_VALID = 4;

    private final List<int[]> points;


    public Square(List<int[]> points) {
        this.points = points;
    }

    @Override
    public final boolean figureIsValid() {
        if (points.size() != SIZE_POINTS_FOR_VALID) {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        }

        double a = super.distance(points.get(Constants.INDEX_ZERO), points.get(Constants.INDEX_ONE));
        if ((points.get(Constants.INDEX_ZERO)[Constants.INDEX_ZERO] == points.get(Constants.INDEX_ONE)[Constants.INDEX_ZERO])
                && (points.get(Constants.INDEX_ZERO)[Constants.INDEX_ONE] != points.get(Constants.INDEX_ONE)[Constants.INDEX_ONE])
                && (points.get(Constants.INDEX_ONE)[Constants.INDEX_ZERO] != points.get(Constants.INDEX_TWO)[Constants.INDEX_ZERO])
                && (points.get(Constants.INDEX_ONE)[Constants.INDEX_ONE] == points.get(Constants.INDEX_TWO)[Constants.INDEX_ONE])
                && (super.distance(points.get(Constants.INDEX_ONE), points.get(Constants.INDEX_TWO)) == a)
                && (points.get(Constants.INDEX_TWO)[Constants.INDEX_ZERO] == points.get(Constants.INDEX_THREE)[Constants.INDEX_ZERO])
                && (points.get(Constants.INDEX_TWO)[Constants.INDEX_ONE] != points.get(Constants.INDEX_THREE)[Constants.INDEX_ONE])
                && (super.distance(points.get(Constants.INDEX_TWO), points.get(Constants.INDEX_THREE)) == a)
                && (points.get(Constants.INDEX_THREE)[Constants.INDEX_ZERO] != points.get(Constants.INDEX_ZERO)[Constants.INDEX_ZERO])
                && (points.get(Constants.INDEX_THREE)[Constants.INDEX_ONE] == points.get(Constants.INDEX_ZERO)[Constants.INDEX_ONE])
                && (super.distance(points.get(Constants.INDEX_ZERO), points.get(Constants.INDEX_THREE)) == a)) {
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
