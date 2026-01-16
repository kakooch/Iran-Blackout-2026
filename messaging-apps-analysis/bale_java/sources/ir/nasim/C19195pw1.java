package ir.nasim;

/* renamed from: ir.nasim.pw1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C19195pw1 {
    private int a = 0;
    private a b = a.NUMERIC;

    /* renamed from: ir.nasim.pw1$a */
    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    C19195pw1() {
    }

    int a() {
        return this.a;
    }

    void b(int i) {
        this.a += i;
    }

    boolean c() {
        return this.b == a.ALPHA;
    }

    boolean d() {
        return this.b == a.ISO_IEC_646;
    }

    void e() {
        this.b = a.ALPHA;
    }

    void f() {
        this.b = a.ISO_IEC_646;
    }

    void g() {
        this.b = a.NUMERIC;
    }

    void h(int i) {
        this.a = i;
    }
}
