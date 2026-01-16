package ir.nasim;

/* renamed from: ir.nasim.b7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C10122b7 {
    private final String a;
    private final C4614Fw5 b;
    private C9528a7 c;
    private final MM3 d;
    private K6 e;
    private Object f;
    private C9528a7 g;

    public C10122b7(MM3 mm3, String str, C4614Fw5 c4614Fw5, C25156zp4 c25156zp4) {
        this.d = mm3;
        this.c = new C9528a7(c25156zp4, str);
        this.a = str;
        this.b = c4614Fw5;
    }

    public K6 a() {
        return this.e;
    }

    public C9528a7 b() {
        return this.c;
    }

    public MM3 c() {
        return this.d;
    }

    public Object d() {
        return this.f;
    }

    public String e() {
        return this.a;
    }

    public C4614Fw5 f() {
        return this.b;
    }

    public C9528a7 g() {
        return this.g;
    }

    public void h(K6 k6) {
        this.e = k6;
    }

    public void i() {
        this.e = null;
        this.g = null;
        this.f = null;
    }

    public void j(C9528a7 c9528a7) {
        c9528a7.a(this.c);
        this.c = c9528a7;
    }

    public void k(Object obj) {
        this.f = obj;
    }

    public void l(C9528a7 c9528a7) {
        this.g = c9528a7;
    }
}
