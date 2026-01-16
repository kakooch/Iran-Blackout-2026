package ir.nasim;

import ir.nasim.core.runtime.bser.UnknownFieldException;

/* renamed from: ir.nasim.bw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC10632bw extends AbstractC17902nl0 {
    public static AbstractC10632bw r(byte[] bArr) throws UnknownFieldException {
        C19084pl0 c19084pl0 = new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(bArr, 0, bArr.length)));
        int iG = c19084pl0.g(1);
        byte[] bArrD = c19084pl0.d(2);
        switch (iG) {
            case 1:
                return (AbstractC10632bw) AbstractC16720ll0.b(new C12629ew(), bArrD);
            case 2:
                return (AbstractC10632bw) AbstractC16720ll0.b(new C13265fw(), bArrD);
            case 3:
                return (AbstractC10632bw) AbstractC16720ll0.b(new C13856gw(), bArrD);
            case 4:
                return (AbstractC10632bw) AbstractC16720ll0.b(new C20992sx(), bArrD);
            case 5:
                return (AbstractC10632bw) AbstractC16720ll0.b(new C21679tx(), bArrD);
            case 6:
                return (AbstractC10632bw) AbstractC16720ll0.b(new C21142tB(), bArrD);
            default:
                return new C11395cw(iG, bArrD);
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
