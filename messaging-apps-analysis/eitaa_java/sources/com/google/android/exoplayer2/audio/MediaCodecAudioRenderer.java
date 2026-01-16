package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    private boolean allowFirstBufferPositionDiscontinuity;
    private boolean allowPositionDiscontinuity;
    private final AudioSink audioSink;
    private int codecMaxInputSize;
    private boolean codecNeedsDiscardChannelsWorkaround;
    private boolean codecNeedsEosBufferTimestampWorkaround;
    private final Context context;
    private long currentPositionUs;
    private final AudioRendererEventListener.EventDispatcher eventDispatcher;
    private Format inputFormat;
    private long lastInputTimeUs;
    private boolean passthroughEnabled;
    private MediaFormat passthroughMediaFormat;
    private int pendingStreamChangeCount;
    private final long[] pendingStreamChangeTimesUs;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public MediaClock getMediaClock() {
        return this;
    }

    protected void onAudioSessionId(int audioSessionId) {
    }

    protected void onAudioTrackPositionDiscontinuity() {
    }

    protected void onAudioTrackUnderrun(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
    }

    @Deprecated
    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean playClearSamplesWithoutKeys, boolean enableDecoderFallback, Handler eventHandler, AudioRendererEventListener eventListener, AudioSink audioSink) {
        super(1, mediaCodecSelector, drmSessionManager, playClearSamplesWithoutKeys, enableDecoderFallback, 44100.0f);
        this.context = context.getApplicationContext();
        this.audioSink = audioSink;
        this.lastInputTimeUs = -9223372036854775807L;
        this.pendingStreamChangeTimesUs = new long[10];
        this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(eventHandler, eventListener);
        audioSink.setListener(new AudioSinkListener());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        String str = format.sampleMimeType;
        if (!MimeTypes.isAudio(str)) {
            return RendererCapabilities.CC.create(0);
        }
        int i = Util.SDK_INT >= 21 ? 32 : 0;
        boolean z = format.drmInitData == null || FrameworkMediaCrypto.class.equals(format.exoMediaCryptoType) || (format.exoMediaCryptoType == null && BaseRenderer.supportsFormatDrm(drmSessionManager, format.drmInitData));
        int i2 = 8;
        if (z && allowPassthrough(format.channelCount, str) && mediaCodecSelector.getPassthroughDecoderInfo() != null) {
            return RendererCapabilities.CC.create(4, 8, i);
        }
        if (("audio/raw".equals(str) && !this.audioSink.supportsOutput(format.channelCount, format.pcmEncoding)) || !this.audioSink.supportsOutput(format.channelCount, 2)) {
            return RendererCapabilities.CC.create(1);
        }
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, false);
        if (decoderInfos.isEmpty()) {
            return RendererCapabilities.CC.create(1);
        }
        if (!z) {
            return RendererCapabilities.CC.create(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean zIsFormatSupported = mediaCodecInfo.isFormatSupported(format);
        if (zIsFormatSupported && mediaCodecInfo.isSeamlessAdaptationSupported(format)) {
            i2 = 16;
        }
        return RendererCapabilities.CC.create(zIsFormatSupported ? 4 : 3, i2, i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean requiresSecureDecoder) throws MediaCodecUtil.DecoderQueryException {
        MediaCodecInfo passthroughDecoderInfo;
        String str = format.sampleMimeType;
        if (str == null) {
            return Collections.emptyList();
        }
        if (allowPassthrough(format.channelCount, str) && (passthroughDecoderInfo = mediaCodecSelector.getPassthroughDecoderInfo()) != null) {
            return Collections.singletonList(passthroughDecoderInfo);
        }
        List<MediaCodecInfo> decoderInfosSortedByFormatSupport = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(str, requiresSecureDecoder, false), format);
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList = new ArrayList(decoderInfosSortedByFormatSupport);
            arrayList.addAll(mediaCodecSelector.getDecoderInfos("audio/eac3", requiresSecureDecoder, false));
            decoderInfosSortedByFormatSupport = arrayList;
        }
        return Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    protected boolean allowPassthrough(int channelCount, String mimeType) {
        return getPassthroughEncoding(channelCount, mimeType) != 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(MediaCodecInfo codecInfo, MediaCodec codec, Format format, MediaCrypto crypto, float codecOperatingRate) {
        this.codecMaxInputSize = getCodecMaxInputSize(codecInfo, format, getStreamFormats());
        this.codecNeedsDiscardChannelsWorkaround = codecNeedsDiscardChannelsWorkaround(codecInfo.name);
        this.codecNeedsEosBufferTimestampWorkaround = codecNeedsEosBufferTimestampWorkaround(codecInfo.name);
        boolean z = codecInfo.passthrough;
        this.passthroughEnabled = z;
        MediaFormat mediaFormat = getMediaFormat(format, z ? "audio/raw" : codecInfo.codecMimeType, this.codecMaxInputSize, codecOperatingRate);
        codec.configure(mediaFormat, (Surface) null, crypto, 0);
        if (this.passthroughEnabled) {
            this.passthroughMediaFormat = mediaFormat;
            mediaFormat.setString("mime", format.sampleMimeType);
        } else {
            this.passthroughMediaFormat = null;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int canKeepCodec(MediaCodec codec, MediaCodecInfo codecInfo, Format oldFormat, Format newFormat) {
        if (getCodecMaxInputSize(codecInfo, newFormat) <= this.codecMaxInputSize && oldFormat.encoderDelay == 0 && oldFormat.encoderPadding == 0 && newFormat.encoderDelay == 0 && newFormat.encoderPadding == 0) {
            if (codecInfo.isSeamlessAdaptationSupported(oldFormat, newFormat, true)) {
                return 3;
            }
            if (canKeepCodecWithFlush(oldFormat, newFormat)) {
                return 1;
            }
        }
        return 0;
    }

    protected boolean canKeepCodecWithFlush(Format oldFormat, Format newFormat) {
        return Util.areEqual(oldFormat.sampleMimeType, newFormat.sampleMimeType) && oldFormat.channelCount == newFormat.channelCount && oldFormat.sampleRate == newFormat.sampleRate && oldFormat.pcmEncoding == newFormat.pcmEncoding && oldFormat.initializationDataEquals(newFormat) && !"audio/opus".equals(oldFormat.sampleMimeType);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float getCodecOperatingRateV23(float operatingRate, Format format, Format[] streamFormats) {
        int iMax = -1;
        for (Format format2 : streamFormats) {
            int i = format2.sampleRate;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return operatingRate * iMax;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(String name, long initializedTimestampMs, long initializationDurationMs) {
        this.eventDispatcher.decoderInitialized(name, initializedTimestampMs, initializationDurationMs);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException, MediaCryptoException {
        super.onInputFormatChanged(formatHolder);
        Format format = formatHolder.format;
        this.inputFormat = format;
        this.eventDispatcher.inputFormatChanged(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onOutputFormatChanged(MediaCodec codec, MediaFormat outputMediaFormat) throws ExoPlaybackException {
        int pcmEncoding;
        int passthroughEncoding;
        int[] iArr;
        int i;
        MediaFormat mediaFormat = this.passthroughMediaFormat;
        if (mediaFormat != null) {
            passthroughEncoding = getPassthroughEncoding(mediaFormat.getInteger("channel-count"), mediaFormat.getString("mime"));
            outputMediaFormat = mediaFormat;
        } else {
            if (outputMediaFormat.containsKey("v-bits-per-sample")) {
                pcmEncoding = Util.getPcmEncoding(outputMediaFormat.getInteger("v-bits-per-sample"));
            } else {
                pcmEncoding = getPcmEncoding(this.inputFormat);
            }
            passthroughEncoding = pcmEncoding;
        }
        int integer = outputMediaFormat.getInteger("channel-count");
        int integer2 = outputMediaFormat.getInteger("sample-rate");
        if (this.codecNeedsDiscardChannelsWorkaround && integer == 6 && (i = this.inputFormat.channelCount) < 6) {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.inputFormat.channelCount; i2++) {
                iArr[i2] = i2;
            }
        } else {
            iArr = null;
        }
        int[] iArr2 = iArr;
        try {
            AudioSink audioSink = this.audioSink;
            Format format = this.inputFormat;
            audioSink.configure(passthroughEncoding, integer, integer2, 0, iArr2, format.encoderDelay, format.encoderPadding);
        } catch (AudioSink.ConfigurationException e) {
            throw createRendererException(e, this.inputFormat);
        }
    }

    protected int getPassthroughEncoding(int channelCount, String mimeType) {
        if ("audio/eac3-joc".equals(mimeType)) {
            if (this.audioSink.supportsOutput(-1, 18)) {
                return MimeTypes.getEncoding("audio/eac3-joc");
            }
            mimeType = "audio/eac3";
        }
        int encoding = MimeTypes.getEncoding(mimeType);
        if (this.audioSink.supportsOutput(channelCount, encoding)) {
            return encoding;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean joining) throws ExoPlaybackException {
        super.onEnabled(joining);
        this.eventDispatcher.enabled(this.decoderCounters);
        int i = getConfiguration().tunnelingAudioSessionId;
        if (i != 0) {
            this.audioSink.enableTunnelingV21(i);
        } else {
            this.audioSink.disableTunneling();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStreamChanged(Format[] formats, long offsetUs) throws ExoPlaybackException {
        super.onStreamChanged(formats, offsetUs);
        if (this.lastInputTimeUs != -9223372036854775807L) {
            int i = this.pendingStreamChangeCount;
            if (i == this.pendingStreamChangeTimesUs.length) {
                Log.w("MediaCodecAudioRenderer", "Too many stream changes, so dropping change at " + this.pendingStreamChangeTimesUs[this.pendingStreamChangeCount - 1]);
            } else {
                this.pendingStreamChangeCount = i + 1;
            }
            this.pendingStreamChangeTimesUs[this.pendingStreamChangeCount - 1] = this.lastInputTimeUs;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long positionUs, boolean joining) throws ExoPlaybackException {
        super.onPositionReset(positionUs, joining);
        this.audioSink.flush();
        this.currentPositionUs = positionUs;
        this.allowFirstBufferPositionDiscontinuity = true;
        this.allowPositionDiscontinuity = true;
        this.lastInputTimeUs = -9223372036854775807L;
        this.pendingStreamChangeCount = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        this.audioSink.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        updateCurrentPosition();
        this.audioSink.pause();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        try {
            this.lastInputTimeUs = -9223372036854775807L;
            this.pendingStreamChangeCount = 0;
            this.audioSink.flush();
            try {
                super.onDisabled();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.onDisabled();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onReset() {
        try {
            super.onReset();
        } finally {
            this.audioSink.reset();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return super.isEnded() && this.audioSink.isEnded();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.audioSink.hasPendingData() || super.isReady();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (getState() == 2) {
            updateCurrentPosition();
        }
        return this.currentPositionUs;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.audioSink.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return this.audioSink.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onQueueInputBuffer(DecoderInputBuffer buffer) {
        if (this.allowFirstBufferPositionDiscontinuity && !buffer.isDecodeOnly()) {
            if (Math.abs(buffer.timeUs - this.currentPositionUs) > 500000) {
                this.currentPositionUs = buffer.timeUs;
            }
            this.allowFirstBufferPositionDiscontinuity = false;
        }
        this.lastInputTimeUs = Math.max(buffer.timeUs, this.lastInputTimeUs);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onProcessedOutputBuffer(long presentationTimeUs) {
        while (this.pendingStreamChangeCount != 0 && presentationTimeUs >= this.pendingStreamChangeTimesUs[0]) {
            this.audioSink.handleDiscontinuity();
            int i = this.pendingStreamChangeCount - 1;
            this.pendingStreamChangeCount = i;
            long[] jArr = this.pendingStreamChangeTimesUs;
            System.arraycopy(jArr, 1, jArr, 0, i);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean processOutputBuffer(long positionUs, long elapsedRealtimeUs, MediaCodec codec, ByteBuffer buffer, int bufferIndex, int bufferFlags, long bufferPresentationTimeUs, boolean isDecodeOnlyBuffer, boolean isLastBuffer, Format format) throws ExoPlaybackException {
        if (this.codecNeedsEosBufferTimestampWorkaround && bufferPresentationTimeUs == 0 && (bufferFlags & 4) != 0) {
            long j = this.lastInputTimeUs;
            if (j != -9223372036854775807L) {
                bufferPresentationTimeUs = j;
            }
        }
        if (this.passthroughEnabled && (bufferFlags & 2) != 0) {
            codec.releaseOutputBuffer(bufferIndex, false);
            return true;
        }
        if (isDecodeOnlyBuffer) {
            codec.releaseOutputBuffer(bufferIndex, false);
            this.decoderCounters.skippedOutputBufferCount++;
            this.audioSink.handleDiscontinuity();
            return true;
        }
        try {
            if (!this.audioSink.handleBuffer(buffer, bufferPresentationTimeUs)) {
                return false;
            }
            codec.releaseOutputBuffer(bufferIndex, false);
            this.decoderCounters.renderedOutputBufferCount++;
            return true;
        } catch (AudioSink.InitializationException | AudioSink.WriteException e) {
            throw createRendererException(e, this.inputFormat);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void renderToEndOfStream() throws ExoPlaybackException {
        try {
            this.audioSink.playToEndOfStream();
        } catch (AudioSink.WriteException e) {
            throw createRendererException(e, this.inputFormat);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int messageType, Object message) throws ExoPlaybackException {
        if (messageType == 2) {
            this.audioSink.setVolume(((Float) message).floatValue());
            return;
        }
        if (messageType == 3) {
            this.audioSink.setAudioAttributes((AudioAttributes) message);
        } else if (messageType == 5) {
            this.audioSink.setAuxEffectInfo((AuxEffectInfo) message);
        } else {
            super.handleMessage(messageType, message);
        }
    }

    protected int getCodecMaxInputSize(MediaCodecInfo codecInfo, Format format, Format[] streamFormats) {
        int codecMaxInputSize = getCodecMaxInputSize(codecInfo, format);
        if (streamFormats.length == 1) {
            return codecMaxInputSize;
        }
        for (Format format2 : streamFormats) {
            if (codecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                codecMaxInputSize = Math.max(codecMaxInputSize, getCodecMaxInputSize(codecInfo, format2));
            }
        }
        return codecMaxInputSize;
    }

    private int getCodecMaxInputSize(MediaCodecInfo codecInfo, Format format) {
        int i;
        if (!"OMX.google.raw.decoder".equals(codecInfo.name) || (i = Util.SDK_INT) >= 24 || (i == 23 && Util.isTv(this.context))) {
            return format.maxInputSize;
        }
        return -1;
    }

    @SuppressLint({"InlinedApi"})
    protected MediaFormat getMediaFormat(Format format, String codecMimeType, int codecMaxInputSize, float codecOperatingRate) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", codecMimeType);
        mediaFormat.setInteger("channel-count", format.channelCount);
        mediaFormat.setInteger("sample-rate", format.sampleRate);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxInputSize);
        int i = Util.SDK_INT;
        if (i >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (codecOperatingRate != -1.0f && !deviceDoesntSupportOperatingRate()) {
                mediaFormat.setFloat("operating-rate", codecOperatingRate);
            }
        }
        if (i <= 28 && "audio/ac4".equals(format.sampleMimeType)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        return mediaFormat;
    }

    private void updateCurrentPosition() {
        long currentPositionUs = this.audioSink.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.allowPositionDiscontinuity) {
                currentPositionUs = Math.max(this.currentPositionUs, currentPositionUs);
            }
            this.currentPositionUs = currentPositionUs;
            this.allowPositionDiscontinuity = false;
        }
    }

    private static boolean deviceDoesntSupportOperatingRate() {
        if (Util.SDK_INT == 23) {
            String str = Util.MODEL;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean codecNeedsDiscardChannelsWorkaround(String codecName) {
        if (Util.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(codecName) && "samsung".equals(Util.MANUFACTURER)) {
            String str = Util.DEVICE;
            if (str.startsWith("zeroflte") || str.startsWith("herolte") || str.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private static boolean codecNeedsEosBufferTimestampWorkaround(String codecName) {
        if (Util.SDK_INT < 21 && "OMX.SEC.mp3.dec".equals(codecName) && "samsung".equals(Util.MANUFACTURER)) {
            String str = Util.DEVICE;
            if (str.startsWith("baffin") || str.startsWith("grand") || str.startsWith("fortuna") || str.startsWith("gprimelte") || str.startsWith("j2y18lte") || str.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    private static int getPcmEncoding(Format format) {
        if ("audio/raw".equals(format.sampleMimeType)) {
            return format.pcmEncoding;
        }
        return 2;
    }

    private final class AudioSinkListener implements AudioSink.Listener {
        private AudioSinkListener() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onAudioSessionId(int audioSessionId) {
            MediaCodecAudioRenderer.this.eventDispatcher.audioSessionId(audioSessionId);
            MediaCodecAudioRenderer.this.onAudioSessionId(audioSessionId);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionDiscontinuity() {
            MediaCodecAudioRenderer.this.onAudioTrackPositionDiscontinuity();
            MediaCodecAudioRenderer.this.allowPositionDiscontinuity = true;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onUnderrun(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
            MediaCodecAudioRenderer.this.eventDispatcher.audioTrackUnderrun(bufferSize, bufferSizeMs, elapsedSinceLastFeedMs);
            MediaCodecAudioRenderer.this.onAudioTrackUnderrun(bufferSize, bufferSizeMs, elapsedSinceLastFeedMs);
        }
    }
}
