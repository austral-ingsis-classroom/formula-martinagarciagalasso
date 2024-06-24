package edu.austral.ingsis.math.function.Visitor.Opperands;

import edu.austral.ingsis.math.function.Visitor.Function;
import edu.austral.ingsis.math.function.Visitor.Visitor;

public class Addition implements Function {
    private final Function l; //left
    private final Function r; //right


    public Addition(Function left, Function right) {
        this.l = left;
        this.r = right;
    }
    public Function getR() {
        return r;
    }

    @Override
    public <M> M accept(Visitor<M> visitor) {
        return visitor.visit(this);
    }

    public Function getL() {
        return l;
    }


}
