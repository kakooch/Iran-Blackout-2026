package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.hU5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C14179hU5 extends TP5 {
    private C17557nA a;
    private long b;

    public static C14179hU5 r(byte[] bArr) {
        return (C14179hU5) AbstractC16720ll0.b(new C14179hU5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.k(1, new C17557nA());
        this.b = c19084pl0.i(3);
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 55;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C17557nA c17557nA = this.a;
        if (c17557nA == null) {
            throw new IOException();
        }
        c19675ql0.i(1, c17557nA);
        c19675ql0.g(3, this.b);
    }

    public String toString() {
        return "rpc MessageReceived{}";
    }
}
