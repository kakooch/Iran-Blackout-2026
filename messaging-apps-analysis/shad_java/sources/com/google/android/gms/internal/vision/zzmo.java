package com.google.android.gms.internal.vision;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
public enum zzmo {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(BuildConfig.FLAVOR),
    BYTE_STRING(zzht.zza),
    ENUM(null),
    MESSAGE(null);

    private final Object zzj;

    zzmo(Object obj) {
        this.zzj = obj;
    }
}
