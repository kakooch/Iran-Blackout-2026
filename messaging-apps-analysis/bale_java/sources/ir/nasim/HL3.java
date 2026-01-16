package ir.nasim;

import ir.nasim.C15680jz5;
import ir.nasim.C19451qN3;

/* loaded from: classes5.dex */
public class HL3 {
    private final long a;
    private final byte[] b;
    private final long c;
    private final LZ2 d;
    private final IL3 e;
    private final String i;
    private final int j;
    private final int k;
    private final int l;
    private final C9528a7 g = C19451qN3.J(this);
    private final C9528a7 h = C15680jz5.G(this);
    private final C9528a7 f = XI5.D(this);

    public HL3(long j, byte[] bArr, long j2, LZ2 lz2, IL3 il3, String str, int i, int i2, int i3) {
        this.a = j;
        this.b = bArr;
        this.c = j2;
        this.d = lz2;
        this.e = il3;
        this.i = str;
        this.j = i;
        this.k = i2;
        this.l = i3;
    }

    public void a(long j) {
        this.h.d(new C15680jz5.d(j, true));
    }

    public void b() {
        this.g.d(new C19451qN3.g());
    }

    public String c() {
        return this.i;
    }

    public long d() {
        return this.a;
    }

    public byte[] e() {
        return this.b;
    }

    public IL3 f() {
        return this.e;
    }

    public LZ2 g() {
        return this.d;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.l;
    }

    public int j() {
        return this.j;
    }

    public long k() {
        return this.c;
    }

    public void l(boolean z) {
        this.g.d(new C19451qN3.c(z));
    }

    public void m(EnumC19739qr4 enumC19739qr4) {
        this.g.d(new C19451qN3.i(enumC19739qr4));
    }

    public void n() {
        this.g.d(new C19451qN3.l());
    }

    public long o(AbstractC24641yx5 abstractC24641yx5) {
        long jA = NL3.a();
        this.h.d(new C15680jz5.g(jA, new LL3(abstractC24641yx5.b()).b()));
        return jA;
    }

    public void p() {
        C9528a7 c9528a7 = this.h;
        C12485eh5 c12485eh5 = C12485eh5.a;
        c9528a7.d(c12485eh5);
        this.g.d(c12485eh5);
        this.f.d(c12485eh5);
    }
}
