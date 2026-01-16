package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.sY5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C20752sY5 extends AbstractC10365bX5 {
    private String b;
    private String c;
    private String d;
    private String e;

    public static C20752sY5 s(byte[] bArr) {
        return (C20752sY5) AbstractC16720ll0.b(new C20752sY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.r(1);
        this.c = c19084pl0.r(2);
        this.d = c19084pl0.r(3);
        this.e = c19084pl0.r(4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        String str2 = this.c;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str2);
        String str3 = this.d;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str3);
        String str4 = this.e;
        if (str4 == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str4);
    }

    public String toString() {
        return "response GetMoneyRequestPaymentTokenByCard{}";
    }
}
