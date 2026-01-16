package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.view.View;
import androidx.annotation.Keep;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.YE2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.CheckBoxBase;

/* loaded from: classes7.dex */
public class CheckBoxBase {
    private static Paint B;
    private static Paint C;
    private static Paint D;
    public long A;
    private View a;
    private Paint d;
    private Paint e;
    private TextPaint f;
    private boolean j;
    private boolean l;
    private float m;
    private ObjectAnimator n;
    private boolean o;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private int u;
    private float v;
    private String w;
    private m.f x;
    private m.h y;
    private YE2 z;
    public Rect b = new Rect();
    private RectF c = new RectF();
    private float g = 1.0f;
    private Path h = new Path();
    private boolean i = true;
    private float k = 1.0f;
    private int p = ir.nasim.tgwidgets.editor.ui.ActionBar.m.T5;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator.equals(CheckBoxBase.this.n)) {
                CheckBoxBase.this.n = null;
            }
            if (CheckBoxBase.this.o) {
                return;
            }
            CheckBoxBase.this.w = null;
        }
    }

    public interface b {
    }

    public CheckBoxBase(View view, int i, m.h hVar) {
        int i2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.Oa;
        this.q = i2;
        this.r = i2;
        this.t = true;
        this.z = new YE2() { // from class: ir.nasim.lS0
            @Override // ir.nasim.YE2
            public final Object a(Object obj) {
                return CheckBoxBase.l((Void) obj);
            }
        };
        this.A = 200L;
        this.y = hVar;
        this.a = view;
        this.v = i;
        if (B == null) {
            B = new Paint(1);
            Paint paint = new Paint(1);
            C = paint;
            paint.setColor(0);
            C.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        Paint paint2 = new Paint(1);
        this.d = paint2;
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = this.d;
        Paint.Style style = Paint.Style.STROKE;
        paint3.setStyle(style);
        this.d.setStrokeJoin(Paint.Join.ROUND);
        this.d.setStrokeWidth(AbstractC21455b.F(1.9f));
        Paint paint4 = new Paint(1);
        this.e = paint4;
        paint4.setStyle(style);
        this.e.setStrokeWidth(AbstractC21455b.F(1.2f));
    }

    private void f(boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "progress", z ? 1.0f : 0.0f);
        this.n = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addListener(new a());
        this.n.setInterpolator(InterpolatorC12631ew1.g);
        this.n.setDuration(this.A);
        this.n.start();
    }

    private void g() {
        ObjectAnimator objectAnimator = this.n;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.n = null;
        }
    }

    private int i(int i) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.y);
    }

    private void j() {
        if (this.a.getParent() != null) {
            ((View) this.a.getParent()).invalidate();
        }
        this.a.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Paint l(Void r0) {
        return B;
    }

    @Keep
    public float getProgress() {
        return this.m;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:207:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(android.graphics.Canvas r27) {
        /*
            Method dump skipped, instructions count: 1378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.CheckBoxBase.h(android.graphics.Canvas):void");
    }

    public boolean k() {
        return this.o;
    }

    public void m() {
        this.j = true;
    }

    public void n() {
        this.j = false;
    }

    public void o(int i) {
        this.u = i;
        if (i == 12 || i == 13) {
            this.e.setStrokeWidth(AbstractC21455b.F(1.0f));
            return;
        }
        if (i == 4 || i == 5) {
            this.e.setStrokeWidth(AbstractC21455b.F(1.9f));
            if (i == 5) {
                this.d.setStrokeWidth(AbstractC21455b.F(1.5f));
                return;
            }
            return;
        }
        if (i == 3) {
            this.e.setStrokeWidth(AbstractC21455b.F(3.0f));
        } else if (i != 0) {
            this.e.setStrokeWidth(AbstractC21455b.F(1.5f));
        }
    }

    public void p(int i, int i2, int i3, int i4) {
        Rect rect = this.b;
        rect.left = i;
        rect.top = i2;
        rect.right = i + i3;
        rect.bottom = i2 + i4;
    }

    public void q(int i, boolean z, boolean z2) {
        if (i >= 0) {
            this.w = "" + (i + 1);
            j();
        }
        if (z == this.o) {
            return;
        }
        this.o = z;
        if (this.j && z2) {
            f(z);
        } else {
            g();
            setProgress(z ? 1.0f : 0.0f);
        }
    }

    public void r(boolean z, boolean z2) {
        q(-1, z, z2);
    }

    public void s(YE2 ye2) {
        this.z = ye2;
    }

    @Keep
    public void setProgress(float f) {
        if (this.m == f) {
            return;
        }
        this.m = f;
        j();
    }

    public void t(int i, int i2, int i3) {
        this.q = i;
        this.r = i2;
        this.p = i3;
        j();
    }

    public void u(boolean z) {
        this.t = z;
    }

    public void v(boolean z) {
        this.i = z;
    }

    public void w(boolean z) {
        if (this.l == z) {
            return;
        }
        this.l = z;
        j();
    }

    public void x(int i) {
        if (i >= 0) {
            this.w = "" + (i + 1);
        } else if (this.n == null) {
            this.w = null;
        }
        j();
    }

    public void y(b bVar) {
    }
}
