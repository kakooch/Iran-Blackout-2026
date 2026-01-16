package ir.nasim;

/* renamed from: ir.nasim.Wo7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8582Wo7 {
    public static final C8582Wo7 a = new C8582Wo7();
    private static final ThreadLocal b = AbstractC9123Yo7.a(new C14539i47("ThreadLocalEventLoop"));

    private C8582Wo7() {
    }

    public final AbstractC8717Xa2 a() {
        return (AbstractC8717Xa2) b.get();
    }

    public final AbstractC8717Xa2 b() {
        ThreadLocal threadLocal = b;
        AbstractC8717Xa2 abstractC8717Xa2 = (AbstractC8717Xa2) threadLocal.get();
        if (abstractC8717Xa2 != null) {
            return abstractC8717Xa2;
        }
        AbstractC8717Xa2 abstractC8717Xa2A = AbstractC9805ab2.a();
        threadLocal.set(abstractC8717Xa2A);
        return abstractC8717Xa2A;
    }

    public final void c() {
        b.set(null);
    }

    public final void d(AbstractC8717Xa2 abstractC8717Xa2) {
        b.set(abstractC8717Xa2);
    }
}
