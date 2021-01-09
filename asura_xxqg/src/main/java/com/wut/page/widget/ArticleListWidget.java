package com.wut.page.widget;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Package_Name: com.wut.page.widget
 * Description: 文章列表
 *
 * @author yangzheng
 * Date:  2020/08/07
 */
@AndroidFindBy(xpath = "//android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout")
public class ArticleListWidget extends Widget {
    protected ArticleListWidget(WebElement element) {
        super(element);
    }

    // 文章列表
    @AndroidFindBy(id = "cn.xuexi.android:id/general_card_title_id")
    private List<AndroidElement> card_titles;

    public List<AndroidElement> getCard_titles() {
        return card_titles;
    }
}
