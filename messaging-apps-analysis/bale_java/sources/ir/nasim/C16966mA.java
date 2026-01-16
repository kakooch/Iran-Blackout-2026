package ir.nasim;

/* renamed from: ir.nasim.mA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16966mA extends AbstractC17902nl0 {
    private EnumC9196Yx a;
    private int b;
    private long c;

    public C16966mA(EnumC9196Yx enumC9196Yx, int i, long j) {
        this.a = enumC9196Yx;
        this.b = i;
        this.c = j;
    }

    public long getAccessHash() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC9196Yx.p(iH);
        }
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.i(3);
    }

    public int q() {
        return this.b;
    }

    public EnumC9196Yx r() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC9196Yx enumC9196Yx = this.a;
        if (enumC9196Yx != null) {
            c19675ql0.f(1, enumC9196Yx.j());
        }
        c19675ql0.f(2, this.b);
        c19675ql0.g(3, this.c);
    }

    public String toString() {
        return "struct OutExPeer{}";
    }

    public C16966mA() {
    }
}
