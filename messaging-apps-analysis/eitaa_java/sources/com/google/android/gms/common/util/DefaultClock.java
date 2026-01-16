package com.google.android.gms.common.util;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes.dex */
public class DefaultClock implements Clock {
    private static final DefaultClock zza = new DefaultClock();

    private DefaultClock() {
    }

    public static Clock getInstance() {
        return zza;
    }
}
