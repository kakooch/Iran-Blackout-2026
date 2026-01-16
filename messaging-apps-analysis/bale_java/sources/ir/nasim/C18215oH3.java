package ir.nasim;

/* renamed from: ir.nasim.oH3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18215oH3 extends AbstractC19230q0 {
    private C4626Fy a;
    private String b;
    private int c;
    private String d;
    private int e;
    private int f;
    private String g;
    private String h;

    public C18215oH3(C14683iJ6 c14683iJ6, int i) {
        AbstractC13042fc3.i(c14683iJ6, "sponsoredMessageAd");
        this.b = "";
        this.d = "";
        this.g = "";
        this.h = "";
        this.a = c14683iJ6.c();
        this.b = c14683iJ6.b();
        this.c = i;
        this.d = c14683iJ6.a();
        this.e = c14683iJ6.f();
        this.f = c14683iJ6.g();
        this.g = c14683iJ6.d();
        this.h = c14683iJ6.e();
    }

    public final int C() {
        return this.e;
    }

    public final int D() {
        return this.f;
    }

    public final int getPeerId() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        this.a = (C4626Fy) c19084pl0.k(1, new C4626Fy());
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.r(4);
        this.e = c19084pl0.g(5);
        this.f = c19084pl0.g(6);
    }

    public final C4626Fy s() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        C4626Fy c4626Fy = this.a;
        if (c4626Fy != null) {
            c19675ql0.i(1, c4626Fy);
        }
        c19675ql0.o(2, this.b);
        c19675ql0.f(3, this.c);
        c19675ql0.o(4, this.d);
        c19675ql0.f(5, this.e);
        c19675ql0.f(6, this.f);
    }

    public final String u() {
        return this.d;
    }

    public final String w() {
        return this.b;
    }

    public final String y() {
        return this.g;
    }

    public final String z() {
        return this.h;
    }

    public C18215oH3(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "data");
        this.b = "";
        this.d = "";
        this.g = "";
        this.h = "";
        load(bArr);
    }
}
