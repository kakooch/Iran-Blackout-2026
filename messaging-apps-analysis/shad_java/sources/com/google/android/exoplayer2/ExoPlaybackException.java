package com.google.android.exoplayer2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.MediaSource;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class ExoPlaybackException extends Exception {
    private final Throwable cause;
    public final MediaSource.MediaPeriodId mediaPeriodId;
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final String rendererName;
    public final int timeoutOperation;
    public final long timestampMs;
    public final int type;

    public static ExoPlaybackException createForSource(IOException iOException) {
        return new ExoPlaybackException(0, iOException);
    }

    public static ExoPlaybackException createForRenderer(Exception exc, String str, int i, Format format, int i2) {
        return new ExoPlaybackException(1, exc, null, str, i, format, format == null ? 4 : i2, 0);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, runtimeException);
    }

    public static ExoPlaybackException createForOutOfMemory(OutOfMemoryError outOfMemoryError) {
        return new ExoPlaybackException(4, outOfMemoryError);
    }

    public static ExoPlaybackException createForTimeout(TimeoutException timeoutException, int i) {
        return new ExoPlaybackException(5, timeoutException, null, null, -1, null, 4, i);
    }

    private ExoPlaybackException(int i, Throwable th) {
        this(i, th, null, null, -1, null, 4, 0);
    }

    private ExoPlaybackException(int i, Throwable th, String str, String str2, int i2, Format format, int i3, int i4) {
        this(deriveMessage(i, str, str2, i2, format, i3), th, i, str2, i2, format, i3, null, i4, SystemClock.elapsedRealtime());
    }

    private ExoPlaybackException(String str, Throwable th, int i, String str2, int i2, Format format, int i3, MediaSource.MediaPeriodId mediaPeriodId, int i4, long j) {
        super(str, th);
        this.type = i;
        this.cause = th;
        this.rendererName = str2;
        this.rendererIndex = i2;
        this.rendererFormat = format;
        this.rendererFormatSupport = i3;
        this.mediaPeriodId = mediaPeriodId;
        this.timeoutOperation = i4;
        this.timestampMs = j;
    }

    ExoPlaybackException copyWithMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId) {
        return new ExoPlaybackException(getMessage(), this.cause, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, mediaPeriodId, this.timeoutOperation, this.timestampMs);
    }

    private static String deriveMessage(int i, String str, String str2, int i2, Format format, int i3) {
        String str3;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = i != 3 ? i != 4 ? i != 5 ? "Unexpected runtime error" : "Timeout error" : "Out of memory error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i2 + ", format=" + format + ", format_supported=" + RendererCapabilities.CC.getFormatSupportString(i3);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }
}
