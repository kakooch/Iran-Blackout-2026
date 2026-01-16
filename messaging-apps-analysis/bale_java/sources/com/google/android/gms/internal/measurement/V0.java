package com.google.android.gms.internal.measurement;

import ir.nasim.Dr8;

/* loaded from: classes3.dex */
abstract class V0 {
    private static final V0 a = new T0(null);
    private static final V0 b = new U0(0 == true ? 1 : 0);

    /* synthetic */ V0(Dr8 dr8) {
    }

    static V0 c() {
        return a;
    }

    static V0 d() {
        return b;
    }

    abstract void a(Object obj, long j);

    abstract void b(Object obj, Object obj2, long j);
}
