package ir.appp.rghapp.rubinoPostSlider;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.SparseArray;
import android.view.View;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class ScrollingPagerIndicator extends View {
    private final ArgbEvaluator colorEvaluator;
    private int dotColor;
    private boolean dotCountInitialized;
    private final int dotMinimumSize;
    private final int dotNormalSize;
    private SparseArray<Float> dotScale;
    private final int dotSelectedSize;
    private float firstDotOffset;
    private int infiniteDotCount;
    private int itemCount;
    private boolean looped;
    private int orientation;
    private final Paint paint;
    private int selectedDotColor;
    private final int spaceBetweenDotCenters;
    private int visibleDotCount;
    private int visibleDotThreshold;
    private float visibleFramePosition;
    private float visibleFrameWidth;

    public ScrollingPagerIndicator(Context context) {
        super(context, null);
        this.colorEvaluator = new ArgbEvaluator();
        this.selectedDotColor = Color.parseColor("#4191EF");
        this.dotColor = Color.parseColor("#A8A8A8");
        this.dotNormalSize = AndroidUtilities.dp(4.0f);
        this.dotSelectedSize = AndroidUtilities.dp(5.0f);
        this.dotMinimumSize = AndroidUtilities.dp(2.0f);
        this.spaceBetweenDotCenters = AndroidUtilities.dp(8.0f);
        this.looped = false;
        setVisibleDotCount(5);
        this.visibleDotThreshold = 2;
        this.orientation = 0;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
    }

    public void setLooped(boolean z) {
        this.looped = z;
        requestLayout();
        invalidate();
    }

    public int getDotColor() {
        return this.dotColor;
    }

    public void setDotColor(int i) {
        this.dotColor = i;
        invalidate();
    }

    public int getSelectedDotColor() {
        return this.selectedDotColor;
    }

    public void setSelectedDotColor(int i) {
        this.selectedDotColor = i;
        invalidate();
    }

    public int getVisibleDotCount() {
        return this.visibleDotCount;
    }

    public void setVisibleDotCount(int i) {
        if (i % 2 == 0) {
            throw new IllegalArgumentException("visibleDotCount must be odd");
        }
        this.visibleDotCount = i;
        this.infiniteDotCount = i + 2;
        requestLayout();
        invalidate();
    }

    public int getVisibleDotThreshold() {
        return this.visibleDotThreshold;
    }

    public void setVisibleDotThreshold(int i) {
        this.visibleDotThreshold = i;
        requestLayout();
        invalidate();
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setOrientation(int i) {
        this.orientation = i;
        requestLayout();
        invalidate();
    }

    public void onPageScrolled(int i, float f) {
        int i2;
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Offset must be [0, 1]");
        }
        if (i < 0 || (i != 0 && i >= this.itemCount)) {
            throw new IndexOutOfBoundsException("page must be [0, adapter.getItemCount())");
        }
        if (!this.looped || ((i2 = this.itemCount) <= this.visibleDotCount && i2 > 1)) {
            this.dotScale.clear();
            scaleDotByOffset(i, f);
            int i3 = this.itemCount;
            if (i < i3 - 1) {
                scaleDotByOffset(i + 1, 1.0f - f);
            } else if (i3 > 1) {
                scaleDotByOffset(0, 1.0f - f);
            }
            invalidate();
        }
        adjustFramePosition(f, i);
        invalidate();
    }

    public void setDotCount(int i) {
        initDots(i);
    }

    public void setCurrentPosition(int i) {
        if (i != 0 && (i < 0 || i >= this.itemCount)) {
            throw new IndexOutOfBoundsException("Position must be [0, adapter.getItemCount()]");
        }
        if (this.itemCount == 0) {
            return;
        }
        adjustFramePosition(0.0f, i);
        updateScaleInIdleState(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r4 = r3.isInEditMode()
            if (r4 == 0) goto L12
            int r4 = r3.visibleDotCount
            int r4 = r4 + (-1)
            int r0 = r3.spaceBetweenDotCenters
            int r4 = r4 * r0
            int r0 = r3.dotSelectedSize
        L10:
            int r4 = r4 + r0
            goto L25
        L12:
            int r4 = r3.itemCount
            int r0 = r3.visibleDotCount
            if (r4 < r0) goto L1c
            float r4 = r3.visibleFrameWidth
            int r4 = (int) r4
            goto L25
        L1c:
            int r4 = r4 + (-1)
            int r0 = r3.spaceBetweenDotCenters
            int r4 = r4 * r0
            int r0 = r3.dotSelectedSize
            goto L10
        L25:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r1 = r3.dotSelectedSize
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r2) goto L39
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L3d
            r5 = r1
            goto L3d
        L39:
            int r5 = java.lang.Math.min(r1, r5)
        L3d:
            r3.setMeasuredDimension(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.ScrollingPagerIndicator.onMeasure(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00dd A[PHI: r9
      0x00dd: PHI (r9v13 int) = (r9v11 int), (r9v14 int) binds: [B:51:0x00db, B:43:0x00be] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0100  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r17) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.ScrollingPagerIndicator.onDraw(android.graphics.Canvas):void");
    }

    private int calculateDotColor(float f) {
        return ((Integer) this.colorEvaluator.evaluate(f, Integer.valueOf(this.dotColor), Integer.valueOf(this.selectedDotColor))).intValue();
    }

    private void updateScaleInIdleState(int i) {
        if (!this.looped || this.itemCount < this.visibleDotCount) {
            this.dotScale.clear();
            this.dotScale.put(i, Float.valueOf(1.0f));
            invalidate();
        }
    }

    private void initDots(int i) {
        if (this.itemCount == i && this.dotCountInitialized) {
            return;
        }
        this.itemCount = i;
        this.dotCountInitialized = true;
        this.dotScale = new SparseArray<>();
        if (i < this.visibleDotThreshold) {
            requestLayout();
            invalidate();
        } else {
            this.firstDotOffset = (!this.looped || this.itemCount <= this.visibleDotCount) ? this.dotSelectedSize / 2 : 0.0f;
            this.visibleFrameWidth = ((this.visibleDotCount - 1) * this.spaceBetweenDotCenters) + this.dotSelectedSize;
            requestLayout();
            invalidate();
        }
    }

    private int getDotCount() {
        if (this.looped && this.itemCount > this.visibleDotCount) {
            return this.infiniteDotCount;
        }
        return this.itemCount;
    }

    private void adjustFramePosition(float f, int i) {
        int i2 = this.itemCount;
        int i3 = this.visibleDotCount;
        if (i2 <= i3) {
            this.visibleFramePosition = 0.0f;
            return;
        }
        if (!this.looped && i2 > i3) {
            this.visibleFramePosition = (getDotOffsetAt(i) + (this.spaceBetweenDotCenters * f)) - (this.visibleFrameWidth / 2.0f);
            int i4 = this.visibleDotCount / 2;
            float dotOffsetAt = getDotOffsetAt((getDotCount() - 1) - i4);
            if (this.visibleFramePosition + (this.visibleFrameWidth / 2.0f) < getDotOffsetAt(i4)) {
                this.visibleFramePosition = getDotOffsetAt(i4) - (this.visibleFrameWidth / 2.0f);
                return;
            }
            float f2 = this.visibleFramePosition;
            float f3 = this.visibleFrameWidth;
            if (f2 + (f3 / 2.0f) > dotOffsetAt) {
                this.visibleFramePosition = dotOffsetAt - (f3 / 2.0f);
                return;
            }
            return;
        }
        this.visibleFramePosition = (getDotOffsetAt(this.infiniteDotCount / 2) + (this.spaceBetweenDotCenters * f)) - (this.visibleFrameWidth / 2.0f);
    }

    private void scaleDotByOffset(int i, float f) {
        if (this.dotScale == null || getDotCount() == 0) {
            return;
        }
        setDotScaleAt(i, 1.0f - Math.abs(f));
    }

    private float getDotOffsetAt(int i) {
        return this.firstDotOffset + (i * this.spaceBetweenDotCenters);
    }

    private float getDotScaleAt(int i) {
        Float f = this.dotScale.get(i);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    private void setDotScaleAt(int i, float f) {
        if (f == 0.0f) {
            this.dotScale.remove(i);
        } else {
            this.dotScale.put(i, Float.valueOf(f));
        }
    }
}
