package edu.austral.ingsis.math.function.Composite;

import java.util.List;
import java.util.Map;

public class Values implements Function {
  private final double number;

  public Values(double number) {
    this.number = number;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return number;
  }

  @Override
  public List<String> getMyVariables() {
    return List.of();
  }

  @Override
  public String print() {
    if (number % 1 == 0) {
      return Integer.toString((int) number);
    }
    return Double.toString(number);
  }
}
