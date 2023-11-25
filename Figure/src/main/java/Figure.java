import java.util.List;

public class Figure {   
    
    public boolean figureIsValid() {
        System.out.println("The figure is figure");
        return true;
    }

    public void figureArea() {
        System.out.println("The figure has no area");
    }

    public void perimeterFigure() {
        System.out.println("The figure has no perimeter");
    }

    protected double area(List<int[]> points) {
        int n = points.size();
        double ans = Constants.INDEX_ZERO;

        for (int i = Constants.INDEX_ZERO; i < n - Constants.INDEX_ONE; i++) {
            ans += points.get(i)[Constants.INDEX_ZERO] * points.get(i + Constants.INDEX_ONE)[Constants.INDEX_ONE];
        }

        for (int i = Constants.INDEX_ZERO; i < n - Constants.INDEX_ONE; i++) {
            ans -= points.get(i)[Constants.INDEX_ONE] * points.get(i + Constants.INDEX_ONE)[Constants.INDEX_ZERO];
        }

        ans += points.get(n - Constants.INDEX_ONE)[Constants.INDEX_ZERO] * points.get(Constants.INDEX_ZERO)[Constants.INDEX_ONE];
        ans -= points.get(n - Constants.INDEX_ONE)[Constants.INDEX_ONE] * points.get(Constants.INDEX_ZERO)[Constants.INDEX_ZERO];
        ans /= Constants.INDEX_TWO;

        return (double) Math.round(Math.abs(ans) * Constants.NUMBER_FOR_ROUND) / Constants.NUMBER_FOR_ROUND;
    }

    protected double perimeter(List<int[]> points) {
        double ans = 0;

        for (int i = Constants.INDEX_ZERO; i < points.size() - Constants.INDEX_ONE; i++) {
            ans += distance(points.get(i), points.get(i + Constants.INDEX_ONE));
        }

        ans += distance(points.get(points.size() - Constants.INDEX_ONE), points.get(Constants.INDEX_ZERO));
        return (double) Math.round(Math.abs(ans) * Constants.NUMBER_FOR_ROUND) / Constants.NUMBER_FOR_ROUND;
    }

    protected double distance(int[] pointA, int[] pointB) {
        return Math.sqrt((pointA[Constants.INDEX_ZERO] - pointB[Constants.INDEX_ZERO])
                * (pointA[Constants.INDEX_ZERO] - pointB[Constants.INDEX_ZERO])
                + (pointA[Constants.INDEX_ONE] - pointB[Constants.INDEX_ONE])
                * (pointA[Constants.INDEX_ONE] - pointB[Constants.INDEX_ONE]));
    }

    protected double distance3D(int[] pointA, int[] pointB) {
        double cathet1 = distance(pointA, pointB);
        double cathet2 = Math.abs(pointA[Constants.INDEX_TWO] - pointB[Constants.INDEX_TWO]);
        return Math.sqrt(cathet1 * cathet1 + cathet2 * cathet2);
    }
}
