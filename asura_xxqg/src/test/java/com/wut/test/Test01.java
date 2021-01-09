package com.wut.test;

import com.wut.config.AppiumDriverConfiguration;
import com.wut.page.LearningIndexPage;
import com.wut.service.BrowseService;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.functions.AppiumFunction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

/**
 * PACKAGE_NAME：com.wut.test
 * Description：冒烟测试类
 *
 * @author yangzheng
 * Date：2020/8/2
 */
@ActiveProfiles("android-xuexi")
@ContextConfiguration(classes = AppiumDriverConfiguration.class)
public class Test01 extends AbstractTestNGSpringContextTests {

    @Autowired
    AppiumDriverConfiguration config;
    @Autowired
    AndroidDriver<AndroidElement> driver;
    @Autowired
    LearningIndexPage learningIndexPage;
    @Autowired
    BrowseService browseService;

    private AppiumFunction<AndroidElement, AndroidTouchAction> tapElement = (element) -> {
        ElementOption elementOption = element(element);
        TapOptions tapElement = tapOptions().withElement(elementOption);
        return new AndroidTouchAction(driver).tap(tapElement);
    };

    @Test
    public void test01() throws Exception {
        Thread.sleep(1000 * 6);
        List<AndroidElement> channelMenus = learningIndexPage.getNavigationBar().getChannelMenus();
        for (AndroidElement channelMenu : channelMenus) {
            logger.info(channelMenu.getText());
        }
        logger.info(channelMenus.size());
        Thread.sleep(1000 * 6);

        AndroidElement more = learningIndexPage.getNavigationBar().getMore();
        driver.performTouchAction(tapElement.apply(more));

        driver.findElementById("").getAttribute("content-desc");

    }

    @Test
    public void test02() throws Exception {
        Thread.sleep(1000 * 6);
        learningIndexPage.getNavigationBar().getMore().click();
        Thread.sleep(1000 * 6);
    }

    @Test
    public void test03() throws Exception {
        browseService.browseResources(60, "0");
    }

    @Test
    public void getTest() throws Exception {

        Thread.sleep(1000 * 6);

        logger.info(driver.currentActivity());
//        AndroidElement items = learningIndexPage.getNavigationBar().getItems();
//        logger.info(items);

        AndroidElement more = learningIndexPage.getNavigationBar().getMore();
        logger.info(more);
//
//        learningIndexPage.getNews_shanxi().click();
//        Thread.sleep(1000 * 2);
//        logger.info(learningIndexPage.getCard_titles().size());
//        learningIndexPage.getCard_titles().get(0).click();
//        Thread.sleep(1000 * 10);

    }

    @Test
    public void test04() throws Exception {
        Thread.sleep(1000 * 4);
        logger.info(driver.currentActivity());
        AndroidElement home_bottom_tab_button_contact = learningIndexPage.getBottomTabWidget().getHome_bottom_tab_button_contact();
        home_bottom_tab_button_contact.click();
        Thread.sleep(1000);
        logger.info(driver.currentActivity());
        List<AndroidElement> channelMenus = learningIndexPage.getNavigationBar().getChannelMenus();
        for (AndroidElement channelMenu : channelMenus) {
            logger.info(channelMenu.getText());
        }
        logger.info(channelMenus.size());
        Thread.sleep(1000);

    }

    @Test
    public void test05() throws Exception {
        Thread.sleep(1000 * 4);
        AndroidElement element = driver.findElementById("cn.xuexi.android:id/home_bottom_tab_button_contact");
        element.click();
        Thread.sleep(1000 * 3);
    }

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
