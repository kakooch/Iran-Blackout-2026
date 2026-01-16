package com.google.android.exoplayer2.drm;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MediaDrmCallbackException extends IOException {
    public final com.google.android.exoplayer2.upstream.b a;
    public final Uri b;
    public final Map c;
    public final long d;

    public MediaDrmCallbackException(com.google.android.exoplayer2.upstream.b bVar, Uri uri, Map map, long j, Throwable th) {
        super(th);
        this.a = bVar;
        this.b = uri;
        this.c = map;
        this.d = j;
    }
}
