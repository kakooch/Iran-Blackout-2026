package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeState;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.C10345bV3;
import ir.nasim.C5234Il7;
import ir.nasim.C7605Sk7;
import ir.nasim.WB5;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* loaded from: classes3.dex */
public class a extends Drawable implements C5234Il7.b {
    private static final int n = AbstractC21175tE5.Widget_MaterialComponents_Badge;
    private static final int o = AbstractC12181eA5.badgeStyle;
    private final WeakReference a;
    private final C10345bV3 b;
    private final C5234Il7 c;
    private final Rect d;
    private final BadgeState e;
    private float f;
    private float g;
    private int h;
    private float i;
    private float j;
    private float k;
    private WeakReference l;
    private WeakReference m;

    /* renamed from: com.google.android.material.badge.a$a, reason: collision with other inner class name */
    class RunnableC0176a implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ FrameLayout b;

        RunnableC0176a(View view, FrameLayout frameLayout) {
            this.a = view;
            this.b = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            a.this.B(this.a, this.b);
        }
    }

    private a(Context context, int i, int i2, int i3, BadgeState.State state) throws Resources.NotFoundException {
        this.a = new WeakReference(context);
        AbstractC5729Ko7.c(context);
        this.d = new Rect();
        this.b = new C10345bV3();
        C5234Il7 c5234Il7 = new C5234Il7(this);
        this.c = c5234Il7;
        c5234Il7.e().setTextAlign(Paint.Align.CENTER);
        y(AbstractC21175tE5.TextAppearance_MaterialComponents_Badge);
        this.e = new BadgeState(context, i, i2, i3, state);
        w();
    }

    private static void A(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void C() throws Resources.NotFoundException {
        Context context = (Context) this.a.get();
        WeakReference weakReference = this.l;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.d);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference weakReference2 = this.m;
        ViewGroup viewGroup = weakReference2 != null ? (FrameLayout) weakReference2.get() : null;
        if (viewGroup != null || b.a) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) view.getParent();
            }
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        b(context, rect2, view);
        b.f(this.d, this.f, this.g, this.j, this.k);
        this.b.Y(this.i);
        if (rect.equals(this.d)) {
            return;
        }
        this.b.setBounds(this.d);
    }

    private void D() {
        this.h = ((int) Math.pow(10.0d, j() - 1.0d)) - 1;
    }

    private void b(Context context, Rect rect, View view) throws Resources.NotFoundException {
        int iN = n();
        int iF = this.e.f();
        if (iF == 8388691 || iF == 8388693) {
            this.g = rect.bottom - iN;
        } else {
            this.g = rect.top + iN;
        }
        if (k() <= 9) {
            float f = !o() ? this.e.c : this.e.d;
            this.i = f;
            this.k = f;
            this.j = f;
        } else {
            float f2 = this.e.d;
            this.i = f2;
            this.k = f2;
            this.j = (this.c.f(f()) / 2.0f) + this.e.e;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(o() ? AbstractC12799fB5.mtrl_badge_text_horizontal_edge_offset : AbstractC12799fB5.mtrl_badge_horizontal_edge_offset);
        int iM = m();
        int iF2 = this.e.f();
        if (iF2 == 8388659 || iF2 == 8388691) {
            this.f = AbstractC12990fW7.A(view) == 0 ? (rect.left - this.j) + dimensionPixelSize + iM : ((rect.right + this.j) - dimensionPixelSize) - iM;
        } else {
            this.f = AbstractC12990fW7.A(view) == 0 ? ((rect.right + this.j) - dimensionPixelSize) - iM : (rect.left - this.j) + dimensionPixelSize + iM;
        }
    }

    public static a c(Context context) {
        return new a(context, 0, o, n, null);
    }

    static a d(Context context, BadgeState.State state) {
        return new a(context, 0, o, n, state);
    }

    private void e(Canvas canvas) {
        Rect rect = new Rect();
        String strF = f();
        this.c.e().getTextBounds(strF, 0, strF.length(), rect);
        canvas.drawText(strF, this.f, this.g + (rect.height() / 2), this.c.e());
    }

    private String f() {
        if (k() <= this.h) {
            return NumberFormat.getInstance(this.e.o()).format(k());
        }
        Context context = (Context) this.a.get();
        return context == null ? "" : String.format(this.e.o(), context.getString(AbstractC23026wD5.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.h), "+");
    }

    private int m() {
        return (o() ? this.e.k() : this.e.l()) + this.e.b();
    }

    private int n() {
        return (o() ? this.e.q() : this.e.r()) + this.e.c();
    }

    private void p() {
        this.c.e().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void q() {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.e.e());
        if (this.b.x() != colorStateListValueOf) {
            this.b.b0(colorStateListValueOf);
            invalidateSelf();
        }
    }

    private void r() throws Resources.NotFoundException {
        WeakReference weakReference = this.l;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.l.get();
        WeakReference weakReference2 = this.m;
        B(view, weakReference2 != null ? (FrameLayout) weakReference2.get() : null);
    }

    private void s() {
        this.c.e().setColor(this.e.g());
        invalidateSelf();
    }

    private void t() throws Resources.NotFoundException {
        D();
        this.c.i(true);
        C();
        invalidateSelf();
    }

    private void u() throws Resources.NotFoundException {
        this.c.i(true);
        C();
        invalidateSelf();
    }

    private void v() {
        boolean zT = this.e.t();
        setVisible(zT, false);
        if (!b.a || h() == null || zT) {
            return;
        }
        ((ViewGroup) h().getParent()).invalidate();
    }

    private void w() throws Resources.NotFoundException {
        t();
        u();
        p();
        q();
        s();
        r();
        C();
        v();
    }

    private void x(C7605Sk7 c7605Sk7) throws Resources.NotFoundException {
        Context context;
        if (this.c.d() == c7605Sk7 || (context = (Context) this.a.get()) == null) {
            return;
        }
        this.c.h(c7605Sk7, context);
        C();
    }

    private void y(int i) throws Resources.NotFoundException {
        Context context = (Context) this.a.get();
        if (context == null) {
            return;
        }
        x(new C7605Sk7(context, i));
    }

    private void z(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != WB5.mtrl_anchor_parent) {
            WeakReference weakReference = this.m;
            if (weakReference == null || weakReference.get() != viewGroup) {
                A(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(WB5.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int iIndexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(iIndexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, iIndexOfChild);
                this.m = new WeakReference(frameLayout);
                frameLayout.post(new RunnableC0176a(view, frameLayout));
            }
        }
    }

    public void B(View view, FrameLayout frameLayout) throws Resources.NotFoundException {
        this.l = new WeakReference(view);
        boolean z = b.a;
        if (z && frameLayout == null) {
            z(view);
        } else {
            this.m = new WeakReference(frameLayout);
        }
        if (!z) {
            A(view);
        }
        C();
        invalidateSelf();
    }

    @Override // ir.nasim.C5234Il7.b
    public void a() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.b.draw(canvas);
        if (o()) {
            e(canvas);
        }
    }

    public CharSequence g() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!o()) {
            return this.e.i();
        }
        if (this.e.j() == 0 || (context = (Context) this.a.get()) == null) {
            return null;
        }
        return k() <= this.h ? context.getResources().getQuantityString(this.e.j(), k(), Integer.valueOf(k())) : context.getString(this.e.h(), Integer.valueOf(this.h));
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public FrameLayout h() {
        WeakReference weakReference = this.m;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    public int i() {
        return this.e.l();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public int j() {
        return this.e.m();
    }

    public int k() {
        if (o()) {
            return this.e.n();
        }
        return 0;
    }

    BadgeState.State l() {
        return this.e.p();
    }

    public boolean o() {
        return this.e.s();
    }

    @Override // android.graphics.drawable.Drawable, ir.nasim.C5234Il7.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.e.v(i);
        p();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
