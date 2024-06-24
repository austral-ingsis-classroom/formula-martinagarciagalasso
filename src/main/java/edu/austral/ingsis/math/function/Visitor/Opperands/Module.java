package edu.austral.ingsis.math.function.Visitor.Opperands;

import edu.austral.ingsis.math.function.Visitor.Function;
import edu.austral.ingsis.math.function.Visitor.Visitor;

import java.util.List;
import java.util.Map;

public class Module implements Function {
    private final Function number;

    public Module(Function number) {
        this.number = number;
    }

    @Override
    public <M> M accept(Visitor<M> visitor) {
        return visitor.visit(this);
    }
    public Function getNumber() {
        return number;
    }

}
