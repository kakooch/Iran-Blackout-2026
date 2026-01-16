package ir.nasim;

import java.util.Map;

/* loaded from: classes2.dex */
public final class AJ3 extends AbstractC14349hm {
    public AJ3(InterfaceC14957im interfaceC14957im) {
        super(interfaceC14957im, null);
    }

    @Override // ir.nasim.AbstractC14349hm
    protected long d(XA4 xa4, long j) {
        DJ3 dj3E2 = xa4.E2();
        AbstractC13042fc3.f(dj3E2);
        long jF1 = dj3E2.F1();
        float fK = C22045ua3.k(jF1);
        float fL = C22045ua3.l(jF1);
        return ZG4.q(ZG4.e((Float.floatToRawIntBits(fK) << 32) | (Float.floatToRawIntBits(fL) & 4294967295L)), j);
    }

    @Override // ir.nasim.AbstractC14349hm
    protected Map e(XA4 xa4) {
        DJ3 dj3E2 = xa4.E2();
        AbstractC13042fc3.f(dj3E2);
        return dj3E2.q1().t();
    }

    @Override // ir.nasim.AbstractC14349hm
    protected int i(XA4 xa4, AbstractC13165fm abstractC13165fm) {
        DJ3 dj3E2 = xa4.E2();
        AbstractC13042fc3.f(dj3E2);
        return dj3E2.J(abstractC13165fm);
    }
}
