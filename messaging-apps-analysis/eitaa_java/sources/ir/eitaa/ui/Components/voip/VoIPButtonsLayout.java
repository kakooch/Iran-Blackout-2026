package ir.eitaa.ui.Components.voip;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class VoIPButtonsLayout extends FrameLayout {
    int childPadding;
    private int childSize;
    int childWidth;
    private boolean startPadding;
    int visibleChildCount;

    public VoIPButtonsLayout(Context context) {
        super(context);
        this.childSize = 68;
        this.startPadding = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (isEnabled()) {
            return super.dispatchTouchEvent(ev);
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        this.visibleChildCount = 0;
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i).getVisibility() != 8) {
                this.visibleChildCount++;
            }
        }
        this.childWidth = AndroidUtilities.dp(this.childSize);
        this.childPadding = ((size / getChildCount()) - this.childWidth) / 2;
        int measuredHeight = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2).getVisibility() != 8) {
                getChildAt(i2).measure(View.MeasureSpec.makeMeasureSpec(this.childWidth, 1073741824), heightMeasureSpec);
                if (getChildAt(i2).getMeasuredHeight() > measuredHeight) {
                    measuredHeight = getChildAt(i2).getMeasuredHeight();
                }
            }
        }
        setMeasuredDimension(size, Math.max(measuredHeight, AndroidUtilities.dp(80.0f)));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.startPadding) {
            int childCount = (int) (((getChildCount() - this.visibleChildCount) / 2.0f) * (this.childWidth + (this.childPadding * 2)));
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    int i2 = this.childPadding;
                    childAt.layout(childCount + i2, 0, i2 + childCount + childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
                    childCount += (this.childPadding * 2) + childAt.getMeasuredWidth();
                }
            }
            return;
        }
        int measuredWidth = this.visibleChildCount > 0 ? (getMeasuredWidth() - this.childWidth) / (this.visibleChildCount - 1) : 0;
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                int i5 = i3 * measuredWidth;
                childAt2.layout(i5, 0, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight());
                i3++;
            }
        }
    }

    public void setChildSize(int childSize) {
        this.childSize = childSize;
    }

    public void setUseStartPadding(boolean startPadding) {
        this.startPadding = startPadding;
    }
}
