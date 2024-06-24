package edu.austral.ingsis.math.function.Visitor;

import edu.austral.ingsis.math.function.Composite.Values;
import edu.austral.ingsis.math.function.Visitor.Opperands.*;
import edu.austral.ingsis.math.function.Visitor.Opperands.Module;

public class PrintMyVisitor implements Visitor<String>{
    @Override
    public String visit(Addition addition) {
        return null;
    }

    @Override
    public String visit(Power power) {
        return null;
    }

    @Override
    public String visit(Values values) {
        return null;
    }

    @Override
    public String visit(Substraction substraction) {
        return null;
    }

    @Override
    public String visit(Multiplication multiplication) {
        return null;
    }

    @Override
    public String visit(Divide division) {
        return null;
    }

    @Override
    public String visit(SquareRoot squareRoot) {
        return null;
    }

    @Override
    public String visit(Variables variables) {
        return null;
    }

    @Override
    public String visit(Val val) {
        return null;
    }

    @Override
    public String visit(Module module) {
        return null;
    }
}
