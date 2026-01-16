package ir.nasim;

/* renamed from: ir.nasim.Qv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C7228Qv extends AbstractC17902nl0 {
    private C12056dy a;
    private int b;
    private int c;
    private int d;

    public C7228Qv(C12056dy c12056dy, int i, int i2, int i3) {
        this.a = c12056dy;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public C12056dy getFileLocation() {
        return this.a;
    }

    public int getFileSize() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C12056dy) c19084pl0.z(1, new C12056dy());
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.g(4);
    }

    public int q() {
        return this.c;
    }

    public int r() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C12056dy c12056dy = this.a;
        if (c12056dy != null) {
            c19675ql0.i(1, c12056dy);
        }
        c19675ql0.f(2, this.b);
        c19675ql0.f(3, this.c);
        c19675ql0.f(4, this.d);
    }

    public String toString() {
        return "struct AvatarImage{}";
    }

    public C7228Qv() {
    }
}
