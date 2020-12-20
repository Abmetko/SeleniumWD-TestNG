
package core.utils.mockito;

import org.junit.Assert;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestClass {

    public int calculate(int a, int b) {
        return a + b;
    }

    /** Define TestClass as mocked class.
     * Define expected behaviour of calculate() method --> thenReturn(100) instead of real 1.
     * **/
    public static void main(String[] args) {
        TestClass testClass = mock(TestClass.class);
        when(testClass.calculate(1,0)).thenReturn(100);
        int result = testClass.calculate(1,0);
        Assert.assertEquals(100,result);
    }
}
