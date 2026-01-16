package com.google.android.gms.measurement.internal;

import ir.nasim.AbstractC24536ym8;

/* loaded from: classes3.dex */
public final class R0 {
    private static final Object h = new Object();
    private final String a;
    private final P0 b;
    private final Object c;
    private final Object d;
    private final Object e = new Object();
    private volatile Object f = null;
    private volatile Object g = null;

    /* synthetic */ R0(String str, Object obj, Object obj2, P0 p0, AbstractC24536ym8 abstractC24536ym8) {
        this.a = str;
        this.c = obj;
        this.d = obj2;
        this.b = p0;
    }

    public final Object a(Object obj) {
        synchronized (this.e) {
        }
        if (obj != null) {
            return obj;
        }
        if (Q0.a == null) {
            return this.c;
        }
        synchronized (h) {
            try {
                if (C2220c.a()) {
                    return this.g == null ? this.c : this.g;
                }
                try {
                    for (R0 r0 : S0.a) {
                        if (C2220c.a()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        Object objZza = null;
                        try {
                            P0 p0 = r0.b;
                            if (p0 != null) {
                                objZza = p0.zza();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (h) {
                            r0.g = objZza;
                        }
                    }
                } catch (SecurityException unused2) {
                }
                P0 p02 = this.b;
                if (p02 == null) {
                    return this.c;
                }
                try {
                    return p02.zza();
                } catch (IllegalStateException unused3) {
                    return this.c;
                } catch (SecurityException unused4) {
                    return this.c;
                }
            } finally {
            }
        }
    }

    public final String b() {
        return this.a;
    }
}
