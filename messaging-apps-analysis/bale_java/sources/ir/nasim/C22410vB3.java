package ir.nasim;

/* renamed from: ir.nasim.vB3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C22410vB3 {
    private final Object a;
    private final Object b;

    public C22410vB3(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public final boolean a() {
        return this.b != C24746z82.a;
    }

    public final boolean b() {
        return this.a != C24746z82.a;
    }

    public final Object c() {
        return this.b;
    }

    public final Object d() {
        return this.a;
    }

    public final C22410vB3 e(Object obj) {
        return new C22410vB3(this.a, obj);
    }

    public final C22410vB3 f(Object obj) {
        return new C22410vB3(obj, this.b);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C22410vB3() {
        C24746z82 c24746z82 = C24746z82.a;
        this(c24746z82, c24746z82);
    }

    public C22410vB3(Object obj) {
        this(obj, C24746z82.a);
    }
}
