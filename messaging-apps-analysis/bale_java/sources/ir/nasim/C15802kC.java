package ir.nasim;

/* renamed from: ir.nasim.kC, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15802kC extends VB {
    private C24054xy a;
    private C19811qz b;

    public C15802kC(C24054xy c24054xy, C19811qz c19811qz) {
        this.a = c24054xy;
        this.b = c19811qz;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C24054xy) c19084pl0.z(1, new C24054xy());
        this.b = (C19811qz) c19084pl0.z(3, new C19811qz());
    }

    @Override // ir.nasim.VB
    public int s() {
        return 23;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C24054xy c24054xy = this.a;
        if (c24054xy != null) {
            c19675ql0.i(1, c24054xy);
        }
        C19811qz c19811qz = this.b;
        if (c19811qz != null) {
            c19675ql0.i(3, c19811qz);
        }
    }

    public String toString() {
        return "struct ServiceExGroupCallStarted{}";
    }

    public C24054xy u() {
        return this.a;
    }

    public C15802kC() {
    }
}
