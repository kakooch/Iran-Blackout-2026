package com.google.android.exoplayer2.source.hls.offline;

import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.upstream.k;
import ir.nasim.AbstractC23934xl6;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class HlsDownloader extends AbstractC23934xl6 {
    public HlsDownloader(C2018a0 c2018a0, a.c cVar, Executor executor) {
        this(c2018a0, new HlsPlaylistParser(), cVar, executor);
    }

    public HlsDownloader(C2018a0 c2018a0, k.a aVar, a.c cVar, Executor executor) {
        super(c2018a0, aVar, cVar, executor);
    }
}
