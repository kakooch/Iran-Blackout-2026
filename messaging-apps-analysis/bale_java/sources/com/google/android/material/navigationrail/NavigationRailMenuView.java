package com.google.android.material.navigationrail;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* loaded from: classes3.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {
    private int H;
    private final FrameLayout.LayoutParams J;

    public NavigationRailMenuView(Context context) {
        super(context);
        this.H = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.J = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    private int o(int i, int i2, int i3) {
        int iMax = i2 / Math.max(1, i3);
        int size = this.H;
        if (size == -1) {
            size = View.MeasureSpec.getSize(i);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, iMax), 0);
    }

    private int p(View view, int i, int i2) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i, i2);
        return view.getMeasuredHeight();
    }

    private int q(int i, int i2, int i3, View view) {
        o(i, i2, i3);
        int iO = view == null ? o(i, i2, i3) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int iP = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt != view) {
                iP += p(childAt, i, iO);
            }
        }
        return iP;
    }

    private int r(int i, int i2, int i3) {
        int iP;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            iP = p(childAt, i, o(i, i2, i3));
            i2 -= iP;
            i3--;
        } else {
            iP = 0;
        }
        return iP + q(i, i2, i3, childAt);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    protected NavigationBarItemView g(Context context) {
        return new a(context);
    }

    public int getItemMinimumHeight() {
        return this.H;
    }

    int getMenuGravity() {
        return this.J.gravity;
    }

    boolean n() {
        return (this.J.gravity & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 48;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i6;
                childAt.layout(0, i6, i5, measuredHeight);
                i6 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = getMenu().G().size();
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i), i, 0), View.resolveSizeAndState((size2 <= 1 || !h(getLabelVisibilityMode(), size2)) ? q(i, size, size2, null) : r(i, size, size2), i2, 0));
    }

    public void setItemMinimumHeight(int i) {
        if (this.H != i) {
            this.H = i;
            requestLayout();
        }
    }

    void setMenuGravity(int i) {
        FrameLayout.LayoutParams layoutParams = this.J;
        if (layoutParams.gravity != i) {
            layoutParams.gravity = i;
            setLayoutParams(layoutParams);
        }
    }
}
