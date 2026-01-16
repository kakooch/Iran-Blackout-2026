package com.google.android.gms.internal.vision;

/* renamed from: com.google.android.gms.internal.vision.p0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2190p0 {
    private static final AbstractC2190p0 a;
    private static final AbstractC2190p0 b;

    static {
        AbstractC2193r0 abstractC2193r0 = null;
        a = new C2192q0();
        b = new C2197t0();
    }

    private AbstractC2190p0() {
    }

    static AbstractC2190p0 a() {
        return a;
    }

    static AbstractC2190p0 c() {
        return b;
    }

    abstract void b(Object obj, Object obj2, long j);

    abstract void d(Object obj, long j);
}
