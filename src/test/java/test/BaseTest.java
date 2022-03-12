package test;

import core.SingletonDriverWrapper;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected SingletonDriverWrapper driverWrapper;
    @BeforeClass
    public void setUp(){
        driverWrapper = SingletonDriverWrapper.getInstance();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        driverWrapper.close();
    }
}
