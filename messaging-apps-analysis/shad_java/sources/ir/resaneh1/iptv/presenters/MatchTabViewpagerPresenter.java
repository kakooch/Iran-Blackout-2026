package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.Match_UI_TabView;
import ir.resaneh1.iptv.model.TabListObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import java.util.ArrayList;
import org.rbmain.ui.ActionBar.BaseFragment;

/* loaded from: classes3.dex */
public class MatchTabViewpagerPresenter extends AbstractPresenter<TabListObject, MyViewHolder> {
    Context mContext;
    ArrayList<String> tabNames;

    public MatchTabViewpagerPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.match_tab_viewpager, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, TabListObject tabListObject) throws Resources.NotFoundException {
        super.onBindViewHolder((MatchTabViewpagerPresenter) myViewHolder, (MyViewHolder) tabListObject);
        this.tabNames = tabListObject.tabNames;
        setupViewPager(myViewHolder);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<TabListObject> {
        public TabLayout tabLayout;
        public ViewPager viewPager;

        public MyViewHolder(MatchTabViewpagerPresenter matchTabViewpagerPresenter, View view) {
            super(view);
            this.tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
            this.viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        }
    }

    public View getTabView(String str, boolean z) throws Resources.NotFoundException {
        int color;
        Match_UI_TabView match_UI_TabView = new Match_UI_TabView();
        if (z) {
            color = this.context.getResources().getColor(R.color.black);
        } else {
            color = this.context.getResources().getColor(R.color.grey_500);
        }
        return match_UI_TabView.createView((Activity) this.context, str, color);
    }

    public View setTabView(View view, String str, boolean z) throws Resources.NotFoundException {
        int color;
        Match_UI_TabView match_UI_TabView = new Match_UI_TabView();
        if (z) {
            color = this.context.getResources().getColor(R.color.black);
        } else {
            color = this.context.getResources().getColor(R.color.grey_500);
        }
        return match_UI_TabView.refreshView(view, str, color);
    }

    public View setTabView(View view, int i, boolean z) {
        return setTabView(view, this.tabNames.get(i), z);
    }

    private void setupViewPager(MyViewHolder myViewHolder) throws Resources.NotFoundException {
        TabListObject tabListObject = (TabListObject) myViewHolder.item;
        myViewHolder.tabLayout.setupWithViewPager(myViewHolder.viewPager);
        myViewHolder.viewPager.setAdapter(new ViewPagerAdapter(this, this.context, tabListObject.fragments));
        for (int i = 0; i < tabListObject.tabNames.size(); i++) {
            if (tabListObject.tabNames.get(i).equals(tabListObject.selectedName)) {
                myViewHolder.tabLayout.getTabAt(i).setCustomView(getTabView(((TabListObject) myViewHolder.item).tabNames.get(i), true));
                myViewHolder.viewPager.setCurrentItem(i);
            } else {
                myViewHolder.tabLayout.getTabAt(i).setCustomView(getTabView(((TabListObject) myViewHolder.item).tabNames.get(i), false));
            }
        }
        myViewHolder.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: ir.resaneh1.iptv.presenters.MatchTabViewpagerPresenter.1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                MatchTabViewpagerPresenter.this.setTabView(tab.getCustomView(), tab.getPosition(), true);
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                MatchTabViewpagerPresenter.this.setTabView(tab.getCustomView(), tab.getPosition(), false);
            }
        });
    }

    class ViewPagerAdapter extends PagerAdapter {
        private ArrayList<BaseFragment> baseFragments;

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return BuildConfig.FLAVOR;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public ViewPagerAdapter(MatchTabViewpagerPresenter matchTabViewpagerPresenter, Context context, ArrayList<BaseFragment> arrayList) {
            this.baseFragments = new ArrayList<>();
            this.baseFragments = arrayList;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View fragmentView = this.baseFragments.get(i).getFragmentView();
            viewGroup.addView(fragmentView);
            return fragmentView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.baseFragments.size();
        }
    }
}
