package io.renren.common.gitUtils.appium;

import io.renren.common.gitUtils.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Web {

    public WebDriver driver;
    Actions actions;

    public Web build() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "F:\\Cache\\ideaProject\\shell\\thecryptoyou\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        // 插件文件直接放到项目文件夹下,当然你需要的插件请自行下载。
//        options.addExtensions(new File("src/main/resources/extension_10_7_0_0.crx"));
//        HashMap<String,String>  mobileEmulation = new HashMap<String,String>();
//        mobileEmulation.put("deviceName","iPhone X");
//        options.setExperimentalOption("mobileEmulation", mobileEmulation);
//        driver = new ChromeDriver(options);

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        actions = new Actions(driver);
//        driver.manage().window().maximize();

        showPage();
        showCurrentUrl();
        showCurrentHandle();
        return this;
    }

    /**
     * 显示当前页面句柄
     *
     * @return
     */
    public Web showCurrentHandle() {
        msg("当前页面", String.format("%s----%s", getWindowHandle(), driver.getCurrentUrl()));
        return this;
    }

    public String getWindowHandle() {
        handle = driver.getWindowHandle();
        return handle;
    }

    // 获取当前页面句柄
    String handle;

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void showCurrentUrl() {
        msg("CurrentUrl", getCurrentUrl());
    }


    public int getWindowHandles() {
        return driver.getWindowHandles().size();
    }

    public void switchTo() {
        switchTo(getWindowHandles() - 1);
    }

    public void switchTo(int i) {
        String msg = String.format("%d---%s---%s 页面", i, handle, driver.getCurrentUrl());
        String handleCode = (String) driver.getWindowHandles().toArray()[i];
        driver.switchTo().window(handleCode);
        handle = handleCode;
        msg("页面转换", String.format("%s ---> %s", msg, String.format("%d---%s---%s 页面", i, handle, driver.getCurrentUrl())));

    }

    /**
     * 显示所有标签页
     */
    public void showPage() {
        Object[] handles = getPage();
        // 获取所有页面的句柄，并循环判断不是当前的句柄
        for (int i = 0; i < handles.length; i++) {
            msg(i, handles[i]);
        }
    }

    public Object[] getPage() {
        showCurrentHandle();
        return (Object[]) driver.getWindowHandles().toArray();
    }

    public void open(String url) {
        driver.get(url);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void msg(Object title, Object msg) {
        System.out.println(String.format("%s:%s", title, msg));
    }

    WebElement webElement;

    public Web sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        sleep(300);
        return this;
    }

    public void newTab() {
        String url = "https://www.baidu.com/";
        newTab(url);
    }

    public void newTab(String url) {
        if (ObjectUtils.notIsEmpty(url)) {
            String script = String.format("window.open('%s')", url);
            executeScript(script);
            switchTo();
        }
    }

    public void close() {
        driver.close();
        switchTo(0);
    }

    public void quit() {
        driver.quit();
    }

    public void sendKeys(String value) {
        if (webElement.isDisplayed()) {
            webElement.sendKeys(value);
        } else {
            msg("未解决错误", "");
        }
    }

    public String getText() {
        if (isWebEle()) {
            return webElement.getText();
        }
        return "";
    }

    public void move(int xOffset, int yOffset) {
        if (isWebEle()) {
            actions.moveToElement(webElement, xOffset, yOffset).pause(6).click().perform();
        }
    }

    public void outText() {
        if (isWebEle()) {
            System.out.println(webElement.getText());
        }
    }

    public String html() {
        return getAttribute("innerHTML");
    }

    public String getAttribute(String name) {
        if (isWebEle()) {
            return webElement.getAttribute(name);
        }
        return "";
    }

    public boolean isWebEle() {
        if (ObjectUtils.isEmpty(webElement)) {
//            throw new MsgException(0);
            msg("webElement", "null");
            return false;
        }
        return true;
    }

    public String getTitle() {
        return (String) executeScript("var ele =document.querySelector(\"head > title\");if(ele!==null){return ele.text} return \"\"");
    }

//    public String getAttribute(String name) {
//        return webElement.getAttribute(name);
//    }

    public Object executeScript(String script) {
        return executeScript(0, script);
    }

    public Object executeScript(long sleepTime, String script) {
        sleep(sleepTime);
        //声明一个js执行器
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //调用执行器的executeScript方法执行js脚本
        return js.executeScript(script);
    }

    public Web click() {
        webElement.click();
        return this;
    }

    public Web until(By by, long timeoutInSeconds) {
        try {
            webElement = new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            msg("err", e.getMessage());
        }
        return this;
    }


}
