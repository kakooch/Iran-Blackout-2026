package ir.eitaa.ui.Components;

import android.content.Context;
import android.content.res.Resources;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes3.dex */
public class CircularViewPager extends ViewPager {
    private Adapter adapter;

    public CircularViewPager(Context context) {
        super(context);
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: ir.eitaa.ui.Components.CircularViewPager.1
            private int scrollState;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) throws Resources.NotFoundException {
                if (position == CircularViewPager.this.getCurrentItem() && positionOffset == 0.0f && this.scrollState == 1) {
                    checkCurrentItem();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) throws Resources.NotFoundException {
                if (state == 0) {
                    checkCurrentItem();
                }
                this.scrollState = state;
            }

            private void checkCurrentItem() throws Resources.NotFoundException {
                if (CircularViewPager.this.adapter != null) {
                    int currentItem = CircularViewPager.this.getCurrentItem();
                    int extraCount = CircularViewPager.this.adapter.getExtraCount() + CircularViewPager.this.adapter.getRealPosition(currentItem);
                    if (currentItem != extraCount) {
                        CircularViewPager.this.setCurrentItem(extraCount, false);
                    }
                }
            }
        });
    }

    @Override // androidx.viewpager.widget.ViewPager
    @Deprecated
    public void setAdapter(PagerAdapter adapter) throws Resources.NotFoundException {
        if (adapter instanceof Adapter) {
            setAdapter((Adapter) adapter);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setAdapter(Adapter adapter) throws Resources.NotFoundException {
        this.adapter = adapter;
        super.setAdapter((PagerAdapter) adapter);
        if (adapter != null) {
            setCurrentItem(adapter.getExtraCount(), false);
        }
    }

    public static abstract class Adapter extends PagerAdapter {
        public abstract int getExtraCount();

        public int getRealPosition(int adapterPosition) {
            int count = getCount();
            int extraCount = getExtraCount();
            if (adapterPosition < extraCount) {
                return ((count - (extraCount * 2)) - ((extraCount - adapterPosition) - 1)) - 1;
            }
            int i = count - extraCount;
            return adapterPosition >= i ? adapterPosition - i : adapterPosition - extraCount;
        }
    }
}
