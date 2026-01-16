package com.google.android.gms.internal.clearcut;

/* loaded from: classes3.dex */
abstract class D {
    private static final D a;
    private static final D b;

    static {
        E e = null;
        a = new F();
        b = new G();
    }

    private D() {
    }

    static D c() {
        return a;
    }

    static D d() {
        return b;
    }

    abstract void a(Object obj, long j);

    abstract void b(Object obj, Object obj2, long j);
}
