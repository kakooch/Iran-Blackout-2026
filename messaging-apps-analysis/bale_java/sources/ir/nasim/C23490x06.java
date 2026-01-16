package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.x06, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23490x06 extends AbstractC10365bX5 {
    private int b;
    private byte[] c;
    private long d;
    private C19811qz e;

    public static C23490x06 s(byte[] bArr) {
        return (C23490x06) AbstractC16720ll0.b(new C23490x06(), bArr);
    }

    public long h() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.g(1);
        this.c = c19084pl0.d(2);
        this.d = c19084pl0.i(3);
        this.e = (C19811qz) c19084pl0.z(4, new C19811qz());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.b);
        byte[] bArr = this.c;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(2, bArr);
        c19675ql0.g(3, this.d);
        C19811qz c19811qz = this.e;
        if (c19811qz != null) {
            c19675ql0.i(4, c19811qz);
        }
    }

    public String toString() {
        return "response SeqDate{}";
    }

    public C19811qz u() {
        return this.e;
    }

    public int w() {
        return this.b;
    }

    public byte[] y() {
        return this.c;
    }
}
