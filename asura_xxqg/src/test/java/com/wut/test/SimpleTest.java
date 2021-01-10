package com.wut.test;

import bsh.This;
import com.wut.service.BrowseService;
import org.testng.annotations.Test;

/**
 * Package_Name: com.wut.test
 * Description: 简单测试
 *
 * @author yangzheng
 * Date:  2020/09/02
 */
public class SimpleTest extends BaseTest {

    /**
     * 浏览视频
     */
    @Test
    public void browseVideo() {
        pageTurnsService.switchModule("电视台");
        pageTurnsService.choiceNavigationBar("联播频道");
//        pageTurnsService.choiceNavigationBar("学习视频");
//        pageTurnsService.choiceNavigationBar("第一频道");
//        browseService.longTimeBrowseResource(362);
        browseService.browseResources(61, "1");
    }

    /**
     * 浏览文章
     */
    @Test
    public void browseArticle() {
        pageTurnsService.choiceNavigationBar("山西");
//        pageTurnsService.choiceNavigationBar("北京");
        browseService.browseResources(62, "0");
    }

    /*
      本地学习频道
     */
//    @Test()
//    public void localPlatform() {
//        pageTurnsService.choiceNavigationBar("山西");
//        browseService.enterLocalLearningPlatform();
//    }

    /*
      分享2次
     */
//    @Test
//    public void shareArticle() {
//        operateService.shareArticle();
//    }

    /*
      订阅2个平台
     */
//    @Test()

//    public void subscribe() {
//        pageTurnsService.enterSubscribePage();
//        operateService.subscribePlatform();
//    }
}
