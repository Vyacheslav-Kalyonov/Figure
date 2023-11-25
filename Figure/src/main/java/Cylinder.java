import java.util.List;

public class Cylinder extends Figure {

    public static final int SIZE_POINTS_FOR_VALID = 3;
    public static final int COEFFICIENT = 2;

    private final List<int[]> points;
    private int[] centerLow;
    private int[] centerHigh;
    private int[] point;

    public Cylinder(List<int[]> points) {
        this.points = points;
    }

    @Override
    public final boolean figureIsValid() {
        if (points.size() != SIZE_POINTS_FOR_VALID) {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        }

        centerLow = points.get(Constants.INDEX_ZERO);
        centerHigh = points.get(Constants.INDEX_ONE);
        point = points.get(Constants.INDEX_TWO);

        boolean validCenter = (centerLow[Constants.INDEX_TWO] == point[Constants.INDEX_TWO]
                && super.distance(centerLow, point) != Constants.INDEX_ZERO)
                || (centerHigh[Constants.INDEX_TWO] == point[Constants.INDEX_TWO]
                && super.distance(centerHigh, point) != Constants.INDEX_ZERO);
        if (centerLow[Constants.INDEX_ZERO] == centerHigh[Constants.INDEX_ZERO]
                && centerLow[Constants.INDEX_ONE] == centerHigh[Constants.INDEX_ONE]
                && centerLow[Constants.INDEX_TWO] != centerHigh[Constants.INDEX_TWO] && validCenter) {
            System.out.println(Constants.PATTERN_IS_VALID);
            return true;
        } else {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        }
    }

    @Override
    public final void figureArea() {
        double r = super.distance(centerHigh, point);
        double h = Math.abs(centerHigh[Constants.INDEX_TWO] - centerLow[Constants.INDEX_TWO]);
        double area = (double) Math.round((COEFFICIENT * Math.PI * r * r + COEFFICIENT * Math.PI * r * h) * Constants.NUMBER_FOR_ROUND)
                / Constants.NUMBER_FOR_ROUND;

        System.out.println(Constants.PATTERN_AREA + area);
    }
}
