package ir.nasim;

import ir.nasim.core.runtime.bser.UnknownFieldException;

/* renamed from: ir.nasim.zv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC25211zv extends AbstractC17902nl0 {
    public static AbstractC25211zv r(byte[] bArr) throws UnknownFieldException {
        C19084pl0 c19084pl0 = new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(bArr, 0, bArr.length)));
        int iG = c19084pl0.g(1);
        byte[] bArrD = c19084pl0.d(2);
        switch (iG) {
            case 1:
                return (AbstractC25211zv) AbstractC16720ll0.b(new CD(), bArrD);
            case 2:
                return (AbstractC25211zv) AbstractC16720ll0.b(new SC(), bArrD);
            case 3:
                return (AbstractC25211zv) AbstractC16720ll0.b(new C7935Tv(), bArrD);
            case 4:
                return (AbstractC25211zv) AbstractC16720ll0.b(new C8959Xz(), bArrD);
            case 5:
                return (AbstractC25211zv) AbstractC16720ll0.b(new C8403Vv(), bArrD);
            case 6:
                return (AbstractC25211zv) AbstractC16720ll0.b(new C8169Uv(), bArrD);
            case 7:
                return (AbstractC25211zv) AbstractC16720ll0.b(new C8637Wv(), bArrD);
            case 8:
                return (AbstractC25211zv) AbstractC16720ll0.b(new C8923Xv(), bArrD);
            default:
                return new C3424Av(iG, bArrD);
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
