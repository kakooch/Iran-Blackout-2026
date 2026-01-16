package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h;

/* loaded from: classes7.dex */
public class ZoomControlView extends View {
    private Drawable a;
    private Drawable b;
    private Drawable c;
    private Drawable d;
    private Drawable e;
    private Drawable f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private float o;
    private boolean p;
    private boolean q;
    private float r;
    private float s;
    private float t;
    private AnimatorSet u;
    private c v;
    public boolean w;
    public final Property x;

    class a extends AbstractC21469h.e {
        a(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(ZoomControlView zoomControlView) {
            return Float.valueOf(ZoomControlView.this.o);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(ZoomControlView zoomControlView, float f) {
            ZoomControlView.this.o = f;
            if (ZoomControlView.this.v != null) {
                ZoomControlView.this.v.a(ZoomControlView.this.o);
            }
            ZoomControlView.this.invalidate();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ZoomControlView.this.u = null;
        }
    }

    public interface c {
        void a(float f);
    }

    public ZoomControlView(Context context) {
        super(context);
        this.w = true;
        this.x = new a("clipProgress");
        this.a = context.getResources().getDrawable(AbstractC23598xB5.zoom_minus);
        this.b = context.getResources().getDrawable(AbstractC23598xB5.zoom_plus);
        this.c = context.getResources().getDrawable(AbstractC23598xB5.zoom_slide);
        this.d = context.getResources().getDrawable(AbstractC23598xB5.zoom_slide_a);
        this.e = context.getResources().getDrawable(AbstractC23598xB5.zoom_round);
        this.f = context.getResources().getDrawable(AbstractC23598xB5.zoom_round_b);
    }

    private boolean e(float f) {
        if (f < 0.0f || f > 1.0f) {
            return false;
        }
        AnimatorSet animatorSet = this.u;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.t = f;
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.u = animatorSet2;
        animatorSet2.playTogether(ObjectAnimator.ofFloat(this, (Property<ZoomControlView, Float>) this.x, f));
        this.u.setDuration(180L);
        this.u.addListener(new b());
        this.u.start();
        return true;
    }

    public boolean f() {
        return this.p || this.q;
    }

    public float getZoom() {
        return this.u != null ? this.t : this.o;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth() / 2;
        int measuredHeight = getMeasuredHeight() / 2;
        boolean z = getMeasuredWidth() > getMeasuredHeight();
        if (z) {
            this.g = AbstractC21455b.F(41.0f);
            this.h = measuredHeight;
            this.i = getMeasuredWidth() - AbstractC21455b.F(41.0f);
            this.j = measuredHeight;
            this.k = this.g + AbstractC21455b.F(18.0f);
            this.l = measuredHeight;
            this.m = this.i - AbstractC21455b.F(18.0f);
            this.n = measuredHeight;
        } else {
            this.g = measuredWidth;
            this.h = AbstractC21455b.F(41.0f);
            this.i = measuredWidth;
            this.j = getMeasuredHeight() - AbstractC21455b.F(41.0f);
            this.k = measuredWidth;
            this.l = this.h + AbstractC21455b.F(18.0f);
            this.m = measuredWidth;
            this.n = this.j - AbstractC21455b.F(18.0f);
        }
        this.a.setBounds(this.g - AbstractC21455b.F(7.0f), this.h - AbstractC21455b.F(7.0f), this.g + AbstractC21455b.F(7.0f), this.h + AbstractC21455b.F(7.0f));
        this.a.draw(canvas);
        this.b.setBounds(this.i - AbstractC21455b.F(7.0f), this.j - AbstractC21455b.F(7.0f), this.i + AbstractC21455b.F(7.0f), this.j + AbstractC21455b.F(7.0f));
        this.b.draw(canvas);
        int i = this.m;
        int i2 = this.k;
        int i3 = this.n;
        int i4 = this.l;
        float f = this.o;
        int i5 = (int) (i2 + ((i - i2) * f));
        int i6 = (int) (i4 + ((i3 - i4) * f));
        if (z) {
            this.c.setBounds(i2, i4 - AbstractC21455b.F(3.0f), this.m, this.l + AbstractC21455b.F(3.0f));
            this.d.setBounds(this.k, this.l - AbstractC21455b.F(3.0f), i5, this.l + AbstractC21455b.F(3.0f));
        } else {
            this.c.setBounds(i4, 0, i3, AbstractC21455b.F(6.0f));
            this.d.setBounds(this.l, 0, i6, AbstractC21455b.F(6.0f));
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, (-this.k) - AbstractC21455b.F(3.0f));
        }
        this.c.draw(canvas);
        this.d.draw(canvas);
        if (!z) {
            canvas.restore();
        }
        Drawable drawable = this.q ? this.f : this.e;
        int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
        drawable.setBounds(i5 - intrinsicWidth, i6 - intrinsicWidth, i5 + intrinsicWidth, i6 + intrinsicWidth);
        drawable.draw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.ZoomControlView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setDelegate(c cVar) {
        this.v = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000c A[PHI: r0
      0x000c: PHI (r0v4 float) = (r0v2 float), (r0v3 float) binds: [B:6:0x000a, B:9:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setZoom(float r3, boolean r4) {
        /*
            r2 = this;
            float r0 = r2.o
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 != 0) goto L7
            return
        L7:
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto Le
        Lc:
            r3 = r0
            goto L15
        Le:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L15
            goto Lc
        L15:
            r2.o = r3
            if (r4 == 0) goto L20
            ir.nasim.tgwidgets.editor.ui.Components.ZoomControlView$c r4 = r2.v
            if (r4 == 0) goto L20
            r4.a(r3)
        L20:
            r2.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.ZoomControlView.setZoom(float, boolean):void");
    }
}
