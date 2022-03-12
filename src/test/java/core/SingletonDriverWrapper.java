package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Синглтон оболочка для webdriver
 */
public class SingletonDriverWrapper {
    private RemoteWebDriver remoteWebDriver;
    private static ThreadLocal<SingletonDriverWrapper> singletonDriverWrapper;

    public static SingletonDriverWrapper getInstance() {
        if (singletonDriverWrapper == null) {
            singletonDriverWrapper = new ThreadLocal<>();
            singletonDriverWrapper.set(new SingletonDriverWrapper());
        }
        return singletonDriverWrapper.get();
    }

    private SingletonDriverWrapper() {
        ChromeOptions options = new ChromeOptions();

        options.setHeadless(true);
        options.addArguments("--ignore-certificate-errors");

        options.setCapability("platformName", "LINUX");
        try {
            remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
            remoteWebDriver.manage().window().setSize(new Dimension(1920, 1080));

        remoteWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    public void openPage(String url) {
        remoteWebDriver.get("http://" + url);
    }

    public void close() {
        remoteWebDriver.quit();
        singletonDriverWrapper = null;
    }
}
