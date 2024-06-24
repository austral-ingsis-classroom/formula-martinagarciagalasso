package edu.austral.ingsis.math.function.Visitor;

public interface Function {
    <M> M accept(Visitor<M> visitor);
}
