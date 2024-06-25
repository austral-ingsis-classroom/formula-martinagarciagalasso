package edu.austral.ingsis.math.function.Composite;

import java.util.List;
import java.util.Map;

public class Variables implements Function {
  private String nombre;
  private Double valor;

  public Variables(String nombre, Double valor) {
    this.nombre = nombre;
    this.valor = valor;
  }

  public void setValue(Double valor) {
    this.valor = valor;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return valor;
  }

  @Override
  public List<String> getMyVariables() {
    return List.of(nombre);
  }

  @Override
  public String print() {
    return nombre;
  }
}
