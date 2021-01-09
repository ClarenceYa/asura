package com.wut.page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Package_Name: com.wut.page
 * Description: 学习强国页面基类
 *
 * @author yangzheng
 * Date:  2020/08/04
 */
@Component
public abstract class AbstractParentPage {

    AndroidDriver<AndroidElement> driver;
    protected final Log logger = LogFactory.getLog(this.getClass());

    public AbstractParentPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }
}
