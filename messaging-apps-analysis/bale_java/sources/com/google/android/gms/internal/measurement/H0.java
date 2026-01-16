package com.google.android.gms.internal.measurement;

import ir.nasim.AbstractC16788lr8;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.Qr8;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public final class H0 {
    private static volatile H0 b;
    static final H0 c = new H0(true);
    private final Map a = Collections.emptyMap();

    H0(boolean z) {
    }

    public static H0 a() {
        H0 h0 = b;
        if (h0 != null) {
            return h0;
        }
        synchronized (H0.class) {
            try {
                H0 h02 = b;
                if (h02 != null) {
                    return h02;
                }
                H0 h0A = M0.a(H0.class);
                b = h0A;
                return h0A;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final AbstractC16788lr8 b(Qr8 qr8, int i) {
        AbstractC18350oW3.a(this.a.get(new G0(qr8, i)));
        return null;
    }
}
