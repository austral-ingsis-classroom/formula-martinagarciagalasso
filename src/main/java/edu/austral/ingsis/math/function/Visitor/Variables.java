package edu.austral.ingsis.math.function.Visitor;

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
}
