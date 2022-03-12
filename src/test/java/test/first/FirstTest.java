package test.first;

import org.testng.annotations.Test;
import test.BaseTest;

public class FirstTest extends BaseTest {
    @Test
    public void test(){
        driverWrapper.openPage("google.com");
    }
}
