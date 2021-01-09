package com.wut.page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.stereotype.Component;

/**
 * Package_Name: com.wut.page
 * Description: 我的页面
 *
 * @author yangzheng
 * Date:  2020/08/08
 */
@Component
public class MyTotalPage extends AbstractParentPage {
    public MyTotalPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    // 订阅
    @AndroidFindBy(id = "cn.xuexi.android:id/my_subscribe_tv")
    private AndroidElement subscribe;

    public AndroidElement getSubscribe() {
        return subscribe;
    }
}
