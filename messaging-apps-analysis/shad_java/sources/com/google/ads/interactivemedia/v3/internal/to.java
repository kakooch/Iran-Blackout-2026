package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class to {
    private static final AtomicLong a = new AtomicLong();

    public to() {
    }

    public to(acb acbVar) {
        Uri uri = acbVar.a;
        Collections.emptyMap();
    }

    public static long a() {
        return a.getAndIncrement();
    }
}
