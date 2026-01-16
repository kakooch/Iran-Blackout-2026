package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.kR5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15943kR5 extends TP5 {
    private int a;
    private long b;
    private String c;

    public static C15943kR5 r(byte[] bArr) {
        return (C15943kR5) AbstractC16720ll0.b(new C15943kR5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.r(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 96;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        c19675ql0.g(2, this.b);
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
    }

    public String toString() {
        return "rpc EditUserLocalName{}";
    }
}
