package com.foxlee.quick_app.ui;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.cniao5.app36kr_cnk.R;
import com.foxlee.quick_app.adapter.LeftItemAdapter;
import com.foxlee.quick_app.common.DefineView;
import com.foxlee.quick_app.ui.base.BaseActivity;
import com.foxlee.quick_app.widget.DragLayout;
import com.nineoldandroids.view.ViewHelper;

/**
 * 当前类注释:主Activity类
 * ProjectName：App36Kr
 * Author:<a href="http://www.cniao5.com">菜鸟窝</a>
 * Description：
 * 菜鸟窝是一个只专注做Android开发技能的在线学习平台，课程以实战项目为主，对课程与服务”吹毛求疵”般的要求，
 * 打造极致课程，是菜鸟窝不变的承诺
 */
public class MainActivity extends BaseActivity implements DefineView {
    public DragLayout getDrag_layout() {
        return drag_layout;
    }

    private DragLayout drag_layout;
    private ImageView top_bar_icon;
    private ListView lv_left_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBar();
        initView();
        initValidata();
        initListener();
        bindData();
    }
    public void initView() {
        drag_layout = (DragLayout) findViewById(R.id.drag_layout);
        top_bar_icon = (ImageView) findViewById(R.id.top_bar_icon);
        lv_left_main=(ListView)findViewById(R.id.lv_left_main);
    }
    @Override
    public void initValidata() {
        lv_left_main.setAdapter(new LeftItemAdapter());
    }
    @Override
    public void initListener() {
        drag_layout.setDragListener(new CustomDragListener());
        top_bar_icon.setOnClickListener(new CustomOnClickListener());

    }
    @Override
    public void bindData() {

    }
    class CustomDragListener implements DragLayout.DragListener{

        /**
         * 界面打开
         */
        @Override
        public void onOpen() {

        }

        /**
         * 界面关闭
         */
        @Override
        public void onClose() {

        }

        /**
         * 界面进行滑动
         * @param percent
         */
        @Override
        public void onDrag(float percent) {
              ViewHelper.setAlpha(top_bar_icon,1-percent);
        }
    }
    class CustomOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View arg0) {
            drag_layout.open();
        }
    }

}
