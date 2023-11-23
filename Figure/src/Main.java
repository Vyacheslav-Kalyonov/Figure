import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        if (nameFigure.contains("END")) {
            return null;
        }

        if (nameFigure.contains("FIGURE")) {
            return new Figure();
        }

        List<int[]> points = input(scanner);

        switch (nameFigure) {
            case "CIRCLE" -> figure = new Circle(points);
            case "SQUARE" -> figure = new Square(points);
            case "RECTANGLE" -> figure = new Rectangle(points);
            case "PARALLELOGRAM" -> figure = new Parallelogram(points);
            case "TRIANGLE" -> figure = new Triangle(points);
            case "POLYGON" -> figure = new Polygon(points);
            case "CONE" -> figure = new Cone(points);
            case "CYLINDER" -> figure = new Cylinder(points);
            case "SPHERE" -> figure = new Sphere(points);
            case "TRUNCATED SPHERE" -> figure = new TruncatedSphere(points);
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
            } else if (!data.contains("STOP_INPUT")) {
                System.out.println("Please, retype");
            }
        } while (!data.contains("STOP_INPUT"));

        return ans;
    }
}