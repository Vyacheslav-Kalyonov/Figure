import java.util.List;

public class Cone extends Figure {

    public static final int SIZE_POINTS_FOR_VALID = 3;

    private final List<int[]> points;
    private int[] center;
    private int[] vertex;
    private int[] point;

    public Cone(List<int[]> points) {
        this.points = points;
    }


    @Override
    public final boolean figureIsValid() {
        if (points.size() != SIZE_POINTS_FOR_VALID) {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        }

        center = points.get(Constants.INDEX_ZERO);
        point = points.get(Constants.INDEX_ONE);
        vertex = points.get(Constants.INDEX_TWO);

        if (center[Constants.INDEX_ZERO] == vertex[Constants.INDEX_ZERO]
                && center[Constants.INDEX_ONE] == vertex[Constants.INDEX_ONE]
                && center[Constants.INDEX_TWO] != vertex[Constants.INDEX_TWO]
                && center[Constants.INDEX_TWO] == point[Constants.INDEX_TWO]
                && super.distance(center, point) != 0) {
            System.out.println(Constants.PATTERN_IS_VALID);
            return true;
        } else {
            System.out.println(Constants.PATTERN_IS_INVALID);
            return false;
        }
    }

    @Override
    public final void figureArea() {
        double r = super.distance(center, point);
        double h = Math.abs(vertex[Constants.INDEX_TWO] - center[Constants.INDEX_TWO]);
        double l = Math.sqrt(r * r + h * h);
        double ans = Math.PI * r * l + Math.PI * r * r;
        ans = (double) (Math.round(ans * Constants.NUMBER_FOR_ROUND) / Constants.NUMBER_FOR_ROUND);
        System.out.println(Constants.PATTERN_AREA + ans);
    }

    @Override
    public final void perimeterFigure() {
        System.out.println(Constants.PATTERN_NO_PERIMETER_FIGURE);
    }
}
