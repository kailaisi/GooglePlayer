package cn.com.tcsl.googleplayer.ui.main;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TableLayout;

import cn.com.tcsl.googleplayer.Base.BaseActivity;
import cn.com.tcsl.googleplayer.R;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View, NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mIdDrawerLayout;
    private AppBarLayout mAblMain;
    private TableLayout mTlMain;
    private ViewPager mVpMain;
    private NavigationView mNvMainNavigation;
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initValue();
    }



    private void initView() {
        mIdDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawer_layout);
        mAblMain = (AppBarLayout) findViewById(R.id.abl_main);
        mTlMain = (TableLayout) findViewById(R.id.tl_main);
        mVpMain = (ViewPager) findViewById(R.id.vp_main);
        mNvMainNavigation = (NavigationView) findViewById(R.id.nv_main_navigation);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }
    private void initValue() {
        initNavigation();
    }
    private void initNavigation() {
        Resources resources=getBaseContext().getResources();
        ColorStateList colorStateList = resources.getColorStateList(R.color.navigation_menu_item_color);
        mNvMainNavigation.setItemTextColor(colorStateList);
        mNvMainNavigation.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void showNavigation() {

    }

    @Override
    public void hideNavigation() {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}
