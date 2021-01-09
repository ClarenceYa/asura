package com.wut.service;

/**
 * Package_Name: com.wut.service
 * Description: 收藏、转发、订阅
 *
 * @author yangzheng
 * Date:  2020/08/09
 */
public interface OperateService {
    /**
     * 收藏文章
     */
    @Deprecated
    void collectionArticle();

    /**
     * 分享文章
     */
    void shareArticle();

    /**
     * 订阅平台
     */
    void subscribePlatform();
}
