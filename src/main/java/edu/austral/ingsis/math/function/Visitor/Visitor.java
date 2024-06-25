package edu.austral.ingsis.math.function.Visitor;

import edu.austral.ingsis.math.function.Composite.Values;
import edu.austral.ingsis.math.function.Visitor.Opperands.*;

public interface Visitor<M>{
    M visit(Addition addition);
    M visit(Power power);

    M visit(Val val);

    M visit(Substraction substraction);

    M visit(Multiplication multiplication);

    M visit(Divide division);

    M visit(SquareRoot squareRoot);



    M visit(Variables variables);



    M visit(edu.austral.ingsis.math.function.Visitor.Opperands.Module module);
}
