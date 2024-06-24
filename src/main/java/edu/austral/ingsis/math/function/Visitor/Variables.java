package edu.austral.ingsis.math.function.Visitor;

import java.util.Map;

public class Variables implements Function{
    private final String nombre;

    public Variables(String nombre) {
        this.nombre = nombre;
    }

    public String getAName() {
        return nombre;
    }
    @Override
    public <M> M accept(Visitor<M> visitor) {
        return visitor.visit(this);

    }

    public Double getVariable(String aName, Map<String, Double> variables) {
        return variables.get(aName);
    }
}
