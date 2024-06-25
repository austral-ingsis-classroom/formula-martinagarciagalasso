package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.function.Visitor.EvaluateMyVisitor;
import edu.austral.ingsis.math.function.Visitor.Opperands.*;
import edu.austral.ingsis.math.function.Visitor.Opperands.Module;
import edu.austral.ingsis.math.function.Visitor.Val;
import edu.austral.ingsis.math.function.Visitor.Variables;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ResolutionWithVariablesTest {
  private final EvaluateMyVisitor visitor = new EvaluateMyVisitor();
  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    EvaluateMyVisitor newEvaluator = visitor.setVariables(Map.of("x", 3d));
    final Double result = newEvaluator.visit(new Addition(new Val(1.0), new Variables("x")));

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    EvaluateMyVisitor newEvaluator = visitor.setVariables(Map.of("div", 4d));
    final Double result = newEvaluator.visit(new Divide(new Val(12.0), new Variables("div")));

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    EvaluateMyVisitor newEvaluator = visitor.setVariables(Map.of("x", 3d, "y", 4d));
    final Double result =
            newEvaluator.visit(
                    new Multiplication(new Divide(new Val(9.0), new Variables("x")), new Variables("y")));

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    EvaluateMyVisitor newEvaluator = visitor.setVariables(Map.of("a", 9d, "b", 3d));
    final Double result =
            newEvaluator.visit(
                    new Power(new Divide(new Val(27.0), new Variables("a")), new Variables("b")));

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    EvaluateMyVisitor newEvaluator = visitor.setVariables(Map.of("z", 36d));
    final Double result =
            newEvaluator.visit(new Power(new Variables("z"), new Divide(new Val(1.0), new Val(2.0))));

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    EvaluateMyVisitor newEvaluator = visitor.setVariables(Map.of("value", 8d));
    final Double result =
            newEvaluator.visit(new Substraction(new Module(new Variables("value")), new Val(8.0)));

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    EvaluateMyVisitor newEvaluator = visitor.setVariables(Map.of("value", 8d));
    final Double result =
            newEvaluator.visit(new Substraction(new Module(new Variables("value")), new Val(8.0)));

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    EvaluateMyVisitor newEvaluator = visitor.setVariables(Map.of("i", 2d));
    final Double result =
            newEvaluator.visit(new Multiplication(new Substraction(new Val(5.0), new Variables("i")), new Val(8.0)));

    assertThat(result, equalTo(24d));
  }
}
