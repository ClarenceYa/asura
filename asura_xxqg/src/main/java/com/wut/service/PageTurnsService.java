package com.wut.service;

/**
 * Package_Name: com.wut.service
 * Description: 模块选择，页面跳转
 *
 * @author yangzheng
 * Date:  2020/09/02
 */
public interface PageTurnsService {
    /**
     * 切换首页底部主选项卡
     *
     * @param moduleName 选项卡名
     */
    void switchModule(String moduleName);

    /**
     * 选择一级导航栏
     *
     * @param barName 导航栏名
     */
    void choiceNavigationBar(String barName);

    /**
     * 进入订阅页面
     */
    void enterSubscribePage();
}
