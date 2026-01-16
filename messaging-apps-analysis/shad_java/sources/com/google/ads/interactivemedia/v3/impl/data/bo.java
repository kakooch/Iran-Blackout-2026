package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.internal.aps;

/* compiled from: IMASDK */
@aps(a = an.class)
/* loaded from: classes.dex */
public abstract class bo {
    private static final String DEFAULT_TIME_UNIT = "ms";

    public static bo create(VideoProgressUpdate videoProgressUpdate) {
        return new an(videoProgressUpdate.getCurrentTimeMs(), videoProgressUpdate.getDurationMs(), DEFAULT_TIME_UNIT);
    }

    public abstract long currentTime();

    public abstract long duration();

    public abstract String timeUnit();
}
