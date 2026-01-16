package ir.nasim;

import ir.nasim.core.runtime.bser.UnknownFieldException;

/* renamed from: ir.nasim.Ex, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC4383Ex extends AbstractC17902nl0 {
    public static AbstractC4383Ex r(byte[] bArr) throws UnknownFieldException {
        C19084pl0 c19084pl0 = new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(bArr, 0, bArr.length)));
        int iG = c19084pl0.g(1);
        byte[] bArrD = c19084pl0.d(2);
        return iG != 1 ? iG != 2 ? iG != 3 ? iG != 4 ? iG != 5 ? new C5334Ix(iG, bArrD) : (AbstractC4383Ex) AbstractC16720ll0.b(new C4617Fx(), bArrD) : (AbstractC4383Ex) AbstractC16720ll0.b(new C4866Gx(), bArrD) : (AbstractC4383Ex) AbstractC16720ll0.b(new C5802Kx(), bArrD) : (AbstractC4383Ex) AbstractC16720ll0.b(new C5568Jx(), bArrD) : (AbstractC4383Ex) AbstractC16720ll0.b(new C5100Hx(), bArrD);
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
