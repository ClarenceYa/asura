package com.wut.page;

import com.wut.page.widget.ArticleListWidget;
import com.wut.page.widget.BottomTabWidget;
import com.wut.page.widget.IndexHeadWidget;
import com.wut.page.widget.NavigationBarWidget;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import static java.time.Duration.ofSeconds;

/**
 * Package_Name: com.wut.page
 * Description: 学习强国首页-学习页面
 *
 * @author yangzheng
 * Date:  2020/08/04
 */
@Component
public class LearningIndexPage extends AbstractParentPage {

    private IndexHeadWidget indexHeadWidget;
    private NavigationBarWidget navigationBar;
    private ArticleListWidget articleListWidget;
    private BottomTabWidget bottomTabWidget;


    public LearningIndexPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(5)), this);
    }

    public NavigationBarWidget getNavigationBar() {
        return navigationBar;
    }

    public IndexHeadWidget getIndexHeadWidget() {
        return indexHeadWidget;
    }

    public ArticleListWidget getArticleListWidget() {
        return articleListWidget;
    }

    public BottomTabWidget getBottomTabWidget() {
        return bottomTabWidget;
    }
}
