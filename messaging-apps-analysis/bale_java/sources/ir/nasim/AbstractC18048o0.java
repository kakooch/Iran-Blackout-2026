package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.o0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC18048o0 {
    public static AbstractC18048o0 b(byte[] bArr) throws IOException {
        C19084pl0 c19084pl0 = new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(bArr)));
        int iG = c19084pl0.g(1);
        byte[] bArrD = c19084pl0.d(2);
        if (iG == 0) {
            return new C8540Wk1(AbstractC19230q0.r(bArrD));
        }
        if (iG == 1) {
            return new C11909dl1(AbstractC24063xz.r(bArrD));
        }
        throw new IOException("Unknown type");
    }

    public byte[] a() throws IOException {
        C12658ez1 c12658ez1 = new C12658ez1();
        C19675ql0 c19675ql0 = new C19675ql0(c12658ez1);
        if (this instanceof C8540Wk1) {
            c19675ql0.f(1, 0);
            c19675ql0.b(2, ((C8540Wk1) this).c().q());
        } else {
            if (!(this instanceof C11909dl1)) {
                throw new IOException("Unknown type");
            }
            c19675ql0.f(1, 1);
            c19675ql0.b(2, ((C11909dl1) this).c().q());
        }
        return c12658ez1.c();
    }
}
