package test.second;

import org.testng.annotations.Test;
import test.BaseTest;

public class SecondTest extends BaseTest {
    @Test
    public void test(){
        driverWrapper.openPage("wikipedia.org");
    }
}
