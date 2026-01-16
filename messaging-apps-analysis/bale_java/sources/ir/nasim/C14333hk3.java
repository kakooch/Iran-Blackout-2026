package ir.nasim;

/* renamed from: ir.nasim.hk3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C14333hk3 {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private String g;
    private boolean h;
    private boolean i;
    private String j;
    private EnumC24354yU0 k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private AbstractC3859Cq6 p;

    public C14333hk3(AbstractC11279ck3 abstractC11279ck3) {
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        this.a = abstractC11279ck3.d().h();
        this.b = abstractC11279ck3.d().i();
        this.c = abstractC11279ck3.d().j();
        this.d = abstractC11279ck3.d().p();
        this.e = abstractC11279ck3.d().b();
        this.f = abstractC11279ck3.d().l();
        this.g = abstractC11279ck3.d().m();
        this.h = abstractC11279ck3.d().f();
        this.i = abstractC11279ck3.d().o();
        this.j = abstractC11279ck3.d().d();
        this.k = abstractC11279ck3.d().e();
        this.l = abstractC11279ck3.d().a();
        this.m = abstractC11279ck3.d().n();
        abstractC11279ck3.d().k();
        this.n = abstractC11279ck3.d().g();
        this.o = abstractC11279ck3.d().c();
        this.p = abstractC11279ck3.a();
    }

    public final C15531jk3 a() {
        if (this.i) {
            if (!AbstractC13042fc3.d(this.j, "type")) {
                throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
            }
            if (this.k != EnumC24354yU0.c) {
                throw new IllegalArgumentException("useArrayPolymorphism option can only be used if classDiscriminatorMode in a default POLYMORPHIC state.".toString());
            }
        }
        if (this.f) {
            if (!AbstractC13042fc3.d(this.g, "    ")) {
                String str = this.g;
                for (int i = 0; i < str.length(); i++) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                        throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.g).toString());
                    }
                }
            }
        } else if (!AbstractC13042fc3.d(this.g, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
        }
        return new C15531jk3(this.a, this.c, this.d, this.e, this.f, this.b, this.g, this.h, this.i, this.j, this.l, this.m, null, this.n, this.o, this.k);
    }

    public final AbstractC3859Cq6 b() {
        return this.p;
    }

    public final void c(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.j = str;
    }

    public final void d(boolean z) {
        this.c = z;
    }

    public final void e(AbstractC3859Cq6 abstractC3859Cq6) {
        AbstractC13042fc3.i(abstractC3859Cq6, "<set-?>");
        this.p = abstractC3859Cq6;
    }
}
