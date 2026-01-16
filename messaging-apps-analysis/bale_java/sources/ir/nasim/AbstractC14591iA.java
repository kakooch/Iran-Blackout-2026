package ir.nasim;

import ir.nasim.core.runtime.bser.UnknownFieldException;

/* renamed from: ir.nasim.iA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC14591iA extends AbstractC17902nl0 {
    public static AbstractC14591iA r(byte[] bArr) throws UnknownFieldException {
        C19084pl0 c19084pl0 = new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(bArr, 0, bArr.length)));
        int iG = c19084pl0.g(1);
        byte[] bArrD = c19084pl0.d(2);
        return iG != 168 ? iG != 169 ? iG != 2786 ? new C15193jA(iG, bArrD) : (AbstractC14591iA) AbstractC16720ll0.b(new C13411gB(), bArrD) : (AbstractC14591iA) AbstractC16720ll0.b(new C16829lw(), bArrD) : (AbstractC14591iA) AbstractC16720ll0.b(new C6759Ow(), bArrD);
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
