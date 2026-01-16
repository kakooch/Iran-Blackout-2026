package ir.nasim;

/* renamed from: ir.nasim.bz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C10658bz extends AbstractC17902nl0 {
    private int a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private C7237Qw f;
    private C7237Qw g;
    private boolean h;

    public C10658bz(int i, boolean z, boolean z2, boolean z3, boolean z4, C7237Qw c7237Qw, C7237Qw c7237Qw2, boolean z5) {
        this.a = i;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = c7237Qw;
        this.g = c7237Qw2;
        this.h = z5;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.b(2);
        this.c = c19084pl0.b(3);
        this.d = c19084pl0.b(4);
        this.e = c19084pl0.b(5);
        this.f = (C7237Qw) c19084pl0.z(6, new C7237Qw());
        this.g = (C7237Qw) c19084pl0.z(7, new C7237Qw());
        this.h = c19084pl0.b(8);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.a(2, this.b);
        c19675ql0.a(3, this.c);
        c19675ql0.a(4, this.d);
        c19675ql0.a(5, this.e);
        C7237Qw c7237Qw = this.f;
        if (c7237Qw != null) {
            c19675ql0.i(6, c7237Qw);
        }
        C7237Qw c7237Qw2 = this.g;
        if (c7237Qw2 != null) {
            c19675ql0.i(7, c7237Qw2);
        }
        c19675ql0.a(8, this.h);
    }

    public String toString() {
        return "struct KeyboardButtonRequestChat{}";
    }

    public C10658bz() {
    }
}
