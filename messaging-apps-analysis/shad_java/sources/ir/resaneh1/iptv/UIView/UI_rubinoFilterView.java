package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.helper.DimensionHelper;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class UI_rubinoFilterView {
    public FrameLayout frameLayout;
    public int itemWidth;
    public boolean showText;
    public View view;
    public ViewPager viewPager;

    public interface ScrollListener {
        void onPageSelected(int i, boolean z);

        void onScrollX(int i, float f);
    }

    public View createView(Activity activity, final int i, final ScrollListener scrollListener) {
        FrameLayout frameLayout = new FrameLayout(activity);
        this.frameLayout = frameLayout;
        this.view = frameLayout;
        this.showText = true;
        this.itemWidth = DimensionHelper.getScreenWidth(activity);
        new LinearLayout.LayoutParams(this.itemWidth, 20);
        this.viewPager = new ViewPager(activity);
        this.viewPager.setAdapter(new FilterPagerAdapter(activity));
        this.viewPager.setOffscreenPageLimit(11);
        this.frameLayout.addView(this.viewPager, LayoutHelper.createFrame(-1, 20.0f));
        this.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: ir.resaneh1.iptv.UIView.UI_rubinoFilterView.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                ScrollListener scrollListener2 = scrollListener;
                if (scrollListener2 != null) {
                    scrollListener2.onScrollX(i2, f * 100.0f);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                ScrollListener scrollListener2 = scrollListener;
                if (scrollListener2 != null) {
                    scrollListener2.onPageSelected(i2 % i, UI_rubinoFilterView.this.showText);
                }
            }
        });
        int i2 = 1073741823;
        if (i > 0) {
            while (i2 % i != 0) {
                i2--;
            }
        }
        this.viewPager.setCurrentItem(i2);
        return this.view;
    }

    static class FilterPagerAdapter extends PagerAdapter {
        private Context mContext;

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ConnectionsManager.DEFAULT_DATACENTER_ID;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return BuildConfig.FLAVOR;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public FilterPagerAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            viewGroup.addView(frameLayout);
            return frameLayout;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }
}
