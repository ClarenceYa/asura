package com.wut.page.widget;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

/**
 * Package_Name: com.wut.page.widget
 * Description: 页面底部主选项卡
 *
 * @author yangzheng
 * Date:  2020/08/07
 */
@AndroidFindBy(id = "cn.xuexi.android:id/home_bottom_tab_root")
public class BottomTabWidget extends Widget {
    protected BottomTabWidget(WebElement element) {
        super(element);
    }

    // 强国通
    @AndroidFindBy(id = "cn.xuexi.android:id/home_bottom_tab_button_message")
    private AndroidElement home_bottom_tab_button_message;
    // 百灵
    @AndroidFindBy(id = "cn.xuexi.android:id/home_bottom_tab_button_ding")
    private AndroidElement home_bottom_tab_button_ding;
    // 学习
    @AndroidFindBy(id = "cn.xuexi.android:id/home_bottom_tab_button_work")
    private AndroidElement home_bottom_tab_button_work;
    // 电视台
    @AndroidFindBy(id = "cn.xuexi.android:id/home_bottom_tab_button_contact")
    private AndroidElement home_bottom_tab_button_contact;
    // 电台
    @AndroidFindBy(id = "cn.xuexi.android:id/home_bottom_tab_button_mine")
    private AndroidElement home_bottom_tab_button_mine;

    public AndroidElement getHome_bottom_tab_button_message() {
        return home_bottom_tab_button_message;
    }

    public AndroidElement getHome_bottom_tab_button_ding() {
        return home_bottom_tab_button_ding;
    }

    public AndroidElement getHome_bottom_tab_button_work() {
        return home_bottom_tab_button_work;
    }

    public AndroidElement getHome_bottom_tab_button_contact() {
        return home_bottom_tab_button_contact;
    }

    public AndroidElement getHome_bottom_tab_button_mine() {
        return home_bottom_tab_button_mine;
    }
}
