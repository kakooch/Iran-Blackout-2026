package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.pZ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18970pZ5 extends AbstractC10365bX5 {
    private int b;
    private int c;
    private String d;
    private String e;

    public static C18970pZ5 s(byte[] bArr) {
        return (C18970pZ5) AbstractC16720ll0.b(new C18970pZ5(), bArr);
    }

    public String getNonce() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.g(1);
        this.c = c19084pl0.g(2);
        this.d = c19084pl0.r(3);
        this.e = c19084pl0.r(4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.b);
        c19675ql0.f(2, this.c);
        String str = this.d;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
        String str2 = this.e;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str2);
    }

    public String toString() {
        return "response GetUserContext{}";
    }

    public int u() {
        return this.b;
    }

    public String w() {
        return this.e;
    }

    public int y() {
        return this.c;
    }
}
