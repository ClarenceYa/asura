package com.wut.service;

/**
 * Package_Name: com.wut.service
 * Description: 浏览文章，视频业务
 *
 * @author yangzheng
 * Date:  2020/08/09
 */
public interface BrowseService {
    /**
     * 浏览资源
     * @param millis 浏览时长
     * @param type 资源类型，0-文章;1-视频
     */
    void browseResources(long millis, String type);

    /**
     * 长时间浏览资源
     *
     * @param millis 浏览时长
     */
    void longTimeBrowseResource(long millis);

    /**
     * 进入本地学习平台
     */
    void enterLocalLearningPlatform();
}
