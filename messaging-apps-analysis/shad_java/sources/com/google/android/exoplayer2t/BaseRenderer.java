package com.google.android.exoplayer2t;

import android.os.Looper;
import com.google.android.exoplayer2t.Renderer;
import com.google.android.exoplayer2t.RendererCapabilities;
import com.google.android.exoplayer2t.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2t.drm.DrmInitData;
import com.google.android.exoplayer2t.drm.DrmSession;
import com.google.android.exoplayer2t.drm.DrmSessionManager;
import com.google.android.exoplayer2t.drm.ExoMediaCrypto;
import com.google.android.exoplayer2t.source.SampleStream;
import com.google.android.exoplayer2t.util.Assertions;
import com.google.android.exoplayer2t.util.MediaClock;
import com.google.android.exoplayer2t.util.Util;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class BaseRenderer implements Renderer, RendererCapabilities {
    private RendererConfiguration configuration;
    private int index;
    private int state;
    private SampleStream stream;
    private Format[] streamFormats;
    private boolean streamIsFinal;
    private long streamOffsetUs;
    private boolean throwRendererExceptionIsExecuting;
    private final int trackType;
    private final FormatHolder formatHolder = new FormatHolder();
    private long readingPositionUs = Long.MIN_VALUE;

    @Override // com.google.android.exoplayer2t.Renderer
    public final RendererCapabilities getCapabilities() {
        return this;
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public MediaClock getMediaClock() {
        return null;
    }

    @Override // com.google.android.exoplayer2t.PlayerMessage.Target
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
    }

    protected abstract void onDisabled();

    protected void onEnabled(boolean z) throws ExoPlaybackException {
    }

    protected abstract void onPositionReset(long j, boolean z) throws ExoPlaybackException;

    protected void onReset() {
    }

    protected void onStarted() throws ExoPlaybackException {
    }

    protected void onStopped() throws ExoPlaybackException {
    }

    protected void onStreamChanged(Format[] formatArr, long j) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public /* synthetic */ void setOperatingRate(float f) throws ExoPlaybackException {
        Renderer.CC.$default$setOperatingRate(this, f);
    }

    @Override // com.google.android.exoplayer2t.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }

    public BaseRenderer(int i) {
        this.trackType = i;
    }

    @Override // com.google.android.exoplayer2t.Renderer, com.google.android.exoplayer2t.RendererCapabilities
    public final int getTrackType() {
        return this.trackType;
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j, boolean z, long j2) throws ExoPlaybackException {
        Assertions.checkState(this.state == 0);
        this.configuration = rendererConfiguration;
        this.state = 1;
        onEnabled(z);
        replaceStream(formatArr, sampleStream, j2);
        onPositionReset(j, z);
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final void start() throws ExoPlaybackException {
        Assertions.checkState(this.state == 1);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j) throws ExoPlaybackException {
        Assertions.checkState(!this.streamIsFinal);
        this.stream = sampleStream;
        this.readingPositionUs = j;
        this.streamFormats = formatArr;
        this.streamOffsetUs = j;
        onStreamChanged(formatArr, j);
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final SampleStream getStream() {
        return this.stream;
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final boolean hasReadStreamToEnd() {
        return this.readingPositionUs == Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final long getReadingPositionUs() {
        return this.readingPositionUs;
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final void maybeThrowStreamError() throws IOException {
        this.stream.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final void resetPosition(long j) throws ExoPlaybackException {
        this.streamIsFinal = false;
        this.readingPositionUs = j;
        onPositionReset(j, false);
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final void stop() throws ExoPlaybackException {
        Assertions.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final void disable() {
        Assertions.checkState(this.state == 1);
        this.formatHolder.clear();
        this.state = 0;
        this.stream = null;
        this.streamFormats = null;
        this.streamIsFinal = false;
        onDisabled();
    }

    @Override // com.google.android.exoplayer2t.Renderer
    public final void reset() {
        Assertions.checkState(this.state == 0);
        this.formatHolder.clear();
        onReset();
    }

    protected final FormatHolder getFormatHolder() {
        this.formatHolder.clear();
        return this.formatHolder;
    }

    protected final Format[] getStreamFormats() {
        return this.streamFormats;
    }

    protected final RendererConfiguration getConfiguration() {
        return this.configuration;
    }

    protected final <T extends ExoMediaCrypto> DrmSession<T> getUpdatedSourceDrmSession(Format format, Format format2, DrmSessionManager<T> drmSessionManager, DrmSession<T> drmSession) throws ExoPlaybackException {
        DrmSession<T> drmSessionAcquireSession = null;
        if (!(!Util.areEqual(format2.drmInitData, format == null ? null : format.drmInitData))) {
            return drmSession;
        }
        if (format2.drmInitData != null) {
            if (drmSessionManager == null) {
                throw createRendererException(new IllegalStateException("Media requires a DrmSessionManager"), format2);
            }
            drmSessionAcquireSession = drmSessionManager.acquireSession((Looper) Assertions.checkNotNull(Looper.myLooper()), format2.drmInitData);
        }
        if (drmSession != null) {
            drmSession.release();
        }
        return drmSessionAcquireSession;
    }

    protected final int getIndex() {
        return this.index;
    }

    protected final ExoPlaybackException createRendererException(Exception exc, Format format) {
        int formatSupport;
        if (format == null || this.throwRendererExceptionIsExecuting) {
            formatSupport = 4;
        } else {
            this.throwRendererExceptionIsExecuting = true;
            try {
                formatSupport = RendererCapabilities.CC.getFormatSupport(supportsFormat(format));
            } catch (ExoPlaybackException unused) {
            } finally {
                this.throwRendererExceptionIsExecuting = false;
            }
        }
        return ExoPlaybackException.createForRenderer(exc, getIndex(), format, formatSupport);
    }

    protected final int readSource(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        int data = this.stream.readData(formatHolder, decoderInputBuffer, z);
        if (data == -4) {
            if (decoderInputBuffer.isEndOfStream()) {
                this.readingPositionUs = Long.MIN_VALUE;
                return this.streamIsFinal ? -4 : -3;
            }
            long j = decoderInputBuffer.timeUs + this.streamOffsetUs;
            decoderInputBuffer.timeUs = j;
            this.readingPositionUs = Math.max(this.readingPositionUs, j);
        } else if (data == -5) {
            Format format = formatHolder.format;
            long j2 = format.subsampleOffsetUs;
            if (j2 != Long.MAX_VALUE) {
                formatHolder.format = format.copyWithSubsampleOffsetUs(j2 + this.streamOffsetUs);
            }
        }
        return data;
    }

    protected int skipSource(long j) {
        return this.stream.skipData(j - this.streamOffsetUs);
    }

    protected final boolean isSourceReady() {
        return hasReadStreamToEnd() ? this.streamIsFinal : this.stream.isReady();
    }

    protected static boolean supportsFormatDrm(DrmSessionManager<?> drmSessionManager, DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (drmSessionManager == null) {
            return false;
        }
        return drmSessionManager.canAcquireSession(drmInitData);
    }
}
