package core.utils.mockito;

import org.junit.Assert;
import org.mockito.Mockito;


public class MockTest {

    public int calc(int a, int b){
        return a + b;
    }

    /** Define TestClass as mocked class.
     * Define expected behaviour of calculate() method --> thenReturn(100) instead of real 1.
     * **/
    public static void main(String[] args) {
        MockTest mockTest = Mockito.mock(MockTest.class);
        Mockito.when(mockTest.calc(1,2)).thenReturn(4);
        int result = mockTest.calc(1,2);
        Assert.assertEquals(4,result);
    }
}