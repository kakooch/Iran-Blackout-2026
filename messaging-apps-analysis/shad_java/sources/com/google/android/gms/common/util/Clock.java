package com.google.android.gms.common.util;

/* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
/* loaded from: classes.dex */
public interface Clock {
    long currentTimeMillis();

    long elapsedRealtime();

    long nanoTime();
}
