package com.wut.page;

import com.wut.page.widget.ArticleListWidget;
import com.wut.page.widget.ChannelColumnWidget;
import com.wut.page.widget.ContentBottomWidget;
import com.wut.page.widget.ContentHeadWidget;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import static java.time.Duration.ofSeconds;

/**
 * Package_Name: com.wut.page
 * Description: 内容详情页
 *
 * @author yangzheng
 * Date:  2020/08/08
 */
@Component
public class ContentDetailsPage extends AbstractParentPage {

    private ContentHeadWidget contentHeadWidget;
    private ChannelColumnWidget channelColumnWidget;
    private ArticleListWidget articleListWidget;
    private ContentBottomWidget contentBottomWidget;

    public ContentDetailsPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(5)), this);
    }

    public ContentHeadWidget getContentHeadWidget() {
        return contentHeadWidget;
    }

    public ArticleListWidget getArticleListWidget() {
        return articleListWidget;
    }

    public ContentBottomWidget getContentBottomWidget() {
        return contentBottomWidget;
    }

    public ChannelColumnWidget getChannelColumnWidget() {
        return channelColumnWidget;
    }
}
