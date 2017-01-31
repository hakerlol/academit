package nsk.academit.feller;


public class Range {
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

    public Range getCross(Range length) {


        if ((length.from >= this.from && length.from < this.to) && length.to > this.to) {
            return new Range(length.from, this.to);

        } else if ((this.from >= length.from && this.from < length.to) && this.to > length.to) {
            return new Range(this.from, length.to);

        } else if (this.from >= length.from && this.to <= length.to) {
            return new Range(this.from, this.to);

        } else if (length.from > this.from && length.to < this.to) {
            return new Range(length.from, length.to);

        } else if (this.from == length.to) {
            return new Range(this.from, length.to);

        } else if (length.from == this.to) {
            return new Range(length.from, this.to);

        } else {
            return null;
        }
    }

    public Range getAssociation(Range length) {
        if ((length.from >= this.from && length.from < this.to) && length.to > this.to) {
            return new Range(this.from, length.to);

        } else if ((this.from >= length.from && this.from < length.to) && this.to > length.to) {
            return new Range(length.from, this.to);

        } else if (this.from >= length.from && this.to <= length.to) {
            return new Range(length.from, length.to);

        } else if (length.from > this.from && length.to < this.to) {
            return new Range(this.from, this.to);
        }
        else {
            return null;
        }
    }

   /* public Range getDifference(Range length){
        
    }*/
}
