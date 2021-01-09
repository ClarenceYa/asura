package com.wut.page.widget;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

/**
 * Package_Name: com.wut.page.widget
 * Description: 内容详情页头部工具栏
 *
 * @author yangzheng
 * Date:  2020/08/08
 */
@AndroidFindBy(id = "cn.xuexi.android:id/TOP_LAYER_VIEW_ID")
public class ContentHeadWidget extends Widget {

    protected ContentHeadWidget(WebElement element) {
        super(element);
    }

    // 顶部左侧-返回按钮
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='cn.xuexi.android:id/TOP_LAYER_VIEW_ID']/android.widget.ImageView[1]")
    private AndroidElement back;
    // 顶部右侧-更多按钮
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='cn.xuexi.android:id/TOP_LAYER_VIEW_ID']/android.widget.ImageView[2]")
    private AndroidElement more;

    public AndroidElement getBack() {
        return back;
    }

    public AndroidElement getMore() {
        return more;
    }
}
