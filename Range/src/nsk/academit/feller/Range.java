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
        return Math.max(this.from, range.from) <= Math.min(this.to, range.to);
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

            Range[] array;
            array = new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
            return array;

        } else {
            Range[] array;
            array = new Range[]{new Range(Math.min(this.from, range.from), Math.min(this.to, range.to)), new Range(Math.max(this.from, range.from), Math.max(this.to, range.to))};
            return array;
        }

    }

    public Range[] getDifference(Range range) {
        if (checkIntersection(range)) {
            if (range.to < this.to && range.from > this.from) {
                Range[] array;
                array = new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
                return array;
            } else if (range.to > this.from && range.to < this.to && range.from < this.from) {
                Range[] array;
                array = new Range[]{new Range(range.to, this.to)};
                return array;
            } else if (range.from < this.to && range.from > this.from) {
                Range[] array;
                array = new Range[]{new Range(this.from, range.from)};
                return array;
            } else {
                Range[] array;
                array = new Range[]{new Range(0, 0)};
                return array;
            }

        } else {
            Range[] array;
            array = new Range[]{new Range(this.from, this.to)};
            return array;
        }
    }
}


