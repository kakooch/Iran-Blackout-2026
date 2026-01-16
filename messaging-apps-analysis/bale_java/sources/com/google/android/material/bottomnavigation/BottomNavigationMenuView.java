package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.e;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;

/* loaded from: classes3.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int A0;
    private boolean B0;
    private int[] C0;
    private final int H;
    private final int J;
    private final int z0;

    public BottomNavigationMenuView(Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.H = resources.getDimensionPixelSize(AbstractC12799fB5.design_bottom_navigation_item_max_width);
        this.J = resources.getDimensionPixelSize(AbstractC12799fB5.design_bottom_navigation_item_min_width);
        this.z0 = resources.getDimensionPixelSize(AbstractC12799fB5.design_bottom_navigation_active_item_max_width);
        this.A0 = resources.getDimensionPixelSize(AbstractC12799fB5.design_bottom_navigation_active_item_min_width);
        this.C0 = new int[5];
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    protected NavigationBarItemView g(Context context) {
        return new BottomNavigationItemView(context);
    }

    public boolean n() {
        return this.B0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                if (AbstractC12990fW7.A(this) == 1) {
                    int i8 = i5 - measuredWidth;
                    childAt.layout(i8 - childAt.getMeasuredWidth(), 0, i8, i6);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i6);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        e menu = getMenu();
        int size = View.MeasureSpec.getSize(i);
        int size2 = menu.G().size();
        int childCount = getChildCount();
        int size3 = View.MeasureSpec.getSize(i2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        if (h(getLabelVisibilityMode(), size2) && n()) {
            View childAt = getChildAt(getSelectedItemPosition());
            int iMax = this.A0;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.z0, RecyclerView.UNDEFINED_DURATION), iMakeMeasureSpec);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i3 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.J * i3), Math.min(iMax, this.z0));
            int i4 = size - iMin;
            int iMin2 = Math.min(i4 / (i3 == 0 ? 1 : i3), this.H);
            int i5 = i4 - (i3 * iMin2);
            int i6 = 0;
            while (i6 < childCount) {
                if (getChildAt(i6).getVisibility() != 8) {
                    this.C0[i6] = i6 == getSelectedItemPosition() ? iMin : iMin2;
                    if (i5 > 0) {
                        int[] iArr = this.C0;
                        iArr[i6] = iArr[i6] + 1;
                        i5--;
                    }
                } else {
                    this.C0[i6] = 0;
                }
                i6++;
            }
        } else {
            int iMin3 = Math.min(size / (size2 != 0 ? size2 : 1), this.z0);
            int i7 = size - (size2 * iMin3);
            for (int i8 = 0; i8 < childCount; i8++) {
                if (getChildAt(i8).getVisibility() != 8) {
                    int[] iArr2 = this.C0;
                    iArr2[i8] = iMin3;
                    if (i7 > 0) {
                        iArr2[i8] = iMin3 + 1;
                        i7--;
                    }
                } else {
                    this.C0[i8] = 0;
                }
            }
        }
        int measuredWidth = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt2 = getChildAt(i9);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.C0[i9], 1073741824), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(measuredWidth, View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), 0), View.resolveSizeAndState(size3, i2, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.B0 = z;
    }
}
