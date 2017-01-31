package nsk.academit.feller;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getLength() {
        return (to - from);
    }

    public boolean isInside(double number) {

        return number - from >= 0 && to - number >= 0;
    }

    public double getFrom() {

        return from;
    }

    public double getTo() {

        return to;
    }

    public boolean checkIntersection(Range range) {
        return (range.from >= this.from && range.from <= this.to) || (this.from >= range.from && this.from <= range.to);
    }

    public Range getIntersection(Range range) {
        if (checkIntersection(range)) {
            return new Range(Math.max(this.from, range.from), Math.min(this.to, range.to));

        } else {
            return null;
        }
    }

    public Range[] getUnion(Range range) {
        if (checkIntersection(range)) {
            Range[] array = new Range[1];
            array[0] = new Range(Math.min(this.from, range.from), Math.max(this.to, range.to));
            return array;

        } else {
            Range[] array = new Range[2];
            array[0] = new Range(Math.min(this.from, range.from), Math.min(this.to, range.to));
            array[1] = new Range(Math.max(this.from, range.from), Math.max(this.to, range.to));
            return array;
        }

    }

    public Range[] getDifference(Range range) {
        if (checkIntersection(range)) {
            Range[] array = new Range[2];
            array[0] = new Range(Math.min(this.from, range.from), Math.max(this.from, range.from));
            array[1] = new Range(Math.min(this.to, range.to), Math.max(this.to, range.to));
            return array;

        } else {
            Range[] array = new Range[2];
            array[0] = new Range(Math.min(this.from, range.from), Math.min(this.to, range.to));
            array[1] = new Range(Math.max(this.from, range.from), Math.max(this.to, range.to));
            return array;
        }
    }
}


