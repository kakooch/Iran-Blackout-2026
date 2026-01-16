package ir.nasim;

/* loaded from: classes5.dex */
public class R92 {
    private final Object a;
    private final C9528a7 b;
    private final MM3 c;
    private final C10122b7 d;

    public R92(Object obj, C10122b7 c10122b7, MM3 mm3, C9528a7 c9528a7) {
        this.d = c10122b7;
        this.a = obj;
        this.b = c9528a7;
        this.c = mm3;
    }

    public MM3 a() {
        return this.c;
    }

    public Object b() {
        return this.a;
    }

    public C10122b7 c() {
        return this.d;
    }

    public C9528a7 d() {
        return this.b;
    }

    public String toString() {
        return "{" + this.a + " -> " + this.d.e() + "}";
    }
}
