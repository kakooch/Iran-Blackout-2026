package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.cy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11413cy extends AbstractC17902nl0 {
    private int a;
    private int b;
    private byte[] c;
    private C12056dy d;

    public C11413cy(int i, int i2, byte[] bArr, C12056dy c12056dy) {
        this.a = i;
        this.b = i2;
        this.c = bArr;
        this.d = c12056dy;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.d(3);
        this.d = (C12056dy) c19084pl0.z(4, new C12056dy());
    }

    public int q() {
        return this.b;
    }

    public C12056dy r() {
        return this.d;
    }

    public byte[] s() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        c19675ql0.f(2, this.b);
        byte[] bArr = this.c;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(3, bArr);
        C12056dy c12056dy = this.d;
        if (c12056dy != null) {
            c19675ql0.i(4, c12056dy);
        }
    }

    public String toString() {
        return "struct FastThumb{}";
    }

    public int u() {
        return this.a;
    }

    public C11413cy() {
    }
}
