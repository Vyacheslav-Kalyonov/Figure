import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements Constants {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_DATA);
        Figure figure = choiceFigure(scanner);
        while (figure != null) {

            if (figure.figureIsValid()) {
                figure.figureArea();
                figure.perimeterFigure();
            }
            figure = choiceFigure(scanner);
        }
    }

    public static Figure choiceFigure(Scanner scanner) {
        String nameFigure = scanner.nextLine();
        Figure figure = null;

        if (nameFigure.contains(END_CHOICE_FIGURE)) {
            return null;
        }

        if (nameFigure.contains(FIGURE_NAME)) {
            return new Figure();
        }

        List<int[]> points = input(scanner);

        switch (nameFigure) {
            case CIRCLE_NAME -> figure = new Circle(points);
            case SQUARE_NAME -> figure = new Square(points);
            case RECTANGLE_NAME -> figure = new Rectangle(points);
            case PARALLELOGRAM_NAME -> figure = new Parallelogram(points);
            case TRIANGLE_NAME -> figure = new Triangle(points);
            case POLYGON_NAME -> figure = new Polygon(points);
            case CONE_NAME -> figure = new Cone(points);
            case CYLINDER_NAME -> figure = new Cylinder(points);
            case SPHERE_NAME -> figure = new Sphere(points);
            case TRUNCATED_SPHERE_NAME -> figure = new TruncatedSphere(points);
        }

        return figure;
    }

    public static List<int[]> input(Scanner scanner) {
        String data;
        String pattern = "(-?\\d+\\s-?\\d+\\s-?\\d+)|(-?\\d+\\s-?\\d+)";
        List<int[]> ans = new ArrayList<>();
        do {
            data = scanner.nextLine();
            if (data.matches(pattern)) {
                String[] line = data.split(" ");
                int[] coordinates = new int[Constants.INDEX_THREE];
                int counter = Constants.INDEX_ZERO;

                for (String element : line) {
                    coordinates[counter++] = Integer.parseInt(element);
                }
                ans.add(coordinates);
            } else if (!data.contains(STOP_INPUT_DATE)) {
                System.out.println(RETYPE_POINT);
            }
        } while (!data.contains(STOP_INPUT_DATE));

        return ans;
    }
}