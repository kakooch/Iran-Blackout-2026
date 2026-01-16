package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.wX5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23206wX5 extends AbstractC10365bX5 {
    private long b;
    private long c;
    private long d;
    private String e;
    private String f;

    public static C23206wX5 s(byte[] bArr) {
        return (C23206wX5) AbstractC16720ll0.b(new C23206wX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.i(1);
        this.c = c19084pl0.i(2);
        this.d = c19084pl0.i(3);
        this.e = c19084pl0.r(4);
        this.f = c19084pl0.r(5);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.b);
        c19675ql0.g(2, this.c);
        c19675ql0.g(3, this.d);
        String str = this.e;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str);
        String str2 = this.f;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(5, str2);
    }

    public String toString() {
        return "response CryptoTransfer{}";
    }
}
