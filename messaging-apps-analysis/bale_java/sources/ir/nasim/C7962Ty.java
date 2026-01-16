package ir.nasim;

/* renamed from: ir.nasim.Ty, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C7962Ty extends AbstractC21697tz {
    private C11413cy a;
    private int b;
    private int c;

    public C7962Ty(C11413cy c11413cy, int i, int i2) {
        this.a = c11413cy;
        this.b = i;
        this.c = i2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C11413cy) c19084pl0.z(1, new C11413cy());
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.g(3);
    }

    @Override // ir.nasim.AbstractC21697tz
    public int s() {
        return 2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C11413cy c11413cy = this.a;
        if (c11413cy != null) {
            c19675ql0.i(1, c11413cy);
        }
        c19675ql0.f(2, this.b);
        c19675ql0.f(3, this.c);
    }

    public String toString() {
        return "struct IntroPhoto{}";
    }

    public int u() {
        return this.c;
    }

    public C11413cy w() {
        return this.a;
    }

    public int y() {
        return this.b;
    }

    public C7962Ty() {
    }
}
