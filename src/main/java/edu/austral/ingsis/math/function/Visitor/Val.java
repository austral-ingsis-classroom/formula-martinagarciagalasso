package edu.austral.ingsis.math.function.Visitor;

// VALUES
public class Val implements Function {
  private final Double number;

  public Val(Double number) {
    this.number = number;
  }

  public Double getANumber() {
    return number;
  }

  @Override
  public <M> M accept(Visitor<M> visitor) {
    return visitor.visit(this);
  }

  public Double getValue() {
    return number;
  }
}
