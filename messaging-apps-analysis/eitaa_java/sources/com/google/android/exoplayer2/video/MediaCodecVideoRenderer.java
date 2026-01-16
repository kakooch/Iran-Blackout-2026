package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import ir.eitaa.messenger.MediaController;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private MediaFormat currentMediaFormat;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastInputTimeUs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private long outputStreamOffsetUs;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private final long[] pendingOutputStreamSwitchTimesUs;
    private float pendingPixelWidthHeightRatio;
    private int pendingRotationDegrees;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private Surface surface;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;

    private static boolean isBufferLate(long earlyUs) {
        return earlyUs < -30000;
    }

    private static boolean isBufferVeryLate(long earlyUs) {
        return earlyUs < -500000;
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long allowedJoiningTimeMs, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean playClearSamplesWithoutKeys, boolean enableDecoderFallback, Handler eventHandler, VideoRendererEventListener eventListener, int maxDroppedFramesToNotify) {
        super(2, mediaCodecSelector, drmSessionManager, playClearSamplesWithoutKeys, enableDecoderFallback, 30.0f);
        this.allowedJoiningTimeMs = allowedJoiningTimeMs;
        this.maxDroppedFramesToNotify = maxDroppedFramesToNotify;
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(applicationContext);
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(eventHandler, eventListener);
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.pendingOutputStreamSwitchTimesUs = new long[10];
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.lastInputTimeUs = -9223372036854775807L;
        this.joiningDeadlineMs = -9223372036854775807L;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        clearReportedVideoSize();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return RendererCapabilities.CC.create(0);
        }
        DrmInitData drmInitData = format.drmInitData;
        boolean z = drmInitData != null;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, z, false);
        if (z && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(mediaCodecSelector, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return RendererCapabilities.CC.create(1);
        }
        if (!(drmInitData == null || FrameworkMediaCrypto.class.equals(format.exoMediaCryptoType) || (format.exoMediaCryptoType == null && BaseRenderer.supportsFormatDrm(drmSessionManager, drmInitData)))) {
            return RendererCapabilities.CC.create(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean zIsFormatSupported = mediaCodecInfo.isFormatSupported(format);
        int i2 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        if (zIsFormatSupported) {
            List<MediaCodecInfo> decoderInfos2 = getDecoderInfos(mediaCodecSelector, format, z, true);
            if (!decoderInfos2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo2 = decoderInfos2.get(0);
                if (mediaCodecInfo2.isFormatSupported(format) && mediaCodecInfo2.isSeamlessAdaptationSupported(format)) {
                    i = 32;
                }
            }
        }
        return RendererCapabilities.CC.create(zIsFormatSupported ? 4 : 3, i2, i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean requiresSecureDecoder) throws MediaCodecUtil.DecoderQueryException {
        return getDecoderInfos(mediaCodecSelector, format, requiresSecureDecoder, this.tunneling);
    }

    private static List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean requiresSecureDecoder, boolean requiresTunnelingDecoder) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> codecProfileAndLevel;
        String str = format.sampleMimeType;
        if (str == null) {
            return Collections.emptyList();
        }
        List<MediaCodecInfo> decoderInfosSortedByFormatSupport = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(str, requiresSecureDecoder, requiresTunnelingDecoder), format);
        if ("video/dolby-vision".equals(str) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            int iIntValue = ((Integer) codecProfileAndLevel.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos("video/hevc", requiresSecureDecoder, requiresTunnelingDecoder));
            } else if (iIntValue == 512) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos(MediaController.VIDEO_MIME_TYPE, requiresSecureDecoder, requiresTunnelingDecoder));
            }
        }
        return Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean joining) throws ExoPlaybackException {
        super.onEnabled(joining);
        int i = this.tunnelingAudioSessionId;
        int i2 = getConfiguration().tunnelingAudioSessionId;
        this.tunnelingAudioSessionId = i2;
        this.tunneling = i2 != 0;
        if (i2 != i) {
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStreamChanged(Format[] formats, long offsetUs) throws ExoPlaybackException {
        if (this.outputStreamOffsetUs == -9223372036854775807L) {
            this.outputStreamOffsetUs = offsetUs;
        } else {
            int i = this.pendingOutputStreamOffsetCount;
            if (i == this.pendingOutputStreamOffsetsUs.length) {
                Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
            } else {
                this.pendingOutputStreamOffsetCount = i + 1;
            }
            long[] jArr = this.pendingOutputStreamOffsetsUs;
            int i2 = this.pendingOutputStreamOffsetCount;
            jArr[i2 - 1] = offsetUs;
            this.pendingOutputStreamSwitchTimesUs[i2 - 1] = this.lastInputTimeUs;
        }
        super.onStreamChanged(formats, offsetUs);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long positionUs, boolean joining) throws ExoPlaybackException {
        super.onPositionReset(positionUs, joining);
        clearRenderedFirstFrame();
        this.initialPositionUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        this.lastInputTimeUs = -9223372036854775807L;
        int i = this.pendingOutputStreamOffsetCount;
        if (i != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[i - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
        if (joining) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.renderedFirstFrame || (((surface = this.dummySurface) != null && this.surface == surface) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        }
        if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
            return true;
        }
        this.joiningDeadlineMs = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.lastInputTimeUs = -9223372036854775807L;
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.pendingOutputStreamOffsetCount = 0;
        this.currentMediaFormat = null;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.frameReleaseTimeHelper.disable();
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onReset() {
        try {
            super.onReset();
            Surface surface = this.dummySurface;
            if (surface != null) {
                if (this.surface == surface) {
                    this.surface = null;
                }
                surface.release();
                this.dummySurface = null;
            }
        } catch (Throwable th) {
            if (this.dummySurface != null) {
                Surface surface2 = this.surface;
                Surface surface3 = this.dummySurface;
                if (surface2 == surface3) {
                    this.surface = null;
                }
                surface3.release();
                this.dummySurface = null;
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int messageType, Object message) throws ExoPlaybackException {
        if (messageType == 1) {
            setSurface((Surface) message);
            return;
        }
        if (messageType != 4) {
            if (messageType == 6) {
                this.frameMetadataListener = (VideoFrameMetadataListener) message;
                return;
            } else {
                super.handleMessage(messageType, message);
                return;
            }
        }
        this.scalingMode = ((Integer) message).intValue();
        MediaCodec codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                surface = surface2;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUseDummySurface(codecInfo)) {
                    surface = DummySurface.newInstanceV17(this.context, codecInfo.secure);
                    this.dummySurface = surface;
                }
            }
        }
        if (this.surface != surface) {
            this.surface = surface;
            int state = getState();
            MediaCodec codec = getCodec();
            if (codec != null) {
                if (Util.SDK_INT >= 23 && surface != null && !this.codecNeedsSetOutputSurfaceWorkaround) {
                    try {
                        setOutputSurfaceV23(codec, surface);
                    } catch (Throwable th) {
                        throw new SurfaceNotValidException(th);
                    }
                } else {
                    releaseCodec();
                    maybeInitCodec();
                }
            }
            if (surface != null && surface != this.dummySurface) {
                maybeRenotifyVideoSizeChanged();
                clearRenderedFirstFrame();
                if (state == 2) {
                    setJoiningDeadlineMs();
                    return;
                }
                return;
            }
            clearReportedVideoSize();
            clearRenderedFirstFrame();
            return;
        }
        if (surface == null || surface == this.dummySurface) {
            return;
        }
        maybeRenotifyVideoSizeChanged();
        maybeRenotifyRenderedFirstFrame();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean shouldInitCodec(MediaCodecInfo codecInfo) {
        return this.surface != null || shouldUseDummySurface(codecInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(MediaCodecInfo codecInfo, MediaCodec codec, Format format, MediaCrypto crypto, float codecOperatingRate) {
        String str = codecInfo.codecMimeType;
        CodecMaxValues codecMaxValues = getCodecMaxValues(codecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues, codecOperatingRate, this.deviceNeedsNoPostProcessWorkaround, this.tunnelingAudioSessionId);
        if (this.surface == null) {
            Assertions.checkState(shouldUseDummySurface(codecInfo));
            if (this.dummySurface == null) {
                this.dummySurface = DummySurface.newInstanceV17(this.context, codecInfo.secure);
            }
            this.surface = this.dummySurface;
        }
        codec.configure(mediaFormat, this.surface, crypto, 0);
        if (Util.SDK_INT < 23 || !this.tunneling) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int canKeepCodec(MediaCodec codec, MediaCodecInfo codecInfo, Format oldFormat, Format newFormat) {
        if (!codecInfo.isSeamlessAdaptationSupported(oldFormat, newFormat, true)) {
            return 0;
        }
        int i = newFormat.width;
        CodecMaxValues codecMaxValues = this.codecMaxValues;
        if (i > codecMaxValues.width || newFormat.height > codecMaxValues.height || getMaxInputSize(codecInfo, newFormat) > this.codecMaxValues.inputSize) {
            return 0;
        }
        return oldFormat.initializationDataEquals(newFormat) ? 3 : 2;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void releaseCodec() {
        try {
            super.releaseCodec();
        } finally {
            this.buffersInCodecCount = 0;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean flushOrReleaseCodec() {
        try {
            return super.flushOrReleaseCodec();
        } finally {
            this.buffersInCodecCount = 0;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float getCodecOperatingRateV23(float operatingRate, Format format, Format[] streamFormats) {
        float fMax = -1.0f;
        for (Format format2 : streamFormats) {
            float f = format2.frameRate;
            if (f != -1.0f) {
                fMax = Math.max(fMax, f);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * operatingRate;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(String name, long initializedTimestampMs, long initializationDurationMs) {
        this.eventDispatcher.decoderInitialized(name, initializedTimestampMs, initializationDurationMs);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(name);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException, MediaCryptoException {
        super.onInputFormatChanged(formatHolder);
        Format format = formatHolder.format;
        this.eventDispatcher.inputFormatChanged(format);
        this.pendingPixelWidthHeightRatio = format.pixelWidthHeightRatio;
        this.pendingRotationDegrees = format.rotationDegrees;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onQueueInputBuffer(DecoderInputBuffer buffer) {
        if (!this.tunneling) {
            this.buffersInCodecCount++;
        }
        this.lastInputTimeUs = Math.max(buffer.timeUs, this.lastInputTimeUs);
        if (Util.SDK_INT >= 23 || !this.tunneling) {
            return;
        }
        onProcessedTunneledBuffer(buffer.timeUs);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onOutputFormatChanged(MediaCodec codec, MediaFormat outputMediaFormat) {
        int integer;
        int integer2;
        this.currentMediaFormat = outputMediaFormat;
        boolean z = outputMediaFormat.containsKey("crop-right") && outputMediaFormat.containsKey("crop-left") && outputMediaFormat.containsKey("crop-bottom") && outputMediaFormat.containsKey("crop-top");
        if (z) {
            integer = (outputMediaFormat.getInteger("crop-right") - outputMediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = outputMediaFormat.getInteger("width");
        }
        if (z) {
            integer2 = (outputMediaFormat.getInteger("crop-bottom") - outputMediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = outputMediaFormat.getInteger("height");
        }
        processOutputFormat(codec, integer, integer2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void handleInputBufferSupplementalData(DecoderInputBuffer buffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(buffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4 && b3 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    setHdr10PlusInfoV29(getCodec(), bArr);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean processOutputBuffer(long positionUs, long elapsedRealtimeUs, MediaCodec codec, ByteBuffer buffer, int bufferIndex, int bufferFlags, long bufferPresentationTimeUs, boolean isDecodeOnlyBuffer, boolean isLastBuffer, Format format) throws ExoPlaybackException, InterruptedException {
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = positionUs;
        }
        long j = bufferPresentationTimeUs - this.outputStreamOffsetUs;
        if (isDecodeOnlyBuffer && !isLastBuffer) {
            skipOutputBuffer(codec, bufferIndex, j);
            return true;
        }
        long j2 = bufferPresentationTimeUs - positionUs;
        if (this.surface == this.dummySurface) {
            if (!isBufferLate(j2)) {
                return false;
            }
            skipOutputBuffer(codec, bufferIndex, j);
            return true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j3 = jElapsedRealtime - this.lastRenderTimeUs;
        boolean z = getState() == 2;
        if (this.joiningDeadlineMs == -9223372036854775807L && positionUs >= this.outputStreamOffsetUs && (!this.renderedFirstFrame || (z && shouldForceRenderOutputBuffer(j2, j3)))) {
            long jNanoTime = System.nanoTime();
            notifyFrameMetadataListener(j, jNanoTime, format, this.currentMediaFormat);
            if (Util.SDK_INT >= 21) {
                renderOutputBufferV21(codec, bufferIndex, j, jNanoTime);
                return true;
            }
            renderOutputBuffer(codec, bufferIndex, j);
            return true;
        }
        if (z && positionUs != this.initialPositionUs) {
            long jNanoTime2 = System.nanoTime();
            long jAdjustReleaseTime = this.frameReleaseTimeHelper.adjustReleaseTime(bufferPresentationTimeUs, ((j2 - (jElapsedRealtime - elapsedRealtimeUs)) * 1000) + jNanoTime2);
            long j4 = (jAdjustReleaseTime - jNanoTime2) / 1000;
            boolean z2 = this.joiningDeadlineMs != -9223372036854775807L;
            if (shouldDropBuffersToKeyframe(j4, elapsedRealtimeUs, isLastBuffer) && maybeDropBuffersToKeyframe(codec, bufferIndex, j, positionUs, z2)) {
                return false;
            }
            if (shouldDropOutputBuffer(j4, elapsedRealtimeUs, isLastBuffer)) {
                if (z2) {
                    skipOutputBuffer(codec, bufferIndex, j);
                    return true;
                }
                dropOutputBuffer(codec, bufferIndex, j);
                return true;
            }
            if (Util.SDK_INT >= 21) {
                if (j4 < 50000) {
                    notifyFrameMetadataListener(j, jAdjustReleaseTime, format, this.currentMediaFormat);
                    renderOutputBufferV21(codec, bufferIndex, j, jAdjustReleaseTime);
                    return true;
                }
            } else if (j4 < 30000) {
                if (j4 > 11000) {
                    try {
                        Thread.sleep((j4 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                notifyFrameMetadataListener(j, jAdjustReleaseTime, format, this.currentMediaFormat);
                renderOutputBuffer(codec, bufferIndex, j);
                return true;
            }
        }
        return false;
    }

    private void processOutputFormat(MediaCodec codec, int width, int height) {
        this.currentWidth = width;
        this.currentHeight = height;
        float f = this.pendingPixelWidthHeightRatio;
        this.currentPixelWidthHeightRatio = f;
        if (Util.SDK_INT >= 21) {
            int i = this.pendingRotationDegrees;
            if (i == 90 || i == 270) {
                this.currentWidth = height;
                this.currentHeight = width;
                this.currentPixelWidthHeightRatio = 1.0f / f;
            }
        } else {
            this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
        }
        codec.setVideoScalingMode(this.scalingMode);
    }

    private void notifyFrameMetadataListener(long presentationTimeUs, long releaseTimeNs, Format format, MediaFormat mediaFormat) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(presentationTimeUs, releaseTimeNs, format, mediaFormat);
        }
    }

    protected void onProcessedTunneledBuffer(long presentationTimeUs) {
        Format formatUpdateOutputFormatForTime = updateOutputFormatForTime(presentationTimeUs);
        if (formatUpdateOutputFormatForTime != null) {
            processOutputFormat(getCodec(), formatUpdateOutputFormatForTime.width, formatUpdateOutputFormatForTime.height);
        }
        maybeNotifyVideoSizeChanged();
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(presentationTimeUs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onProcessedOutputBuffer(long presentationTimeUs) {
        if (!this.tunneling) {
            this.buffersInCodecCount--;
        }
        while (true) {
            int i = this.pendingOutputStreamOffsetCount;
            if (i == 0 || presentationTimeUs < this.pendingOutputStreamSwitchTimesUs[0]) {
                return;
            }
            long[] jArr = this.pendingOutputStreamOffsetsUs;
            this.outputStreamOffsetUs = jArr[0];
            int i2 = i - 1;
            this.pendingOutputStreamOffsetCount = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.pendingOutputStreamSwitchTimesUs;
            System.arraycopy(jArr2, 1, jArr2, 0, this.pendingOutputStreamOffsetCount);
            clearRenderedFirstFrame();
        }
    }

    protected boolean shouldDropOutputBuffer(long earlyUs, long elapsedRealtimeUs, boolean isLastBuffer) {
        return isBufferLate(earlyUs) && !isLastBuffer;
    }

    protected boolean shouldDropBuffersToKeyframe(long earlyUs, long elapsedRealtimeUs, boolean isLastBuffer) {
        return isBufferVeryLate(earlyUs) && !isLastBuffer;
    }

    protected boolean shouldForceRenderOutputBuffer(long earlyUs, long elapsedSinceLastRenderUs) {
        return isBufferLate(earlyUs) && elapsedSinceLastRenderUs > 100000;
    }

    protected void skipOutputBuffer(MediaCodec codec, int index, long presentationTimeUs) {
        TraceUtil.beginSection("skipVideoBuffer");
        codec.releaseOutputBuffer(index, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    protected void dropOutputBuffer(MediaCodec codec, int index, long presentationTimeUs) {
        TraceUtil.beginSection("dropVideoBuffer");
        codec.releaseOutputBuffer(index, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    protected boolean maybeDropBuffersToKeyframe(MediaCodec codec, int index, long presentationTimeUs, long positionUs, boolean treatDroppedBuffersAsSkipped) throws ExoPlaybackException {
        int iSkipSource = skipSource(positionUs);
        if (iSkipSource == 0) {
            return false;
        }
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedToKeyframeCount++;
        int i = this.buffersInCodecCount + iSkipSource;
        if (treatDroppedBuffersAsSkipped) {
            decoderCounters.skippedOutputBufferCount += i;
        } else {
            updateDroppedBufferCounters(i);
        }
        flushOrReinitializeCodec();
        return true;
    }

    protected void updateDroppedBufferCounters(int droppedBufferCount) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount += droppedBufferCount;
        this.droppedFrames += droppedBufferCount;
        int i = this.consecutiveDroppedFrameCount + droppedBufferCount;
        this.consecutiveDroppedFrameCount = i;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i2 = this.maxDroppedFramesToNotify;
        if (i2 <= 0 || this.droppedFrames < i2) {
            return;
        }
        maybeNotifyDroppedFrames();
    }

    protected void renderOutputBuffer(MediaCodec codec, int index, long presentationTimeUs) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        codec.releaseOutputBuffer(index, true);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    @TargetApi(21)
    protected void renderOutputBufferV21(MediaCodec codec, int index, long presentationTimeUs, long releaseTimeNs) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        codec.releaseOutputBuffer(index, releaseTimeNs);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    private boolean shouldUseDummySurface(MediaCodecInfo codecInfo) {
        return Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(codecInfo.name) && (!codecInfo.secure || DummySurface.isSecureSupported(this.context));
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        MediaCodec codec;
        this.renderedFirstFrame = false;
        if (Util.SDK_INT < 23 || !this.tunneling || (codec = getCodec()) == null) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
    }

    void maybeNotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            return;
        }
        this.renderedFirstFrame = true;
        this.eventDispatcher.renderedFirstFrame(this.surface);
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    private void maybeNotifyVideoSizeChanged() {
        int i = this.currentWidth;
        if (i == -1 && this.currentHeight == -1) {
            return;
        }
        if (this.reportedWidth == i && this.reportedHeight == this.currentHeight && this.reportedUnappliedRotationDegrees == this.currentUnappliedRotationDegrees && this.reportedPixelWidthHeightRatio == this.currentPixelWidthHeightRatio) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(i, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
        this.reportedWidth = this.currentWidth;
        this.reportedHeight = this.currentHeight;
        this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
        this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
    }

    private void maybeRenotifyVideoSizeChanged() {
        int i = this.reportedWidth;
        if (i == -1 && this.reportedHeight == -1) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(i, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }

    @TargetApi(29)
    private static void setHdr10PlusInfoV29(MediaCodec codec, byte[] hdr10PlusInfo) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", hdr10PlusInfo);
        codec.setParameters(bundle);
    }

    @TargetApi(23)
    private static void setOutputSurfaceV23(MediaCodec codec, Surface surface) {
        codec.setOutputSurface(surface);
    }

    @TargetApi(21)
    private static void configureTunnelingV21(MediaFormat mediaFormat, int tunnelingAudioSessionId) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", tunnelingAudioSessionId);
    }

    @SuppressLint({"InlinedApi"})
    protected MediaFormat getMediaFormat(Format format, String codecMimeType, CodecMaxValues codecMaxValues, float codecOperatingRate, boolean deviceNeedsNoPostProcessWorkaround, int tunnelingAudioSessionId) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", codecMimeType);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if ("video/dolby-vision".equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, "profile", ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues.width);
        mediaFormat.setInteger("max-height", codecMaxValues.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (codecOperatingRate != -1.0f) {
                mediaFormat.setFloat("operating-rate", codecOperatingRate);
            }
        }
        if (deviceNeedsNoPostProcessWorkaround) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (tunnelingAudioSessionId != 0) {
            configureTunnelingV21(mediaFormat, tunnelingAudioSessionId);
        }
        return mediaFormat;
    }

    protected CodecMaxValues getCodecMaxValues(MediaCodecInfo codecInfo, Format format, Format[] streamFormats) {
        int codecMaxInputSize;
        int iMax = format.width;
        int iMax2 = format.height;
        int maxInputSize = getMaxInputSize(codecInfo, format);
        if (streamFormats.length == 1) {
            if (maxInputSize != -1 && (codecMaxInputSize = getCodecMaxInputSize(codecInfo, format.sampleMimeType, format.width, format.height)) != -1) {
                maxInputSize = Math.min((int) (maxInputSize * 1.5f), codecMaxInputSize);
            }
            return new CodecMaxValues(iMax, iMax2, maxInputSize);
        }
        boolean z = false;
        for (Format format2 : streamFormats) {
            if (codecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                int i = format2.width;
                z |= i == -1 || format2.height == -1;
                iMax = Math.max(iMax, i);
                iMax2 = Math.max(iMax2, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(codecInfo, format2));
            }
        }
        if (z) {
            Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point codecMaxSize = getCodecMaxSize(codecInfo, format);
            if (codecMaxSize != null) {
                iMax = Math.max(iMax, codecMaxSize.x);
                iMax2 = Math.max(iMax2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(codecInfo, format.sampleMimeType, iMax, iMax2));
                Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new CodecMaxValues(iMax, iMax2, maxInputSize);
    }

    private static Point getCodecMaxSize(MediaCodecInfo codecInfo, Format format) {
        int i = format.height;
        int i2 = format.width;
        boolean z = i > i2;
        int i3 = z ? i : i2;
        if (z) {
            i = i2;
        }
        float f = i / i3;
        for (int i4 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i5 = (int) (i4 * f);
            if (i4 <= i3 || i5 <= i) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                int i6 = z ? i5 : i4;
                if (!z) {
                    i4 = i5;
                }
                Point pointAlignVideoSizeV21 = codecInfo.alignVideoSizeV21(i6, i4);
                if (codecInfo.isVideoSizeAndRateSupportedV21(pointAlignVideoSizeV21.x, pointAlignVideoSizeV21.y, format.frameRate)) {
                    return pointAlignVideoSizeV21;
                }
            } else {
                try {
                    int iCeilDivide = Util.ceilDivide(i4, 16) * 16;
                    int iCeilDivide2 = Util.ceilDivide(i5, 16) * 16;
                    if (iCeilDivide * iCeilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int i7 = z ? iCeilDivide2 : iCeilDivide;
                        if (!z) {
                            iCeilDivide = iCeilDivide2;
                        }
                        return new Point(i7, iCeilDivide);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    private static int getMaxInputSize(MediaCodecInfo codecInfo, Format format) {
        if (format.maxInputSize != -1) {
            int size = format.initializationData.size();
            int length = 0;
            for (int i = 0; i < size; i++) {
                length += format.initializationData.get(i).length;
            }
            return format.maxInputSize + length;
        }
        return getCodecMaxInputSize(codecInfo, format.sampleMimeType, format.width, format.height);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo r5, java.lang.String r6, int r7, int r8) {
        /*
            r0 = -1
            if (r7 == r0) goto La8
            if (r8 != r0) goto L7
            goto La8
        L7:
            r6.hashCode()
            int r1 = r6.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r1) {
                case -1664118616: goto L52;
                case -1662541442: goto L46;
                case 1187890754: goto L3a;
                case 1331836730: goto L2e;
                case 1599127256: goto L22;
                case 1599127257: goto L16;
                default: goto L14;
            }
        L14:
            r6 = -1
            goto L5d
        L16:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L20
            goto L14
        L20:
            r6 = 5
            goto L5d
        L22:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L2c
            goto L14
        L2c:
            r6 = 4
            goto L5d
        L2e:
            java.lang.String r1 = "video/avc"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L38
            goto L14
        L38:
            r6 = 3
            goto L5d
        L3a:
            java.lang.String r1 = "video/mp4v-es"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L44
            goto L14
        L44:
            r6 = 2
            goto L5d
        L46:
            java.lang.String r1 = "video/hevc"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L50
            goto L14
        L50:
            r6 = 1
            goto L5d
        L52:
            java.lang.String r1 = "video/3gpp"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L5c
            goto L14
        L5c:
            r6 = 0
        L5d:
            switch(r6) {
                case 0: goto L9f;
                case 1: goto L9c;
                case 2: goto L9f;
                case 3: goto L61;
                case 4: goto L9f;
                case 5: goto L9c;
                default: goto L60;
            }
        L60:
            return r0
        L61:
            java.lang.String r6 = com.google.android.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L9b
            java.lang.String r1 = com.google.android.exoplayer2.util.Util.MANUFACTURER
            java.lang.String r2 = "Amazon"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L8a
            java.lang.String r1 = "KFSOWI"
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L9b
            java.lang.String r1 = "AFTS"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L8a
            boolean r5 = r5.secure
            if (r5 == 0) goto L8a
            goto L9b
        L8a:
            r5 = 16
            int r6 = com.google.android.exoplayer2.util.Util.ceilDivide(r7, r5)
            int r7 = com.google.android.exoplayer2.util.Util.ceilDivide(r8, r5)
            int r6 = r6 * r7
            int r6 = r6 * 16
            int r7 = r6 * 16
            goto La1
        L9b:
            return r0
        L9c:
            int r7 = r7 * r8
            goto La2
        L9f:
            int r7 = r7 * r8
        La1:
            r2 = 2
        La2:
            int r7 = r7 * 3
            int r2 = r2 * 2
            int r7 = r7 / r2
            return r7
        La8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo, java.lang.String, int, int):int");
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Util.MANUFACTURER);
    }

    /* JADX WARN: Removed duplicated region for block: B:400:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0655  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0658 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:425:0x065d A[Catch: all -> 0x0665, TryCatch #0 {, blocks: (B:7:0x000d, B:9:0x0011, B:11:0x001c, B:426:0x065f, B:12:0x0020, B:14:0x0026, B:16:0x002e, B:19:0x0036, B:20:0x003c, B:401:0x061c, B:404:0x0622, B:425:0x065d, B:411:0x0638, B:414:0x0642, B:417:0x064b, B:403:0x0620, B:22:0x0041, B:25:0x004d, B:28:0x0059, B:31:0x0065, B:34:0x006f, B:37:0x007b, B:40:0x0087, B:43:0x0093, B:46:0x009f, B:49:0x00ab, B:52:0x00b7, B:55:0x00c3, B:58:0x00cf, B:61:0x00db, B:64:0x00e8, B:67:0x00f4, B:70:0x0100, B:73:0x010c, B:76:0x0118, B:79:0x0124, B:82:0x0130, B:85:0x013c, B:88:0x0148, B:91:0x0154, B:94:0x0160, B:97:0x016c, B:100:0x0178, B:103:0x0184, B:106:0x0190, B:109:0x019c, B:112:0x01a8, B:115:0x01b4, B:118:0x01c0, B:121:0x01cc, B:124:0x01d8, B:127:0x01e4, B:130:0x01f0, B:133:0x01fc, B:136:0x0207, B:139:0x0213, B:142:0x021f, B:145:0x022b, B:148:0x0237, B:151:0x0243, B:154:0x024f, B:157:0x025b, B:160:0x0267, B:163:0x0273, B:166:0x027f, B:169:0x028b, B:172:0x0297, B:175:0x02a3, B:178:0x02af, B:181:0x02bb, B:184:0x02c7, B:187:0x02d2, B:190:0x02de, B:193:0x02ea, B:196:0x02f6, B:199:0x0302, B:202:0x030e, B:205:0x031a, B:208:0x0326, B:211:0x0332, B:214:0x033e, B:217:0x034a, B:220:0x0355, B:223:0x0360, B:226:0x036b, B:229:0x0377, B:232:0x0383, B:235:0x038f, B:238:0x039b, B:241:0x03a7, B:244:0x03b3, B:247:0x03bf, B:250:0x03cb, B:253:0x03d7, B:256:0x03e3, B:259:0x03ef, B:262:0x03fb, B:265:0x0407, B:268:0x0413, B:271:0x041f, B:274:0x042b, B:277:0x0438, B:280:0x0444, B:283:0x0450, B:286:0x045c, B:289:0x0468, B:292:0x0474, B:295:0x0480, B:298:0x048c, B:301:0x0498, B:304:0x04a5, B:307:0x04b2, B:310:0x04be, B:313:0x04c9, B:316:0x04d5, B:319:0x04e1, B:322:0x04ed, B:325:0x04f9, B:328:0x0504, B:331:0x050f, B:334:0x051b, B:337:0x0527, B:340:0x0533, B:343:0x053f, B:346:0x054b, B:349:0x0557, B:352:0x0563, B:355:0x056f, B:358:0x057c, B:361:0x0588, B:364:0x0594, B:367:0x05a0, B:370:0x05ac, B:373:0x05b8, B:376:0x05c3, B:379:0x05ce, B:382:0x05d9, B:385:0x05e4, B:388:0x05ef, B:391:0x05fa, B:394:0x0605, B:397:0x0610, B:427:0x0661), top: B:433:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean codecNeedsSetOutputSurfaceWorkaround(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 2402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.codecNeedsSetOutputSurfaceWorkaround(java.lang.String):boolean");
    }

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int width, int height, int inputSize) {
            this.width = width;
            this.height = height;
            this.inputSize = inputSize;
        }
    }

    @TargetApi(23)
    private final class OnFrameRenderedListenerV23 implements MediaCodec.OnFrameRenderedListener, Handler.Callback {
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodec codec) {
            Handler handler = new Handler(this);
            this.handler = handler;
            codec.setOnFrameRenderedListener(this, handler);
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(MediaCodec codec, long presentationTimeUs, long nanoTime) {
            if (Util.SDK_INT < 30) {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (presentationTimeUs >> 32), (int) presentationTimeUs));
            } else {
                handleFrameRendered(presentationTimeUs);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        private void handleFrameRendered(long presentationTimeUs) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this != mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener) {
                return;
            }
            if (presentationTimeUs == Long.MAX_VALUE) {
                mediaCodecVideoRenderer.onProcessedTunneledEndOfStream();
            } else {
                mediaCodecVideoRenderer.onProcessedTunneledBuffer(presentationTimeUs);
            }
        }
    }
}
