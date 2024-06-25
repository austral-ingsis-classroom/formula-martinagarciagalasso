package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.function.Visitor.Opperands.*;
import edu.austral.ingsis.math.function.Visitor.Opperands.Module;
import edu.austral.ingsis.math.function.Visitor.PrintMyVisitor;
import edu.austral.ingsis.math.function.Visitor.Val;
import edu.austral.ingsis.math.function.Visitor.Variables;
import edu.austral.ingsis.math.function.Visitor.Visitor;
import org.junit.jupiter.api.Test;

public class PrintTest {
  private final Visitor<String> visitor = new PrintMyVisitor();

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "(1 + 6)";
    final String result = visitor.visit(new Addition(new Val(1.0), new Val(6.0)));

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "(12 / 2)";
    final String result = visitor.visit(new Divide(new Val(12.0), new Val(2.0)));
    ;

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "((9 / 2) * 3)";
    final String result =
        visitor.visit(new Multiplication(new Divide(new Val(9.0), new Val(2.0)), new Val(3.0)));

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "((27 / 6) ^ 2)";
    final String result =
        visitor.visit(new Power(new Divide(new Val(27.0), new Val(6.0)), new Val(2.0)));

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "(|value| - 8)";
    final String result =
        visitor.visit(new Substraction(new Module(new Variables("value")), new Val(8.0)));

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "(|value| - 8)";
    final String result =
        visitor.visit(new Substraction(new Module(new Variables("value")), new Val(8.0)));

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "((5 - i) * 8)";
    final String result =
        visitor.visit(
            new Multiplication(new Substraction(new Val(5.0), new Variables("i")), new Val(8.0)));

    assertThat(result, equalTo(expected));
  }
}
