package ir.nasim;

import ir.nasim.core.runtime.bser.UnknownFieldException;

/* renamed from: ir.nasim.rD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC19948rD extends AbstractC17902nl0 {
    public static AbstractC19948rD r(byte[] bArr) throws UnknownFieldException {
        C19084pl0 c19084pl0 = new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(bArr, 0, bArr.length)));
        int iG = c19084pl0.g(1);
        byte[] bArrD = c19084pl0.d(2);
        return iG != 1 ? iG != 2 ? new C20557sD(iG, bArrD) : (AbstractC19948rD) AbstractC16720ll0.b(new C17584nD(), bArrD) : (AbstractC19948rD) AbstractC16720ll0.b(new C18175oD(), bArrD);
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
