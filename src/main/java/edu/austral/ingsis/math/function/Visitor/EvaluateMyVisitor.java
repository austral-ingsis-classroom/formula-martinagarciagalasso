package edu.austral.ingsis.math.function.Visitor;

import edu.austral.ingsis.math.function.Visitor.Opperands.*;
import edu.austral.ingsis.math.function.Visitor.Opperands.Module;
import java.util.Map;

public class EvaluateMyVisitor implements Visitor<Double> {
  private final Map<String, Double> variables;

  public EvaluateMyVisitor(Map<String, Double> variables) {
    this.variables = variables;
  }

  public EvaluateMyVisitor() {
    this.variables = Map.of();
  }

  public EvaluateMyVisitor setVariables(Map<String, Double> variables) {
    return new EvaluateMyVisitor(variables);
  }

  @Override
  public Double visit(Addition addition) {
    return addition.getL().accept(this) + addition.getR().accept(this);
  }

  @Override
  public Double visit(Power power) {
    return Math.pow(power.getL().accept(this), power.getR().accept(this));
  }

  @Override
  public Double visit(Val val) {
    return val.getValue();
  }

  @Override
  public Double visit(Substraction substraction) {
    return substraction.getL().accept(this) - substraction.getR().accept(this);
  }

  @Override
  public Double visit(Module module) {
    return Math.abs(module.getNumber().accept(this));
  }

  @Override
  public Double visit(Multiplication multiplication) {
    return multiplication.getL().accept(this) * multiplication.getR().accept(this);
  }

  @Override
  public Double visit(Divide division) {
    return division.getL().accept(this) / division.getR().accept(this);
  }

  @Override
  public Double visit(SquareRoot squareRoot) {
    return Math.sqrt(squareRoot.getVal().accept(this));
  }

  @Override
  public Double visit(Variables variables) {
    return variables.getVariable(variables.getAName(), this.variables);
  }
}
