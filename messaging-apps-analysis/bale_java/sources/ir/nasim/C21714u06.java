package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.u06, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C21714u06 extends AbstractC10365bX5 {
    private String b;
    private PA c;

    public static C21714u06 s(byte[] bArr) {
        return (C21714u06) AbstractC16720ll0.b(new C21714u06(), bArr);
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
        return "response SendChangePhoneVerificationCode{}";
    }
}
