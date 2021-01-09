package com.wut.service.impl;

import com.wut.page.widget.LearningPlatformWidget;
import com.wut.service.OperateService;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Point;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Package_Name: com.wut.service.impl
 * Description: 收藏分享订阅实现类
 *
 * @author yangzheng
 * Date:  2020/08/09
 */
@Service
public class OperateServiceImpl extends GestureOperation implements OperateService {
    public OperateServiceImpl(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Deprecated
    @Override
    public void collectionArticle() {
        // do nothing,Deprecated
    }

    @Override
    public void shareArticle() {
        int count = 0;
        while (count < 2) {
            List<AndroidElement> articles = learningIndexPage.getArticleListWidget().getCard_titles();
            logger.info("当前页面有" + articles.size() + "个资源！");
            if(articles.size() == 0) {
                driver.performTouchAction(pullUpLoading.get());
            }
            for (AndroidElement article : articles) {
                logger.info("资源标题 = " + article.getText());
                driver.performTouchAction(tapElement.apply(article));
                driver.performTouchAction(waitForTime.apply((long) 1));
                AndroidElement share = contentDetailsPage.getContentBottomWidget().getShare();
                driver.performTouchAction(tapElement.apply(share));
                driver.performTouchAction(waitForTime.apply((long) 1));
                driver.performTouchAction(tapCoordinate.apply(new Point(180, 1285)));
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
                driver.performTouchAction(waitForTime.apply((long) 2));
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
                driver.performTouchAction(waitForTime.apply((long) 2));
                count++;
            }
            driver.performTouchAction(pullUpLoading.get());
        }
    }

    @Override
    public void subscribePlatform() {
        Integer num = subscribePage.getLearningPlatformWidget().getSubscribeButtonCount();
        AndroidElement lastScribeButton = subscribePage.getLearningPlatformWidget().getSubscribeButton(num);
        List<AndroidElement> subscribeButtons = subscribePage.getLearningPlatformWidget().getSubscribeButtons();
        logger.info("list中的元素有" + num + "个");
        while (true) {
            logger.info("属性值为：" + lastScribeButton.getAttribute("content-desc"));
            if (!"订阅".equals(lastScribeButton.getAttribute("content-desc"))) {
                driver.performTouchAction(pullUpLoading.get());
                continue;
            } else {
                int a = 0;
                int count = 0;
                for (AndroidElement subscribeButton : subscribeButtons) {
                    if ("订阅".equals(subscribeButton.getAttribute("content-desc"))) {
                        a++;
                    }
                }
                if (a == 1) {
                    driver.performTouchAction(pullUpLoading.get());
                }

                for (AndroidElement subscribeButton : subscribeButtons) {
                    if ("订阅".equals(subscribeButton.getAttribute("content-desc"))) {
                        driver.performTouchAction(tapElement.apply(subscribeButton));
                        count++;
                    }
                    if (count == 2) {
                        break;
                    }
                }
                break;
            }
        }


    }
}
