package cn.com.tcsl.googleplayer.ui.main;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.tcsl.googleplayer.Base.BaseActivity;
import cn.com.tcsl.googleplayer.R;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View, NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tl_main)
    TabLayout tlMain;
    @BindView(R.id.abl_main)
    AppBarLayout ablMain;
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.nv_main_navigation)
    NavigationView nvMainNavigation;
    @BindView(R.id.dl_drawer_layout)
    DrawerLayout dlDrawerLayout;
    private ActionBarDrawerToggle mDrawToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new MainPresenter(this);
        mPresenter.start();
    }

    /**
     * 初始化toolbar
     */
    @Override
    public void initToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_list_white_18dp);
        toolbar.setLogo(R.mipmap.ic_launcher);
        mDrawToggle = new ActionBarDrawerToggle(this, dlDrawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        dlDrawerLayout.addDrawerListener(mDrawToggle);//drawerlayout和控件进行绑定
        mDrawToggle.syncState();////  让开关和actionbar建立关系
        tlMain.setupWithViewPager(vpMain);
    }

    @Override
    public void initNavigation() {
        Resources resources = getBaseContext().getResources();
        ColorStateList colorStateList = resources.getColorStateList(R.color.navigation_menu_item_color);
        nvMainNavigation.setItemTextColor(colorStateList);
        nvMainNavigation.setItemIconTintList(null);
        nvMainNavigation.setNavigationItemSelectedListener(this);
        nvMainNavigation.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_view, menu);
        if (Build.VERSION.SDK_INT > 11) {
            SearchView searchView = (SearchView) menu.findItem(R.id.search_icon).getActionView();
            searchView.setOnQueryTextListener(this);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showNavigation() {
    }

    @Override
    public void hideNavigation() {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        item.setChecked(true);
        Log.d("MainActivity", "item.getItemId():" + item.getItemId());
        dlDrawerLayout.closeDrawers();
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
