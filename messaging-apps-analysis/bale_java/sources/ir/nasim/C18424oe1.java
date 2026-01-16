package ir.nasim;

/* renamed from: ir.nasim.oe1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18424oe1 {
    public static final C18424oe1 i = new a().a();
    private EnumC22806vr4 a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private long f;
    private long g;
    private C21563tl1 h;

    /* renamed from: ir.nasim.oe1$a */
    public static final class a {
        boolean a = false;
        boolean b = false;
        EnumC22806vr4 c = EnumC22806vr4.NOT_REQUIRED;
        boolean d = false;
        boolean e = false;
        long f = -1;
        long g = -1;
        C21563tl1 h = new C21563tl1();

        public C18424oe1 a() {
            return new C18424oe1(this);
        }

        public a b(boolean z) {
            this.d = z;
            return this;
        }
    }

    public C18424oe1() {
        this.a = EnumC22806vr4.NOT_REQUIRED;
        this.f = -1L;
        this.g = -1L;
        this.h = new C21563tl1();
    }

    public C21563tl1 a() {
        return this.h;
    }

    public EnumC22806vr4 b() {
        return this.a;
    }

    public long c() {
        return this.f;
    }

    public long d() {
        return this.g;
    }

    public boolean e() {
        return this.h.c() > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C18424oe1.class != obj.getClass()) {
            return false;
        }
        C18424oe1 c18424oe1 = (C18424oe1) obj;
        if (this.b == c18424oe1.b && this.c == c18424oe1.c && this.d == c18424oe1.d && this.e == c18424oe1.e && this.f == c18424oe1.f && this.g == c18424oe1.g && this.a == c18424oe1.a) {
            return this.h.equals(c18424oe1.h);
        }
        return false;
    }

    public boolean f() {
        return this.d;
    }

    public boolean g() {
        return this.b;
    }

    public boolean h() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        long j = this.f;
        int i2 = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.g;
        return ((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.h.hashCode();
    }

    public boolean i() {
        return this.e;
    }

    public void j(C21563tl1 c21563tl1) {
        this.h = c21563tl1;
    }

    public void k(EnumC22806vr4 enumC22806vr4) {
        this.a = enumC22806vr4;
    }

    public void l(boolean z) {
        this.d = z;
    }

    public void m(boolean z) {
        this.b = z;
    }

    public void n(boolean z) {
        this.c = z;
    }

    public void o(boolean z) {
        this.e = z;
    }

    public void p(long j) {
        this.f = j;
    }

    public void q(long j) {
        this.g = j;
    }

    C18424oe1(a aVar) {
        this.a = EnumC22806vr4.NOT_REQUIRED;
        this.f = -1L;
        this.g = -1L;
        this.h = new C21563tl1();
        this.b = aVar.a;
        this.c = aVar.b;
        this.a = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.h = aVar.h;
        this.f = aVar.f;
        this.g = aVar.g;
    }

    public C18424oe1(C18424oe1 c18424oe1) {
        this.a = EnumC22806vr4.NOT_REQUIRED;
        this.f = -1L;
        this.g = -1L;
        this.h = new C21563tl1();
        this.b = c18424oe1.b;
        this.c = c18424oe1.c;
        this.a = c18424oe1.a;
        this.d = c18424oe1.d;
        this.e = c18424oe1.e;
        this.h = c18424oe1.h;
    }
}
