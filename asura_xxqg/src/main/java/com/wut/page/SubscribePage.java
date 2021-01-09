package com.wut.page;

import com.wut.page.widget.LearningPlatformWidget;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Package_Name: com.wut.page
 * Description: 订阅页面
 *
 * @author yangzheng
 * Date:  2020/08/08
 */
@Component
public class SubscribePage extends AbstractParentPage {
    public SubscribePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    // 强国号
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='强国号']")
    private AndroidElement leftPlatform;
    // 学习平台
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='学习平台']")
    private AndroidElement rightPlatform;

    private LearningPlatformWidget Platforms;

    public AndroidElement getLeftPlatform() {
        return leftPlatform;
    }

    public AndroidElement getRightPlatform() {
        return rightPlatform;
    }

    public LearningPlatformWidget getLearningPlatformWidget() {
        return Platforms;
    }
}
