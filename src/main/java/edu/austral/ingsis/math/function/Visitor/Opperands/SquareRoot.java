package edu.austral.ingsis.math.function.Visitor.Opperands;

import edu.austral.ingsis.math.function.Visitor.Function;
import edu.austral.ingsis.math.function.Visitor.Visitor;

import java.util.List;
import java.util.Map;

public class SquareRoot implements Function {
    private final Function val;

    public SquareRoot(Function val) {
        this.val = val;
    }


    @Override
    public <M> M accept(Visitor<M> visitor) {
        return visitor.visit(this);
    }
    public Function getVal() {
        return val;
    }
}
