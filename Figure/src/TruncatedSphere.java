import java.util.List;

public class TruncatedSphere extends Figure {

    public static final int SIZE_POINTS_FOR_VALID = 3;
    public static final int COEFFICIENT = 2;

    private final List<int[]> points;

    private int[] center;
    private int[] pointOnSphere;
    private int[] pointOnCircle;

    public TruncatedSphere(List<int[]> points) {
        this.points = points;
    }

    @Override
    public boolean figureIsValid() {
        if (points.size() != SIZE_POINTS_FOR_VALID) {
            System.out.println("Figure is invalid");
            return false;
        }

        center = points.get(Constants.INDEX_ZERO);
        pointOnSphere = points.get(Constants.INDEX_ONE);
        pointOnCircle = points.get(Constants.INDEX_TWO);

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
        double h = Math.abs(r + center[Constants.INDEX_TWO] - pointOnCircle[Constants.INDEX_TWO]);
        double area = (double) Math.round(Math.PI * (COEFFICIENT * r * h + r * r) * Constants.NUMBER_FOR_ROUND) / Constants.NUMBER_FOR_ROUND;

        System.out.println(Constants.PATTERN_AREA + area);
    }

    @Override
    public void perimeterFigure() {
        System.out.println(Constants.PATTERN_NO_PERIMETER_FIGURE);
    }
}
