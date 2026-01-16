package ir.nasim;

/* renamed from: ir.nasim.Ek5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4272Ek5 {
    private final C23182wV a = new C23182wV();
    private final C7386Rm4 b = AbstractC22068uc6.b();
    private Object c;
    private C23182wV d;

    private final C23182wV a(Object obj) {
        C23182wV c23182wV = this.d;
        if (this.c == obj && c23182wV != null) {
            return c23182wV;
        }
        C7386Rm4 c7386Rm4 = this.b;
        Object objE = c7386Rm4.e(obj);
        if (objE == null) {
            objE = this.a.b();
            c7386Rm4.x(obj, objE);
        }
        C23182wV c23182wV2 = (C23182wV) objE;
        this.c = obj;
        this.d = c23182wV2;
        return c23182wV2;
    }

    public final long b(Object obj) {
        return a(obj).c();
    }

    public final long c(Object obj) {
        return a(obj).d();
    }

    public final void d(Object obj, long j) {
        this.a.e(j);
        a(obj).e(j);
    }

    public final void e(Object obj, long j) {
        this.a.f(j);
        a(obj).f(j);
    }
}
