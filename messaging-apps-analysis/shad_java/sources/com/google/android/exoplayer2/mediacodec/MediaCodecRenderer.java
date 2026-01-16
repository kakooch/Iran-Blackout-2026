package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.facebook.stetho.dumpapp.Framer;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.rbmain.messenger.MediaController;

/* loaded from: classes.dex */
public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] ADAPTATION_WORKAROUND_BUFFER = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, Framer.STDOUT_FRAME_PREFIX, -61, 39, 93, Framer.EXIT_FRAME_PREFIX};
    private final float assumedMinimumCodecOperatingRate;
    private ArrayDeque<MediaCodecInfo> availableCodecInfos;
    private final DecoderInputBuffer buffer;
    private final BatchBuffer bypassBatchBuffer;
    private boolean bypassDrainAndReinitialize;
    private boolean bypassEnabled;
    private C2Mp3TimestampTracker c2Mp3TimestampTracker;
    private MediaCodec codec;
    private int codecAdaptationWorkaroundMode;
    private MediaCodecAdapter codecAdapter;
    private int codecDrainAction;
    private int codecDrainState;
    private DrmSession codecDrmSession;
    private boolean codecHasOutputMediaFormat;
    private long codecHotswapDeadlineMs;
    private MediaCodecInfo codecInfo;
    private Format codecInputFormat;
    private boolean codecNeedsAdaptationWorkaroundBuffer;
    private boolean codecNeedsDiscardToSpsWorkaround;
    private boolean codecNeedsEosFlushWorkaround;
    private boolean codecNeedsEosOutputExceptionWorkaround;
    private boolean codecNeedsEosPropagation;
    private boolean codecNeedsFlushWorkaround;
    private boolean codecNeedsMonoChannelCountWorkaround;
    private boolean codecNeedsReconfigureWorkaround;
    private boolean codecNeedsSosFlushWorkaround;
    private float codecOperatingRate;
    private MediaFormat codecOutputMediaFormat;
    private boolean codecOutputMediaFormatChanged;
    private boolean codecReceivedBuffers;
    private boolean codecReceivedEos;
    private int codecReconfigurationState;
    private boolean codecReconfigured;
    private final ArrayList<Long> decodeOnlyPresentationTimestamps;
    protected DecoderCounters decoderCounters;
    private final boolean enableDecoderFallback;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private final TimedValueQueue<Format> formatQueue;
    private ByteBuffer[] inputBuffers;
    private Format inputFormat;
    private int inputIndex;
    private boolean inputStreamEnded;
    private boolean isDecodeOnlyOutputBuffer;
    private boolean isLastOutputBuffer;
    private long largestQueuedPresentationTimeUs;
    private long lastBufferInStreamPresentationTimeUs;
    private int mediaCodecOperationMode;
    private final MediaCodecSelector mediaCodecSelector;
    private MediaCrypto mediaCrypto;
    private boolean mediaCryptoRequiresSecureDecoder;
    private float operatingRate;
    private ByteBuffer outputBuffer;
    private final MediaCodec.BufferInfo outputBufferInfo;
    private ByteBuffer[] outputBuffers;
    private Format outputFormat;
    private int outputIndex;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    private long outputStreamStartPositionUs;
    private boolean pendingOutputEndOfStream;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private final long[] pendingOutputStreamStartPositionsUs;
    private final long[] pendingOutputStreamSwitchTimesUs;
    private ExoPlaybackException pendingPlaybackException;
    private DecoderInitializationException preferredDecoderInitializationException;
    private long renderTimeLimitMs;
    private boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    private DrmSession sourceDrmSession;
    private boolean waitingForFirstSampleInFormat;

    protected abstract int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2);

    protected abstract void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodecAdapter mediaCodecAdapter, Format format, MediaCrypto mediaCrypto, float f);

    protected boolean getCodecNeedsEosPropagation() {
        return false;
    }

    protected abstract float getCodecOperatingRateV23(float f, Format format, Format[] formatArr);

    protected abstract List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException;

    protected void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    protected boolean legacyKeepAvailableCodecInfosWithoutCodec() {
        return false;
    }

    protected abstract void onCodecInitialized(String str, long j, long j2);

    protected abstract void onOutputFormatChanged(Format format, MediaFormat mediaFormat) throws ExoPlaybackException;

    protected void onProcessedStreamChange() {
    }

    protected abstract void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException;

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
    }

    protected abstract boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException;

    protected void renderToEndOfStream() throws ExoPlaybackException {
    }

    protected boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    protected boolean shouldUseBypass(Format format) {
        return false;
    }

    protected abstract int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public static class DecoderInitializationException extends Exception {
        public final MediaCodecInfo codecInfo;
        public final String diagnosticInfo;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format, Throwable th, boolean z, int i) {
            this("Decoder init failed: [" + i + "], " + format, th, format.sampleMimeType, z, null, buildCustomDiagnosticInfo(i), null);
        }

        public DecoderInitializationException(Format format, Throwable th, boolean z, MediaCodecInfo mediaCodecInfo) {
            this("Decoder init failed: " + mediaCodecInfo.name + ", " + format, th, format.sampleMimeType, z, mediaCodecInfo, Util.SDK_INT >= 21 ? getDiagnosticInfoV21(th) : null, null);
        }

        private DecoderInitializationException(String str, Throwable th, String str2, boolean z, MediaCodecInfo mediaCodecInfo, String str3, DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z;
            this.codecInfo = mediaCodecInfo;
            this.diagnosticInfo = str3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DecoderInitializationException copyWithFallbackException(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, decoderInitializationException);
        }

        private static String getDiagnosticInfoV21(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String buildCustomDiagnosticInfo(int i) {
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : BuildConfig.FLAVOR) + Math.abs(i);
        }
    }

    public MediaCodecRenderer(int i, MediaCodecSelector mediaCodecSelector, boolean z, float f) {
        super(i);
        this.mediaCodecSelector = (MediaCodecSelector) Assertions.checkNotNull(mediaCodecSelector);
        this.enableDecoderFallback = z;
        this.assumedMinimumCodecOperatingRate = f;
        this.buffer = new DecoderInputBuffer(0);
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.formatQueue = new TimedValueQueue<>();
        this.decodeOnlyPresentationTimestamps = new ArrayList<>();
        this.outputBufferInfo = new MediaCodec.BufferInfo();
        this.operatingRate = 1.0f;
        this.mediaCodecOperationMode = 0;
        this.renderTimeLimitMs = -9223372036854775807L;
        this.pendingOutputStreamStartPositionsUs = new long[10];
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.pendingOutputStreamSwitchTimesUs = new long[10];
        this.outputStreamStartPositionUs = -9223372036854775807L;
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.bypassBatchBuffer = new BatchBuffer();
        resetCodecStateForRelease();
    }

    public void experimentalSetMediaCodecOperationMode(int i) {
        this.mediaCodecOperationMode = i;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(Format format) throws ExoPlaybackException {
        try {
            return supportsFormat(this.mediaCodecSelector, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw createRendererException(e, format);
        }
    }

    protected final void maybeInitCodecOrBypass() throws ExoPlaybackException {
        Format format;
        if (this.codec != null || this.bypassEnabled || (format = this.inputFormat) == null) {
            return;
        }
        if (this.sourceDrmSession == null && shouldUseBypass(format)) {
            initBypass(this.inputFormat);
            return;
        }
        setCodecDrmSession(this.sourceDrmSession);
        String str = this.inputFormat.sampleMimeType;
        DrmSession drmSession = this.codecDrmSession;
        if (drmSession != null) {
            if (this.mediaCrypto == null) {
                FrameworkMediaCrypto frameworkMediaCrypto = getFrameworkMediaCrypto(drmSession);
                if (frameworkMediaCrypto == null) {
                    if (this.codecDrmSession.getError() == null) {
                        return;
                    }
                } else {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(frameworkMediaCrypto.uuid, frameworkMediaCrypto.sessionId);
                        this.mediaCrypto = mediaCrypto;
                        this.mediaCryptoRequiresSecureDecoder = !frameworkMediaCrypto.forceAllowInsecureDecoderComponents && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e) {
                        throw createRendererException(e, this.inputFormat);
                    }
                }
            }
            if (FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) {
                int state = this.codecDrmSession.getState();
                if (state == 1) {
                    throw createRendererException(this.codecDrmSession.getError(), this.inputFormat);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            maybeInitCodecWithFallback(this.mediaCrypto, this.mediaCryptoRequiresSecureDecoder);
        } catch (DecoderInitializationException e2) {
            throw createRendererException(e2, this.inputFormat);
        }
    }

    protected final void setPendingPlaybackException(ExoPlaybackException exoPlaybackException) {
        this.pendingPlaybackException = exoPlaybackException;
    }

    protected final void updateOutputFormatForTime(long j) throws ExoPlaybackException {
        boolean z;
        Format formatPollFloor = this.formatQueue.pollFloor(j);
        if (formatPollFloor == null && this.codecOutputMediaFormatChanged) {
            formatPollFloor = this.formatQueue.pollFirst();
        }
        if (formatPollFloor != null) {
            this.outputFormat = formatPollFloor;
            z = true;
        } else {
            z = false;
        }
        if (z || (this.codecOutputMediaFormatChanged && this.outputFormat != null)) {
            onOutputFormatChanged(this.outputFormat, this.codecOutputMediaFormat);
            this.codecOutputMediaFormatChanged = false;
        }
    }

    protected Format getInputFormat() {
        return this.inputFormat;
    }

    protected final Format getOutputFormat() {
        return this.outputFormat;
    }

    protected final MediaCodec getCodec() {
        return this.codec;
    }

    protected final MediaFormat getCodecOutputMediaFormat() {
        return this.codecOutputMediaFormat;
    }

    protected final MediaCodecInfo getCodecInfo() {
        return this.codecInfo;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        this.decoderCounters = new DecoderCounters();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStreamChanged(Format[] formatArr, long j, long j2) throws ExoPlaybackException {
        if (this.outputStreamOffsetUs == -9223372036854775807L) {
            Assertions.checkState(this.outputStreamStartPositionUs == -9223372036854775807L);
            this.outputStreamStartPositionUs = j;
            this.outputStreamOffsetUs = j2;
            return;
        }
        int i = this.pendingOutputStreamOffsetCount;
        if (i == this.pendingOutputStreamOffsetsUs.length) {
            Log.w("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
        } else {
            this.pendingOutputStreamOffsetCount = i + 1;
        }
        long[] jArr = this.pendingOutputStreamStartPositionsUs;
        int i2 = this.pendingOutputStreamOffsetCount;
        jArr[i2 - 1] = j;
        this.pendingOutputStreamOffsetsUs[i2 - 1] = j2;
        this.pendingOutputStreamSwitchTimesUs[i2 - 1] = this.largestQueuedPresentationTimeUs;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.pendingOutputEndOfStream = false;
        if (this.bypassEnabled) {
            this.bypassBatchBuffer.flush();
        } else {
            flushOrReinitializeCodec();
        }
        if (this.formatQueue.size() > 0) {
            this.waitingForFirstSampleInFormat = true;
        }
        this.formatQueue.clear();
        int i = this.pendingOutputStreamOffsetCount;
        if (i != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[i - 1];
            this.outputStreamStartPositionUs = this.pendingOutputStreamStartPositionsUs[i - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public void setOperatingRate(float f) throws ExoPlaybackException {
        this.operatingRate = f;
        if (this.codec == null || this.codecDrainAction == 3 || getState() == 0) {
            return;
        }
        updateCodecOperatingRate();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.inputFormat = null;
        this.outputStreamStartPositionUs = -9223372036854775807L;
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.pendingOutputStreamOffsetCount = 0;
        if (this.sourceDrmSession != null || this.codecDrmSession != null) {
            onReset();
        } else {
            flushOrReleaseCodec();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onReset() {
        try {
            disableBypass();
            releaseCodec();
        } finally {
            setSourceDrmSession(null);
        }
    }

    private void disableBypass() {
        this.bypassDrainAndReinitialize = false;
        this.bypassBatchBuffer.clear();
        this.bypassEnabled = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void releaseCodec() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.codecAdapter;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.shutdown();
            }
            MediaCodec mediaCodec = this.codec;
            if (mediaCodec != null) {
                this.decoderCounters.decoderReleaseCount++;
                mediaCodec.release();
            }
            this.codec = null;
            this.codecAdapter = null;
            try {
                MediaCrypto mediaCrypto = this.mediaCrypto;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.codec = null;
            this.codecAdapter = null;
            try {
                MediaCrypto mediaCrypto2 = this.mediaCrypto;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException, MediaCryptoException {
        if (this.pendingOutputEndOfStream) {
            this.pendingOutputEndOfStream = false;
            processEndOfStream();
        }
        ExoPlaybackException exoPlaybackException = this.pendingPlaybackException;
        if (exoPlaybackException != null) {
            this.pendingPlaybackException = null;
            throw exoPlaybackException;
        }
        try {
            if (this.outputStreamEnded) {
                renderToEndOfStream();
                return;
            }
            if (this.inputFormat != null || readToFlagsOnlyBuffer(true)) {
                maybeInitCodecOrBypass();
                if (this.bypassEnabled) {
                    TraceUtil.beginSection("bypassRender");
                    while (bypassRender(j, j2)) {
                    }
                    TraceUtil.endSection();
                } else if (this.codec != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    TraceUtil.beginSection("drainAndFeed");
                    while (drainOutputBuffer(j, j2) && shouldContinueRendering(jElapsedRealtime)) {
                    }
                    while (feedInputBuffer() && shouldContinueRendering(jElapsedRealtime)) {
                    }
                    TraceUtil.endSection();
                } else {
                    this.decoderCounters.skippedInputBufferCount += skipSource(j);
                    readToFlagsOnlyBuffer(false);
                }
                this.decoderCounters.ensureUpdated();
            }
        } catch (IllegalStateException e) {
            if (isMediaCodecException(e)) {
                throw createRendererException(createDecoderException(e, getCodecInfo()), this.inputFormat);
            }
            throw e;
        }
    }

    protected final boolean flushOrReinitializeCodec() throws ExoPlaybackException {
        boolean zFlushOrReleaseCodec = flushOrReleaseCodec();
        if (zFlushOrReleaseCodec) {
            maybeInitCodecOrBypass();
        }
        return zFlushOrReleaseCodec;
    }

    protected boolean flushOrReleaseCodec() {
        if (this.codec == null) {
            return false;
        }
        if (this.codecDrainAction == 3 || this.codecNeedsFlushWorkaround || ((this.codecNeedsSosFlushWorkaround && !this.codecHasOutputMediaFormat) || (this.codecNeedsEosFlushWorkaround && this.codecReceivedEos))) {
            releaseCodec();
            return true;
        }
        try {
            this.codecAdapter.flush();
            return false;
        } finally {
            resetCodecStateForFlush();
        }
    }

    protected void resetCodecStateForFlush() {
        resetInputBuffer();
        resetOutputBuffer();
        this.codecHotswapDeadlineMs = -9223372036854775807L;
        this.codecReceivedEos = false;
        this.codecReceivedBuffers = false;
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        this.isDecodeOnlyOutputBuffer = false;
        this.isLastOutputBuffer = false;
        this.decodeOnlyPresentationTimestamps.clear();
        this.largestQueuedPresentationTimeUs = -9223372036854775807L;
        this.lastBufferInStreamPresentationTimeUs = -9223372036854775807L;
        C2Mp3TimestampTracker c2Mp3TimestampTracker = this.c2Mp3TimestampTracker;
        if (c2Mp3TimestampTracker != null) {
            c2Mp3TimestampTracker.reset();
        }
        this.codecDrainState = 0;
        this.codecDrainAction = 0;
        this.codecReconfigurationState = this.codecReconfigured ? 1 : 0;
    }

    protected void resetCodecStateForRelease() {
        resetCodecStateForFlush();
        this.pendingPlaybackException = null;
        this.c2Mp3TimestampTracker = null;
        this.availableCodecInfos = null;
        this.codecInfo = null;
        this.codecInputFormat = null;
        this.codecOutputMediaFormat = null;
        this.codecOutputMediaFormatChanged = false;
        this.codecHasOutputMediaFormat = false;
        this.codecOperatingRate = -1.0f;
        this.codecAdaptationWorkaroundMode = 0;
        this.codecNeedsReconfigureWorkaround = false;
        this.codecNeedsDiscardToSpsWorkaround = false;
        this.codecNeedsFlushWorkaround = false;
        this.codecNeedsSosFlushWorkaround = false;
        this.codecNeedsEosFlushWorkaround = false;
        this.codecNeedsEosOutputExceptionWorkaround = false;
        this.codecNeedsMonoChannelCountWorkaround = false;
        this.codecNeedsEosPropagation = false;
        this.codecReconfigured = false;
        this.codecReconfigurationState = 0;
        resetCodecBuffers();
        this.mediaCryptoRequiresSecureDecoder = false;
    }

    protected MediaCodecDecoderException createDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecDecoderException(th, mediaCodecInfo);
    }

    private boolean readToFlagsOnlyBuffer(boolean z) throws ExoPlaybackException, MediaCryptoException {
        FormatHolder formatHolder = getFormatHolder();
        this.flagsOnlyBuffer.clear();
        int source = readSource(formatHolder, this.flagsOnlyBuffer, z);
        if (source == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (source != -4 || !this.flagsOnlyBuffer.isEndOfStream()) {
            return false;
        }
        this.inputStreamEnded = true;
        processEndOfStream();
        return false;
    }

    private void maybeInitCodecWithFallback(MediaCrypto mediaCrypto, boolean z) throws DecoderInitializationException {
        if (this.availableCodecInfos == null) {
            try {
                List<MediaCodecInfo> availableCodecInfos = getAvailableCodecInfos(z);
                ArrayDeque<MediaCodecInfo> arrayDeque = new ArrayDeque<>();
                this.availableCodecInfos = arrayDeque;
                if (this.enableDecoderFallback) {
                    arrayDeque.addAll(availableCodecInfos);
                } else if (!availableCodecInfos.isEmpty()) {
                    this.availableCodecInfos.add(availableCodecInfos.get(0));
                }
                this.preferredDecoderInitializationException = null;
            } catch (MediaCodecUtil.DecoderQueryException e) {
                throw new DecoderInitializationException(this.inputFormat, e, z, -49998);
            }
        }
        if (this.availableCodecInfos.isEmpty()) {
            throw new DecoderInitializationException(this.inputFormat, (Throwable) null, z, -49999);
        }
        while (this.codec == null) {
            MediaCodecInfo mediaCodecInfoPeekFirst = this.availableCodecInfos.peekFirst();
            if (!shouldInitCodec(mediaCodecInfoPeekFirst)) {
                return;
            }
            try {
                initCodec(mediaCodecInfoPeekFirst, mediaCrypto);
            } catch (Exception e2) {
                Log.w("MediaCodecRenderer", "Failed to initialize decoder: " + mediaCodecInfoPeekFirst, e2);
                this.availableCodecInfos.removeFirst();
                DecoderInitializationException decoderInitializationException = new DecoderInitializationException(this.inputFormat, e2, z, mediaCodecInfoPeekFirst);
                if (this.preferredDecoderInitializationException != null) {
                    this.preferredDecoderInitializationException = this.preferredDecoderInitializationException.copyWithFallbackException(decoderInitializationException);
                } else {
                    this.preferredDecoderInitializationException = decoderInitializationException;
                }
                if (this.availableCodecInfos.isEmpty()) {
                    throw this.preferredDecoderInitializationException;
                }
            }
        }
        this.availableCodecInfos = null;
    }

    private List<MediaCodecInfo> getAvailableCodecInfos(boolean z) throws MediaCodecUtil.DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(this.mediaCodecSelector, this.inputFormat, z);
        if (decoderInfos.isEmpty() && z) {
            decoderInfos = getDecoderInfos(this.mediaCodecSelector, this.inputFormat, false);
            if (!decoderInfos.isEmpty()) {
                Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + this.inputFormat.sampleMimeType + ", but no secure decoder available. Trying to proceed with " + decoderInfos + ".");
            }
        }
        return decoderInfos;
    }

    private void initBypass(Format format) {
        disableBypass();
        String str = format.sampleMimeType;
        if (!MediaController.AUIDO_MIME_TYPE.equals(str) && !"audio/mpeg".equals(str) && !"audio/opus".equals(str)) {
            this.bypassBatchBuffer.setMaxAccessUnitCount(1);
        } else {
            this.bypassBatchBuffer.setMaxAccessUnitCount(32);
        }
        this.bypassEnabled = true;
    }

    private void initCodec(MediaCodecInfo mediaCodecInfo, MediaCrypto mediaCrypto) throws Exception {
        MediaCodec mediaCodecCreateByCodecName;
        long jElapsedRealtime;
        MediaCodecAdapter synchronousMediaCodecAdapter;
        MediaCodecAdapter mediaCodecAdapter;
        String str = mediaCodecInfo.name;
        int i = Util.SDK_INT;
        float codecOperatingRateV23 = i < 23 ? -1.0f : getCodecOperatingRateV23(this.operatingRate, this.inputFormat, getStreamFormats());
        float f = codecOperatingRateV23 <= this.assumedMinimumCodecOperatingRate ? -1.0f : codecOperatingRateV23;
        MediaCodecAdapter mediaCodecAdapter2 = null;
        try {
            jElapsedRealtime = SystemClock.elapsedRealtime();
            TraceUtil.beginSection("createCodec:" + str);
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                int i2 = this.mediaCodecOperationMode;
                if (i2 == 2 && i >= 23) {
                    synchronousMediaCodecAdapter = new AsynchronousMediaCodecAdapter(mediaCodecCreateByCodecName, getTrackType());
                } else if (i2 == 4 && i >= 23) {
                    synchronousMediaCodecAdapter = new AsynchronousMediaCodecAdapter(mediaCodecCreateByCodecName, true, getTrackType());
                } else {
                    synchronousMediaCodecAdapter = new SynchronousMediaCodecAdapter(mediaCodecCreateByCodecName);
                }
                mediaCodecAdapter = synchronousMediaCodecAdapter;
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            mediaCodecCreateByCodecName = null;
        }
        try {
            TraceUtil.endSection();
            TraceUtil.beginSection("configureCodec");
            configureCodec(mediaCodecInfo, mediaCodecAdapter, this.inputFormat, mediaCrypto, f);
            TraceUtil.endSection();
            TraceUtil.beginSection("startCodec");
            mediaCodecAdapter.start();
            TraceUtil.endSection();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            getCodecBuffers(mediaCodecCreateByCodecName);
            this.codec = mediaCodecCreateByCodecName;
            this.codecAdapter = mediaCodecAdapter;
            this.codecInfo = mediaCodecInfo;
            this.codecOperatingRate = f;
            this.codecInputFormat = this.inputFormat;
            this.codecAdaptationWorkaroundMode = codecAdaptationWorkaroundMode(str);
            this.codecNeedsReconfigureWorkaround = codecNeedsReconfigureWorkaround(str);
            this.codecNeedsDiscardToSpsWorkaround = codecNeedsDiscardToSpsWorkaround(str, this.codecInputFormat);
            this.codecNeedsFlushWorkaround = codecNeedsFlushWorkaround(str);
            this.codecNeedsSosFlushWorkaround = codecNeedsSosFlushWorkaround(str);
            this.codecNeedsEosFlushWorkaround = codecNeedsEosFlushWorkaround(str);
            this.codecNeedsEosOutputExceptionWorkaround = codecNeedsEosOutputExceptionWorkaround(str);
            this.codecNeedsMonoChannelCountWorkaround = codecNeedsMonoChannelCountWorkaround(str, this.codecInputFormat);
            this.codecNeedsEosPropagation = codecNeedsEosPropagationWorkaround(mediaCodecInfo) || getCodecNeedsEosPropagation();
            if ("c2.android.mp3.decoder".equals(mediaCodecInfo.name)) {
                this.c2Mp3TimestampTracker = new C2Mp3TimestampTracker();
            }
            if (getState() == 2) {
                this.codecHotswapDeadlineMs = SystemClock.elapsedRealtime() + 1000;
            }
            this.decoderCounters.decoderInitCount++;
            onCodecInitialized(str, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
        } catch (Exception e3) {
            e = e3;
            mediaCodecAdapter2 = mediaCodecAdapter;
            if (mediaCodecAdapter2 != null) {
                mediaCodecAdapter2.shutdown();
            }
            if (mediaCodecCreateByCodecName != null) {
                resetCodecBuffers();
                mediaCodecCreateByCodecName.release();
            }
            throw e;
        }
    }

    private boolean shouldContinueRendering(long j) {
        return this.renderTimeLimitMs == -9223372036854775807L || SystemClock.elapsedRealtime() - j < this.renderTimeLimitMs;
    }

    private void getCodecBuffers(MediaCodec mediaCodec) {
        if (Util.SDK_INT < 21) {
            this.inputBuffers = mediaCodec.getInputBuffers();
            this.outputBuffers = mediaCodec.getOutputBuffers();
        }
    }

    private void resetCodecBuffers() {
        if (Util.SDK_INT < 21) {
            this.inputBuffers = null;
            this.outputBuffers = null;
        }
    }

    private ByteBuffer getInputBuffer(int i) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getInputBuffer(i);
        }
        return this.inputBuffers[i];
    }

    private ByteBuffer getOutputBuffer(int i) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getOutputBuffer(i);
        }
        return this.outputBuffers[i];
    }

    private boolean hasOutputBuffer() {
        return this.outputIndex >= 0;
    }

    private void resetInputBuffer() {
        this.inputIndex = -1;
        this.buffer.data = null;
    }

    private void resetOutputBuffer() {
        this.outputIndex = -1;
        this.outputBuffer = null;
    }

    private void setSourceDrmSession(DrmSession drmSession) {
        DrmSession.CC.replaceSession(this.sourceDrmSession, drmSession);
        this.sourceDrmSession = drmSession;
    }

    private void setCodecDrmSession(DrmSession drmSession) {
        DrmSession.CC.replaceSession(this.codecDrmSession, drmSession);
        this.codecDrmSession = drmSession;
    }

    private boolean feedInputBuffer() throws ExoPlaybackException, MediaCryptoException {
        if (this.codec == null || this.codecDrainState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputIndex < 0) {
            int iDequeueInputBufferIndex = this.codecAdapter.dequeueInputBufferIndex();
            this.inputIndex = iDequeueInputBufferIndex;
            if (iDequeueInputBufferIndex < 0) {
                return false;
            }
            this.buffer.data = getInputBuffer(iDequeueInputBufferIndex);
            this.buffer.clear();
        }
        if (this.codecDrainState == 1) {
            if (!this.codecNeedsEosPropagation) {
                this.codecReceivedEos = true;
                this.codecAdapter.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                resetInputBuffer();
            }
            this.codecDrainState = 2;
            return false;
        }
        if (this.codecNeedsAdaptationWorkaroundBuffer) {
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            ByteBuffer byteBuffer = this.buffer.data;
            byte[] bArr = ADAPTATION_WORKAROUND_BUFFER;
            byteBuffer.put(bArr);
            this.codecAdapter.queueInputBuffer(this.inputIndex, 0, bArr.length, 0L, 0);
            resetInputBuffer();
            this.codecReceivedBuffers = true;
            return true;
        }
        if (this.codecReconfigurationState == 1) {
            for (int i = 0; i < this.codecInputFormat.initializationData.size(); i++) {
                this.buffer.data.put(this.codecInputFormat.initializationData.get(i));
            }
            this.codecReconfigurationState = 2;
        }
        int iPosition = this.buffer.data.position();
        FormatHolder formatHolder = getFormatHolder();
        int source = readSource(formatHolder, this.buffer, false);
        if (hasReadStreamToEnd()) {
            this.lastBufferInStreamPresentationTimeUs = this.largestQueuedPresentationTimeUs;
        }
        if (source == -3) {
            return false;
        }
        if (source == -5) {
            if (this.codecReconfigurationState == 2) {
                this.buffer.clear();
                this.codecReconfigurationState = 1;
            }
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (this.buffer.isEndOfStream()) {
            if (this.codecReconfigurationState == 2) {
                this.buffer.clear();
                this.codecReconfigurationState = 1;
            }
            this.inputStreamEnded = true;
            if (!this.codecReceivedBuffers) {
                processEndOfStream();
                return false;
            }
            try {
                if (!this.codecNeedsEosPropagation) {
                    this.codecReceivedEos = true;
                    this.codecAdapter.queueInputBuffer(this.inputIndex, 0, 0, 0L, 4);
                    resetInputBuffer();
                }
                return false;
            } catch (MediaCodec.CryptoException e) {
                throw createRendererException(e, this.inputFormat);
            }
        }
        if (!this.codecReceivedBuffers && !this.buffer.isKeyFrame()) {
            this.buffer.clear();
            if (this.codecReconfigurationState == 2) {
                this.codecReconfigurationState = 1;
            }
            return true;
        }
        boolean zIsEncrypted = this.buffer.isEncrypted();
        if (zIsEncrypted) {
            this.buffer.cryptoInfo.increaseClearDataFirstSubSampleBy(iPosition);
        }
        if (this.codecNeedsDiscardToSpsWorkaround && !zIsEncrypted) {
            NalUnitUtil.discardToSps(this.buffer.data);
            if (this.buffer.data.position() == 0) {
                return true;
            }
            this.codecNeedsDiscardToSpsWorkaround = false;
        }
        DecoderInputBuffer decoderInputBuffer = this.buffer;
        long jUpdateAndGetPresentationTimeUs = decoderInputBuffer.timeUs;
        C2Mp3TimestampTracker c2Mp3TimestampTracker = this.c2Mp3TimestampTracker;
        if (c2Mp3TimestampTracker != null) {
            jUpdateAndGetPresentationTimeUs = c2Mp3TimestampTracker.updateAndGetPresentationTimeUs(this.inputFormat, decoderInputBuffer);
        }
        long j = jUpdateAndGetPresentationTimeUs;
        if (this.buffer.isDecodeOnly()) {
            this.decodeOnlyPresentationTimestamps.add(Long.valueOf(j));
        }
        if (this.waitingForFirstSampleInFormat) {
            this.formatQueue.add(j, this.inputFormat);
            this.waitingForFirstSampleInFormat = false;
        }
        if (this.c2Mp3TimestampTracker != null) {
            this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, this.buffer.timeUs);
        } else {
            this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, j);
        }
        this.buffer.flip();
        if (this.buffer.hasSupplementalData()) {
            handleInputBufferSupplementalData(this.buffer);
        }
        onQueueInputBuffer(this.buffer);
        try {
            if (zIsEncrypted) {
                this.codecAdapter.queueSecureInputBuffer(this.inputIndex, 0, this.buffer.cryptoInfo, j, 0);
            } else {
                this.codecAdapter.queueInputBuffer(this.inputIndex, 0, this.buffer.data.limit(), j, 0);
            }
            resetInputBuffer();
            this.codecReceivedBuffers = true;
            this.codecReconfigurationState = 0;
            this.decoderCounters.inputBufferCount++;
            return true;
        } catch (MediaCodec.CryptoException e2) {
            throw createRendererException(e2, this.inputFormat);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onInputFormatChanged(com.google.android.exoplayer2.FormatHolder r5) throws com.google.android.exoplayer2.ExoPlaybackException, android.media.MediaCryptoException {
        /*
            r4 = this;
            r0 = 1
            r4.waitingForFirstSampleInFormat = r0
            com.google.android.exoplayer2.Format r1 = r5.format
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r1)
            com.google.android.exoplayer2.Format r1 = (com.google.android.exoplayer2.Format) r1
            com.google.android.exoplayer2.drm.DrmSession r5 = r5.drmSession
            r4.setSourceDrmSession(r5)
            r4.inputFormat = r1
            boolean r5 = r4.bypassEnabled
            if (r5 == 0) goto L19
            r4.bypassDrainAndReinitialize = r0
            return
        L19:
            android.media.MediaCodec r5 = r4.codec
            if (r5 != 0) goto L2a
            boolean r5 = r4.legacyKeepAvailableCodecInfosWithoutCodec()
            if (r5 != 0) goto L26
            r5 = 0
            r4.availableCodecInfos = r5
        L26:
            r4.maybeInitCodecOrBypass()
            return
        L2a:
            com.google.android.exoplayer2.drm.DrmSession r5 = r4.sourceDrmSession
            if (r5 != 0) goto L32
            com.google.android.exoplayer2.drm.DrmSession r2 = r4.codecDrmSession
            if (r2 != 0) goto L54
        L32:
            if (r5 == 0) goto L38
            com.google.android.exoplayer2.drm.DrmSession r2 = r4.codecDrmSession
            if (r2 == 0) goto L54
        L38:
            com.google.android.exoplayer2.drm.DrmSession r2 = r4.codecDrmSession
            if (r5 == r2) goto L48
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r2 = r4.codecInfo
            boolean r2 = r2.secure
            if (r2 != 0) goto L48
            boolean r5 = r4.maybeRequiresSecureDecoder(r5, r1)
            if (r5 != 0) goto L54
        L48:
            int r5 = com.google.android.exoplayer2.util.Util.SDK_INT
            r2 = 23
            if (r5 >= r2) goto L58
            com.google.android.exoplayer2.drm.DrmSession r5 = r4.sourceDrmSession
            com.google.android.exoplayer2.drm.DrmSession r2 = r4.codecDrmSession
            if (r5 == r2) goto L58
        L54:
            r4.drainAndReinitializeCodec()
            return
        L58:
            android.media.MediaCodec r5 = r4.codec
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r2 = r4.codecInfo
            com.google.android.exoplayer2.Format r3 = r4.codecInputFormat
            int r5 = r4.canKeepCodec(r5, r2, r3, r1)
            if (r5 == 0) goto Lc7
            if (r5 == r0) goto Lb4
            r2 = 2
            if (r5 == r2) goto L81
            r0 = 3
            if (r5 != r0) goto L7b
            r4.codecInputFormat = r1
            r4.updateCodecOperatingRate()
            com.google.android.exoplayer2.drm.DrmSession r5 = r4.sourceDrmSession
            com.google.android.exoplayer2.drm.DrmSession r0 = r4.codecDrmSession
            if (r5 == r0) goto Lca
            r4.drainAndUpdateCodecDrmSession()
            goto Lca
        L7b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            r5.<init>()
            throw r5
        L81:
            boolean r5 = r4.codecNeedsReconfigureWorkaround
            if (r5 == 0) goto L89
            r4.drainAndReinitializeCodec()
            goto Lca
        L89:
            r4.codecReconfigured = r0
            r4.codecReconfigurationState = r0
            int r5 = r4.codecAdaptationWorkaroundMode
            if (r5 == r2) goto La3
            if (r5 != r0) goto La2
            int r5 = r1.width
            com.google.android.exoplayer2.Format r2 = r4.codecInputFormat
            int r3 = r2.width
            if (r5 != r3) goto La2
            int r5 = r1.height
            int r2 = r2.height
            if (r5 != r2) goto La2
            goto La3
        La2:
            r0 = 0
        La3:
            r4.codecNeedsAdaptationWorkaroundBuffer = r0
            r4.codecInputFormat = r1
            r4.updateCodecOperatingRate()
            com.google.android.exoplayer2.drm.DrmSession r5 = r4.sourceDrmSession
            com.google.android.exoplayer2.drm.DrmSession r0 = r4.codecDrmSession
            if (r5 == r0) goto Lca
            r4.drainAndUpdateCodecDrmSession()
            goto Lca
        Lb4:
            r4.codecInputFormat = r1
            r4.updateCodecOperatingRate()
            com.google.android.exoplayer2.drm.DrmSession r5 = r4.sourceDrmSession
            com.google.android.exoplayer2.drm.DrmSession r0 = r4.codecDrmSession
            if (r5 == r0) goto Lc3
            r4.drainAndUpdateCodecDrmSession()
            goto Lca
        Lc3:
            r4.drainAndFlushCodec()
            goto Lca
        Lc7:
            r4.drainAndReinitializeCodec()
        Lca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.onInputFormatChanged(com.google.android.exoplayer2.FormatHolder):void");
    }

    protected void onProcessedOutputBuffer(long j) {
        while (true) {
            int i = this.pendingOutputStreamOffsetCount;
            if (i == 0 || j < this.pendingOutputStreamSwitchTimesUs[0]) {
                return;
            }
            long[] jArr = this.pendingOutputStreamStartPositionsUs;
            this.outputStreamStartPositionUs = jArr[0];
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[0];
            int i2 = i - 1;
            this.pendingOutputStreamOffsetCount = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.pendingOutputStreamOffsetsUs;
            System.arraycopy(jArr2, 1, jArr2, 0, this.pendingOutputStreamOffsetCount);
            long[] jArr3 = this.pendingOutputStreamSwitchTimesUs;
            System.arraycopy(jArr3, 1, jArr3, 0, this.pendingOutputStreamOffsetCount);
            onProcessedStreamChange();
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.inputFormat != null && (isSourceReady() || hasOutputBuffer() || (this.codecHotswapDeadlineMs != -9223372036854775807L && SystemClock.elapsedRealtime() < this.codecHotswapDeadlineMs));
    }

    protected float getOperatingRate() {
        return this.operatingRate;
    }

    private void updateCodecOperatingRate() throws ExoPlaybackException {
        if (Util.SDK_INT < 23) {
            return;
        }
        float codecOperatingRateV23 = getCodecOperatingRateV23(this.operatingRate, this.codecInputFormat, getStreamFormats());
        float f = this.codecOperatingRate;
        if (f == codecOperatingRateV23) {
            return;
        }
        if (codecOperatingRateV23 == -1.0f) {
            drainAndReinitializeCodec();
            return;
        }
        if (f != -1.0f || codecOperatingRateV23 > this.assumedMinimumCodecOperatingRate) {
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", codecOperatingRateV23);
            this.codec.setParameters(bundle);
            this.codecOperatingRate = codecOperatingRateV23;
        }
    }

    private void drainAndFlushCodec() {
        if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 1;
        }
    }

    private void drainAndUpdateCodecDrmSession() throws ExoPlaybackException, MediaCryptoException {
        if (Util.SDK_INT < 23) {
            drainAndReinitializeCodec();
        } else if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 2;
        } else {
            updateDrmSessionOrReinitializeCodecV23();
        }
    }

    private void drainAndReinitializeCodec() throws ExoPlaybackException {
        if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 3;
        } else {
            reinitializeCodec();
        }
    }

    private boolean drainOutputBuffer(long j, long j2) throws ExoPlaybackException, MediaCryptoException {
        boolean z;
        boolean zProcessOutputBuffer;
        int iDequeueOutputBufferIndex;
        if (!hasOutputBuffer()) {
            if (this.codecNeedsEosOutputExceptionWorkaround && this.codecReceivedEos) {
                try {
                    iDequeueOutputBufferIndex = this.codecAdapter.dequeueOutputBufferIndex(this.outputBufferInfo);
                } catch (IllegalStateException unused) {
                    processEndOfStream();
                    if (this.outputStreamEnded) {
                        releaseCodec();
                    }
                    return false;
                }
            } else {
                iDequeueOutputBufferIndex = this.codecAdapter.dequeueOutputBufferIndex(this.outputBufferInfo);
            }
            if (iDequeueOutputBufferIndex < 0) {
                if (iDequeueOutputBufferIndex == -2) {
                    processOutputMediaFormatChanged();
                    return true;
                }
                if (iDequeueOutputBufferIndex == -3) {
                    processOutputBuffersChanged();
                    return true;
                }
                if (this.codecNeedsEosPropagation && (this.inputStreamEnded || this.codecDrainState == 2)) {
                    processEndOfStream();
                }
                return false;
            }
            if (this.shouldSkipAdaptationWorkaroundOutputBuffer) {
                this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
                this.codec.releaseOutputBuffer(iDequeueOutputBufferIndex, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.outputBufferInfo;
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                processEndOfStream();
                return false;
            }
            this.outputIndex = iDequeueOutputBufferIndex;
            ByteBuffer outputBuffer = getOutputBuffer(iDequeueOutputBufferIndex);
            this.outputBuffer = outputBuffer;
            if (outputBuffer != null) {
                outputBuffer.position(this.outputBufferInfo.offset);
                ByteBuffer byteBuffer = this.outputBuffer;
                MediaCodec.BufferInfo bufferInfo2 = this.outputBufferInfo;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            this.isDecodeOnlyOutputBuffer = isDecodeOnlyBuffer(this.outputBufferInfo.presentationTimeUs);
            long j3 = this.lastBufferInStreamPresentationTimeUs;
            long j4 = this.outputBufferInfo.presentationTimeUs;
            this.isLastOutputBuffer = j3 == j4;
            updateOutputFormatForTime(j4);
        }
        if (this.codecNeedsEosOutputExceptionWorkaround && this.codecReceivedEos) {
            try {
                MediaCodec mediaCodec = this.codec;
                ByteBuffer byteBuffer2 = this.outputBuffer;
                int i = this.outputIndex;
                MediaCodec.BufferInfo bufferInfo3 = this.outputBufferInfo;
                z = false;
                try {
                    zProcessOutputBuffer = processOutputBuffer(j, j2, mediaCodec, byteBuffer2, i, bufferInfo3.flags, 1, bufferInfo3.presentationTimeUs, this.isDecodeOnlyOutputBuffer, this.isLastOutputBuffer, this.outputFormat);
                } catch (IllegalStateException unused2) {
                    processEndOfStream();
                    if (this.outputStreamEnded) {
                        releaseCodec();
                    }
                    return z;
                }
            } catch (IllegalStateException unused3) {
                z = false;
            }
        } else {
            z = false;
            MediaCodec mediaCodec2 = this.codec;
            ByteBuffer byteBuffer3 = this.outputBuffer;
            int i2 = this.outputIndex;
            MediaCodec.BufferInfo bufferInfo4 = this.outputBufferInfo;
            zProcessOutputBuffer = processOutputBuffer(j, j2, mediaCodec2, byteBuffer3, i2, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.isDecodeOnlyOutputBuffer, this.isLastOutputBuffer, this.outputFormat);
        }
        if (zProcessOutputBuffer) {
            onProcessedOutputBuffer(this.outputBufferInfo.presentationTimeUs);
            boolean z2 = (this.outputBufferInfo.flags & 4) != 0;
            resetOutputBuffer();
            if (!z2) {
                return true;
            }
            processEndOfStream();
        }
        return z;
    }

    private void processOutputMediaFormatChanged() {
        this.codecHasOutputMediaFormat = true;
        MediaFormat outputFormat = this.codecAdapter.getOutputFormat();
        if (this.codecAdaptationWorkaroundMode != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.shouldSkipAdaptationWorkaroundOutputBuffer = true;
            return;
        }
        if (this.codecNeedsMonoChannelCountWorkaround) {
            outputFormat.setInteger("channel-count", 1);
        }
        this.codecOutputMediaFormat = outputFormat;
        this.codecOutputMediaFormatChanged = true;
    }

    private void processOutputBuffersChanged() {
        if (Util.SDK_INT < 21) {
            this.outputBuffers = this.codec.getOutputBuffers();
        }
    }

    private void processEndOfStream() throws ExoPlaybackException, MediaCryptoException {
        int i = this.codecDrainAction;
        if (i == 1) {
            flushOrReinitializeCodec();
            return;
        }
        if (i == 2) {
            updateDrmSessionOrReinitializeCodecV23();
        } else if (i == 3) {
            reinitializeCodec();
        } else {
            this.outputStreamEnded = true;
            renderToEndOfStream();
        }
    }

    protected final void setPendingOutputEndOfStream() {
        this.pendingOutputEndOfStream = true;
    }

    protected final long getLargestQueuedPresentationTimeUs() {
        return this.largestQueuedPresentationTimeUs;
    }

    protected final long getOutputStreamOffsetUs() {
        return this.outputStreamOffsetUs;
    }

    protected static boolean supportsFormatDrm(Format format) {
        Class<? extends ExoMediaCrypto> cls = format.exoMediaCryptoType;
        return cls == null || FrameworkMediaCrypto.class.equals(cls);
    }

    private boolean maybeRequiresSecureDecoder(DrmSession drmSession, Format format) throws ExoPlaybackException {
        FrameworkMediaCrypto frameworkMediaCrypto = getFrameworkMediaCrypto(drmSession);
        if (frameworkMediaCrypto == null) {
            return true;
        }
        if (frameworkMediaCrypto.forceAllowInsecureDecoderComponents) {
            return false;
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(frameworkMediaCrypto.uuid, frameworkMediaCrypto.sessionId);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(format.sampleMimeType);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    private void reinitializeCodec() throws ExoPlaybackException {
        releaseCodec();
        maybeInitCodecOrBypass();
    }

    private boolean isDecodeOnlyBuffer(long j) {
        int size = this.decodeOnlyPresentationTimestamps.size();
        for (int i = 0; i < size; i++) {
            if (this.decodeOnlyPresentationTimestamps.get(i).longValue() == j) {
                this.decodeOnlyPresentationTimestamps.remove(i);
                return true;
            }
        }
        return false;
    }

    private void updateDrmSessionOrReinitializeCodecV23() throws ExoPlaybackException, MediaCryptoException {
        FrameworkMediaCrypto frameworkMediaCrypto = getFrameworkMediaCrypto(this.sourceDrmSession);
        if (frameworkMediaCrypto == null) {
            reinitializeCodec();
            return;
        }
        if (C.PLAYREADY_UUID.equals(frameworkMediaCrypto.uuid)) {
            reinitializeCodec();
            return;
        }
        if (flushOrReinitializeCodec()) {
            return;
        }
        try {
            this.mediaCrypto.setMediaDrmSession(frameworkMediaCrypto.sessionId);
            setCodecDrmSession(this.sourceDrmSession);
            this.codecDrainState = 0;
            this.codecDrainAction = 0;
        } catch (MediaCryptoException e) {
            throw createRendererException(e, this.inputFormat);
        }
    }

    private FrameworkMediaCrypto getFrameworkMediaCrypto(DrmSession drmSession) throws ExoPlaybackException {
        ExoMediaCrypto mediaCrypto = drmSession.getMediaCrypto();
        if (mediaCrypto != null && !(mediaCrypto instanceof FrameworkMediaCrypto)) {
            throw createRendererException(new IllegalArgumentException("Expecting FrameworkMediaCrypto but found: " + mediaCrypto), this.inputFormat);
        }
        return (FrameworkMediaCrypto) mediaCrypto;
    }

    private boolean bypassRender(long j, long j2) throws ExoPlaybackException, MediaCryptoException {
        BatchBuffer batchBuffer;
        BatchBuffer batchBuffer2 = this.bypassBatchBuffer;
        Assertions.checkState(!this.outputStreamEnded);
        if (batchBuffer2.isEmpty()) {
            batchBuffer = batchBuffer2;
        } else {
            batchBuffer = batchBuffer2;
            if (!processOutputBuffer(j, j2, null, batchBuffer2.data, this.outputIndex, 0, batchBuffer2.getAccessUnitCount(), batchBuffer2.getFirstAccessUnitTimeUs(), batchBuffer2.isDecodeOnly(), batchBuffer2.isEndOfStream(), this.outputFormat)) {
                return false;
            }
            onProcessedOutputBuffer(batchBuffer.getLastAccessUnitTimeUs());
        }
        if (batchBuffer.isEndOfStream()) {
            this.outputStreamEnded = true;
            return false;
        }
        batchBuffer.batchWasConsumed();
        if (this.bypassDrainAndReinitialize) {
            if (!batchBuffer.isEmpty()) {
                return true;
            }
            disableBypass();
            this.bypassDrainAndReinitialize = false;
            maybeInitCodecOrBypass();
            if (!this.bypassEnabled) {
                return false;
            }
        }
        Assertions.checkState(!this.inputStreamEnded);
        FormatHolder formatHolder = getFormatHolder();
        BatchBuffer batchBuffer3 = batchBuffer;
        boolean batchFromSource = readBatchFromSource(formatHolder, batchBuffer3);
        if (!batchBuffer3.isEmpty() && this.waitingForFirstSampleInFormat) {
            Format format = (Format) Assertions.checkNotNull(this.inputFormat);
            this.outputFormat = format;
            onOutputFormatChanged(format, null);
            this.waitingForFirstSampleInFormat = false;
        }
        if (batchFromSource) {
            onInputFormatChanged(formatHolder);
        }
        if (batchBuffer3.isEndOfStream()) {
            this.inputStreamEnded = true;
        }
        if (batchBuffer3.isEmpty()) {
            return false;
        }
        batchBuffer3.flip();
        batchBuffer3.data.order(ByteOrder.nativeOrder());
        return true;
    }

    private boolean readBatchFromSource(FormatHolder formatHolder, BatchBuffer batchBuffer) {
        while (!batchBuffer.isFull() && !batchBuffer.isEndOfStream()) {
            int source = readSource(formatHolder, batchBuffer.getNextAccessUnitBuffer(), false);
            if (source == -5) {
                return true;
            }
            if (source != -4) {
                if (source == -3) {
                    return false;
                }
                throw new IllegalStateException();
            }
            batchBuffer.commitNextAccessUnit();
        }
        return false;
    }

    private static boolean isMediaCodecException(IllegalStateException illegalStateException) {
        if (Util.SDK_INT >= 21 && isMediaCodecExceptionV21(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    private static boolean isMediaCodecExceptionV21(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        int i = Util.SDK_INT;
        return i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i == 19 && Util.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private int codecAdaptationWorkaroundMode(String str) {
        int i = Util.SDK_INT;
        if (i <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = Util.MODEL;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = Util.DEVICE;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    private static boolean codecNeedsReconfigureWorkaround(String str) {
        return Util.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean codecNeedsDiscardToSpsWorkaround(String str, Format format) {
        return Util.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean codecNeedsEosPropagationWorkaround(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.name;
        int i = Util.SDK_INT;
        return (i <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) || ("Amazon".equals(Util.MANUFACTURER) && "AFTS".equals(Util.MODEL) && mediaCodecInfo.secure));
    }

    private static boolean codecNeedsEosFlushWorkaround(String str) {
        int i = Util.SDK_INT;
        if (i > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i <= 19) {
                String str2 = Util.DEVICE;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    private static boolean codecNeedsEosOutputExceptionWorkaround(String str) {
        return Util.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean codecNeedsMonoChannelCountWorkaround(String str, Format format) {
        return Util.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private static boolean codecNeedsSosFlushWorkaround(String str) {
        return Util.SDK_INT == 29 && "c2.android.aac.decoder".equals(str);
    }
}
