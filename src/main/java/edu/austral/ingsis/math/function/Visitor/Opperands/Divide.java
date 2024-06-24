package edu.austral.ingsis.math.function.Visitor.Opperands;

import edu.austral.ingsis.math.function.Visitor.Function;
import edu.austral.ingsis.math.function.Visitor.Visitor;

import java.util.List;
import java.util.Map;

public class Divide implements Function {
    private final Function l; //left
    private final Function r; //right


    public Divide(Function left, Function right) {
        this.l = left;
        this.r = right;
    }
    public Function getL() {
        return l;
    }
    public Function getR() {
        return r;
    }
    @Override
    public <M> M accept(Visitor<M> visitor) {
        return null;
    }
}
