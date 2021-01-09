package com.wut.test;

import com.wut.config.AppiumDriverConfiguration;
import com.wut.service.BrowseService;
import com.wut.service.OperateService;
import com.wut.service.PageTurnsService;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;

/**
 * Package_Name: com.wut.test
 * Description: 测试类基类
 *
 * @author yangzheng
 * Date:  2020/09/02
 */
@ActiveProfiles("android-xuexi")
@ContextConfiguration(classes = AppiumDriverConfiguration.class)
public class BaseTest extends AbstractTestNGSpringContextTests {
    @Autowired
    AppiumDriverConfiguration config;
    @Autowired
    AndroidDriver<AndroidElement> driver;
    @Autowired
    BrowseService browseService;
    @Autowired
    PageTurnsService pageTurnsService;
    @Autowired
    OperateService operateService;

    @AfterTest
    public void afterTest() {
        driver.closeApp();
        driver.quit();
        logger.info("运行结束后，service必须关闭");
        if (config.getAppiumService().isRunning()) {
            config.getAppiumService().stop();
        }
        logger.info(config.getAppiumService().isRunning());
    }
}
