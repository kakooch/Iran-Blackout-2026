package com.google.android.gms.internal.clearcut;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzbt {
    static final zzbt zzgo;
    private final Map<Object, Object> zzgp;

    static {
        zzam();
        zzgo = new zzbt(true);
    }

    zzbt() {
        new HashMap();
    }

    private zzbt(boolean z) {
        this.zzgp = Collections.emptyMap();
    }

    private static Class<?> zzam() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzbt zzan() {
        return zzbs.zzal();
    }
}
