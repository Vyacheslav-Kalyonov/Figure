import java.util.List;

public class TruncatedSphere extends Figure implements Constants {

    public static final int SIZE_POINTS_FOR_VALID = 3;
    public static final int COEFFICIENT = 2;
    private static final int COEFFICIENT_SPHERE = 4;

    private final List<int[]> points;

    private int[] center;
    private int[] pointOnSphere;
    private int[] pointOnCircle;

    public TruncatedSphere(List<int[]> points) {
        this.points = points;
        center = points.get(Constants.INDEX_ZERO);
        pointOnSphere = points.get(Constants.INDEX_ONE);
        pointOnCircle = points.get(Constants.INDEX_TWO);
    }

    @Override
    public boolean figureIsValid() {
        if (points.size() != SIZE_POINTS_FOR_VALID) {
            System.out.println("Figure is invalid");
            return false;
        }

        if (pointOnSphere[Constants.INDEX_ZERO] == center[Constants.INDEX_ZERO]
                && pointOnSphere[Constants.INDEX_ONE] == center[Constants.INDEX_ONE]
                && pointOnSphere[Constants.INDEX_TWO] == center[Constants.INDEX_TWO]
                && super.distance3D(center, pointOnSphere) == super.distance3D(center, pointOnCircle)) {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        } else {
            System.out.println(Constants.PATTERN_IS_VALID);
            return true;
        }
    }

    @Override
    public void figureArea() {
        double r = super.distance3D(center, pointOnSphere);
        double h = Math.abs(r - Math.abs(center[INDEX_TWO] - pointOnCircle[INDEX_TWO]));
        double areaSphere = (double) Math.round(COEFFICIENT_SPHERE * Math.PI * r * r * Constants.NUMBER_FOR_ROUND) / Constants.NUMBER_FOR_ROUND;
        double area = areaSphere - (double) Math.round((COEFFICIENT * Math.PI * r * h) * Constants.NUMBER_FOR_ROUND) / Constants.NUMBER_FOR_ROUND;

        System.out.println(Constants.PATTERN_AREA + area);
    }
}
