package ir.nasim;

/* renamed from: ir.nasim.jC, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15211jC extends VB {
    private C24054xy a;
    private boolean b;
    private C19811qz c;

    public C15211jC(C24054xy c24054xy, boolean z, C19811qz c19811qz) {
        this.a = c24054xy;
        this.b = z;
        this.c = c19811qz;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C24054xy) c19084pl0.z(1, new C24054xy());
        this.b = c19084pl0.b(2);
        this.c = (C19811qz) c19084pl0.z(4, new C19811qz());
    }

    @Override // ir.nasim.VB
    public int s() {
        return 25;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C24054xy c24054xy = this.a;
        if (c24054xy != null) {
            c19675ql0.i(1, c24054xy);
        }
        c19675ql0.a(2, this.b);
        C19811qz c19811qz = this.c;
        if (c19811qz != null) {
            c19675ql0.i(4, c19811qz);
        }
    }

    public String toString() {
        return "struct ServiceExGroupCallEnded{}";
    }

    public C19811qz u() {
        return this.c;
    }

    public C24054xy w() {
        return this.a;
    }

    public boolean y() {
        return this.b;
    }

    public C15211jC() {
    }
}
