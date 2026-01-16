package ir.nasim.tgwidgets.editor.ui.Components.Paint;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import ir.nasim.AbstractC22000uV3;
import ir.nasim.AbstractC23776xV3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.SD6;
import ir.nasim.X05;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.a;
import java.util.Vector;

/* loaded from: classes7.dex */
public class b {
    private static final InterpolatorC12631ew1 C = new InterpolatorC12631ew1(0.0d, 0.5d, 0.0d, 1.0d);
    private boolean A;
    private ir.nasim.tgwidgets.editor.ui.Components.Paint.a B;
    private RenderView a;
    private boolean b;
    private boolean c;
    private long d;
    private boolean e;
    private boolean f;
    private f g;
    private f h;
    private double i;
    private boolean j;
    private float k;
    private float l;
    private boolean m;
    private int o;
    private int p;
    private double q;
    private double r;
    private ValueAnimator s;
    private final r t;
    private Matrix u;
    private long w;
    private float x;
    private ValueAnimator y;
    private f[] n = new f[3];
    private float[] v = new float[2];
    private final Runnable z = new Runnable() { // from class: ir.nasim.n83
        @Override // java.lang.Runnable
        public final void run() {
            this.a.o();
        }
    };

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ f a;
        final /* synthetic */ float b;
        final /* synthetic */ ir.nasim.tgwidgets.editor.ui.Components.Paint.a c;
        final /* synthetic */ boolean d;
        final /* synthetic */ Runnable e;

        a(f fVar, float f, ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar, boolean z, Runnable runnable) {
            this.a = fVar;
            this.b = f;
            this.c = aVar;
            this.d = z;
            this.e = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.y = null;
            X05 x05 = new X05(new f[]{this.a});
            x05.f(b.this.a.getCurrentColor(), this.b * 1.0f, this.c);
            b.this.a.getPainting().L(x05, this.c.m() ? -1 : b.this.a.getCurrentColor(), this.d, null);
            if (this.d) {
                b.this.a.A(true);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.Paint.b$b, reason: collision with other inner class name */
    class C1589b extends AnimatorListenerAdapter {
        C1589b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!b.this.a.getCurrentBrush().m() || b.this.a.getUndoStore().b()) {
                b.this.a.getPainting().K(null, b.this.a.getCurrentColor());
            }
            b.this.s = null;
        }
    }

    public b(RenderView renderView) {
        this.a = renderView;
        this.t = new r(renderView.getContext(), new Utilities.b() { // from class: ir.nasim.o83
            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
            public final void a(Object obj) {
                this.a.y((ir.nasim.tgwidgets.editor.ui.Components.Paint.q) obj);
            }
        });
    }

    private void A(boolean z, float f) {
        int i = this.o;
        if (i <= 2) {
            f[] fVarArr = new f[i];
            System.arraycopy(this.n, 0, fVarArr, 0, i);
            u(new X05(fVarArr));
            return;
        }
        Vector vector = new Vector();
        f[] fVarArr2 = this.n;
        f fVar = fVarArr2[0];
        f fVar2 = fVarArr2[1];
        f fVar3 = fVarArr2[2];
        if (fVar3 == null || fVar2 == null || fVar == null) {
            return;
        }
        f fVarD = fVar2.d(fVar, 0.5d);
        f fVarD2 = fVar3.d(fVar2, 0.5d);
        int iMin = (int) Math.min(48.0d, Math.max(Math.floor(fVarD.b(fVarD2) / 1), 24.0d));
        float f2 = 1.0f / iMin;
        float f3 = 0.0f;
        int i2 = 0;
        while (i2 < iMin) {
            int i3 = i2;
            f fVarZ = z(fVarD, fVarD2, fVar2, f3, f);
            if (this.c) {
                fVarZ.d = true;
                this.c = false;
            }
            vector.add(fVarZ);
            this.q += fVarZ.c;
            this.r += 1.0d;
            f3 += f2;
            i2 = i3 + 1;
        }
        if (z) {
            fVarD2.d = true;
        }
        vector.add(fVarD2);
        f[] fVarArr3 = new f[vector.size()];
        vector.toArray(fVarArr3);
        u(new X05(fVarArr3));
        f[] fVarArr4 = this.n;
        System.arraycopy(fVarArr4, 1, fVarArr4, 0, 2);
        if (z) {
            this.o = 0;
        } else {
            this.o = 2;
        }
    }

    private void l(ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar, boolean z, Runnable runnable) {
        if (!this.m || this.g == null) {
            return;
        }
        if (aVar == null) {
            aVar = this.a.getCurrentBrush();
        }
        if ((aVar instanceof a.c) || (aVar instanceof a.e)) {
            aVar = new a.f();
        }
        final ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar2 = aVar;
        this.m = false;
        this.a.getPainting().H();
        this.o = 0;
        this.p = 0;
        this.j = false;
        this.b = false;
        if (z) {
            this.a.y();
        }
        SD6 sd6U = this.a.getPainting().U();
        f fVar = this.g;
        float fA = AbstractC23776xV3.a((float) fVar.a, (float) fVar.b, 0.0f, 0.0f);
        f fVar2 = this.g;
        float fMax = Math.max(fA, AbstractC23776xV3.a((float) fVar2.a, (float) fVar2.b, sd6U.a, 0.0f));
        f fVar3 = this.g;
        float fA2 = AbstractC23776xV3.a((float) fVar3.a, (float) fVar3.b, 0.0f, sd6U.b);
        f fVar4 = this.g;
        final float fMax2 = Math.max(fMax, Math.max(fA2, AbstractC23776xV3.a((float) fVar4.a, (float) fVar4.b, sd6U.a, sd6U.b))) / 0.84f;
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.s = null;
        }
        ValueAnimator valueAnimator2 = this.y;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.y = null;
        }
        f fVar5 = this.g;
        final f fVar6 = new f(fVar5.a, fVar5.b, 1.0d);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.y = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.k83
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                this.a.n(fVar6, aVar2, fMax2, valueAnimator3);
            }
        });
        this.y.addListener(new a(fVar6, fMax2, aVar2, z, runnable));
        this.y.setDuration(450L);
        this.y.setInterpolator(InterpolatorC12631ew1.h);
        this.y.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(f fVar, ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar, float f, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        X05 x05 = new X05(new f[]{fVar});
        x05.f(aVar.m() ? -1 : this.a.getCurrentColor(), fFloatValue * f, aVar);
        this.a.getPainting().p0(x05, true, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        l(null, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(X05 x05) {
        this.i = x05.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(final X05 x05) {
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.q83
            @Override // java.lang.Runnable
            public final void run() {
                this.a.p(x05);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(f fVar, float f, float f2, float[] fArr, double d, boolean[] zArr, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        double d2 = f;
        double d3 = d2 - 2.356194490192345d;
        double d4 = f2;
        double d5 = d2 - 2.5132741228718345d;
        f fVar2 = new f(fVar.a + (Math.cos(d3) * d4 * fArr[0]), fVar.b + (Math.sin(d5) * d4 * fArr[0]), d);
        double d6 = fVar.a;
        double dCos = Math.cos(d3) * d4;
        double d7 = fFloatValue;
        u(new X05(new f[]{fVar2, new f(d6 + (dCos * d7), fVar.b + (Math.sin(d5) * d4 * d7), d, true)}));
        double d8 = 2.356194490192345d + d2;
        double d9 = d2 + 2.5132741228718345d;
        u(new X05(new f[]{new f(fVar.a + (Math.cos(d8) * d4 * fArr[0]), fVar.b + (Math.sin(d9) * d4 * fArr[0]), d), new f(fVar.a + (Math.cos(d8) * d4 * d7), fVar.b + (Math.sin(d9) * d4 * d7), d, true)}));
        if (!zArr[0] && fFloatValue > 0.4f) {
            zArr[0] = true;
        }
        fArr[0] = fFloatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar = this.B;
        if (aVar != null) {
            this.a.F(aVar);
            this.B = null;
        }
    }

    private float t(float f, float f2, float f3) {
        double d = 1.0f - f3;
        double d2 = f;
        double d3 = f3;
        double d4 = f2;
        return (float) Math.atan2((Math.sin(d2) * d) + (Math.sin(d4) * d3), (d * Math.cos(d2)) + (d3 * Math.cos(d4)));
    }

    private void u(final X05 x05) {
        x05.f(this.a.getCurrentColor(), this.a.getCurrentWeight(), this.a.getCurrentBrush());
        if (this.f) {
            this.i = 0.0d;
        }
        x05.a = this.i;
        this.a.getPainting().p0(x05, this.f, false, new Runnable() { // from class: ir.nasim.p83
            @Override // java.lang.Runnable
            public final void run() {
                this.a.q(x05);
            }
        });
        this.f = false;
    }

    private void w() {
        this.o = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(q qVar) {
        if (qVar != null) {
            float currentWeight = this.a.getCurrentWeight();
            qVar.f = currentWeight;
            double d = this.q;
            if (d > 0.0d) {
                qVar.f = (float) (currentWeight * (d / this.r));
            }
            if (qVar.b() == 4) {
                qVar.k *= qVar.f;
            }
        }
        this.a.getPainting().B0(qVar);
    }

    private f z(f fVar, f fVar2, f fVar3, float f, float f2) {
        float f3 = 1.0f - f;
        double d = f3;
        double d2 = f * f;
        double d3 = f3 * f3;
        double d4 = f;
        return new f((fVar.a * d3) + (fVar3.a * 2.0d * d4 * d) + (fVar2.a * d2), (fVar.b * d3) + (fVar3.b * 2.0d * d4 * d) + (fVar2.b * d2), (((((fVar.c * Math.pow(d, 2.0d)) + (fVar3.c * ((2.0f * f3) * f))) + (fVar2.c * d2)) - 1.0d) * AbstractC21455b.T0(1.0f, f2, AbstractC22000uV3.a(this.p / 16.0f, 0.0f, 1.0f))) + 1.0d);
    }

    public void k(Runnable runnable) {
        this.g = new f(this.a.getPainting().U().a, 0.0d, 1.0d);
        this.m = true;
        l(new a.d(), false, runnable);
    }

    public void m() {
        this.A = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007c A[PHI: r6
      0x007c: PHI (r6v5 float) = (r6v4 float), (r6v25 float) binds: [B:8:0x005e, B:10:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void v(android.view.MotionEvent r22, float r23) {
        /*
            Method dump skipped, instructions count: 868
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.Paint.b.v(android.view.MotionEvent, float):void");
    }

    public void x(Matrix matrix) {
        Matrix matrix2 = new Matrix();
        this.u = matrix2;
        matrix.invert(matrix2);
    }
}
