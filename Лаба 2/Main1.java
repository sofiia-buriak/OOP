import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Shape {
    abstract void draw();

    protected void printEmptyLines(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println();
        }
    }
}

class Square extends Shape {
    private int x, y, sideLength;

    public Square(int x, int y, int sideLength) {
        this.x = x;
        this.y = y;
        this.sideLength = sideLength;
    }
 
    @Override
    void draw() {
        printEmptyLines(y);
        String line = " ".repeat(x) + "* ".repeat(sideLength);
        System.out.println(line);
        for (int i = 1; i < sideLength - 1; i++)
            System.out.println(" ".repeat(x) + "*" + " ".repeat(2 * sideLength - 3) + "*");
        System.out.println(line);
    }
}

class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    void draw() {
        printEmptyLines(y);
        for (int i = 0; i <= 2 * radius; i++) {
            System.out.print(" ".repeat(x));
            for (int j = 0; j <= 2 * radius; j++) 
                System.out.print(Math.abs(Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j - radius, 2)) - radius) < 0.5 ? "* " : "  ");
            System.out.println();
        }
    }
}

class Triangle extends Shape {
    private int x, y, height;

    public Triangle(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    @Override
    void draw() {
        printEmptyLines(y);
        for (int i = 0; i < height; i++) {
            System.out.print(" ".repeat(x + height - i - 1) + "*");
            if (i > 0 && i < height - 1) System.out.print(" ".repeat(2 * i - 1) + "*");
            else if (i == height - 1) System.out.print(" *".repeat(i));
            System.out.println();
        }
    }
}

interface ShapeFactory {
    Shape createShape(int x, int y, UserInteraction userInteraction);
}

class SquareFactory implements ShapeFactory {
    @Override
    public Shape createShape(int x, int y, UserInteraction userInteraction) {
        int sideLength = userInteraction.getIntInput("Введіть довжину сторони квадрата (від 1 до 100):", 1, 100);
        return new Square(x, y, sideLength);
    }
}

class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape(int x, int y, UserInteraction userInteraction) {
        int radius = userInteraction.getIntInput("Введіть радіус кола (від 1 до 100):", 1, 100);
        return new Circle(x, y, radius);
    }
}

class TriangleFactory implements ShapeFactory {
    @Override
    public Shape createShape(int x, int y, UserInteraction userInteraction) {
        int height = userInteraction.getIntInput("Введіть висоту трикутника (від 1 до 100):", 1, 100);
        return new Triangle(x, y, height);
    }
}

class UserInteraction {
    private Scanner scanner;

    public UserInteraction(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getIntInput(String prompt, int min, int max) {
        while (true) {
            System.out.println(prompt);
            int input = scanner.nextInt();
            if (isValidInput(input, min, max)) return input;
            System.out.println("Невірне значення. Будь ласка, спробуйте ще раз.");
        }
    }

    private boolean isValidInput(int input, int min, int max) {
        return input >= min && input <= max;
    }

    public boolean continueProgram() {
        System.out.println("Чи хочете ви продовжити? Якщо ні, то введіть 0, інакше будь-яке число:");
        return scanner.nextInt() != 0;
    }

    public void handleException(Exception e) {
        if (e instanceof InputMismatchException) {
            System.out.println("Помилка: введено некоректне значення. Будь ласка, введіть число.");
            scanner.nextLine(); 
        } else {
            System.out.println("Сталася помилка: " + e.getMessage());
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInteraction userInteraction = new UserInteraction(scanner);

        while (true) {
            try {
                ShapeFactory shapeFactory = getShapeFactory(userInteraction);
                int x = userInteraction.getIntInput("Введіть координату x (від 0 до 100):", 0, 100);
                int y = userInteraction.getIntInput("Введіть координату y (від 0 до 100):", 0, 100);
                Shape shape = shapeFactory.createShape(x, y, userInteraction);
                shape.draw();
                if (!userInteraction.continueProgram()) break;
            } catch (Exception e) {
                userInteraction.handleException(e);
            }
        }
        scanner.close();
    }

    private static ShapeFactory getShapeFactory(UserInteraction userInteraction) {
        int choice = userInteraction.getIntInput("Оберіть фігуру (1 - квадрат, 2 - коло, 3 - трикутник):", 1, 3);
        return createShapeFactory(choice);
    }

    private static ShapeFactory createShapeFactory(int choice) {
        switch (choice) {
            case 1: return new SquareFactory();
            case 2: return new CircleFactory();
            case 3: return new TriangleFactory();
            default: throw new IllegalArgumentException("Невірний вибір фігури");
        }
    }
}