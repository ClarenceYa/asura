package com.wut.page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.stereotype.Component;

/**
 * Package_Name: com.wut.page
 * Description: 我的订阅页面
 *
 * @author yangzheng
 * Date:  2020/09/04
 */
@Component
public class MySubscribePage extends AbstractParentPage {
    public MySubscribePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    // 添加按钮
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='添加']")
    private AndroidElement addition;

    public AndroidElement getAddition() {
        return addition;
    }
}
