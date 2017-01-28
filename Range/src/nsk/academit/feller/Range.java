package nsk.academit.feller;


public class Range {
    private double from;
    private double to;
    private static final double EPSILON = 1.0e-10;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getLength()
    {
        return (to - from);
    }

    public boolean isInside(double number) {

        return number - from >= EPSILON && to - number >= EPSILON;
    }

    public double getFrom()
    {
        return from;
    }

    public double getTo() {

        return to;
    }

    public Object getCross(double from, double to) {


        if ((from >= this.from && from <= this.to) && to > this.to) {

            return new Range(this.from, to);

        } else if ((this.from >= from && this.from <= to) && this.to > to) {

            return new Range(from, this.to);

        } else if ((this.from >= from && this.to <= to) || (from >= this.from && to <= this.to)) {

            return new Range(from, to);

        } else {
            return null;
        }
    }
}
