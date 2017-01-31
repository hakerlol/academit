package nsk.academit.feller;

import java.util.Locale;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        Range length = new Range(-6.6, 7.4);
        Range length1 = new Range(-3, 9);

      /*  System.out.println("Enter real number:");
        double number = scanner.nextDouble();

        System.out.printf("From: %f To: %f%nInterval is %f%nNumber is in interval: %s%n", length.getFrom(), length.getTo(), length.getLength(), length.isInside(number));
        System.out.printf("From: %f To: %f%nInterval is %f%nNumber is in interval: %s%n", length1.getFrom(), length1.getTo(), length1.getLength(), length1.isInside(number));*/

        System.out.printf("New cross interval is: From %f To %f%n", length.getCross(length1).getFrom(), length.getCross(length1).getTo());
        System.out.printf("New association interval is: From %f To %f", length.getAssociation(length1).getFrom(), length.getAssociation(length1).getTo());
    }
}
