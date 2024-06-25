package edu.austral.ingsis.math.function.Composite.Opperands;

import edu.austral.ingsis.math.function.Composite.Function;
import java.util.List;
import java.util.Map;

public class Module implements Function {
  private final Function values;

  public Module(Function values) {
    this.values = values;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return Math.abs(values.evaluate(variables));
  }

  @Override
  public List<String> getMyVariables() {
    return values.getMyVariables();
  }

  @Override
  public String print() {
    return "|" + values.print() + "|";
  }
}
