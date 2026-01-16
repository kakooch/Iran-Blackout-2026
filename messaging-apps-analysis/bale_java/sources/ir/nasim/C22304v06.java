package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.v06, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22304v06 extends AbstractC10365bX5 {
    private String b;
    private PA c;

    public static C22304v06 s(byte[] bArr) {
        return (C22304v06) AbstractC16720ll0.b(new C22304v06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.r(1);
        int iH = c19084pl0.h(3, 0);
        if (iH != 0) {
            this.c = PA.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        PA pa = this.c;
        if (pa != null) {
            c19675ql0.f(3, pa.j());
        }
    }

    public String toString() {
        return "response SendDeleteAccountVerificationCode{}";
    }
}
