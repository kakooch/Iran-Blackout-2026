package ir.nasim;

/* renamed from: ir.nasim.ad3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C9826ad3 {
    private final PJ5 a;
    private final int b;
    private Object c;

    public C9826ad3(PJ5 pj5, int i, Object obj) {
        this.a = pj5;
        this.b = i;
        this.c = obj;
    }

    public final Object a() {
        return this.c;
    }

    public final int b() {
        return this.b;
    }

    public final PJ5 c() {
        return this.a;
    }

    public final boolean d() {
        return this.a.x(this.c);
    }

    public final void e(Object obj) {
        this.c = obj;
    }
}
