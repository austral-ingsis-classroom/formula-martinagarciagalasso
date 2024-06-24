package edu.austral.ingsis.math.function.Visitor.Opperands;

import edu.austral.ingsis.math.function.Visitor.Function;
import edu.austral.ingsis.math.function.Visitor.Visitor;

public class Power implements Function {
    private final Function l;
    private final Function r;

    public Power(Function left, Function right) {
        this.l = left;
        this.r = right;
    }

    @Override
    public <M> M accept(Visitor<M> visitor) {
        return visitor.visit(this);
    }

    public Function getL() {
        return l;
    }

    public Function getR() {
        return r;
    }
}
