package ir.eitaa.ui.Components;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
public class MessageBackgroundDrawable extends Drawable {
    private boolean animationInProgress;
    private float currentAnimationProgress;
    private float finalRadius;
    private boolean isSelected;
    private long lastAnimationTime;
    private long lastTouchTime;
    private View parentView;
    private Paint paint = new Paint(1);
    private float touchX = -1.0f;
    private float touchY = -1.0f;
    private float touchOverrideX = -1.0f;
    private float touchOverrideY = -1.0f;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public MessageBackgroundDrawable(View parent) {
        this.parentView = parent;
    }

    public void setColor(int color) {
        this.paint.setColor(color);
    }

    public void setSelected(boolean selected, boolean animated) {
        if (this.isSelected == selected) {
            if (this.animationInProgress == animated || animated) {
                return;
            }
            this.currentAnimationProgress = selected ? 1.0f : 0.0f;
            this.animationInProgress = false;
            return;
        }
        this.isSelected = selected;
        this.animationInProgress = animated;
        if (animated) {
            this.lastAnimationTime = SystemClock.elapsedRealtime();
        } else {
            this.currentAnimationProgress = selected ? 1.0f : 0.0f;
        }
        calcRadius();
        invalidate();
    }

    private void invalidate() {
        View view = this.parentView;
        if (view != null) {
            view.invalidate();
            if (this.parentView.getParent() != null) {
                ((ViewGroup) this.parentView.getParent()).invalidate();
            }
        }
    }

    private void calcRadius() {
        android.graphics.Rect bounds = getBounds();
        float fCenterX = bounds.centerX();
        float fCenterY = bounds.centerY();
        int i = bounds.left;
        int i2 = bounds.top;
        this.finalRadius = (float) Math.ceil(Math.sqrt(((i - fCenterX) * (i - fCenterX)) + ((i2 - fCenterY) * (i2 - fCenterY))));
    }

    public void setTouchCoords(float x, float y) {
        this.touchX = x;
        this.touchY = y;
        this.lastTouchTime = SystemClock.elapsedRealtime();
    }

    public void setTouchCoordsOverride(float x, float y) {
        this.touchOverrideX = x;
        this.touchOverrideY = y;
    }

    public float getTouchX() {
        return this.touchX;
    }

    public float getTouchY() {
        return this.touchY;
    }

    public long getLastTouchTime() {
        return this.lastTouchTime;
    }

    public boolean isAnimationInProgress() {
        return this.animationInProgress;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        calcRadius();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(android.graphics.Rect bounds) {
        super.setBounds(bounds);
        calcRadius();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r10) {
        /*
            r9 = this;
            float r0 = r9.currentAnimationProgress
            r1 = 1065353216(0x3f800000, float:1.0)
            r2 = 0
            int r3 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r3 != 0) goto L13
            android.graphics.Rect r0 = r9.getBounds()
            android.graphics.Paint r3 = r9.paint
            r10.drawRect(r0, r3)
            goto L69
        L13:
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 == 0) goto L69
            boolean r3 = r9.isSelected
            if (r3 == 0) goto L22
            ir.eitaa.ui.Components.CubicBezierInterpolator r3 = ir.eitaa.ui.Components.CubicBezierInterpolator.EASE_OUT_QUINT
            float r0 = r3.getInterpolation(r0)
            goto L2c
        L22:
            ir.eitaa.ui.Components.CubicBezierInterpolator r3 = ir.eitaa.ui.Components.CubicBezierInterpolator.EASE_OUT_QUINT
            float r0 = r1 - r0
            float r0 = r3.getInterpolation(r0)
            float r0 = r1 - r0
        L2c:
            android.graphics.Rect r3 = r9.getBounds()
            int r4 = r3.centerX()
            float r4 = (float) r4
            int r3 = r3.centerY()
            float r3 = (float) r3
            float r5 = r9.touchOverrideX
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 < 0) goto L47
            float r6 = r9.touchOverrideY
            int r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r7 < 0) goto L47
            goto L56
        L47:
            float r5 = r9.touchX
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 < 0) goto L54
            float r6 = r9.touchY
            int r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r7 < 0) goto L54
            goto L56
        L54:
            r6 = r3
            r5 = r4
        L56:
            float r7 = r1 - r0
            float r5 = r5 - r4
            float r5 = r5 * r7
            float r4 = r4 + r5
            float r6 = r6 - r3
            float r7 = r7 * r6
            float r3 = r3 + r7
            float r5 = r9.finalRadius
            float r5 = r5 * r0
            android.graphics.Paint r0 = r9.paint
            r10.drawCircle(r4, r3, r5, r0)
        L69:
            boolean r10 = r9.animationInProgress
            if (r10 == 0) goto Lb5
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r5 = r9.lastAnimationTime
            long r5 = r3 - r5
            r7 = 20
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 <= 0) goto L7d
            r5 = 17
        L7d:
            r9.lastAnimationTime = r3
            boolean r10 = r9.isSelected
            r0 = 1
            r3 = 1131413504(0x43700000, float:240.0)
            r4 = 0
            if (r10 == 0) goto L95
            float r10 = r9.currentAnimationProgress
            float r2 = (float) r5
            float r2 = r2 / r3
            float r10 = r10 + r2
            r9.currentAnimationProgress = r10
            int r10 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r10 < 0) goto La3
            r9.currentAnimationProgress = r1
            goto La4
        L95:
            float r10 = r9.currentAnimationProgress
            float r1 = (float) r5
            float r1 = r1 / r3
            float r10 = r10 - r1
            r9.currentAnimationProgress = r10
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 > 0) goto La3
            r9.currentAnimationProgress = r2
            goto La4
        La3:
            r0 = 0
        La4:
            if (r0 == 0) goto Lb2
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9.touchX = r10
            r9.touchY = r10
            r9.touchOverrideX = r10
            r9.touchOverrideY = r10
            r9.animationInProgress = r4
        Lb2:
            r9.invalidate()
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.MessageBackgroundDrawable.draw(android.graphics.Canvas):void");
    }
}
