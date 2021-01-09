package com.wut.service.impl;

import com.wut.service.BrowseService;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

/**
 * Package_Name: com.wut.service.impl
 * Description: 浏览文章视频实现类
 *
 * @author yangzheng
 * Date:  2020/08/09
 */
@Service
public class BrowseServiceImpl extends GestureOperation implements BrowseService {

    public BrowseServiceImpl(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @Override
    public void browseResources(long millis, String type) {
        int count = 0;
        while (count < 12) {
            List<AndroidElement> articles = learningIndexPage.getArticleListWidget().getCard_titles();
            logger.info("当前页面有" + articles.size() + "个资源！");
            if(articles.size() == 0) {
                driver.performTouchAction(pullUpLoading.get());
            }
            for (AndroidElement article : articles) {
                logger.info("资源标题 = " + article.getText());
                driver.performTouchAction(tapElement.apply(article));
                if (type.equals("0")) {
                    waitingStrategy(10);
                    driver.performTouchAction(waitForTime.apply(millis - 10));
                } else if (type.equals("1")) {
                    driver.performTouchAction(waitForTime.apply(millis));
                } else {
                    logger.error("type error,0-文章;1-视频 ");
                }
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
                driver.performTouchAction(waitForTime.apply((long) 3));
                count++;
            }
            driver.performTouchAction(pullUpLoading.get());

        }
    }

    @Override
    public void longTimeBrowseResource(long millis) {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        Point point = new Point(width / 2, height * 2 / 5);
        driver.performTouchAction(waitForTime.apply((long) 3));
        driver.performTouchAction(tapCoordinate.apply(point));
        driver.performTouchAction(waitForTime.apply(millis));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.performTouchAction(waitForTime.apply((long) 2));
    }

    @Override
    public void enterLocalLearningPlatform() {
        List<AndroidElement> channels = contentDetailsPage.getChannelColumnWidget().getChannels();
        driver.performTouchAction(tapElement.apply(channels.get(0)));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.performTouchAction(waitForTime.apply((long) 2));
    }

    /**
     * 滑动等待策略，避免被检测
     *
     * @param swipeMillis 滑动时间
     * @return 滑动时间
     */
    private Long waitingStrategy(long swipeMillis) {
        Instant startTime = Instant.now();
        Instant currentTime = startTime;

        while (Duration.between(startTime, currentTime).getSeconds() < swipeMillis) {
            driver.performTouchAction(pullUpLoading.get());
            currentTime = Instant.now();
        }
        return swipeMillis;
    }
}
