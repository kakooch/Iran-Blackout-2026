package ir.nasim;

import ir.nasim.core.runtime.bser.UnknownFieldException;

/* loaded from: classes4.dex */
public abstract class VB extends AbstractC17902nl0 {
    public static VB r(byte[] bArr) throws UnknownFieldException {
        C19084pl0 c19084pl0 = new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(bArr, 0, bArr.length)));
        int iG = c19084pl0.g(1);
        byte[] bArrD = c19084pl0.d(2);
        if (iG == 8) {
            return (VB) AbstractC16720ll0.b(new C13420gC(), bArrD);
        }
        if (iG == 9) {
            return (VB) AbstractC16720ll0.b(new C19348qC(), bArrD);
        }
        if (iG == 65) {
            return (VB) AbstractC16720ll0.b(new WB(), bArrD);
        }
        if (iG == 153) {
            return (VB) AbstractC16720ll0.b(new C10170bC(), bArrD);
        }
        if (iG == 262626) {
            return (VB) AbstractC16720ll0.b(new YB(), bArrD);
        }
        if (iG == 434343) {
            return (VB) AbstractC16720ll0.b(new C16984mC(), bArrD);
        }
        if (iG == 555555) {
            return (VB) AbstractC16720ll0.b(new C18166oC(), bArrD);
        }
        switch (iG) {
            case 1:
                return (VB) AbstractC16720ll0.b(new C20548sC(), bArrD);
            case 2:
                return (VB) AbstractC16720ll0.b(new C21825uC(), bArrD);
            case 3:
                return (VB) AbstractC16720ll0.b(new C22415vC(), bArrD);
            case 4:
                return (VB) AbstractC16720ll0.b(new C16393lC(), bArrD);
            case 5:
                return (VB) AbstractC16720ll0.b(new C10786cC(), bArrD);
            case 6:
                return (VB) AbstractC16720ll0.b(new C9576aC(), bArrD);
            default:
                switch (iG) {
                    case 16:
                        return (VB) AbstractC16720ll0.b(new C18757pC(), bArrD);
                    case 17:
                        return (VB) AbstractC16720ll0.b(new C21151tC(), bArrD);
                    case 18:
                        return (VB) AbstractC16720ll0.b(new C11550dC(), bArrD);
                    case 19:
                        return (VB) AbstractC16720ll0.b(new ZB(), bArrD);
                    case 20:
                        return (VB) AbstractC16720ll0.b(new C12193eC(), bArrD);
                    case 21:
                        return (VB) AbstractC16720ll0.b(new C12802fC(), bArrD);
                    case 22:
                        return (VB) AbstractC16720ll0.b(new XB(), bArrD);
                    case 23:
                        return (VB) AbstractC16720ll0.b(new C15802kC(), bArrD);
                    case 24:
                        return (VB) AbstractC16720ll0.b(new C17575nC(), bArrD);
                    case 25:
                        return (VB) AbstractC16720ll0.b(new C15211jC(), bArrD);
                    default:
                        switch (iG) {
                            case 62978:
                                return (VB) AbstractC16720ll0.b(new C14011hC(), bArrD);
                            case 62979:
                                return (VB) AbstractC16720ll0.b(new C14613iC(), bArrD);
                            default:
                                return new C19939rC(iG, bArrD);
                        }
                }
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
