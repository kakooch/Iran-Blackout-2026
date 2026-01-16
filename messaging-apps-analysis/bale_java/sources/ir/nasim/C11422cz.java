package ir.nasim;

/* renamed from: ir.nasim.cz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11422cz extends AbstractC17902nl0 {
    private int a;
    private boolean b;
    private boolean c;

    public C11422cz(int i, boolean z, boolean z2) {
        this.a = i;
        this.b = z;
        this.c = z2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.b(2);
        this.c = c19084pl0.b(3);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.a(2, this.b);
        c19675ql0.a(3, this.c);
    }

    public String toString() {
        return "struct KeyboardButtonRequestUser{}";
    }

    public C11422cz() {
    }
}
