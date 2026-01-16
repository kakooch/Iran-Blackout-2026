package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.TB5;
import java.lang.reflect.InvocationTargetException;

/* renamed from: androidx.transition.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1985h extends ViewGroup implements InterfaceC1982e {
    ViewGroup a;
    View b;
    final View c;
    int d;
    private Matrix e;
    private final ViewTreeObserver.OnPreDrawListener f;

    /* renamed from: androidx.transition.h$a */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View view;
            AbstractC12990fW7.g0(C1985h.this);
            C1985h c1985h = C1985h.this;
            ViewGroup viewGroup = c1985h.a;
            if (viewGroup == null || (view = c1985h.b) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            AbstractC12990fW7.g0(C1985h.this.a);
            C1985h c1985h2 = C1985h.this;
            c1985h2.a = null;
            c1985h2.b = null;
            return true;
        }
    }

    C1985h(View view) {
        super(view.getContext());
        this.f = new a();
        this.c = view;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, null);
    }

    static C1985h b(View view, ViewGroup viewGroup, Matrix matrix) {
        int i;
        C1983f c1983f;
        if (!(view.getParent() instanceof ViewGroup)) {
            throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        }
        C1983f c1983fB = C1983f.b(viewGroup);
        C1985h c1985hE = e(view);
        if (c1985hE == null || (c1983f = (C1983f) c1985hE.getParent()) == c1983fB) {
            i = 0;
        } else {
            i = c1985hE.d;
            c1983f.removeView(c1985hE);
            c1985hE = null;
        }
        if (c1985hE == null) {
            if (matrix == null) {
                matrix = new Matrix();
                c(view, viewGroup, matrix);
            }
            c1985hE = new C1985h(view);
            c1985hE.h(matrix);
            if (c1983fB == null) {
                c1983fB = new C1983f(viewGroup);
            } else {
                c1983fB.g();
            }
            d(viewGroup, c1983fB);
            d(viewGroup, c1985hE);
            c1983fB.a(c1985hE);
            c1985hE.d = i;
        } else if (matrix != null) {
            c1985hE.h(matrix);
        }
        c1985hE.d++;
        return c1985hE;
    }

    static void c(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        B.j(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        B.k(viewGroup, matrix);
    }

    static void d(View view, View view2) {
        B.g(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static C1985h e(View view) {
        return (C1985h) view.getTag(TB5.ghost_view);
    }

    static void f(View view) {
        C1985h c1985hE = e(view);
        if (c1985hE != null) {
            int i = c1985hE.d - 1;
            c1985hE.d = i;
            if (i <= 0) {
                ((C1983f) c1985hE.getParent()).removeView(c1985hE);
            }
        }
    }

    static void g(View view, C1985h c1985h) {
        view.setTag(TB5.ghost_view, c1985h);
    }

    @Override // androidx.transition.InterfaceC1982e
    public void a(ViewGroup viewGroup, View view) {
        this.a = viewGroup;
        this.b = view;
    }

    void h(Matrix matrix) {
        this.e = matrix;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super.onAttachedToWindow();
        g(this.c, this);
        this.c.getViewTreeObserver().addOnPreDrawListener(this.f);
        B.i(this.c, 4);
        if (this.c.getParent() != null) {
            ((View) this.c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        this.c.getViewTreeObserver().removeOnPreDrawListener(this.f);
        B.i(this.c, 0);
        g(this.c, null);
        if (this.c.getParent() != null) {
            ((View) this.c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        AbstractC1979b.a(canvas, true);
        canvas.setMatrix(this.e);
        B.i(this.c, 0);
        this.c.invalidate();
        B.i(this.c, 4);
        drawChild(canvas, this.c, getDrawingTime());
        AbstractC1979b.a(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View, androidx.transition.InterfaceC1982e
    public void setVisibility(int i) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super.setVisibility(i);
        if (e(this.c) == this) {
            B.i(this.c, i == 0 ? 4 : 0);
        }
    }
}
