package com.facebook.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.shimmer.a;
import ir.nasim.BE5;

/* loaded from: classes2.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private final Paint a;
    private final b b;
    private boolean c;

    public ShimmerFrameLayout(Context context) {
        super(context);
        this.a = new Paint();
        this.b = new b();
        this.c = true;
        b(context, null);
    }

    private void b(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        this.b.setCallback(this);
        if (attributeSet == null) {
            c(new a.C0157a().a());
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, BE5.ShimmerFrameLayout, 0, 0);
        try {
            c(((typedArrayObtainStyledAttributes.hasValue(BE5.ShimmerFrameLayout_shimmer_colored) && typedArrayObtainStyledAttributes.getBoolean(BE5.ShimmerFrameLayout_shimmer_colored, false)) ? new a.c() : new a.C0157a()).c(typedArrayObtainStyledAttributes).a());
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void a() {
        if (this.c) {
            f();
            this.c = false;
            invalidate();
        }
    }

    public ShimmerFrameLayout c(a aVar) {
        this.b.d(aVar);
        if (aVar == null || !aVar.o) {
            setLayerType(0, null);
        } else {
            setLayerType(2, this.a);
        }
        return this;
    }

    public void d(boolean z) {
        if (this.c) {
            return;
        }
        this.c = true;
        if (z) {
            e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.c) {
            this.b.draw(canvas);
        }
    }

    public void e() {
        this.b.e();
    }

    public void f() {
        this.b.f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.b.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.b;
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.b = new b();
        this.c = true;
        b(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint();
        this.b = new b();
        this.c = true;
        b(context, attributeSet);
    }
}
