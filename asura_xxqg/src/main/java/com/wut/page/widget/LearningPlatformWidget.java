package com.wut.page.widget;

import com.google.common.eventbus.Subscribe;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Package_Name: com.wut.page.widget
 * Description: 订阅页面每个学习平台控件
 *
 * @author yangzheng
 * Date:  2020/09/04
 */
@AndroidFindBy(xpath = "//android.support.v4.view.ViewPager[@id='cn.xuexi.android:id/st_viewpager']//android.widget.ListView/android.widget.FrameLayout")
public class LearningPlatformWidget extends Widget {
    protected LearningPlatformWidget(WebElement element) {
        super(element);
    }

    // 订阅按钮
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.ImageView")
    private List<AndroidElement> subscribeButtons;

    public List<AndroidElement> getSubscribeButtons() {
        return subscribeButtons;
    }

    public Integer getSubscribeButtonCount() {
        return subscribeButtons.size();
    }

    public AndroidElement getSubscribeButton(int index) {
        return subscribeButtons.get(index);
    }
}
