package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class AX5 extends AbstractC10365bX5 {
    private C6984Pv b;
    private int c;
    private byte[] d;
    private long e;

    public static AX5 s(byte[] bArr) {
        return (AX5) AbstractC16720ll0.b(new AX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (C6984Pv) c19084pl0.z(1, new C6984Pv());
        this.c = c19084pl0.g(2);
        this.d = c19084pl0.d(3);
        this.e = c19084pl0.i(4);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        C6984Pv c6984Pv = this.b;
        if (c6984Pv != null) {
            c19675ql0.i(1, c6984Pv);
        }
        c19675ql0.f(2, this.c);
        byte[] bArr = this.d;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(3, bArr);
        c19675ql0.g(4, this.e);
    }

    public String toString() {
        return "response EditGroupAvatar{}";
    }
}
