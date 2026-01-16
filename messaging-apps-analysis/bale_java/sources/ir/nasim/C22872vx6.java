package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.vx6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C22872vx6 extends AbstractC3236Aa0 {
    private final C4502Fk1 E;
    private final C8725Xb1 F;
    private C19243q12 G;

    C22872vx6(com.airbnb.lottie.q qVar, C6970Pt3 c6970Pt3, C8725Xb1 c8725Xb1, C23677xK3 c23677xK3) {
        super(qVar, c6970Pt3);
        this.F = c8725Xb1;
        C4502Fk1 c4502Fk1 = new C4502Fk1(qVar, this, new C20409rx6("__container", c6970Pt3.o(), false), c23677xK3);
        this.E = c4502Fk1;
        c4502Fk1.b(Collections.emptyList(), Collections.emptyList());
        if (z() != null) {
            this.G = new C19243q12(this, this, z());
        }
    }

    @Override // ir.nasim.AbstractC3236Aa0
    protected void K(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32) {
        this.E.f(c5023Ho3, i, list, c5023Ho32);
    }

    @Override // ir.nasim.AbstractC3236Aa0, ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        C19243q12 c19243q12;
        C19243q12 c19243q122;
        C19243q12 c19243q123;
        C19243q12 c19243q124;
        C19243q12 c19243q125;
        super.c(obj, c13505gL3);
        if (obj == InterfaceC9661aL3.e && (c19243q125 = this.G) != null) {
            c19243q125.c(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.G && (c19243q124 = this.G) != null) {
            c19243q124.f(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.H && (c19243q123 = this.G) != null) {
            c19243q123.d(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.I && (c19243q122 = this.G) != null) {
            c19243q122.e(c13505gL3);
        } else {
            if (obj != InterfaceC9661aL3.J || (c19243q12 = this.G) == null) {
                return;
            }
            c19243q12.g(c13505gL3);
        }
    }

    @Override // ir.nasim.AbstractC3236Aa0, ir.nasim.V02
    public void g(RectF rectF, Matrix matrix, boolean z) {
        super.g(rectF, matrix, z);
        this.E.g(rectF, this.o, z);
    }

    @Override // ir.nasim.AbstractC3236Aa0
    void u(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12) {
        C19243q12 c19243q12 = this.G;
        if (c19243q12 != null) {
            c17470n12 = c19243q12.b(matrix, i);
        }
        this.E.i(canvas, matrix, i, c17470n12);
    }

    @Override // ir.nasim.AbstractC3236Aa0
    public C4474Fh0 x() {
        C4474Fh0 c4474Fh0X = super.x();
        return c4474Fh0X != null ? c4474Fh0X : this.F.x();
    }
}
