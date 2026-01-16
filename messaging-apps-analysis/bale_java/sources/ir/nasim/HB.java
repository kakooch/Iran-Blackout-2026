package ir.nasim;

import ir.nasim.core.runtime.bser.UnknownFieldException;

/* loaded from: classes4.dex */
public abstract class HB extends AbstractC17902nl0 {
    public static HB r(byte[] bArr) throws UnknownFieldException {
        C19084pl0 c19084pl0 = new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(bArr, 0, bArr.length)));
        int iG = c19084pl0.g(1);
        byte[] bArrD = c19084pl0.d(2);
        switch (iG) {
            case 1:
                return (HB) AbstractC16720ll0.b(new PB(), bArrD);
            case 2:
                return (HB) AbstractC16720ll0.b(new QB(), bArrD);
            case 3:
                return (HB) AbstractC16720ll0.b(new GB(), bArrD);
            case 4:
                return (HB) AbstractC16720ll0.b(new LB(), bArrD);
            case 5:
                return (HB) AbstractC16720ll0.b(new MB(), bArrD);
            case 6:
                return (HB) AbstractC16720ll0.b(new NB(), bArrD);
            default:
                return new IB(iG, bArrD);
        }
    }

    public byte[] q() {
        C12658ez1 c12658ez1 = new C12658ez1();
        C19675ql0 c19675ql0 = new C19675ql0(c12658ez1);
        c19675ql0.f(1, s());
        c19675ql0.b(2, toByteArray());
        return c12658ez1.c();
    }

    public abstract int s();
}
