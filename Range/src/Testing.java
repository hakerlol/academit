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
    public static double[] getCross(double from1, double to1, double from2, double to2){
        double[] array = new double[2];
        if((from2 >= from1 && from2 <= to1) && to2 > to1){
            array[0] = from1;
            array[1] = to2;
            return array;

        }else if((from1 >= from2 && from1 <= to2) && to1 > to2){
            array[0] = from2;
            array[1] = to1;
            return array;

        }else if((from1 >= from2 && to1 <= to2)||(from2 >= from1 && to2 <= to1)){
            array[0] = from1;
            array[1] = to1;
            return array;

        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        Range length = new Range(-6.6, 7.4);
        Range length1 = new Range(8, 9);

        System.out.println("Enter real number:");
        double number = scanner.nextDouble();

        System.out.printf("From: %f To: %f%nInterval is %f%nNumber is in interval: %s%n", length.getFrom(), length.getTo(), length.getLength(), length.isInside(number));
        System.out.printf("From: %f To: %f%nInterval is %f%nNumber is in interval: %s%n", length1.getFrom(), length1.getTo(), length1.getLength(), length1.isInside(number));

        for ( double x : getCross(length.getFrom(), length.getTo(), length1.getFrom(), length1.getTo())){
            System.out.print(x + " ");
        }
    }
}
