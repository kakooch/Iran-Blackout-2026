package ir.nasim;

import ir.nasim.core.runtime.bser.UnknownFieldException;

/* renamed from: ir.nasim.xz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC24063xz extends AbstractC17902nl0 {
    public static AbstractC24063xz r(byte[] bArr) throws UnknownFieldException {
        C19084pl0 c19084pl0 = new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(bArr, 0, bArr.length)));
        int iG = c19084pl0.g(1);
        byte[] bArrD = c19084pl0.d(2);
        if (iG == 15) {
            return (AbstractC24063xz) AbstractC16720ll0.b(new C16384lB(), bArrD);
        }
        if (iG == 96) {
            return (AbstractC24063xz) AbstractC16720ll0.b(new XA(), bArrD);
        }
        if (iG == 167) {
            return (AbstractC24063xz) AbstractC16720ll0.b(new C15784kA(), bArrD);
        }
        if (iG == 241) {
            return (AbstractC24063xz) AbstractC16720ll0.b(new C20402rx(), bArrD);
        }
        switch (iG) {
            case 1:
                return (AbstractC24063xz) AbstractC16720ll0.b(new ZC(), bArrD);
            case 2:
                return (AbstractC24063xz) AbstractC16720ll0.b(new C23011wC(), bArrD);
            case 3:
                return (AbstractC24063xz) AbstractC16720ll0.b(new C6035Lx(), bArrD);
            case 4:
                return (AbstractC24063xz) AbstractC16720ll0.b(new C8664Wy(), bArrD);
            case 5:
                return (AbstractC24063xz) AbstractC16720ll0.b(new C14622iD(), bArrD);
            case 6:
                return (AbstractC24063xz) AbstractC16720ll0.b(new IC(), bArrD);
            case 7:
                return (AbstractC24063xz) AbstractC16720ll0.b(new C19193pw(), bArrD);
            default:
                switch (iG) {
                    case 9:
                        return (AbstractC24063xz) AbstractC16720ll0.b(new C7246Qx(), bArrD);
                    case 10:
                        return (AbstractC24063xz) AbstractC16720ll0.b(new C12038dw(), bArrD);
                    case 11:
                        return (AbstractC24063xz) AbstractC16720ll0.b(new C8205Uz(), bArrD);
                    case 12:
                        return (AbstractC24063xz) AbstractC16720ll0.b(new TC(), bArrD);
                    case 13:
                        return (AbstractC24063xz) AbstractC16720ll0.b(new VC(), bArrD);
                    default:
                        switch (iG) {
                            case 19:
                                return (AbstractC24063xz) AbstractC16720ll0.b(new C8693Wz(), bArrD);
                            case 20:
                                return (AbstractC24063xz) AbstractC16720ll0.b(new C22260uw(), bArrD);
                            case 21:
                                return (AbstractC24063xz) AbstractC16720ll0.b(new C4365Ev(), bArrD);
                            default:
                                switch (iG) {
                                    case 23:
                                        return (AbstractC24063xz) AbstractC16720ll0.b(new C16247kx(), bArrD);
                                    case 24:
                                        return (AbstractC24063xz) AbstractC16720ll0.b(new C5316Iv(), bArrD);
                                    case 25:
                                        return (AbstractC24063xz) AbstractC16720ll0.b(new C14449hw(), bArrD);
                                    case 26:
                                        return (AbstractC24063xz) AbstractC16720ll0.b(new C16265kz(), bArrD);
                                    case 27:
                                        return (AbstractC24063xz) AbstractC16720ll0.b(new C12793fB(), bArrD);
                                    default:
                                        switch (iG) {
                                            case 62979:
                                                return (AbstractC24063xz) AbstractC16720ll0.b(new C21001sy(), bArrD);
                                            case 62980:
                                                return (AbstractC24063xz) AbstractC16720ll0.b(new C11541dB(), bArrD);
                                            case 62981:
                                                return (AbstractC24063xz) AbstractC16720ll0.b(new C22874vy(), bArrD);
                                            default:
                                                return new C5586Jz(iG, bArrD);
                                        }
                                }
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
