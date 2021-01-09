package com.wut.page.widget;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

/**
 * Package_Name: com.wut.page.widget
 * Description: 首页顶部信息栏
 *
 * @author yangzheng
 * Date:  2020/08/07
 */
@AndroidFindBy(id = "cn.xuexi.android:id/header")
public class IndexHeadWidget extends Widget {
    protected IndexHeadWidget(WebElement element) {
        super(element);
    }

    // 搜索框
    @AndroidFindBy(id = "cn.xuexi.android:id/base_contnet_search")
    private AndroidElement search;

    // 扫一扫
    @AndroidFindBy(id = "cn.xuexi.android:id/img_search_right")
    private AndroidElement scan;

    // 积分
    @AndroidFindBy(id = "cn.xuexi.android:id/comm_head_xuexi_score")
    private AndroidElement score;

    // 我的
    @AndroidFindBy(id = "cn.xuexi.android:id/comm_head_xuexi_mine")
    private AndroidElement my;

    public AndroidElement getSearch() {
        return search;
    }

    public AndroidElement getScan() {
        return scan;
    }

    public AndroidElement getScore() {
        return score;
    }

    public AndroidElement getMy() {
        return my;
    }
}
