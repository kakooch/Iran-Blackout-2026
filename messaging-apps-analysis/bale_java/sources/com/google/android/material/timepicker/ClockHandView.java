package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.GE5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class ClockHandView extends View {
    private ValueAnimator a;
    private boolean b;
    private float c;
    private float d;
    private boolean e;
    private int f;
    private final List g;
    private final int h;
    private final float i;
    private final Paint j;
    private final RectF k;
    private final int l;
    private float m;
    private boolean n;
    private double o;
    private int p;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.m(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
        void a(float f, boolean z);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.materialClockStyle);
    }

    private void c(Canvas canvas) {
        int height = getHeight() / 2;
        float width = getWidth() / 2;
        float fCos = (this.p * ((float) Math.cos(this.o))) + width;
        float f = height;
        float fSin = (this.p * ((float) Math.sin(this.o))) + f;
        this.j.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.h, this.j);
        double dSin = Math.sin(this.o);
        double dCos = Math.cos(this.o);
        this.j.setStrokeWidth(this.l);
        canvas.drawLine(width, f, r1 + ((int) (dCos * d)), height + ((int) (d * dSin)), this.j);
        canvas.drawCircle(width, f, this.i, this.j);
    }

    private int e(float f, float f2) {
        int degrees = (int) Math.toDegrees(Math.atan2(f2 - (getHeight() / 2), f - (getWidth() / 2)));
        int i = degrees + 90;
        return i < 0 ? degrees + 450 : i;
    }

    private Pair h(float f) {
        float f2 = f();
        if (Math.abs(f2 - f) > 180.0f) {
            if (f2 > 180.0f && f < 180.0f) {
                f += 360.0f;
            }
            if (f2 < 180.0f && f > 180.0f) {
                f2 += 360.0f;
            }
        }
        return new Pair(Float.valueOf(f2), Float.valueOf(f));
    }

    private boolean i(float f, float f2, boolean z, boolean z2, boolean z3) {
        float fE = e(f, f2);
        boolean z4 = false;
        boolean z5 = f() != fE;
        if (z2 && z5) {
            return true;
        }
        if (!z5 && !z) {
            return false;
        }
        if (z3 && this.b) {
            z4 = true;
        }
        l(fE, z4);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(float f, boolean z) {
        float f2 = f % 360.0f;
        this.m = f2;
        this.o = Math.toRadians(f2 - 90.0f);
        int height = getHeight() / 2;
        float width = (getWidth() / 2) + (this.p * ((float) Math.cos(this.o)));
        float fSin = height + (this.p * ((float) Math.sin(this.o)));
        RectF rectF = this.k;
        int i = this.h;
        rectF.set(width - i, fSin - i, width + i, fSin + i);
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(f2, z);
        }
        invalidate();
    }

    public void b(c cVar) {
        this.g.add(cVar);
    }

    public RectF d() {
        return this.k;
    }

    public float f() {
        return this.m;
    }

    public int g() {
        return this.h;
    }

    public void j(int i) {
        this.p = i;
        invalidate();
    }

    public void k(float f) {
        l(f, false);
    }

    public void l(float f, boolean z) {
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            m(f, false);
            return;
        }
        Pair pairH = h(f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(((Float) pairH.first).floatValue(), ((Float) pairH.second).floatValue());
        this.a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        this.a.addUpdateListener(new a());
        this.a.addListener(new b());
        this.a.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        k(f());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.c = x;
            this.d = y;
            this.e = true;
            this.n = false;
            z = true;
            z2 = false;
            z3 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i = (int) (x - this.c);
            int i2 = (int) (y - this.d);
            this.e = (i * i) + (i2 * i2) > this.f;
            z2 = this.n;
            z3 = actionMasked == 1;
            z = false;
        } else {
            z2 = false;
            z = false;
            z3 = false;
        }
        this.n |= i(x, y, z2, z, z3);
        return true;
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new ArrayList();
        Paint paint = new Paint();
        this.j = paint;
        this.k = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, GE5.ClockHandView, i, AbstractC21175tE5.Widget_MaterialComponents_TimePicker_Clock);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.ClockHandView_materialCircleRadius, 0);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.ClockHandView_selectorSize, 0);
        this.l = getResources().getDimensionPixelSize(AbstractC12799fB5.material_clock_hand_stroke_width);
        this.i = r6.getDimensionPixelSize(AbstractC12799fB5.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(GE5.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        k(0.0f);
        this.f = ViewConfiguration.get(context).getScaledTouchSlop();
        AbstractC12990fW7.A0(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
