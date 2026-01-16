package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.oZ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18379oZ5 extends AbstractC10365bX5 {
    private long b;
    private String c;
    private boolean d;

    public static C18379oZ5 s(byte[] bArr) {
        return (C18379oZ5) AbstractC16720ll0.b(new C18379oZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.i(1);
        this.c = c19084pl0.r(2);
        this.d = c19084pl0.b(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.b);
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        c19675ql0.a(3, this.d);
    }

    public String toString() {
        return "response GetUserBank{}";
    }
}
