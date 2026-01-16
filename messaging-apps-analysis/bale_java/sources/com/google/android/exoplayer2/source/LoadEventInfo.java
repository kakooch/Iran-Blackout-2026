package com.google.android.exoplayer2.source;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class LoadEventInfo {
    private static final AtomicLong h = new AtomicLong();
    public final long a;
    public final com.google.android.exoplayer2.upstream.b b;
    public final Uri c;
    public final Map d;
    public final long e;
    public final long f;
    public final long g;

    public LoadEventInfo(long j, com.google.android.exoplayer2.upstream.b bVar, long j2) {
        this(j, bVar, bVar.a, Collections.emptyMap(), j2, 0L, 0L);
    }

    public static long a() {
        return h.getAndIncrement();
    }

    public LoadEventInfo(long j, com.google.android.exoplayer2.upstream.b bVar, Uri uri, Map map, long j2, long j3, long j4) {
        this.a = j;
        this.b = bVar;
        this.c = uri;
        this.d = map;
        this.e = j2;
        this.f = j3;
        this.g = j4;
    }
}
