package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.q0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC19230q0 extends AbstractC17902nl0 {
    public static AbstractC19230q0 r(byte[] bArr) throws IOException {
        C19084pl0 c19084pl0 = new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(bArr)));
        int iG = c19084pl0.g(1);
        byte[] bArrD = c19084pl0.d(2);
        if (iG == 4) {
            return new C10835cH3(bArrD);
        }
        if (iG == 0) {
            return new OG3(bArrD);
        }
        if (iG == 11) {
            return new VG3(bArrD);
        }
        if (iG == 1) {
            return new C9625aH3(bArrD);
        }
        if (iG == 2) {
            return new C21874uH3(bArrD);
        }
        if (iG == 3) {
            return new BH3(bArrD);
        }
        if (iG == 5) {
            return new GG3(bArrD);
        }
        if (iG == 10) {
            return new SG3(bArrD);
        }
        if (iG == 7) {
            return new FG3(bArrD);
        }
        if (iG == 12) {
            return new C8894Xu(bArrD);
        }
        if (iG == 13) {
            return new C10219bH3(bArrD);
        }
        if (iG == 8) {
            return new C18215oH3(bArrD);
        }
        if (iG == 9) {
            return new NG3(bArrD);
        }
        throw new IOException("Unknown type in loadContainer in AbsLocalContent");
    }

    public byte[] q() throws IOException {
        C12658ez1 c12658ez1 = new C12658ez1();
        C19675ql0 c19675ql0 = new C19675ql0(c12658ez1);
        if (this instanceof C10835cH3) {
            c19675ql0.f(1, 4);
        } else if (this instanceof MG3) {
            c19675ql0.f(1, 6);
        } else if (this instanceof VG3) {
            c19675ql0.f(1, 11);
        } else if (this instanceof C9625aH3) {
            c19675ql0.f(1, 1);
        } else if (this instanceof C21874uH3) {
            c19675ql0.f(1, 2);
        } else if (this instanceof BH3) {
            c19675ql0.f(1, 3);
        } else if (this instanceof GG3) {
            c19675ql0.f(1, 5);
        } else if (this instanceof SG3) {
            c19675ql0.f(1, 10);
        } else if (this instanceof FG3) {
            c19675ql0.f(1, 7);
        } else if (this instanceof C18215oH3) {
            c19675ql0.f(1, 8);
        } else if (this instanceof NG3) {
            c19675ql0.f(1, 9);
        } else if (this instanceof OG3) {
            c19675ql0.f(1, 0);
        } else if (this instanceof C8894Xu) {
            c19675ql0.f(1, 12);
        } else {
            if (!(this instanceof C10219bH3)) {
                throw new IOException("Unknown type in buildContainer in AbsLocalContent");
            }
            c19675ql0.f(1, 13);
        }
        c19675ql0.b(2, toByteArray());
        return c12658ez1.c();
    }
}
