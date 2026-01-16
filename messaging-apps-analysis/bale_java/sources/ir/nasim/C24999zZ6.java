package ir.nasim;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* renamed from: ir.nasim.zZ6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C24999zZ6 extends AbstractC9242Zc0 {
    private final AbstractC3236Aa0 q;
    private final String r;
    private final boolean s;
    private final AbstractC24408ya0 t;
    private AbstractC24408ya0 u;

    public C24999zZ6(com.airbnb.lottie.q qVar, AbstractC3236Aa0 abstractC3236Aa0, C3449Ax6 c3449Ax6) {
        super(qVar, abstractC3236Aa0, c3449Ax6.b().j(), c3449Ax6.e().j(), c3449Ax6.g(), c3449Ax6.i(), c3449Ax6.j(), c3449Ax6.f(), c3449Ax6.d());
        this.q = abstractC3236Aa0;
        this.r = c3449Ax6.h();
        this.s = c3449Ax6.k();
        AbstractC24408ya0 abstractC24408ya0J = c3449Ax6.c().j();
        this.t = abstractC24408ya0J;
        abstractC24408ya0J.a(this);
        abstractC3236Aa0.j(abstractC24408ya0J);
    }

    @Override // ir.nasim.AbstractC9242Zc0, ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        super.c(obj, c13505gL3);
        if (obj == InterfaceC9661aL3.b) {
            this.t.o(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.K) {
            AbstractC24408ya0 abstractC24408ya0 = this.u;
            if (abstractC24408ya0 != null) {
                this.q.J(abstractC24408ya0);
            }
            if (c13505gL3 == null) {
                this.u = null;
                return;
            }
            C14145hQ7 c14145hQ7 = new C14145hQ7(c13505gL3);
            this.u = c14145hQ7;
            c14145hQ7.a(this);
            this.q.j(this.t);
        }
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public String getName() {
        return this.r;
    }

    @Override // ir.nasim.AbstractC9242Zc0, ir.nasim.V02
    public void i(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12) {
        if (this.s) {
            return;
        }
        this.i.setColor(((CX0) this.t).r());
        AbstractC24408ya0 abstractC24408ya0 = this.u;
        if (abstractC24408ya0 != null) {
            this.i.setColorFilter((ColorFilter) abstractC24408ya0.h());
        }
        super.i(canvas, matrix, i, c17470n12);
    }
}
