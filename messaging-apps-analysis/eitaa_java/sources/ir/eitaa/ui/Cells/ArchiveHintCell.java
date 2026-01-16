package ir.eitaa.ui.Cells;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.BottomPagesView;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class ArchiveHintCell extends FrameLayout {
    private BottomPagesView bottomPages;
    private ViewPager viewPager;

    public ArchiveHintCell(Context context) throws NoSuchFieldException, Resources.NotFoundException {
        super(context);
        ViewPager viewPager = new ViewPager(context) { // from class: ir.eitaa.ui.Cells.ArchiveHintCell.1
            @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return super.onInterceptTouchEvent(ev);
            }

            @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                requestLayout();
            }
        };
        this.viewPager = viewPager;
        AndroidUtilities.setViewPagerEdgeEffectColor(viewPager, Theme.getColor("actionBarDefaultArchived"));
        this.viewPager.setAdapter(new Adapter());
        this.viewPager.setPageMargin(0);
        this.viewPager.setOffscreenPageLimit(1);
        addView(this.viewPager, LayoutHelper.createFrame(-1, -1.0f));
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: ir.eitaa.ui.Cells.ArchiveHintCell.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ArchiveHintCell.this.bottomPages.setPageOffset(position, positionOffset);
            }
        });
        BottomPagesView bottomPagesView = new BottomPagesView(context, this.viewPager, 3);
        this.bottomPages = bottomPagesView;
        bottomPagesView.setColor("chats_unreadCounterMuted", "chats_actionBackground");
        addView(this.bottomPages, LayoutHelper.createFrame(33, 5.0f, 81, 0.0f, 0.0f, 0.0f, 19.0f));
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        this.bottomPages.invalidate();
    }

    public ViewPager getViewPager() {
        return this.viewPager;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(204.0f), 1073741824));
    }

    private class Adapter extends PagerAdapter {
        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 3;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Parcelable saveState() {
            return null;
        }

        private Adapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int position) {
            ArchiveHintInnerCell archiveHintInnerCell = new ArchiveHintInnerCell(container.getContext(), position);
            if (archiveHintInnerCell.getParent() != null) {
                ((ViewGroup) archiveHintInnerCell.getParent()).removeView(archiveHintInnerCell);
            }
            container.addView(archiveHintInnerCell, 0);
            return archiveHintInnerCell;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);
            ArchiveHintCell.this.bottomPages.setCurrentPage(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }
    }
}
