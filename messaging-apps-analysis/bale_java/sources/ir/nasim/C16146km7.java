package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.km7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16146km7 extends AbstractC10443bd0 {
    private final C23945xm7 j;
    private final C14367hn7 k;

    public C16146km7(C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4, C14367hn7 c14367hn7, C4067Dn7 c4067Dn7) {
        super(c23945xm7.e(), c23945xm7.g(), c14367hn7 != null ? c14367hn7.f() : null, interfaceC11600dH4, c4067Dn7, null);
        this.j = c23945xm7;
        this.k = c14367hn7;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int a0(ir.nasim.C14367hn7 r9, int r10) {
        /*
            r8 = this;
            ir.nasim.cu3 r0 = r9.c()
            if (r0 == 0) goto L15
            ir.nasim.cu3 r1 = r9.b()
            r2 = 0
            if (r1 == 0) goto L13
            r3 = 0
            r4 = 2
            ir.nasim.CK5 r2 = ir.nasim.InterfaceC11379cu3.W(r1, r0, r3, r4, r2)
        L13:
            if (r2 != 0) goto L1b
        L15:
            ir.nasim.CK5$a r0 = ir.nasim.CK5.e
            ir.nasim.CK5 r2 = r0.a()
        L1b:
            ir.nasim.dH4 r0 = r8.p()
            ir.nasim.xm7 r1 = r8.j
            long r3 = r1.g()
            int r1 = ir.nasim.C4301En7.i(r3)
            int r0 = r0.b(r1)
            ir.nasim.gn7 r1 = r9.f()
            ir.nasim.CK5 r0 = r1.e(r0)
            float r1 = r0.i()
            float r0 = r0.l()
            long r2 = r2.k()
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r4
            int r2 = (int) r2
            float r2 = java.lang.Float.intBitsToFloat(r2)
            float r10 = (float) r10
            float r2 = r2 * r10
            float r0 = r0 + r2
            ir.nasim.dH4 r10 = r8.p()
            ir.nasim.gn7 r9 = r9.f()
            int r1 = java.lang.Float.floatToRawIntBits(r1)
            long r1 = (long) r1
            int r0 = java.lang.Float.floatToRawIntBits(r0)
            long r6 = (long) r0
            r0 = 32
            long r0 = r1 << r0
            long r2 = r6 & r4
            long r0 = r0 | r2
            long r0 = ir.nasim.ZG4.e(r0)
            int r9 = r9.x(r0)
            int r9 = r10.a(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16146km7.a0(ir.nasim.hn7, int):int");
    }

    public final List Y(UA2 ua2) {
        if (!C4301En7.h(u())) {
            return AbstractC10360bX0.p(new UZ0("", 0), new C24024xu6(C4301En7.l(u()), C4301En7.l(u())));
        }
        InterfaceC18081o32 interfaceC18081o32 = (InterfaceC18081o32) ua2.invoke(this);
        if (interfaceC18081o32 != null) {
            return AbstractC9766aX0.e(interfaceC18081o32);
        }
        return null;
    }

    public final C23945xm7 Z() {
        return C23945xm7.c(this.j, e(), u(), null, 4, null);
    }

    public final C16146km7 b0() {
        C14367hn7 c14367hn7;
        if (w().length() > 0 && (c14367hn7 = this.k) != null) {
            T(a0(c14367hn7, 1));
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final C16146km7 c0() {
        C14367hn7 c14367hn7;
        if (w().length() > 0 && (c14367hn7 = this.k) != null) {
            T(a0(c14367hn7, -1));
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }
}
