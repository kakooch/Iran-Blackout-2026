package ir.nasim;

/* renamed from: ir.nasim.gn4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13771gn4 {
    public static final int c = C12544en4.d;
    private final C12544en4 a;
    private final SA2 b;

    public C13771gn4(C12544en4 c12544en4, SA2 sa2) {
        this.a = c12544en4;
        this.b = sa2;
    }

    public final void a(int i, Object obj) {
        this.a.a(i, obj);
        this.b.invoke();
    }

    public final void b() {
        this.a.k();
        this.b.invoke();
    }

    public final C12544en4 c() {
        return this.a;
    }

    public final Object d(int i) {
        Object objW = this.a.w(i);
        this.b.invoke();
        return objW;
    }
}
