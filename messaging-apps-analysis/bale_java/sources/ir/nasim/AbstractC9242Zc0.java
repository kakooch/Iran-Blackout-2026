package ir.nasim;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import ir.nasim.AbstractC24408ya0;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Zc0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9242Zc0 implements AbstractC24408ya0.b, InterfaceC5491Jo3, V02 {
    private final com.airbnb.lottie.q e;
    protected final AbstractC3236Aa0 f;
    private final float[] h;
    final Paint i;
    private final AbstractC24408ya0 j;
    private final AbstractC24408ya0 k;
    private final List l;
    private final AbstractC24408ya0 m;
    private AbstractC24408ya0 n;
    private AbstractC24408ya0 o;
    float p;
    private final PathMeasure a = new PathMeasure();
    private final Path b = new Path();
    private final Path c = new Path();
    private final RectF d = new RectF();
    private final List g = new ArrayList();

    /* renamed from: ir.nasim.Zc0$b */
    private static final class b {
        private final List a;
        private final C16837lw7 b;

        private b(C16837lw7 c16837lw7) {
            this.a = new ArrayList();
            this.b = c16837lw7;
        }
    }

    AbstractC9242Zc0(com.airbnb.lottie.q qVar, AbstractC3236Aa0 abstractC3236Aa0, Paint.Cap cap, Paint.Join join, float f, C18562os c18562os, C17380ms c17380ms, List list, C17380ms c17380ms2) {
        C7430Rr3 c7430Rr3 = new C7430Rr3(1);
        this.i = c7430Rr3;
        this.p = 0.0f;
        this.e = qVar;
        this.f = abstractC3236Aa0;
        c7430Rr3.setStyle(Paint.Style.STROKE);
        c7430Rr3.setStrokeCap(cap);
        c7430Rr3.setStrokeJoin(join);
        c7430Rr3.setStrokeMiter(f);
        this.k = c18562os.j();
        this.j = c17380ms.j();
        if (c17380ms2 == null) {
            this.m = null;
        } else {
            this.m = c17380ms2.j();
        }
        this.l = new ArrayList(list.size());
        this.h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.l.add(((C17380ms) list.get(i)).j());
        }
        abstractC3236Aa0.j(this.k);
        abstractC3236Aa0.j(this.j);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            abstractC3236Aa0.j((AbstractC24408ya0) this.l.get(i2));
        }
        AbstractC24408ya0 abstractC24408ya0 = this.m;
        if (abstractC24408ya0 != null) {
            abstractC3236Aa0.j(abstractC24408ya0);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            ((AbstractC24408ya0) this.l.get(i3)).a(this);
        }
        AbstractC24408ya0 abstractC24408ya02 = this.m;
        if (abstractC24408ya02 != null) {
            abstractC24408ya02.a(this);
        }
        if (abstractC3236Aa0.x() != null) {
            C11959dq2 c11959dq2J = abstractC3236Aa0.x().a().j();
            this.o = c11959dq2J;
            c11959dq2J.a(this);
            abstractC3236Aa0.j(this.o);
        }
    }

    private void h() {
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("StrokeContent#applyDashPattern");
        }
        if (this.l.isEmpty()) {
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.c("StrokeContent#applyDashPattern");
                return;
            }
            return;
        }
        for (int i = 0; i < this.l.size(); i++) {
            this.h[i] = ((Float) ((AbstractC24408ya0) this.l.get(i)).h()).floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.h;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.h;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
        }
        AbstractC24408ya0 abstractC24408ya0 = this.m;
        this.i.setPathEffect(new DashPathEffect(this.h, abstractC24408ya0 == null ? 0.0f : ((Float) abstractC24408ya0.h()).floatValue()));
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("StrokeContent#applyDashPattern");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j(android.graphics.Canvas r14, ir.nasim.AbstractC9242Zc0.b r15) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9242Zc0.j(android.graphics.Canvas, ir.nasim.Zc0$b):void");
    }

    @Override // ir.nasim.AbstractC24408ya0.b
    public void a() {
        this.e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // ir.nasim.InterfaceC14939ik1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.util.List r8, java.util.List r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            ir.nasim.ik1 r3 = (ir.nasim.InterfaceC14939ik1) r3
            boolean r4 = r3 instanceof ir.nasim.C16837lw7
            if (r4 == 0) goto L1f
            ir.nasim.lw7 r3 = (ir.nasim.C16837lw7) r3
            ir.nasim.Dx6$a r4 = r3.k()
            ir.nasim.Dx6$a r5 = ir.nasim.C4156Dx6.a.INDIVIDUALLY
            if (r4 != r5) goto L1f
            r2 = r3
        L1f:
            int r0 = r0 + (-1)
            goto L8
        L22:
            if (r2 == 0) goto L27
            r2.c(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
            r0 = r1
        L2e:
            if (r8 < 0) goto L6c
            java.lang.Object r3 = r9.get(r8)
            ir.nasim.ik1 r3 = (ir.nasim.InterfaceC14939ik1) r3
            boolean r4 = r3 instanceof ir.nasim.C16837lw7
            if (r4 == 0) goto L55
            r4 = r3
            ir.nasim.lw7 r4 = (ir.nasim.C16837lw7) r4
            ir.nasim.Dx6$a r5 = r4.k()
            ir.nasim.Dx6$a r6 = ir.nasim.C4156Dx6.a.INDIVIDUALLY
            if (r5 != r6) goto L55
            if (r0 == 0) goto L4c
            java.util.List r3 = r7.g
            r3.add(r0)
        L4c:
            ir.nasim.Zc0$b r0 = new ir.nasim.Zc0$b
            r0.<init>(r4)
            r4.c(r7)
            goto L69
        L55:
            boolean r4 = r3 instanceof ir.nasim.InterfaceC13318g15
            if (r4 == 0) goto L69
            if (r0 != 0) goto L60
            ir.nasim.Zc0$b r0 = new ir.nasim.Zc0$b
            r0.<init>(r2)
        L60:
            java.util.List r4 = ir.nasim.AbstractC9242Zc0.b.a(r0)
            ir.nasim.g15 r3 = (ir.nasim.InterfaceC13318g15) r3
            r4.add(r3)
        L69:
            int r8 = r8 + (-1)
            goto L2e
        L6c:
            if (r0 == 0) goto L73
            java.util.List r8 = r7.g
            r8.add(r0)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9242Zc0.b(java.util.List, java.util.List):void");
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        if (obj == InterfaceC9661aL3.d) {
            this.k.o(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.s) {
            this.j.o(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.K) {
            AbstractC24408ya0 abstractC24408ya0 = this.n;
            if (abstractC24408ya0 != null) {
                this.f.J(abstractC24408ya0);
            }
            if (c13505gL3 == null) {
                this.n = null;
                return;
            }
            C14145hQ7 c14145hQ7 = new C14145hQ7(c13505gL3);
            this.n = c14145hQ7;
            c14145hQ7.a(this);
            this.f.j(this.n);
            return;
        }
        if (obj == InterfaceC9661aL3.j) {
            AbstractC24408ya0 abstractC24408ya02 = this.o;
            if (abstractC24408ya02 != null) {
                abstractC24408ya02.o(c13505gL3);
                return;
            }
            C14145hQ7 c14145hQ72 = new C14145hQ7(c13505gL3);
            this.o = c14145hQ72;
            c14145hQ72.a(this);
            this.f.j(this.o);
        }
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void f(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32) {
        AbstractC7323Rf4.k(c5023Ho3, i, list, c5023Ho32, this);
    }

    @Override // ir.nasim.V02
    public void g(RectF rectF, Matrix matrix, boolean z) {
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("StrokeContent#getBounds");
        }
        this.b.reset();
        for (int i = 0; i < this.g.size(); i++) {
            b bVar = (b) this.g.get(i);
            for (int i2 = 0; i2 < bVar.a.size(); i2++) {
                this.b.addPath(((InterfaceC13318g15) bVar.a.get(i2)).A(), matrix);
            }
        }
        this.b.computeBounds(this.d, false);
        float fR = ((C11959dq2) this.j).r();
        RectF rectF2 = this.d;
        float f = fR / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("StrokeContent#getBounds");
        }
    }

    @Override // ir.nasim.V02
    public void i(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12) {
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("StrokeContent#draw");
        }
        if (AbstractC16500lN7.h(matrix)) {
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.c("StrokeContent#draw");
                return;
            }
            return;
        }
        float fIntValue = ((Integer) this.k.h()).intValue() / 100.0f;
        this.i.setAlpha(AbstractC7323Rf4.c((int) (i * fIntValue), 0, 255));
        this.i.setStrokeWidth(((C11959dq2) this.j).r());
        if (this.i.getStrokeWidth() <= 0.0f) {
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.c("StrokeContent#draw");
                return;
            }
            return;
        }
        h();
        AbstractC24408ya0 abstractC24408ya0 = this.n;
        if (abstractC24408ya0 != null) {
            this.i.setColorFilter((ColorFilter) abstractC24408ya0.h());
        }
        AbstractC24408ya0 abstractC24408ya02 = this.o;
        if (abstractC24408ya02 != null) {
            float fFloatValue = ((Float) abstractC24408ya02.h()).floatValue();
            if (fFloatValue == 0.0f) {
                this.i.setMaskFilter(null);
            } else if (fFloatValue != this.p) {
                this.i.setMaskFilter(this.f.y(fFloatValue));
            }
            this.p = fFloatValue;
        }
        if (c17470n12 != null) {
            c17470n12.c((int) (fIntValue * 255.0f), this.i);
        }
        canvas.save();
        canvas.concat(matrix);
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = (b) this.g.get(i2);
            if (bVar.b != null) {
                j(canvas, bVar);
            } else {
                if (AbstractC6219Mr3.h()) {
                    AbstractC6219Mr3.b("StrokeContent#buildPath");
                }
                this.b.reset();
                for (int size = bVar.a.size() - 1; size >= 0; size--) {
                    this.b.addPath(((InterfaceC13318g15) bVar.a.get(size)).A());
                }
                if (AbstractC6219Mr3.h()) {
                    AbstractC6219Mr3.c("StrokeContent#buildPath");
                    AbstractC6219Mr3.b("StrokeContent#drawPath");
                }
                canvas.drawPath(this.b, this.i);
                if (AbstractC6219Mr3.h()) {
                    AbstractC6219Mr3.c("StrokeContent#drawPath");
                }
            }
        }
        canvas.restore();
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("StrokeContent#draw");
        }
    }
}
