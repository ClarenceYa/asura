package com.wut.page.widget;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Package_Name: com.wut.page.widget
 * Description: 文章列表页频道栏目
 *
 * @author yangzheng
 * Date:  2020/09/04
 */
@AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView")
public class ChannelColumnWidget extends Widget {
    protected ChannelColumnWidget(WebElement element) {
        super(element);
    }

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout")
    private List<AndroidElement> channels;

    public List<AndroidElement> getChannels() {
        return channels;
    }
}
