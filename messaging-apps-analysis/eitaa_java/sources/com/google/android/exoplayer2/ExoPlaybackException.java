package com.google.android.exoplayer2;

import android.os.SystemClock;
import java.io.IOException;

/* loaded from: classes.dex */
public final class ExoPlaybackException extends Exception {
    private final Throwable cause;
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final long timestampMs;
    public final int type;

    public static ExoPlaybackException createForSource(IOException cause) {
        return new ExoPlaybackException(0, cause);
    }

    public static ExoPlaybackException createForRenderer(Exception cause, int rendererIndex, Format rendererFormat, int rendererFormatSupport) {
        return new ExoPlaybackException(1, cause, rendererIndex, rendererFormat, rendererFormat == null ? 4 : rendererFormatSupport);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException cause) {
        return new ExoPlaybackException(2, cause);
    }

    public static ExoPlaybackException createForOutOfMemoryError(OutOfMemoryError cause) {
        return new ExoPlaybackException(4, cause);
    }

    private ExoPlaybackException(int type, Throwable cause) {
        this(type, cause, -1, null, 4);
    }

    private ExoPlaybackException(int type, Throwable cause, int rendererIndex, Format rendererFormat, int rendererFormatSupport) {
        super(cause);
        this.type = type;
        this.cause = cause;
        this.rendererIndex = rendererIndex;
        this.rendererFormat = rendererFormat;
        this.rendererFormatSupport = rendererFormatSupport;
        this.timestampMs = SystemClock.elapsedRealtime();
    }
}
