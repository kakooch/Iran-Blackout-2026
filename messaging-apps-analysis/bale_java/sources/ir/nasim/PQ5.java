package ir.nasim;

import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public class PQ5 extends TP5 {
    private C17557nA a;
    private List b;
    private C5820Kz c;
    private Boolean d;

    public static PQ5 r(byte[] bArr) {
        return (PQ5) AbstractC16720ll0.b(new PQ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C17557nA) c19084pl0.k(1, new C17557nA());
        this.b = c19084pl0.o(3);
        this.c = (C5820Kz) c19084pl0.z(5, new C5820Kz());
        this.d = Boolean.valueOf(c19084pl0.u(4));
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 98;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C17557nA c17557nA = this.a;
        if (c17557nA == null) {
            throw new IOException();
        }
        c19675ql0.i(1, c17557nA);
        c19675ql0.l(3, this.b);
        C5820Kz c5820Kz = this.c;
        if (c5820Kz != null) {
            c19675ql0.i(5, c5820Kz);
        }
        Boolean bool = this.d;
        if (bool != null) {
            c19675ql0.a(4, bool.booleanValue());
        }
    }

    public String toString() {
        return "rpc DeleteMessage{}";
    }
}
