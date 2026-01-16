package io.sentry;

/* renamed from: io.sentry.i1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3128i1 {
    private final Class a;

    private C3128i1(Class cls) {
        this.a = cls;
    }

    public static C3128i1 a(Class cls) {
        return new C3128i1(cls);
    }

    public Object b() {
        return this.a.getDeclaredConstructor(null).newInstance(null);
    }
}
