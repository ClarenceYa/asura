package com.wut.page.widget;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Package_Name: com.wut.page.widget
 * Description: 一级导航栏
 *
 * @author yangzheng
 * Date:  2020/08/07
 */
@AndroidFindBy(xpath = "//android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout")
public class NavigationBarWidget extends Widget {
    protected NavigationBarWidget(WebElement element) {
        super(element);
    }

    // 一级可滑动导航栏
    @AndroidFindBy(xpath = "//android.widget.TextView")
    private List<AndroidElement> ChannelMenus;

    // 山西文章入口
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='山西']")
//    private AndroidElement news_shanxi;

    // 更多
    @AndroidFindBy(xpath = "//android.widget.ImageView")
    private AndroidElement more;

    public List<AndroidElement> getChannelMenus() {
        return ChannelMenus;
    }

    public AndroidElement getMore() {
        return more;
    }
}
