package ir.nasim;

import ir.nasim.core.runtime.bser.UnknownFieldException;

/* renamed from: ir.nasim.nB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC17566nB extends AbstractC17902nl0 {
    public static AbstractC17566nB r(byte[] bArr) throws UnknownFieldException {
        C19084pl0 c19084pl0 = new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(bArr, 0, bArr.length)));
        int iG = c19084pl0.g(1);
        byte[] bArrD = c19084pl0.d(2);
        switch (iG) {
            case 1:
                return (AbstractC17566nB) AbstractC16720ll0.b(new OC(), bArrD);
            case 2:
                return (AbstractC17566nB) AbstractC16720ll0.b(new C5577Jy(), bArrD);
            case 3:
                return (AbstractC17566nB) AbstractC16720ll0.b(new C5811Ky(), bArrD);
            case 4:
                return (AbstractC17566nB) AbstractC16720ll0.b(new C6529Nx(), bArrD);
            case 5:
                return (AbstractC17566nB) AbstractC16720ll0.b(new C5784Kv(), bArrD);
            case 6:
                return (AbstractC17566nB) AbstractC16720ll0.b(new C19811qz(), bArrD);
            case 7:
                return (AbstractC17566nB) AbstractC16720ll0.b(new C19784qw(), bArrD);
            default:
                return new C18157oB(iG, bArrD);
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
