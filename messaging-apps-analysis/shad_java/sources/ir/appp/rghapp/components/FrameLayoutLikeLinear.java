package ir.appp.rghapp.components;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class FrameLayoutLikeLinear extends FrameLayout {
    private float[] weights;

    public FrameLayoutLikeLinear(Context context) {
        super(context);
        this.weights = new float[0];
    }

    public void setWeights(float[] fArr) {
        this.weights = fArr;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            float[] fArr = this.weights;
            float f = i3 < fArr.length ? fArr[i3] : 1.0f / childCount;
            View childAt = getChildAt(i3);
            childAt.getLayoutParams().width = (int) (size * f);
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                i4 += getChildAt(i5).getLayoutParams().width;
            }
            ((FrameLayout.LayoutParams) childAt.getLayoutParams()).leftMargin = i4;
            ((FrameLayout.LayoutParams) childAt.getLayoutParams()).gravity = 3;
            i3++;
        }
        super.onMeasure(i, i2);
    }
}
