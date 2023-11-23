import java.util.List;

public class Figure {

    public Figure() {
    }

    public Figure(List<int[]> points) {
    }
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

    public double area(List<int[]> points) {
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

    public double perimeter(List<int[]> points) {
        double ans = 0;

        for (int i = Constants.INDEX_ZERO; i < points.size() - Constants.INDEX_ONE; i++) {
            ans += distance(points.get(i), points.get(i + Constants.INDEX_ONE));
        }

        ans += distance(points.get(points.size() - Constants.INDEX_ONE), points.get(Constants.INDEX_ZERO));
        return (double) Math.round(Math.abs(ans) * Constants.NUMBER_FOR_ROUND) / Constants.NUMBER_FOR_ROUND;
    }

    public double distance(int[] point1, int[] point2) {
        return Math.sqrt((point1[Constants.INDEX_ZERO] - point2[Constants.INDEX_ZERO])
                * (point1[Constants.INDEX_ZERO] - point2[Constants.INDEX_ZERO])
                + (point1[Constants.INDEX_ONE] - point2[Constants.INDEX_ONE])
                * (point1[Constants.INDEX_ONE] - point2[Constants.INDEX_ONE]));
    }

    public double distance3D(int[] points1, int[] points2) {
        double katet1 = distance(points1, points2);
        double katet2 = Math.abs(points1[Constants.INDEX_TWO] - points2[Constants.INDEX_TWO]);
        return Math.sqrt(katet1 * katet1 + katet2 * katet2);
    }
}
