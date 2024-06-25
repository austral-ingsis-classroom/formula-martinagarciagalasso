package edu.austral.ingsis.math.function.Visitor;

import edu.austral.ingsis.math.function.Composite.Values;
import edu.austral.ingsis.math.function.Visitor.Opperands.*;
import edu.austral.ingsis.math.function.Visitor.Opperands.Module;

public class PrintMyVisitor implements Visitor<String>{

    @Override
    public String visit(Addition addition) {
        return "("+addition.getL().accept(this) + " + " + addition.getR().accept(this)+")";
    }

    @Override
    public String visit(Power power) {
        return "("+power.getL().accept(this) + " ^ " + power.getR().accept(this)+")";
    }

    @Override
    public String visit(Substraction substraction) {
        return "("+substraction.getL().accept(this) + " - " + substraction.getR().accept(this)+")";
    }

    @Override
    public String visit(Multiplication multiplication) {
        return "("+multiplication.getL().accept(this) + " * " + multiplication.getR().accept(this)+")";
    }

    @Override
    public String visit(Divide division) {
        return "("+division.getL().accept(this) + " / " + division.getR().accept(this)+")";
    }

    @Override
    public String visit(SquareRoot squareRoot) {
        return "sqrt("+squareRoot.getVal().accept(this)+")";
    }

    @Override
    public String visit(Variables variables) {
        return variables.getAName();
    }

    @Override
    public String visit(Val val) {
        return val.getValue().toString();
    }

    @Override
    public String visit(Module module) {
        return "|"+module.getNumber().accept(this)+"|";
    }
}
