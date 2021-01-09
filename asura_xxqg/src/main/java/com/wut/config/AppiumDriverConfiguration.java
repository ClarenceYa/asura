package com.wut.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.*;

/**
 * PACKAGE_NAME：com.wut.config
 * Description：spring配置类
 *
 * @author yangzheng
 * Date：2020/8/2
 */
@ComponentScan("com.wut")
@Configuration
public class AppiumDriverConfiguration {
    private DesiredCapabilities capabilities;
    private AppiumDriverLocalService appiumService;

    public AppiumDriverLocalService getAppiumService() {
        return appiumService;
    }

    @Profile({"android-xianfeng", "default"})
    @Bean("androidDriver_XianFeng")
    public AndroidDriver<AndroidElement> creatXianFengDriver() {
        if (appiumService == null) {
            startService();
        }

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "TWGDU17420002031");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "127.0.0.1:62001");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.dcloud.H5B1841EE");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "cn.com.chinaunicom.intelligencepartybuilding.ui.activity.SplashActivity");

        return new AndroidDriver<>(appiumService, capabilities);
    }

    @Profile({"android-xuexi"})
    @Bean("androidDriver_XueXi")
    public AndroidDriver<AndroidElement> creatXueXiDriver() {
        startService();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "TWGDU17420002031");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "127.0.0.1:62001");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "H8B6R19828006915");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "9YS0220226000773");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "LKN5T19307004547");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "cn.xuexi.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.alibaba.android.rimet.biz.SplashActivity");

        return new AndroidDriver<>(appiumService, capabilities);
    }

    private void startService() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AppiumServiceBuilder builder = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).withCapabilities(capabilities);
        appiumService = AppiumDriverLocalService.buildService(builder);
        appiumService.start();
    }
}
