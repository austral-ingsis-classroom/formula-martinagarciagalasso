package edu.austral.ingsis.math.function.Composite.Opperands;

import edu.austral.ingsis.math.function.Composite.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Addition implements Function {
    private final Function leftFunction;
    private final Function rightFunction;


    public Addition(Function leftFunction, Function rightFunction) {
        this.leftFunction = leftFunction;
        this.rightFunction = rightFunction;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        return leftFunction.evaluate(variables) + rightFunction.evaluate(variables);
    }

    @Override
    public List<String> getMyVariables() {
        //para obtener todas las vaariables de las funciones
        List<String> leftVariables = leftFunction.getMyVariables();
        List<String> rightVariables = rightFunction.getMyVariables();
        List<String> combinedVariables = new ArrayList<>(leftVariables);
        combinedVariables.addAll(rightVariables);
        return combinedVariables;
    }

    @Override
    public String print() {
        return "(" + leftFunction.print() + " + " + rightFunction.print() + ")";
    }
}
