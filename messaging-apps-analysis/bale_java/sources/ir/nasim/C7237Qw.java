package ir.nasim;

/* renamed from: ir.nasim.Qw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C7237Qw extends AbstractC17902nl0 {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;

    public C7237Qw(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = z6;
        this.g = z7;
        this.h = z8;
        this.i = z9;
        this.j = z10;
        this.k = z11;
        this.l = z12;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.b(1);
        this.b = c19084pl0.b(2);
        this.c = c19084pl0.b(3);
        this.d = c19084pl0.b(4);
        this.e = c19084pl0.b(5);
        this.f = c19084pl0.b(6);
        this.g = c19084pl0.b(7);
        this.h = c19084pl0.b(8);
        this.i = c19084pl0.b(9);
        this.j = c19084pl0.b(10);
        this.k = c19084pl0.b(11);
        this.l = c19084pl0.b(12);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.a(1, this.a);
        c19675ql0.a(2, this.b);
        c19675ql0.a(3, this.c);
        c19675ql0.a(4, this.d);
        c19675ql0.a(5, this.e);
        c19675ql0.a(6, this.f);
        c19675ql0.a(7, this.g);
        c19675ql0.a(8, this.h);
        c19675ql0.a(9, this.i);
        c19675ql0.a(10, this.j);
        c19675ql0.a(11, this.k);
        c19675ql0.a(12, this.l);
    }

    public String toString() {
        return "struct ChatAdministratorRights{}";
    }

    public C7237Qw() {
    }
}
