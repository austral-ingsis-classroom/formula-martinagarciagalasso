package edu.austral.ingsis.math.function.Visitor.Opperands;

import edu.austral.ingsis.math.function.Visitor.Function;
import edu.austral.ingsis.math.function.Visitor.Visitor;

public class Multiplication implements Function {
  private final Function l;
  private final Function r;

  public Multiplication(Function l, Function r) {
    this.l = l;
    this.r = r;
  }

  @Override
  public <M> M accept(Visitor<M> visitor) {
    return visitor.visit(this);
  }

  public Function getL() {
    return l;
  }

  public Function getR() {
    return r;
  }
}
