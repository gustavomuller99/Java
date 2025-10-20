package squaresExample.adapters;

import squaresExample.round.RoundPeg;
import squaresExample.square.SquarePeg;

public class SquarePegAdapter extends RoundPeg {

    private SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    public double getRadius() {
        double result;
        result = (Math.sqrt(Math.pow((squarePeg.getWidth()), 2) * 2));
        return result;
    }
}
