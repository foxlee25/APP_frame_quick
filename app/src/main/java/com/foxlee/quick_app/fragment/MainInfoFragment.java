package com.foxlee.quick_app.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cniao5.app36kr_cnk.R;
import com.foxlee.quick_app.adapter.FixedPagerAdapter;
import com.foxlee.quick_app.common.DefineView;
import com.foxlee.quick_app.entity.CategoriesBean;
import com.foxlee.quick_app.fragment.base.BaseFragment;
import com.foxlee.quick_app.ui.MainActivity;
import com.foxlee.quick_app.utils.CategoryDataUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释:   Tab layout frame
 *
 */
public class MainInfoFragment extends BaseFragment implements  DefineView,ViewPager.OnPageChangeListener{
    private View mView;
    private TabLayout tab_layout;
    private ViewPager info_viewpager;
    private FixedPagerAdapter fixedPagerAdapter;
    private List<Fragment> fragments;
    private static List<CategoriesBean> categoriesBeans= CategoryDataUtils.getCategoryBeans();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mView==null){
            mView=inflater.inflate(R.layout.main_info_fragment_layout,container,false);
            initView();
            initValidata();
            initListener();
            bindData();
        }
        return mView;
    }

    @Override
    public void initView() {
        tab_layout=(TabLayout)mView.findViewById(R.id.tab_layout);
        info_viewpager=(ViewPager)mView.findViewById(R.id.info_viewpager);
    }

    @Override
    public void initValidata() {
        fixedPagerAdapter=new FixedPagerAdapter(getChildFragmentManager());
        fixedPagerAdapter.setCategoriesBeans(categoriesBeans);
        fragments=new ArrayList<Fragment>();
        for(int i=0;i<categoriesBeans.size();i++){
            BaseFragment fragment=null;
            if(i==0){
                fragment= HomeFragment.newInstance(categoriesBeans.get(i));
            }else{
                fragment= PageFragment.newInstance(categoriesBeans.get(i));
            }
            fragments.add(fragment);
        }
        fixedPagerAdapter.setFragments(fragments);

        info_viewpager.setAdapter(fixedPagerAdapter);
        tab_layout.setupWithViewPager(info_viewpager);
        tab_layout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void initListener() {
        info_viewpager.setOnPageChangeListener(this);
    }

    @Override
    public void bindData() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position==0){
            ((MainActivity)getActivity()).getDrag_layout().setIsDrag(true);
        }else {
            ((MainActivity)getActivity()).getDrag_layout().setIsDrag(false);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
