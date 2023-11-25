import java.util.List;

public class Sphere extends Figure {

    public static final int SIZE_POINTS_FOR_VALID = 2;
    public static final int COEFFICIENT = 4;
    private final List<int[]> points;

    private int[] center;
    private int[] point;

    public Sphere(List<int[]> points) {
        this.points = points;

        center = points.get(Constants.INDEX_ZERO);
        point = points.get(Constants.INDEX_ONE);
    }

    @Override
    public final boolean figureIsValid() {
        if (points.size() != SIZE_POINTS_FOR_VALID) {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        }

        if (point[Constants.INDEX_ZERO] == center[Constants.INDEX_ZERO] && point[Constants.INDEX_ONE] == center[Constants.INDEX_ONE]
                && point[Constants.INDEX_TWO] == center[Constants.INDEX_TWO]) {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        } else {
            System.out.println(Constants.PATTERN_IS_VALID);
            return true;
        }
    }

    @Override
    public final void figureArea() {
        double r = super.distance3D(center, point);
        double area = (double) Math.round(COEFFICIENT * Math.PI * r * r * Constants.NUMBER_FOR_ROUND) / Constants.NUMBER_FOR_ROUND;
        System.out.println(Constants.PATTERN_AREA + area);
    }
}
