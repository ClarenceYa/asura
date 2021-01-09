package com.wut.page.widget;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

/**
 * Package_Name: com.wut.page.widget
 * Description: 内容详情页底部工具栏
 *
 * @author yangzheng
 * Date:  2020/08/08
 */
@AndroidFindBy(id = "cn.xuexi.android:id/BOTTOM_LAYER_VIEW_ID")
public class ContentBottomWidget extends Widget {
    protected ContentBottomWidget(WebElement element) {
        super(element);
    }

    // 底部评论区
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='cn.xuexi.android:id/BOTTOM_LAYER_VIEW_ID']/android.widget.TextView")
    private AndroidElement commentArea;
    // 点赞
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='cn.xuexi.android:id/BOTTOM_LAYER_VIEW_ID']/android.widget.ImageView[1]")
    private AndroidElement like;
    // 分享
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='cn.xuexi.android:id/BOTTOM_LAYER_VIEW_ID']/android.widget.ImageView[2]")
    private AndroidElement share;

    public AndroidElement getCommentArea() {
        return commentArea;
    }

    public AndroidElement getLike() {
        return like;
    }

    public AndroidElement getShare() {
        return share;
    }

}
