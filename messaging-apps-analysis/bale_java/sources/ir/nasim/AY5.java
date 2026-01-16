package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class AY5 extends AbstractC10365bX5 {
    private long b;
    private String c;
    private boolean d;
    private int e;
    private long f;

    public static AY5 s(byte[] bArr) {
        return (AY5) AbstractC16720ll0.b(new AY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.i(1);
        this.c = c19084pl0.r(2);
        this.d = c19084pl0.b(3);
        this.e = c19084pl0.g(4);
        this.f = c19084pl0.i(5);
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
        c19675ql0.f(4, this.e);
        c19675ql0.g(5, this.f);
    }

    public String toString() {
        return "response GetNasimFileUploadUrl{}";
    }
}
