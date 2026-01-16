package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.GE5;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.O98;

/* loaded from: classes3.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {
    Drawable a;
    Rect b;
    private Rect c;
    private boolean d;
    private boolean e;

    class a implements InterfaceC22474vI4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC22474vI4
        public O98 b(View view, O98 o98) {
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.b == null) {
                scrimInsetsFrameLayout.b = new Rect();
            }
            ScrimInsetsFrameLayout.this.b.set(o98.k(), o98.m(), o98.l(), o98.j());
            ScrimInsetsFrameLayout.this.a(o98);
            ScrimInsetsFrameLayout.this.setWillNotDraw(!o98.o() || ScrimInsetsFrameLayout.this.a == null);
            AbstractC12990fW7.g0(ScrimInsetsFrameLayout.this);
            return o98.c();
        }
    }

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.b == null || this.a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.d) {
            this.c.set(0, 0, width, this.b.top);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
        }
        if (this.e) {
            this.c.set(0, height - this.b.bottom, width, height);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
        }
        Rect rect = this.c;
        Rect rect2 = this.b;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.a.setBounds(this.c);
        this.a.draw(canvas);
        Rect rect3 = this.c;
        Rect rect4 = this.b;
        rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
        this.a.setBounds(this.c);
        this.a.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.e = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.d = z;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.a = drawable;
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Rect();
        this.d = true;
        this.e = true;
        TypedArray typedArrayH = AbstractC5729Ko7.h(context, attributeSet, GE5.ScrimInsetsFrameLayout, i, AbstractC21175tE5.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.a = typedArrayH.getDrawable(GE5.ScrimInsetsFrameLayout_insetForeground);
        typedArrayH.recycle();
        setWillNotDraw(true);
        AbstractC12990fW7.E0(this, new a());
    }

    protected void a(O98 o98) {
    }
}
