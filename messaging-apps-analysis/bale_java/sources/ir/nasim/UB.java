package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class UB extends AbstractC17902nl0 {
    private C25238zy a;
    private int b;
    private byte[] c;

    public UB(C25238zy c25238zy, int i, byte[] bArr) {
        this.a = c25238zy;
        this.b = i;
        this.c = bArr;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C25238zy) c19084pl0.z(1, new C25238zy());
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.d(3);
    }

    public C25238zy q() {
        return this.a;
    }

    public int r() {
        return this.b;
    }

    public byte[] s() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C25238zy c25238zy = this.a;
        if (c25238zy != null) {
            c19675ql0.i(1, c25238zy);
        }
        c19675ql0.f(2, this.b);
        byte[] bArr = this.c;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(3, bArr);
    }

    public String toString() {
        return "struct SeqState{}";
    }

    public UB() {
    }
}
