package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.tY5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C21372tY5 extends AbstractC10365bX5 {
    private String b;
    private int c;
    private int d;
    private boolean e;

    public static C21372tY5 s(byte[] bArr) {
        return (C21372tY5) AbstractC16720ll0.b(new C21372tY5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.r(1);
        this.c = c19084pl0.g(2);
        this.d = c19084pl0.g(3);
        this.e = c19084pl0.b(4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.f(2, this.c);
        c19675ql0.f(3, this.d);
        c19675ql0.a(4, this.e);
    }

    public String toString() {
        return "response GetMyBank{}";
    }
}
