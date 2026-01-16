package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.exoplayer2.ui.B;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.DE5;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public class DefaultTimeBar extends View implements B {
    private int A;
    private boolean A0;
    private long B;
    private long B0;
    private long C0;
    private int D;
    private long D0;
    private long E0;
    private int F0;
    private Rect G;
    private long[] G0;
    private ValueAnimator H;
    private boolean[] H0;
    private float J;
    private final Rect a;
    private final Rect b;
    private final Rect c;
    private final Rect d;
    private final Paint e;
    private final Paint f;
    private final Paint g;
    private final Paint h;
    private final Paint i;
    private final Paint j;
    private final Drawable k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private final int r;
    private final int s;
    private final int t;
    private final StringBuilder u;
    private final Formatter v;
    private final Runnable w;
    private final CopyOnWriteArraySet x;
    private final Point y;
    private final float z;
    private boolean z0;

    public DefaultTimeBar(Context context) {
        this(context, null);
    }

    private static int d(float f, int i) {
        return (int) ((i * f) + 0.5f);
    }

    private void e(Canvas canvas) {
        if (this.C0 <= 0) {
            return;
        }
        Rect rect = this.d;
        int iP = AbstractC9683aN7.p(rect.right, rect.left, this.b.right);
        int iCenterY = this.d.centerY();
        if (this.k == null) {
            canvas.drawCircle(iP, iCenterY, (int) ((((this.A0 || isFocused()) ? this.r : isEnabled() ? this.p : this.q) * this.J) / 2.0f), this.j);
            return;
        }
        int intrinsicWidth = ((int) (r2.getIntrinsicWidth() * this.J)) / 2;
        int intrinsicHeight = ((int) (this.k.getIntrinsicHeight() * this.J)) / 2;
        this.k.setBounds(iP - intrinsicWidth, iCenterY - intrinsicHeight, iP + intrinsicWidth, iCenterY + intrinsicHeight);
        this.k.draw(canvas);
    }

    private void f(Canvas canvas) {
        int iHeight = this.b.height();
        int iCenterY = this.b.centerY() - (iHeight / 2);
        int i = iHeight + iCenterY;
        if (this.C0 <= 0) {
            Rect rect = this.b;
            canvas.drawRect(rect.left, iCenterY, rect.right, i, this.g);
            return;
        }
        Rect rect2 = this.c;
        int i2 = rect2.left;
        int i3 = rect2.right;
        int iMax = Math.max(Math.max(this.b.left, i3), this.d.right);
        int i4 = this.b.right;
        if (iMax < i4) {
            canvas.drawRect(iMax, iCenterY, i4, i, this.g);
        }
        int iMax2 = Math.max(i2, this.d.right);
        if (i3 > iMax2) {
            canvas.drawRect(iMax2, iCenterY, i3, i, this.f);
        }
        if (this.d.width() > 0) {
            Rect rect3 = this.d;
            canvas.drawRect(rect3.left, iCenterY, rect3.right, i, this.e);
        }
        if (this.F0 == 0) {
            return;
        }
        long[] jArr = (long[]) AbstractC20011rK.e(this.G0);
        boolean[] zArr = (boolean[]) AbstractC20011rK.e(this.H0);
        int i5 = this.o / 2;
        for (int i6 = 0; i6 < this.F0; i6++) {
            int iWidth = ((int) ((this.b.width() * AbstractC9683aN7.q(jArr[i6], 0L, this.C0)) / this.C0)) - i5;
            Rect rect4 = this.b;
            canvas.drawRect(rect4.left + Math.min(rect4.width() - this.o, Math.max(0, iWidth)), iCenterY, r10 + this.o, i, zArr[i6] ? this.i : this.h);
        }
    }

    private long getPositionIncrement() {
        long j = this.B;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.C0;
        if (j2 == -9223372036854775807L) {
            return 0L;
        }
        return j2 / this.A;
    }

    private String getProgressText() {
        return AbstractC9683aN7.f0(this.u, this.v, this.D0);
    }

    private long getScrubberPosition() {
        if (this.b.width() <= 0 || this.C0 == -9223372036854775807L) {
            return 0L;
        }
        return (this.d.width() * this.C0) / this.b.width();
    }

    private boolean i(float f, float f2) {
        return this.a.contains((int) f, (int) f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        v(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(ValueAnimator valueAnimator) {
        this.J = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.a);
    }

    private void l(float f) {
        Rect rect = this.d;
        Rect rect2 = this.b;
        rect.right = AbstractC9683aN7.p((int) f, rect2.left, rect2.right);
    }

    private static int m(float f, int i) {
        return (int) (i / f);
    }

    private Point n(MotionEvent motionEvent) {
        this.y.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.y;
    }

    private boolean o(long j) {
        long j2 = this.C0;
        if (j2 <= 0) {
            return false;
        }
        long j3 = this.A0 ? this.B0 : this.D0;
        long jQ = AbstractC9683aN7.q(j3 + j, 0L, j2);
        if (jQ == j3) {
            return false;
        }
        if (this.A0) {
            y(jQ);
        } else {
            u(jQ);
        }
        w();
        return true;
    }

    private boolean p(Drawable drawable) {
        return AbstractC9683aN7.a >= 23 && q(drawable, getLayoutDirection());
    }

    private static boolean q(Drawable drawable, int i) {
        return AbstractC9683aN7.a >= 23 && drawable.setLayoutDirection(i);
    }

    private void r(int i, int i2) {
        Rect rect = this.G;
        if (rect != null && rect.width() == i && this.G.height() == i2) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i, i2);
        this.G = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    private void u(long j) {
        this.B0 = j;
        this.A0 = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            ((B.a) it.next()).h(this, j);
        }
    }

    private void v(boolean z) {
        removeCallbacks(this.w);
        this.A0 = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            ((B.a) it.next()).e(this, this.B0, z);
        }
    }

    private void w() {
        this.c.set(this.b);
        this.d.set(this.b);
        long j = this.A0 ? this.B0 : this.D0;
        if (this.C0 > 0) {
            int iWidth = (int) ((this.b.width() * this.E0) / this.C0);
            Rect rect = this.c;
            Rect rect2 = this.b;
            rect.right = Math.min(rect2.left + iWidth, rect2.right);
            int iWidth2 = (int) ((this.b.width() * j) / this.C0);
            Rect rect3 = this.d;
            Rect rect4 = this.b;
            rect3.right = Math.min(rect4.left + iWidth2, rect4.right);
        } else {
            Rect rect5 = this.c;
            int i = this.b.left;
            rect5.right = i;
            this.d.right = i;
        }
        invalidate(this.a);
    }

    private void x() {
        Drawable drawable = this.k;
        if (drawable != null && drawable.isStateful() && this.k.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void y(long j) {
        if (this.B0 == j) {
            return;
        }
        this.B0 = j;
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            ((B.a) it.next()).a(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.ui.B
    public void a(B.a aVar) {
        AbstractC20011rK.e(aVar);
        this.x.add(aVar);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        x();
    }

    public void g(long j) {
        if (this.H.isStarted()) {
            this.H.cancel();
        }
        this.H.setFloatValues(this.J, 0.0f);
        this.H.setDuration(j);
        this.H.start();
    }

    @Override // com.google.android.exoplayer2.ui.B
    public long getPreferredUpdateDelay() {
        int iM = m(this.z, this.b.width());
        if (iM != 0) {
            long j = this.C0;
            if (j != 0 && j != -9223372036854775807L) {
                return j / iM;
            }
        }
        return Long.MAX_VALUE;
    }

    public void h(boolean z) {
        if (this.H.isStarted()) {
            this.H.cancel();
        }
        this.z0 = z;
        this.J = 0.0f;
        invalidate(this.a);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        f(canvas);
        e(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!this.A0 || z) {
            return;
        }
        v(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.C0 <= 0) {
            return;
        }
        if (AbstractC9683aN7.a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L30
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L27
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L27;
                default: goto L12;
            }
        L12:
            goto L30
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.o(r0)
            if (r0 == 0) goto L30
            java.lang.Runnable r5 = r4.w
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.w
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L27:
            boolean r0 = r4.A0
            if (r0 == 0) goto L30
            r5 = 0
            r4.v(r5)
            return r3
        L30:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingBottom;
        int iMax;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i5 - getPaddingRight();
        int i7 = this.z0 ? 0 : this.s;
        if (this.n == 1) {
            paddingBottom = (i6 - getPaddingBottom()) - this.m;
            int paddingBottom2 = i6 - getPaddingBottom();
            int i8 = this.l;
            iMax = (paddingBottom2 - i8) - Math.max(i7 - (i8 / 2), 0);
        } else {
            paddingBottom = (i6 - this.m) / 2;
            iMax = (i6 - this.l) / 2;
        }
        this.a.set(paddingLeft, paddingBottom, paddingRight, this.m + paddingBottom);
        Rect rect = this.b;
        Rect rect2 = this.a;
        rect.set(rect2.left + i7, iMax, rect2.right - i7, this.l + iMax);
        if (AbstractC9683aN7.a >= 29) {
            r(i5, i6);
        }
        w();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.m;
        } else if (mode != 1073741824) {
            size = Math.min(this.m, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        x();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.k;
        if (drawable == null || !q(drawable, i)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L76
            long r2 = r7.C0
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L10
            goto L76
        L10:
            android.graphics.Point r0 = r7.n(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L5d
            r5 = 3
            if (r3 == r4) goto L4e
            r6 = 2
            if (r3 == r6) goto L28
            if (r3 == r5) goto L4e
            goto L76
        L28:
            boolean r8 = r7.A0
            if (r8 == 0) goto L76
            int r8 = r7.t
            if (r0 >= r8) goto L3a
            int r8 = r7.D
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.l(r8)
            goto L40
        L3a:
            r7.D = r2
            float r8 = (float) r2
            r7.l(r8)
        L40:
            long r0 = r7.getScrubberPosition()
            r7.y(r0)
            r7.w()
            r7.invalidate()
            return r4
        L4e:
            boolean r0 = r7.A0
            if (r0 == 0) goto L76
            int r8 = r8.getAction()
            if (r8 != r5) goto L59
            r1 = r4
        L59:
            r7.v(r1)
            return r4
        L5d:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.i(r8, r0)
            if (r0 == 0) goto L76
            r7.l(r8)
            long r0 = r7.getScrubberPosition()
            r7.u(r0)
            r7.w()
            r7.invalidate()
            return r4
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.C0 <= 0) {
            return false;
        }
        if (i == 8192) {
            if (o(-getPositionIncrement())) {
                v(false);
            }
        } else {
            if (i != 4096) {
                return false;
            }
            if (o(getPositionIncrement())) {
                v(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void s() {
        if (this.H.isStarted()) {
            this.H.cancel();
        }
        this.z0 = false;
        this.J = 1.0f;
        invalidate(this.a);
    }

    @Override // com.google.android.exoplayer2.ui.B
    public void setAdGroupTimesMs(long[] jArr, boolean[] zArr, int i) {
        AbstractC20011rK.a(i == 0 || !(jArr == null || zArr == null));
        this.F0 = i;
        this.G0 = jArr;
        this.H0 = zArr;
        w();
    }

    public void setAdMarkerColor(int i) {
        this.h.setColor(i);
        invalidate(this.a);
    }

    public void setBufferedColor(int i) {
        this.f.setColor(i);
        invalidate(this.a);
    }

    @Override // com.google.android.exoplayer2.ui.B
    public void setBufferedPosition(long j) {
        if (this.E0 == j) {
            return;
        }
        this.E0 = j;
        w();
    }

    @Override // com.google.android.exoplayer2.ui.B
    public void setDuration(long j) {
        if (this.C0 == j) {
            return;
        }
        this.C0 = j;
        if (this.A0 && j == -9223372036854775807L) {
            v(true);
        }
        w();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.B
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!this.A0 || z) {
            return;
        }
        v(true);
    }

    public void setKeyCountIncrement(int i) {
        AbstractC20011rK.a(i > 0);
        this.A = i;
        this.B = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j) {
        AbstractC20011rK.a(j > 0);
        this.A = -1;
        this.B = j;
    }

    public void setPlayedAdMarkerColor(int i) {
        this.i.setColor(i);
        invalidate(this.a);
    }

    public void setPlayedColor(int i) {
        this.e.setColor(i);
        invalidate(this.a);
    }

    @Override // com.google.android.exoplayer2.ui.B
    public void setPosition(long j) {
        if (this.D0 == j) {
            return;
        }
        this.D0 = j;
        setContentDescription(getProgressText());
        w();
    }

    public void setScrubberColor(int i) {
        this.j.setColor(i);
        invalidate(this.a);
    }

    public void setUnplayedColor(int i) {
        this.g.setColor(i);
        invalidate(this.a);
    }

    public void t(long j) {
        if (this.H.isStarted()) {
            this.H.cancel();
        }
        this.z0 = false;
        this.H.setFloatValues(this.J, 1.0f);
        this.H.setDuration(j);
        this.H.start();
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        this(context, attributeSet, i, attributeSet2, 0);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2, int i2) {
        super(context, attributeSet, i);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new Rect();
        this.d = new Rect();
        Paint paint = new Paint();
        this.e = paint;
        Paint paint2 = new Paint();
        this.f = paint2;
        Paint paint3 = new Paint();
        this.g = paint3;
        Paint paint4 = new Paint();
        this.h = paint4;
        Paint paint5 = new Paint();
        this.i = paint5;
        Paint paint6 = new Paint();
        this.j = paint6;
        paint6.setAntiAlias(true);
        this.x = new CopyOnWriteArraySet();
        this.y = new Point();
        float f = context.getResources().getDisplayMetrics().density;
        this.z = f;
        this.t = d(f, -50);
        int iD = d(f, 4);
        int iD2 = d(f, 26);
        int iD3 = d(f, 4);
        int iD4 = d(f, 12);
        int iD5 = d(f, 0);
        int iD6 = d(f, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, DE5.DefaultTimeBar, i, i2);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(DE5.DefaultTimeBar_scrubber_drawable);
                this.k = drawable;
                if (drawable != null) {
                    p(drawable);
                    iD2 = Math.max(drawable.getMinimumHeight(), iD2);
                }
                this.l = typedArrayObtainStyledAttributes.getDimensionPixelSize(DE5.DefaultTimeBar_bar_height, iD);
                this.m = typedArrayObtainStyledAttributes.getDimensionPixelSize(DE5.DefaultTimeBar_touch_target_height, iD2);
                this.n = typedArrayObtainStyledAttributes.getInt(DE5.DefaultTimeBar_bar_gravity, 0);
                this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(DE5.DefaultTimeBar_ad_marker_width, iD3);
                this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(DE5.DefaultTimeBar_scrubber_enabled_size, iD4);
                this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(DE5.DefaultTimeBar_scrubber_disabled_size, iD5);
                this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(DE5.DefaultTimeBar_scrubber_dragged_size, iD6);
                int i3 = typedArrayObtainStyledAttributes.getInt(DE5.DefaultTimeBar_played_color, -1);
                int i4 = typedArrayObtainStyledAttributes.getInt(DE5.DefaultTimeBar_scrubber_color, -1);
                int i5 = typedArrayObtainStyledAttributes.getInt(DE5.DefaultTimeBar_buffered_color, -855638017);
                int i6 = typedArrayObtainStyledAttributes.getInt(DE5.DefaultTimeBar_unplayed_color, 872415231);
                int i7 = typedArrayObtainStyledAttributes.getInt(DE5.DefaultTimeBar_ad_marker_color, -1291845888);
                int i8 = typedArrayObtainStyledAttributes.getInt(DE5.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint.setColor(i3);
                paint6.setColor(i4);
                paint2.setColor(i5);
                paint3.setColor(i6);
                paint4.setColor(i7);
                paint5.setColor(i8);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.l = iD;
            this.m = iD2;
            this.n = 0;
            this.o = iD3;
            this.p = iD4;
            this.q = iD5;
            this.r = iD6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.k = null;
        }
        StringBuilder sb = new StringBuilder();
        this.u = sb;
        this.v = new Formatter(sb, Locale.getDefault());
        this.w = new Runnable() { // from class: ir.nasim.IF1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j();
            }
        };
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            this.s = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.s = (Math.max(this.q, Math.max(this.p, this.r)) + 1) / 2;
        }
        this.J = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.H = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.KF1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.k(valueAnimator2);
            }
        });
        this.C0 = -9223372036854775807L;
        this.B = -9223372036854775807L;
        this.A = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
