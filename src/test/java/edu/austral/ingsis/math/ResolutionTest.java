package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.function.Visitor.EvaluateMyVisitor;
import edu.austral.ingsis.math.function.Visitor.Opperands.*;
import edu.austral.ingsis.math.function.Visitor.Opperands.Module;
import edu.austral.ingsis.math.function.Visitor.Val;
import edu.austral.ingsis.math.function.Visitor.Visitor;
import org.junit.jupiter.api.Test;

public class ResolutionTest {
  private final Visitor<Double> visitor = new EvaluateMyVisitor();

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double result = visitor.visit(new Addition(new Val(1.0), new Val(6.0)));

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double result = visitor.visit(new Divide(new Val(12.0), new Val(2.0)));

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double result = visitor.visit(new Multiplication(new Divide(new Val(9.0), new Val(2.0)), new Val(3.0)));

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double result =  visitor.visit(new Power(new Divide(new Val(27.0), new Val(6.0)), new Val(2.0)));

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double result = visitor.visit(new Power(new Val(36.0), new Divide(new Val(1.0), new Val(2.0))));

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double result = visitor.visit(new Module(new Val(136.0)));

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double result = visitor.visit(new Module(new Val(-136.0)));

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double result =  visitor.visit(new Multiplication(new Substraction(new Val(5.0), new Val(5.0)), new Val(8.0)));

    assertThat(result, equalTo(0d));
  }
}
