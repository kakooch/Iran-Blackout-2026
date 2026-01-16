package ir.nasim;

/* renamed from: ir.nasim.a7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C9528a7 {
    private String a;
    private C25156zp4 b;

    public C9528a7(C25156zp4 c25156zp4, String str) {
        this.b = c25156zp4;
        this.a = str;
    }

    public void a(C9528a7 c9528a7) {
        this.b = c9528a7.b;
        this.a = c9528a7.a;
    }

    public String b() {
        return this.a;
    }

    public void c(Runnable runnable) {
        d(runnable);
    }

    public void d(Object obj) {
        e(obj, null);
    }

    public void e(Object obj, C9528a7 c9528a7) {
        this.b.b().b(new R92(obj, this.b.c(), this.b.b(), c9528a7));
    }

    public void f(Object obj) {
        this.b.b().c(new R92(obj, this.b.c(), this.b.b(), null));
    }

    public void g(Object obj, C9528a7 c9528a7) {
        this.b.b().c(new R92(obj, this.b.c(), this.b.b(), c9528a7));
    }
}
