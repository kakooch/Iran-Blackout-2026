package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.jU5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15379jU5 extends TP5 {
    private C17557nA a;
    private long b;
    private String c;
    private long d;

    public static C15379jU5 r(byte[] bArr) {
        return (C15379jU5) AbstractC16720ll0.b(new C15379jU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.k(1, new C17557nA());
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.i(4);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 210;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C17557nA c17557nA = this.a;
        if (c17557nA == null) {
            throw new IOException();
        }
        c19675ql0.i(1, c17557nA);
        c19675ql0.g(2, this.b);
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
        c19675ql0.g(4, this.d);
    }

    public String toString() {
        return "rpc MessageSetReaction{}";
    }
}
