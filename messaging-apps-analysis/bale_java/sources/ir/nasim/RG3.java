package ir.nasim;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class RG3 extends AbstractC17902nl0 implements Serializable {
    private int a;
    private int b;
    private byte[] c;

    public RG3(C22694vg2 c22694vg2) {
        this.a = c22694vg2.d();
        this.b = c22694vg2.b();
        this.c = c22694vg2.c();
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.d(3);
    }

    public int q() {
        return this.b;
    }

    public byte[] r() {
        return this.c;
    }

    public int s() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.f(2, this.b);
        c19675ql0.b(3, this.c);
    }

    public RG3(byte[] bArr) {
        load(bArr);
    }
}
