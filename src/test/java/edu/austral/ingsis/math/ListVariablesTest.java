package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.function.Visitor.GetMyVariableVisitor;
import edu.austral.ingsis.math.function.Visitor.Opperands.*;
import edu.austral.ingsis.math.function.Visitor.Opperands.Module;
import edu.austral.ingsis.math.function.Visitor.Val;
import edu.austral.ingsis.math.function.Visitor.Variables;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {
  private final GetMyVariableVisitor visitor = new GetMyVariableVisitor();

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final List<String> result = visitor.visit(new Addition(new Val(1.0), new Val(6.0)));

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final List<String> result = visitor.visit(new Divide(new Val(12.0), new Variables("div")));

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final List<String> result =
        visitor.visit(
            new Multiplication(new Divide(new Val(9.0), new Variables("x")), new Variables("y")));

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final List<String> result =
        visitor.visit(new Power(new Divide(new Val(27.0), new Variables("a")), new Variables("b")));

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final List<String> result =
        visitor.visit(new Power(new Variables("z"), new Divide(new Val(1.0), new Val(2.0))));
    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final List<String> result =
        visitor.visit(new Substraction(new Module(new Variables("value")), new Val(8.0)));

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final List<String> result =
        visitor.visit(new Substraction(new Module(new Variables("value")), new Val(8.0)));

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final List<String> result =
        visitor.visit(
            new Multiplication(new Substraction(new Val(5.0), new Variables("i")), new Val(8.0)));

    assertThat(result, containsInAnyOrder("i"));
  }
}
