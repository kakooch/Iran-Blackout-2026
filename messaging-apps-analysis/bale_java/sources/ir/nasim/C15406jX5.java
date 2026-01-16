package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.jX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15406jX5 extends AbstractC10365bX5 {
    private long b;
    private String c;
    private String d;
    private String e;

    public static C15406jX5 s(byte[] bArr) {
        return (C15406jX5) AbstractC16720ll0.b(new C15406jX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.i(1);
        this.c = c19084pl0.r(2);
        this.d = c19084pl0.A(3);
        this.e = c19084pl0.A(4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.b);
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        String str2 = this.d;
        if (str2 != null) {
            c19675ql0.o(3, str2);
        }
        String str3 = this.e;
        if (str3 != null) {
            c19675ql0.o(4, str3);
        }
    }

    public String toString() {
        return "response BuyFastCharge{}";
    }
}
