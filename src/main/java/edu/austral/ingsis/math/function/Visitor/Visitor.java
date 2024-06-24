package edu.austral.ingsis.math.function.Visitor;

import edu.austral.ingsis.math.function.Composite.Values;
import edu.austral.ingsis.math.function.Visitor.Opperands.*;

import java.lang.Module;

public interface Visitor<M>{
    M visit(Addition addition);

    M visit(Substraction substraction);

    M visit(Multiplication multiplication);

    M visit(Divide division);

    M visit(SquareRoot squareRoot);

    M visit(Power power);

    M visit(Module module);

    M visit(Values values);

    M visit(Variables variables);

    M visit(Val val);
}
