import java.util.Locale;
import java.util.Scanner;

class Range {
    private double from;
    private double to;
    private static final double EPSILON = 1.0e-10;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getLength() {
        return (to - from);
    }

    public boolean isInside(double number) {
        return number - from >= EPSILON && to - number >= EPSILON;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }
}

public class Testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        Range length = new Range(-6.6, 7.4);

        System.out.println("Enter real number:");
        double number = scanner.nextDouble();

        System.out.printf("From: %f To: %f%nInterval is %f%nNumber is in interval: %s", length.getFrom(), length.getTo(), length.getLength(), length.isInside(number));
    }
}
