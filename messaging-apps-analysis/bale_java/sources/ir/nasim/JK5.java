package ir.nasim;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import ir.nasim.AbstractC24408ya0;
import java.util.List;

/* loaded from: classes2.dex */
public class JK5 implements AbstractC24408ya0.b, InterfaceC5491Jo3, InterfaceC13318g15 {
    private final String c;
    private final boolean d;
    private final com.airbnb.lottie.q e;
    private final AbstractC24408ya0 f;
    private final AbstractC24408ya0 g;
    private final AbstractC24408ya0 h;
    private boolean k;
    private final Path a = new Path();
    private final RectF b = new RectF();
    private final C17813nc1 i = new C17813nc1();
    private AbstractC24408ya0 j = null;

    public JK5(com.airbnb.lottie.q qVar, AbstractC3236Aa0 abstractC3236Aa0, LK5 lk5) {
        this.c = lk5.c();
        this.d = lk5.f();
        this.e = qVar;
        AbstractC24408ya0 abstractC24408ya0J = lk5.d().j();
        this.f = abstractC24408ya0J;
        AbstractC24408ya0 abstractC24408ya0J2 = lk5.e().j();
        this.g = abstractC24408ya0J2;
        C11959dq2 c11959dq2J = lk5.b().j();
        this.h = c11959dq2J;
        abstractC3236Aa0.j(abstractC24408ya0J);
        abstractC3236Aa0.j(abstractC24408ya0J2);
        abstractC3236Aa0.j(c11959dq2J);
        abstractC24408ya0J.a(this);
        abstractC24408ya0J2.a(this);
        c11959dq2J.a(this);
    }

    private void h() {
        this.k = false;
        this.e.invalidateSelf();
    }

    @Override // ir.nasim.InterfaceC13318g15
    public Path A() {
        AbstractC24408ya0 abstractC24408ya0;
        if (this.k) {
            return this.a;
        }
        this.a.reset();
        if (this.d) {
            this.k = true;
            return this.a;
        }
        PointF pointF = (PointF) this.g.h();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        AbstractC24408ya0 abstractC24408ya02 = this.h;
        float fR = abstractC24408ya02 == null ? 0.0f : ((C11959dq2) abstractC24408ya02).r();
        if (fR == 0.0f && (abstractC24408ya0 = this.j) != null) {
            fR = Math.min(((Float) abstractC24408ya0.h()).floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fR > fMin) {
            fR = fMin;
        }
        PointF pointF2 = (PointF) this.f.h();
        this.a.moveTo(pointF2.x + f, (pointF2.y - f2) + fR);
        this.a.lineTo(pointF2.x + f, (pointF2.y + f2) - fR);
        if (fR > 0.0f) {
            RectF rectF = this.b;
            float f3 = pointF2.x;
            float f4 = fR * 2.0f;
            float f5 = pointF2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((pointF2.x - f) + fR, pointF2.y + f2);
        if (fR > 0.0f) {
            RectF rectF2 = this.b;
            float f6 = pointF2.x;
            float f7 = pointF2.y;
            float f8 = fR * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(pointF2.x - f, (pointF2.y - f2) + fR);
        if (fR > 0.0f) {
            RectF rectF3 = this.b;
            float f9 = pointF2.x;
            float f10 = pointF2.y;
            float f11 = fR * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((pointF2.x + f) - fR, pointF2.y - f2);
        if (fR > 0.0f) {
            RectF rectF4 = this.b;
            float f12 = pointF2.x;
            float f13 = fR * 2.0f;
            float f14 = pointF2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.i.b(this.a);
        this.k = true;
        return this.a;
    }

    @Override // ir.nasim.AbstractC24408ya0.b
    public void a() {
        h();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    @Override // ir.nasim.InterfaceC14939ik1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.util.List r5, java.util.List r6) {
        /*
            r4 = this;
            r6 = 0
        L1:
            int r0 = r5.size()
            if (r6 >= r0) goto L34
            java.lang.Object r0 = r5.get(r6)
            ir.nasim.ik1 r0 = (ir.nasim.InterfaceC14939ik1) r0
            boolean r1 = r0 instanceof ir.nasim.C16837lw7
            if (r1 == 0) goto L25
            r1 = r0
            ir.nasim.lw7 r1 = (ir.nasim.C16837lw7) r1
            ir.nasim.Dx6$a r2 = r1.k()
            ir.nasim.Dx6$a r3 = ir.nasim.C4156Dx6.a.SIMULTANEOUSLY
            if (r2 != r3) goto L25
            ir.nasim.nc1 r0 = r4.i
            r0.a(r1)
            r1.c(r4)
            goto L31
        L25:
            boolean r1 = r0 instanceof ir.nasim.R46
            if (r1 == 0) goto L31
            ir.nasim.R46 r0 = (ir.nasim.R46) r0
            ir.nasim.ya0 r0 = r0.h()
            r4.j = r0
        L31:
            int r6 = r6 + 1
            goto L1
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.JK5.b(java.util.List, java.util.List):void");
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        if (obj == InterfaceC9661aL3.l) {
            this.g.o(c13505gL3);
        } else if (obj == InterfaceC9661aL3.n) {
            this.f.o(c13505gL3);
        } else if (obj == InterfaceC9661aL3.m) {
            this.h.o(c13505gL3);
        }
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void f(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32) {
        AbstractC7323Rf4.k(c5023Ho3, i, list, c5023Ho32, this);
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public String getName() {
        return this.c;
    }
}
