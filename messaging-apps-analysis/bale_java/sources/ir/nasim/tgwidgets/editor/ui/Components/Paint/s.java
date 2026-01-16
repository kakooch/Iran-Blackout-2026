package ir.nasim.tgwidgets.editor.ui.Components.Paint;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import ir.nasim.AbstractC23776xV3;
import ir.nasim.C22477vI7;
import ir.nasim.SD6;
import ir.nasim.T45;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.a;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class s {
    private RenderView a;
    private Runnable b;
    private q h;
    private float i;
    private float j;
    private j k;
    private j l;
    private Matrix o;
    private Paint c = new Paint(1);
    private Paint d = new Paint(1);
    private Paint e = new Paint(1);
    private Paint f = new Paint(1);
    private Paint g = new Paint(1);
    private ArrayList m = new ArrayList();
    private ArrayList n = new ArrayList();
    private float[] p = new float[2];

    class a extends j {
        a() {
            super();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        void a() {
            double dAtan2 = Math.atan2(s.this.h.c - s.this.h.j, s.this.h.b - s.this.h.i) + 3.141592653589793d;
            double d = s.this.h.k / 5.5f;
            b(s.this.h.b + ((float) (Math.cos(dAtan2) * d)), s.this.h.c + ((float) (Math.sin(dAtan2) * d)));
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        protected void c(float f, float f2) {
            double dAtan2 = Math.atan2(s.this.h.c - s.this.h.j, s.this.h.b - s.this.h.i) + 1.5707963267948966d;
            float fA = (AbstractC23776xV3.a(s.this.h.b, s.this.h.c, s.this.h.i, s.this.h.j) * 5.5f) / 2.0f;
            q qVar = s.this.h;
            s sVar = s.this;
            qVar.k = Math.min(fA, Math.max(100.0f, (-sVar.h(f, f2, sVar.h.b, s.this.h.c, dAtan2)) * 5.5f));
            a();
        }
    }

    class b extends j {
        final /* synthetic */ j g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(j jVar) {
            super();
            this.g = jVar;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        void a() {
            b(s.this.h.i, s.this.h.j);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        protected void c(float f, float f2) {
            s.this.h.i = f;
            s.this.h.j = f2;
            super.c(f, f2);
            this.g.a();
        }
    }

    class c extends j {
        final /* synthetic */ j g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(j jVar) {
            super();
            this.g = jVar;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        void a() {
            b(s.this.h.d, s.this.h.e);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        protected void c(float f, float f2) {
            s.this.h.d = f;
            s.this.h.e = f2;
            super.c(f, f2);
            this.g.a();
        }
    }

    class d extends j {
        d() {
            super();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        void a() {
            b(s.this.h.b + s.this.h.d, s.this.h.c);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        protected void c(float f, float f2) {
            super.c(f, f2);
            q qVar = s.this.h;
            q qVar2 = s.this.h;
            float fA = AbstractC23776xV3.a(s.this.h.b, s.this.h.c, f, f2);
            qVar2.e = fA;
            qVar.d = fA;
        }
    }

    class e extends j {
        final int g;

        e() {
            super();
            this.g = 5;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        void a() {
            float fMin = Math.min(s.this.h.d, s.this.h.e);
            b(s.this.h.b + (((float) Math.cos(-0.3141592653589793d)) * fMin), s.this.h.c + (((float) Math.sin(-0.3141592653589793d)) * fMin));
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        protected void c(float f, float f2) {
            q qVar = s.this.h;
            q qVar2 = s.this.h;
            float fA = AbstractC23776xV3.a(s.this.h.b, s.this.h.c, f, f2);
            qVar2.e = fA;
            qVar.d = fA;
            s.this.h.h = (float) (r0.h + (((float) Math.atan2(s.this.h.c - f2, f - s.this.h.b)) - 0.3141592653589793d));
            a();
        }
    }

    class f extends j {
        f(boolean z) {
            super(z);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        void a() {
            b(s.this.h.b, s.this.h.c - Math.abs(s.this.h.e));
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        protected void c(float f, float f2) {
            s.this.h.h = (float) (r0.h + (((float) Math.atan2(s.this.h.c - f2, f - s.this.h.b)) - 1.5707963267948966d));
            for (int i = 0; i < s.this.m.size(); i++) {
                j jVar = (j) s.this.m.get(i);
                if (jVar instanceof i) {
                    jVar.a();
                }
            }
        }
    }

    class g extends j {
        g() {
            super();
        }

        private void d() {
            if (this.e > s.this.h.c - s.this.h.e && this.e < s.this.h.c + s.this.h.e) {
                if (this.d <= s.this.h.b && this.d > s.this.h.b - s.this.h.d) {
                    this.d = s.this.h.b - s.this.h.d;
                } else if (this.d > s.this.h.c && this.d < s.this.h.b + s.this.h.d) {
                    this.d = s.this.h.b + s.this.h.d;
                }
            }
            if (this.d <= s.this.h.b - s.this.h.d || this.d >= s.this.h.b + s.this.h.d) {
                return;
            }
            if (this.e <= s.this.h.c && this.e > s.this.h.c - s.this.h.e) {
                this.e = s.this.h.c - s.this.h.e;
            } else {
                if (this.e <= s.this.h.c || this.e >= s.this.h.c + s.this.h.e) {
                    return;
                }
                this.e = s.this.h.c + s.this.h.e;
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        void a() {
            b(s.this.h.i, s.this.h.j);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        void b(float f, float f2) {
            s.this.h.i = f;
            s.this.h.j = f2;
            super.b(f, f2);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        protected void c(float f, float f2) {
            b(f, f2);
            d();
            s.this.h.i = this.d;
            s.this.h.j = this.e;
        }
    }

    class h extends j {
        h(boolean z) {
            super(z);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        void a() {
            this.d = s.this.h.b;
            this.e = s.this.h.c;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        protected void c(float f, float f2) {
            for (int i = 0; i < s.this.m.size(); i++) {
                j jVar = (j) s.this.m.get(i);
                if (jVar != this) {
                    jVar.a();
                }
            }
            s.this.h.b = f;
            s.this.h.c = f2;
            super.c(f, f2);
        }
    }

    private class i extends j {
        public q g;
        public float h;
        public float i;

        public i(q qVar, boolean z, boolean z2) {
            super();
            this.b = false;
            this.g = qVar;
            this.h = z ? -1.0f : 1.0f;
            this.i = z2 ? -1.0f : 1.0f;
            a();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        void a() {
            q qVar = this.g;
            if (qVar != null) {
                s.this.o(qVar.b + (this.h * qVar.d), qVar.c + (this.i * qVar.e), true);
                b(s.this.p[0], s.this.p[1]);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.s.j
        protected void c(float f, float f2) {
            super.c(f, f2);
            q qVar = this.g;
            float f3 = qVar.b + ((-this.h) * qVar.d);
            float f4 = qVar.c + ((-this.i) * qVar.e);
            s.this.o(f, f2, false);
            s.this.o(f3, f4, true);
            float f5 = s.this.p[0];
            float f6 = s.this.p[1];
            double dAtan2 = (3.141592653589793d - Math.atan2(f2 - f6, f - f5)) - this.g.h;
            double dCos = Math.cos(dAtan2) * AbstractC23776xV3.a(f, f2, f5, f6);
            double dSin = Math.sin(dAtan2) * AbstractC23776xV3.a(f, f2, f5, f6);
            this.g.d = ((float) Math.abs(dCos)) / 2.0f;
            this.g.e = ((float) Math.abs(dSin)) / 2.0f;
            q qVar2 = this.g;
            qVar2.b = (f + f5) / 2.0f;
            qVar2.c = (f2 + f6) / 2.0f;
            for (int i = 0; i < s.this.m.size(); i++) {
                ((j) s.this.m.get(i)).a();
            }
        }
    }

    public s(RenderView renderView, Runnable runnable) {
        this.a = renderView;
        this.b = runnable;
        this.d.setColor(-13840296);
        Paint paint = this.e;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.e.setColor(-1);
        this.e.setStrokeWidth(AbstractC21455b.F(1.0f));
        this.f.setColor(-16745729);
        this.g.setStyle(style);
        this.g.setColor(-1);
        this.g.setStrokeWidth(AbstractC21455b.F(1.0f));
        this.c.setStyle(style);
        this.c.setColor(-1);
        this.c.setStrokeWidth(AbstractC21455b.F(0.8f));
        this.c.setPathEffect(new DashPathEffect(new float[]{AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f)}, 0.0f));
        this.c.setShadowLayer(4.0f, 0.0f, 1.5f, 1073741824);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float h(float f2, float f3, float f4, float f5, double d2) {
        return (float) ((Math.cos(d2) * (f5 - f3)) - (Math.sin(d2) * (f4 - f2)));
    }

    private float i(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f6 - f4;
        float f9 = f7 - f5;
        float fMax = Math.max(Math.min((((f2 - f4) * f8) + ((f3 - f5) * f9)) / ((f8 * f8) + (f9 * f9)), 1.0f), 0.0f);
        float f10 = (f4 + (f8 * fMax)) - f2;
        float f11 = (f5 + (fMax * f9)) - f3;
        return (float) Math.sqrt((f10 * f10) + (f11 * f11));
    }

    private void j(Canvas canvas, SD6 sd6, j jVar) {
        canvas.drawCircle((jVar.d / sd6.a) * canvas.getWidth(), (jVar.e / sd6.b) * canvas.getHeight(), AbstractC21455b.F(5.0f), jVar.a ? this.d : this.f);
        canvas.drawCircle((jVar.d / sd6.a) * canvas.getWidth(), (jVar.e / sd6.b) * canvas.getHeight(), AbstractC21455b.F(5.0f), jVar.a ? this.e : this.g);
    }

    private boolean k(float f2, float f3) {
        q qVar = this.h;
        if (qVar == null) {
            return false;
        }
        if (qVar.b() == 0 || this.h.b() == 2) {
            double dSqrt = Math.sqrt(Math.pow(f2 - this.h.b, 2.0d) + Math.pow(f3 - this.h.c, 2.0d));
            q qVar2 = this.h;
            return (dSqrt - ((double) Math.min(qVar2.d, qVar2.e))) - ((double) (this.h.f / 2.0f)) < ((double) AbstractC21455b.F(30.0f));
        }
        if (this.h.b() != 1 && this.h.b() != 3) {
            if (this.h.b() != 4) {
                return false;
            }
            SD6 sd6U = this.a.getPainting().U();
            q qVar3 = this.h;
            float fI = i(f2, f3, qVar3.b, qVar3.c, qVar3.i, qVar3.j);
            q qVar4 = this.h;
            return Math.min(fI, i(f2, f3, qVar4.d, qVar4.e, qVar4.i, qVar4.j)) - (this.h.f / 2.0f) < Math.min(sd6U.a, sd6U.b) * 0.1f;
        }
        q qVar5 = this.h;
        float f4 = qVar5.b;
        float f5 = qVar5.d;
        float f6 = qVar5.f;
        float f7 = (f4 - f5) - (f6 / 2.0f);
        float f8 = qVar5.c;
        float f9 = qVar5.e;
        float f10 = (f8 - f9) - (f6 / 2.0f);
        float f11 = f4 + f5 + (f6 / 2.0f);
        float f12 = f8 + f9 + (f6 / 2.0f);
        float fSqrt = 0.0f;
        if (f3 <= f10 || f3 >= f12) {
            if (f2 >= f7 || f2 <= f11) {
                double d2 = f2 - f7;
                double d3 = f3 - f10;
                double d4 = f2 - f11;
                double d5 = f3 - f12;
                fSqrt = (float) Math.sqrt(Math.min(Math.min(Math.pow(d2, 2.0d) + Math.pow(d3, 2.0d), Math.pow(d4, 2.0d) + Math.pow(d3, 2.0d)), Math.min(Math.pow(d2, 2.0d) + Math.pow(d5, 2.0d), Math.pow(d4, 2.0d) + Math.pow(d5, 2.0d))));
            } else if (f3 < f10) {
                fSqrt = f10 - f3;
            } else if (f3 > f12) {
                fSqrt = f3 - f12;
            }
        } else if (f2 < f7) {
            fSqrt = f7 - f2;
        } else if (f2 > f11) {
            fSqrt = f2 - f11;
        }
        float fMin = fSqrt;
        if (this.h.b() == 3) {
            q qVar6 = this.h;
            fMin = Math.min(fMin, i(f2, f3, qVar6.b, qVar6.c, qVar6.i, qVar6.j));
        }
        return fMin < ((float) AbstractC21455b.F(30.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(float f2, float f3, boolean z) {
        float[] fArr = this.p;
        fArr[0] = f2;
        fArr[1] = f3;
        p(z);
    }

    private void p(boolean z) {
        q qVar = this.h;
        if (qVar != null) {
            float f2 = qVar.h;
            if (f2 != 0.0f) {
                float[] fArr = this.p;
                float f3 = fArr[0] - qVar.b;
                fArr[0] = f3;
                fArr[1] = fArr[1] - qVar.c;
                double d2 = f2 * (z ? -1 : 1);
                float fCos = (float) ((f3 * Math.cos(d2)) - (this.p[1] * Math.sin(d2)));
                float fSin = (float) ((this.p[0] * Math.sin(d2)) + (this.p[1] * Math.cos(d2)));
                float[] fArr2 = this.p;
                q qVar2 = this.h;
                fArr2[0] = fCos + qVar2.b;
                fArr2[1] = fSin + qVar2.c;
            }
        }
    }

    public void f() {
        RenderView renderView = this.a;
        if (renderView == null || renderView.getPainting() == null || this.h == null) {
            return;
        }
        this.a.getPainting().G();
        this.m.clear();
        this.n.clear();
        this.h = null;
    }

    public void g(Canvas canvas) {
        RenderView renderView = this.a;
        if (renderView == null || renderView.getPainting() == null) {
            return;
        }
        SD6 sd6U = this.a.getPainting().U();
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            j jVar = (j) this.m.get(i2);
            if (jVar.c && !jVar.b) {
                j(canvas, sd6U, jVar);
            }
        }
        q qVar = this.h;
        if (qVar != null && qVar.h != 0.0f) {
            canvas.save();
            canvas.rotate((float) (((-r2.h) / 3.141592653589793d) * 180.0d), (this.h.b / sd6U.a) * canvas.getWidth(), (this.h.c / sd6U.b) * canvas.getHeight());
        }
        q qVar2 = this.h;
        if (qVar2 != null && qVar2.b() == 4) {
            canvas.drawLine((this.h.b / sd6U.a) * canvas.getWidth(), (this.h.c / sd6U.b) * canvas.getHeight(), (this.h.i / sd6U.a) * canvas.getWidth(), (this.h.j / sd6U.b) * canvas.getHeight(), this.c);
            canvas.drawLine((this.h.d / sd6U.a) * canvas.getWidth(), (this.h.e / sd6U.b) * canvas.getHeight(), (this.h.i / sd6U.a) * canvas.getWidth(), (this.h.j / sd6U.b) * canvas.getHeight(), this.c);
        }
        for (int i3 = 0; i3 < this.m.size(); i3++) {
            j jVar2 = (j) this.m.get(i3);
            if (jVar2.c && jVar2.b) {
                j(canvas, sd6U, jVar2);
            }
        }
        q qVar3 = this.h;
        if (qVar3 == null || qVar3.h == 0.0f) {
            return;
        }
        canvas.restore();
    }

    public void l() {
        if (this.h != null) {
            this.a.getPainting().o0(this.h, null);
        }
    }

    public void m() {
        q qVar = this.h;
        if (qVar == null || qVar.f == this.a.getCurrentWeight()) {
            return;
        }
        this.h.f = this.a.getCurrentWeight();
        this.a.getPainting().o0(this.h, null);
    }

    public void n(MotionEvent motionEvent, float f2) {
        RenderView renderView = this.a;
        if (renderView == null || renderView.getPainting() == null || this.h == null) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float height = this.a.getHeight() - motionEvent.getY();
        float[] fArr = this.p;
        fArr[0] = x;
        fArr[1] = height;
        this.o.mapPoints(fArr);
        float[] fArr2 = this.p;
        float f3 = fArr2[0];
        float f4 = fArr2[1];
        this.b.run();
        j jVar = null;
        if (actionMasked != 0) {
            if (actionMasked != 2) {
                if (actionMasked == 1 || actionMasked == 3) {
                    this.k = null;
                    return;
                }
                return;
            }
            j jVar2 = this.k;
            if (jVar2 == null) {
                j jVar3 = this.l;
                if (jVar3 != null) {
                    if (jVar3.b) {
                        o(f3, f4, false);
                    }
                    float[] fArr3 = this.p;
                    float f5 = fArr3[0] + this.i;
                    j jVar4 = this.l;
                    float f6 = f5 - jVar4.d;
                    float f7 = (fArr3[1] + this.j) - jVar4.e;
                    for (int i2 = 0; i2 < this.n.size(); i2++) {
                        j jVar5 = (j) this.n.get(i2);
                        jVar5.c(jVar5.d + f6, jVar5.e + f7);
                    }
                }
            } else {
                if (jVar2.b) {
                    p(false);
                }
                j jVar6 = this.k;
                float[] fArr4 = this.p;
                jVar6.c(fArr4[0] + this.i, fArr4[1] + this.j);
            }
            this.a.getPainting().o0(this.h, null);
            this.b.run();
            return;
        }
        double d2 = Double.MAX_VALUE;
        for (int i3 = 0; i3 < this.m.size(); i3++) {
            j jVar7 = (j) this.m.get(i3);
            if (jVar7.c) {
                float[] fArr5 = this.p;
                fArr5[0] = f3;
                fArr5[1] = f4;
                if (jVar7.b) {
                    o(f3, f4, false);
                }
                float f8 = jVar7.d;
                float f9 = jVar7.e;
                float[] fArr6 = this.p;
                double dA = AbstractC23776xV3.a(f8, f9, fArr6[0], fArr6[1]);
                if (dA < AbstractC21455b.F(40.0f) && (jVar == null || dA < d2)) {
                    jVar = jVar7;
                    d2 = dA;
                }
            }
        }
        float[] fArr7 = this.p;
        fArr7[0] = f3;
        fArr7[1] = f4;
        o(f3, f4, false);
        if (jVar == null && !k(f3, f4)) {
            s();
            return;
        }
        float[] fArr8 = this.p;
        fArr8[0] = f3;
        fArr8[1] = f4;
        this.k = jVar;
        if (jVar != null) {
            if (jVar.b) {
                o(f3, f4, false);
            }
            j jVar8 = this.k;
            float f10 = jVar8.d;
            float[] fArr9 = this.p;
            this.i = f10 - fArr9[0];
            this.j = jVar8.e - fArr9[1];
            return;
        }
        j jVar9 = this.l;
        if (jVar9 != null) {
            if (jVar9.b) {
                o(f3, f4, false);
            }
            j jVar10 = this.l;
            float f11 = jVar10.d;
            float[] fArr10 = this.p;
            this.i = f11 - fArr10[0];
            this.j = jVar10.e - fArr10[1];
        }
    }

    public void q(Matrix matrix) {
        Matrix matrix2 = new Matrix();
        this.o = matrix2;
        matrix.invert(matrix2);
    }

    public void r(int i2) {
        RenderView renderView = this.a;
        if (renderView == null || renderView.getPainting() == null) {
            return;
        }
        this.m.clear();
        this.n.clear();
        this.h = new q(a.g.q(i2));
        SD6 sd6U = this.a.getPainting().U();
        q qVar = this.h;
        float f2 = sd6U.a;
        qVar.b = f2 / 2.0f;
        float f3 = sd6U.b;
        qVar.c = f3 / 2.0f;
        float fMin = Math.min(f2, f3) / 5.0f;
        qVar.e = fMin;
        qVar.d = fMin;
        this.h.f = this.a.getCurrentWeight();
        this.h.g = AbstractC21455b.F(32.0f);
        this.h.l = T45.h(C22477vI7.f).g();
        if (this.h.b() == 4) {
            q qVar2 = this.h;
            float f4 = sd6U.a / 2.0f;
            qVar2.i = f4;
            qVar2.d = f4;
            qVar2.b = f4;
            qVar2.i = f4 + 1.0f;
            float f5 = sd6U.b;
            float f6 = (f5 / 3.0f) * 1.0f;
            qVar2.c = f6;
            float f7 = f5 / 2.0f;
            qVar2.j = f7;
            qVar2.e = (f5 / 3.0f) * 2.0f;
            qVar2.k = Math.abs(f6 - f7);
            ArrayList arrayList = this.m;
            a aVar = new a();
            arrayList.add(aVar);
            ArrayList arrayList2 = this.m;
            b bVar = new b(aVar);
            arrayList2.add(bVar);
            this.n.add(bVar);
            ArrayList arrayList3 = this.m;
            c cVar = new c(aVar);
            arrayList3.add(cVar);
            this.n.add(cVar);
        }
        if (this.h.b() == 0) {
            this.m.add(new d());
        }
        if (this.h.b() == 2) {
            this.m.add(new e());
        }
        if (this.h.b() == 1 || this.h.b() == 3) {
            this.m.add(new i(this.h, false, false));
            this.m.add(new i(this.h, true, false));
            this.m.add(new i(this.h, false, true));
            this.m.add(new i(this.h, true, true));
            this.m.add(new f(true));
        }
        if (this.h.b() == 3) {
            q qVar3 = this.h;
            qVar3.i = qVar3.b + (qVar3.d * 0.8f);
            qVar3.j = qVar3.c + (qVar3.e * 1.2f) + qVar3.f;
            ArrayList arrayList4 = this.m;
            g gVar = new g();
            arrayList4.add(gVar);
            gVar.b = false;
            this.n.add(gVar);
        }
        this.l = new h(true);
        if (this.h.b() != 4) {
            this.l.c = false;
        }
        j jVar = this.l;
        jVar.b = false;
        this.n.add(jVar);
        this.m.add(this.l);
        this.a.getPainting().o0(this.h, null);
    }

    public void s() {
        q qVar;
        RenderView renderView = this.a;
        if (renderView == null || renderView.getPainting() == null || (qVar = this.h) == null) {
            return;
        }
        qVar.f = this.a.getCurrentWeight();
        this.a.getPainting().N(this.h, this.a.getCurrentColor());
        this.m.clear();
        this.n.clear();
        this.h = null;
        this.a.E();
    }

    private class j {
        boolean a;
        boolean b = true;
        boolean c = true;
        float d;
        float e;

        public j() {
            a();
        }

        abstract void a();

        void b(float f, float f2) {
            this.d = f;
            this.e = f2;
        }

        protected void c(float f, float f2) {
            this.d = f;
            this.e = f2;
        }

        public j(boolean z) {
            this.a = z;
            a();
        }
    }
}
