package com.cniao5.app36kr_cnk.utils;


import com.cniao5.app36kr_cnk.R;
import com.cniao5.app36kr_cnk.entity.LeftItemMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释:左侧菜单Item数据构造
 * ProjectName：App36Kr
 * Author:<a href="http://www.cniao5.com">菜鸟窝</a>
 * Description：
 * 菜鸟窝是一个只专注做Android开发技能的在线学习平台，课程以实战项目为主，对课程与服务”吹毛求疵”般的要求，
 * 打造极致课程，是菜鸟窝不变的承诺
 */
public class MenuDataUtils {
    public static List<LeftItemMenu> getItemMenus(){
        List<LeftItemMenu> menus=new ArrayList<LeftItemMenu>();
        menus.add(new LeftItemMenu(R.drawable.icon_zhanghaoxinxi,"Me"));
        menus.add(new LeftItemMenu(R.drawable.icon_wodeguanzhu,"Mark"));
        menus.add(new LeftItemMenu(R.drawable.icon_shoucang,"Flavor"));
        menus.add(new LeftItemMenu(R.drawable.icon_yijianfankui,"Feedback"));
        menus.add(new LeftItemMenu(R.drawable.icon_shezhi,"Setting"));
        return  menus;
    }

}
