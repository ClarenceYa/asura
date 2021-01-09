package com.wut.service.impl;

import com.wut.service.PageTurnsService;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Package_Name: com.wut.service.impl
 * Description: 模块选择，页面跳转业务实现类
 *
 * @author yangzheng
 * Date:  2020/09/02
 */
@Service
public class PageTurnsServiceImpl extends GestureOperation implements PageTurnsService {
    public PageTurnsServiceImpl(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Override
    public void switchModule(String moduleName) {
        AndroidElement message = learningIndexPage.getBottomTabWidget().getHome_bottom_tab_button_message();
        AndroidElement ding = learningIndexPage.getBottomTabWidget().getHome_bottom_tab_button_ding();
        AndroidElement work = learningIndexPage.getBottomTabWidget().getHome_bottom_tab_button_work();
        AndroidElement contact = learningIndexPage.getBottomTabWidget().getHome_bottom_tab_button_contact();
        AndroidElement mine = learningIndexPage.getBottomTabWidget().getHome_bottom_tab_button_mine();
        if (moduleName.equals(message.getAttribute("content-desc"))) {
            driver.performTouchAction(tapElement.apply(message));
        } else if (moduleName.equals(ding.getAttribute("content-desc"))) {
            driver.performTouchAction(tapElement.apply(ding));
        } else if (moduleName.equals(work.getAttribute("content-desc"))) {
            driver.performTouchAction(tapElement.apply(work));
        }else if (moduleName.equals(contact.getAttribute("content-desc"))) {
            driver.performTouchAction(tapElement.apply(contact));
        }else if (moduleName.equals(mine.getAttribute("content-desc"))) {
            driver.performTouchAction(tapElement.apply(mine));
        }else {
            logger.error("module name unmatched,please checking it!");
        }
    }

    @Override
    public void choiceNavigationBar(String barName) {
        List<AndroidElement> channelMenus = learningIndexPage.getNavigationBar().getChannelMenus();
        // 利用stream找到barName对应的一级导航栏
        Optional<AndroidElement> rightElement = channelMenus.stream()
                .filter((element) -> barName.equals(element.getText()))
                .findFirst();
        driver.performTouchAction(tapElement.apply(rightElement.get()));
        logger.info("进入 " + barName + " 一级导航栏");
    }

    @Override
    public void enterSubscribePage() {
        AndroidElement myElement = learningIndexPage.getIndexHeadWidget().getMy();
        driver.performTouchAction(tapElement.apply(myElement));
        driver.performTouchAction(waitForTime.apply((long) 3));

        driver.performTouchAction(tapCoordinate.apply(new Point(720, 495)));
        driver.performTouchAction(waitForTime.apply((long) 2));

        driver.performTouchAction(tapCoordinate.apply(new Point(1312, 196)));
        driver.performTouchAction(waitForTime.apply((long) 2));
    }
}
