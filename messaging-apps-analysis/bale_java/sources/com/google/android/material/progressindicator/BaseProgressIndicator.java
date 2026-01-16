package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.material.progressindicator.a;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC16198ks;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.C8885Xt;
import ir.nasim.GE5;
import ir.nasim.WU3;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class BaseProgressIndicator<S extends com.google.android.material.progressindicator.a> extends ProgressBar {
    static final int o = AbstractC21175tE5.Widget_MaterialComponents_ProgressIndicator;
    com.google.android.material.progressindicator.a a;
    private int b;
    private boolean c;
    private boolean d;
    private final int e;
    private final int f;
    private long g;
    C8885Xt h;
    private boolean i;
    private int j;
    private final Runnable k;
    private final Runnable l;
    private final AbstractC16198ks m;
    private final AbstractC16198ks n;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.k();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.j();
            BaseProgressIndicator.this.g = -1L;
        }
    }

    class c extends AbstractC16198ks {
        c() {
        }

        @Override // ir.nasim.AbstractC16198ks
        public void a(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setProgressCompat(baseProgressIndicator.b, BaseProgressIndicator.this.c);
        }
    }

    class d extends AbstractC16198ks {
        d() {
        }

        @Override // ir.nasim.AbstractC16198ks
        public void a(Drawable drawable) {
            super.a(drawable);
            if (BaseProgressIndicator.this.i) {
                return;
            }
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setVisibility(baseProgressIndicator.j);
        }
    }

    protected BaseProgressIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(AbstractC17750nV3.c(context, attributeSet, i, o), attributeSet, i);
        this.g = -1L;
        this.i = false;
        this.j = 4;
        this.k = new a();
        this.l = new b();
        this.m = new c();
        this.n = new d();
        Context context2 = getContext();
        this.a = i(context2, attributeSet);
        TypedArray typedArrayH = AbstractC5729Ko7.h(context2, attributeSet, GE5.BaseProgressIndicator, i, i2, new int[0]);
        this.e = typedArrayH.getInt(GE5.BaseProgressIndicator_showDelay, -1);
        this.f = Math.min(typedArrayH.getInt(GE5.BaseProgressIndicator_minHideDelay, -1), AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        typedArrayH.recycle();
        this.h = new C8885Xt();
        this.d = true;
    }

    private f getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().v();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ((e) getCurrentDrawable()).p(false, false, true);
        if (m()) {
            setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f > 0) {
            this.g = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean m() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    private void n() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().u().d(this.m);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().l(this.n);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().l(this.n);
        }
    }

    private void o() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().r(this.n);
            getIndeterminateDrawable().u().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().r(this.n);
        }
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.a.f;
    }

    public int[] getIndicatorColor() {
        return this.a.c;
    }

    public int getShowAnimationBehavior() {
        return this.a.e;
    }

    public int getTrackColor() {
        return this.a.d;
    }

    public int getTrackCornerRadius() {
        return this.a.b;
    }

    public int getTrackThickness() {
        return this.a.a;
    }

    protected void h(boolean z) {
        if (this.d) {
            ((e) getCurrentDrawable()).p(p(), false, z);
        }
    }

    abstract com.google.android.material.progressindicator.a i(Context context, AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    boolean l() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        if (p()) {
            k();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.l);
        removeCallbacks(this.k);
        ((e) getCurrentDrawable()).h();
        o();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        try {
            int iSave = canvas.save();
            if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
                canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            }
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
            f currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            int iE = currentDrawingDelegate.e();
            int iD = currentDrawingDelegate.d();
            setMeasuredDimension(iE < 0 ? getMeasuredWidth() : iE + getPaddingLeft() + getPaddingRight(), iD < 0 ? getMeasuredHeight() : iD + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        h(i == 0);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        h(false);
    }

    boolean p() {
        return AbstractC12990fW7.S(this) && getWindowVisibility() == 0 && l();
    }

    public void setAnimatorDurationScaleProvider(C8885Xt c8885Xt) {
        this.h = c8885Xt;
        if (getProgressDrawable() != null) {
            getProgressDrawable().c = c8885Xt;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().c = c8885Xt;
        }
    }

    public void setHideAnimationBehavior(int i) {
        this.a.f = i;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        try {
            if (z == isIndeterminate()) {
                return;
            }
            e eVar = (e) getCurrentDrawable();
            if (eVar != null) {
                eVar.h();
            }
            super.setIndeterminate(z);
            e eVar2 = (e) getCurrentDrawable();
            if (eVar2 != null) {
                eVar2.p(p(), false, false);
            }
            if ((eVar2 instanceof h) && p()) {
                ((h) eVar2).u().g();
            }
            this.i = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof h)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((e) drawable).h();
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{WU3.b(getContext(), AbstractC12181eA5.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.a.c = iArr;
        getIndeterminateDrawable().u().c();
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        if (isIndeterminate()) {
            return;
        }
        setProgressCompat(i, false);
    }

    public void setProgressCompat(int i, boolean z) {
        if (!isIndeterminate()) {
            super.setProgress(i);
            if (getProgressDrawable() == null || z) {
                return;
            }
            getProgressDrawable().jumpToCurrentState();
            return;
        }
        if (getProgressDrawable() != null) {
            this.b = i;
            this.c = z;
            this.i = true;
            if (!getIndeterminateDrawable().isVisible() || this.h.a(getContext().getContentResolver()) == 0.0f) {
                this.m.a(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().u().f();
            }
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof com.google.android.material.progressindicator.d)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            com.google.android.material.progressindicator.d dVar = (com.google.android.material.progressindicator.d) drawable;
            dVar.h();
            super.setProgressDrawable(dVar);
            dVar.A(getProgress() / getMax());
        }
    }

    public void setShowAnimationBehavior(int i) {
        this.a.e = i;
        invalidate();
    }

    public void setTrackColor(int i) {
        com.google.android.material.progressindicator.a aVar = this.a;
        if (aVar.d != i) {
            aVar.d = i;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i) {
        com.google.android.material.progressindicator.a aVar = this.a;
        if (aVar.b != i) {
            aVar.b = Math.min(i, aVar.a / 2);
        }
    }

    public void setTrackThickness(int i) {
        com.google.android.material.progressindicator.a aVar = this.a;
        if (aVar.a != i) {
            aVar.a = i;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i) {
        if (i != 0 && i != 4 && i != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.j = i;
    }

    @Override // android.widget.ProgressBar
    public h getIndeterminateDrawable() {
        return (h) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public com.google.android.material.progressindicator.d getProgressDrawable() {
        return (com.google.android.material.progressindicator.d) super.getProgressDrawable();
    }
}
