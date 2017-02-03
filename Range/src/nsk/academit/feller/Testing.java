package nsk.academit.feller;

import java.util.Locale;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        Range range = new Range(-6.6, 7.4);
        Range range1 = new Range(-8, -7);

        System.out.println("Enter real number:");
        double number = scanner.nextDouble();

        System.out.printf("From: %f To: %f%nInterval is %f%nNumber is in interval: %s%n", range.getFrom(), range.getTo(), range.getLength(), range.isInside(number));
        System.out.printf("From: %f To: %f%nInterval is %f%nNumber is in interval: %s%n", range1.getFrom(), range1.getTo(), range1.getLength(), range1.isInside(number));

        if (range.getIntersection(range1) == null) {
            System.out.println("There is no intersection");
        } else {
            System.out.printf("Intersection interval is: From %f To %f%n", range.getIntersection(range1).getFrom(), range.getIntersection(range1).getTo());
        }

        for (int i = 0; i < range.getUnion(range1).length; i++) {
            System.out.printf("Union interval number %d: %f %f%n", i + 1, range.getUnion(range1)[i].getFrom(), range.getUnion(range1)[i].getTo());
        }

        if (range.getDifference(range1).length == 0) {
            System.out.println("Difference interval is empty");
        } else {
            for (int i = 0; i < range.getDifference(range1).length; i++) {
                System.out.printf("Difference interval number %d: %f %f%n", i + 1, range.getDifference(range1)[i].getFrom(), range.getDifference(range1)[i].getTo());
            }
        }
    }
}
