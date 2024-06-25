package edu.austral.ingsis.math.function.Visitor;

import edu.austral.ingsis.math.function.Visitor.Opperands.*;
import edu.austral.ingsis.math.function.Visitor.Opperands.Module;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GetMyVariableVisitor implements Visitor<List<String>> {
  private List<String> run(List<String> a, List<String> b) {
    List<String> result = new ArrayList<>(a);
    result.addAll(b);
    return result;
  }

  @Override
  public List<String> visit(Addition addition) {
    return run(addition.getL().accept(this), addition.getR().accept(this));
  }

  @Override
  public List<String> visit(Power power) {
    return run(power.getL().accept(this), power.getR().accept(this));
  }

  @Override
  public List<String> visit(Substraction substraction) {
    return run(substraction.getL().accept(this), substraction.getR().accept(this));
  }

  @Override
  public List<String> visit(Multiplication multiplication) {
    return run(multiplication.getL().accept(this), multiplication.getR().accept(this));
  }

  @Override
  public List<String> visit(Divide division) {
    return run(division.getL().accept(this), division.getR().accept(this));
  }

  @Override
  public List<String> visit(SquareRoot squareRoot) {
    return squareRoot.getVal().accept(this);
  }

  @Override
  public List<String> visit(Variables variables) {
    return List.of(variables.getAName());
  }

  @Override
  public List<String> visit(Val val) {
    return new ArrayList<>();
  }

  @Override
  public List<String> visit(Module module) {
    return module.getNumber().accept(this);
  }
}
