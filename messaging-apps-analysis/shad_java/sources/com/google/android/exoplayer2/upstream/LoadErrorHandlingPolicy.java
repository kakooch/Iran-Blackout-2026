package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import java.io.IOException;

/* loaded from: classes.dex */
public interface LoadErrorHandlingPolicy {

    /* renamed from: com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onLoadTaskConcluded(LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j) {
        }
    }

    long getBlacklistDurationMsFor(LoadErrorInfo loadErrorInfo);

    int getMinimumLoadableRetryCount(int i);

    long getRetryDelayMsFor(LoadErrorInfo loadErrorInfo);

    void onLoadTaskConcluded(long j);

    public static final class LoadErrorInfo {
        public final int errorCount;
        public final IOException exception;
        public final LoadEventInfo loadEventInfo;
        public final MediaLoadData mediaLoadData;

        public LoadErrorInfo(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, int i) {
            this.loadEventInfo = loadEventInfo;
            this.mediaLoadData = mediaLoadData;
            this.exception = iOException;
            this.errorCount = i;
        }
    }
}
