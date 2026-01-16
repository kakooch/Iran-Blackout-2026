package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import java.util.SortedSet;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class amm implements ant {
    private final apq a;
    private final SortedSet<Float> b;
    private final ane c;
    private final String d;
    private long e;
    private VideoProgressUpdate f;

    amm(ane aneVar, SortedSet<Float> sortedSet, String str) {
        apr aprVar = new apr();
        this.e = 0L;
        this.f = new VideoProgressUpdate(0L, 0L);
        this.b = sortedSet;
        this.a = aprVar;
        this.c = aneVar;
        this.d = str;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ant
    public final void a(VideoProgressUpdate videoProgressUpdate) {
        if (videoProgressUpdate == null || videoProgressUpdate.getDuration() < 0.0f || videoProgressUpdate.equals(this.f)) {
            return;
        }
        float currentTime = this.f.getCurrentTime();
        float currentTime2 = videoProgressUpdate.getCurrentTime();
        if (!(currentTime < currentTime2 ? this.b.subSet(Float.valueOf(currentTime), Float.valueOf(currentTime2)) : this.b.subSet(Float.valueOf(currentTime2), Float.valueOf(currentTime))).isEmpty() || this.b.contains(Float.valueOf(videoProgressUpdate.getCurrentTime())) || System.currentTimeMillis() - this.e >= 1000) {
            this.e = System.currentTimeMillis();
            this.f = videoProgressUpdate;
            this.c.n(new amx(amv.contentTimeUpdate, amw.contentTimeUpdate, this.d, com.google.ads.interactivemedia.v3.impl.data.bo.create(videoProgressUpdate)));
        }
    }
}
