package com.wut.service.impl;

import com.wut.page.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.functions.ActionSupplier;
import io.appium.java_client.functions.AppiumFunction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;

/**
 * Package_Name: com.wut.service
 * Description: 手势操作lambda定义，同时也是所以service实现类的父类
 *
 * @author yangzheng
 * Date:  2020/08/09
 */
@Service
public abstract class GestureOperation {

    /**
     * Logger available to subclasses.
     */
    final Log logger = LogFactory.getLog(getClass());

    AndroidDriver<AndroidElement> driver;
    private AndroidTouchAction action;

    @Autowired
    LearningIndexPage learningIndexPage;
    @Autowired
    ContentDetailsPage contentDetailsPage;
    @Autowired
    SubscribePage subscribePage;
    @Autowired
    MyTotalPage myTotalPage;
    @Autowired
    MySubscribePage mySubscribePage;

    // 屏幕宽度
    private int width;
    // 屏幕高度
    private int height;

    public GestureOperation(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        action = new AndroidTouchAction(driver);
        width = driver.manage().window().getSize().getWidth();
        height = driver.manage().window().getSize().getHeight();
    }

    // 点击元素
    // @param element 被点击的元素
    AppiumFunction<AndroidElement, AndroidTouchAction> tapElement = (element) ->
            action.tap(tapOptions().withElement(element(element)));

    // 点击坐标
    // @param point 坐标点 对象
    AppiumFunction<Point, AndroidTouchAction> tapCoordinate = (point) ->
            action.tap(PointOption.point(point));

    // 等待时间
    AppiumFunction<Long, AndroidTouchAction> waitForTime = (millis) ->
            action.waitAction(waitOptions(ofSeconds(millis)));

    // 下拉刷新
    ActionSupplier<AndroidTouchAction> dropDownRefresh = () ->
            action.press(PointOption.point(width / 2, height / 3))
                    .waitAction(waitOptions(ofSeconds(1)))
                    .moveTo(PointOption.point(width / 2, height / 2))
                    .release();

    // 上拉加载
    ActionSupplier<AndroidTouchAction> pullUpLoading = () ->
            action
                    .press(PointOption.point(width / 2, height / 10 * 9))
                    .waitAction(waitOptions(ofSeconds(3)))
                    .moveTo(PointOption.point(width / 2, height / 10))
                    .release();

    // 横向左滑动一级导航栏
    ActionSupplier<AndroidTouchAction> horizontalSwipeLeft = () ->
            action
                    .press(PointOption.point(1100, 400))
                    .waitAction(waitOptions(ofSeconds(1)))
                    .moveTo(PointOption.point(100, 400))
                    .release();
}
