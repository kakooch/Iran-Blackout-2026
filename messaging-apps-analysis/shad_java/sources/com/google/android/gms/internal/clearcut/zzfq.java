package com.google.android.gms.internal.clearcut;

import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes.dex */
public enum zzfq {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(BuildConfig.FLAVOR),
    BYTE_STRING(zzbb.zzfi),
    ENUM(null),
    MESSAGE(null);

    private final Object zzlj;

    zzfq(Object obj) {
        this.zzlj = obj;
    }
}
