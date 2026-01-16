package com.google.android.exoplayer2t.ext.flac;

import android.os.Handler;
import com.google.android.exoplayer2t.BaseRenderer;
import com.google.android.exoplayer2t.ExoPlaybackException;
import com.google.android.exoplayer2t.Format;
import com.google.android.exoplayer2t.Renderer;
import com.google.android.exoplayer2t.audio.AudioProcessor;
import com.google.android.exoplayer2t.audio.AudioRendererEventListener;
import com.google.android.exoplayer2t.audio.AudioSink;
import com.google.android.exoplayer2t.audio.SimpleDecoderAudioRenderer;
import com.google.android.exoplayer2t.drm.DrmSessionManager;
import com.google.android.exoplayer2t.drm.ExoMediaCrypto;
import com.google.android.exoplayer2t.util.Assertions;
import com.google.android.exoplayer2t.util.FlacStreamMetadata;
import com.google.android.exoplayer2t.util.Util;

/* loaded from: classes.dex */
public final class LibflacAudioRenderer extends SimpleDecoderAudioRenderer {
    private static final int NUM_BUFFERS = 16;
    private FlacStreamMetadata streamMetadata;

    @Override // com.google.android.exoplayer2t.BaseRenderer, com.google.android.exoplayer2t.Renderer
    public /* bridge */ /* synthetic */ void setOperatingRate(float f) throws ExoPlaybackException {
        Renderer.CC.$default$setOperatingRate(this, f);
    }

    public LibflacAudioRenderer() {
        this((Handler) null, (AudioRendererEventListener) null, new AudioProcessor[0]);
    }

    public LibflacAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        super(handler, audioRendererEventListener, audioProcessorArr);
    }

    public LibflacAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(handler, audioRendererEventListener, null, false, audioSink);
    }

    @Override // com.google.android.exoplayer2t.audio.SimpleDecoderAudioRenderer
    protected int supportsFormatInternal(DrmSessionManager<ExoMediaCrypto> drmSessionManager, Format format) {
        if (!"audio/flac".equalsIgnoreCase(format.sampleMimeType)) {
            return 0;
        }
        if (supportsOutput(format.channelCount, format.initializationData.isEmpty() ? 2 : Util.getPcmEncoding(new FlacStreamMetadata(format.initializationData.get(0), 8).bitsPerSample))) {
            return !BaseRenderer.supportsFormatDrm(drmSessionManager, format.drmInitData) ? 2 : 4;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2t.audio.SimpleDecoderAudioRenderer
    public FlacDecoder createDecoder(Format format, ExoMediaCrypto exoMediaCrypto) throws FlacDecoderException {
        FlacDecoder flacDecoder = new FlacDecoder(16, 16, format.maxInputSize, format.initializationData);
        this.streamMetadata = flacDecoder.getStreamMetadata();
        return flacDecoder;
    }

    @Override // com.google.android.exoplayer2t.audio.SimpleDecoderAudioRenderer
    protected Format getOutputFormat() {
        Assertions.checkNotNull(this.streamMetadata);
        FlacStreamMetadata flacStreamMetadata = this.streamMetadata;
        return Format.createAudioSampleFormat(null, "audio/raw", null, -1, -1, flacStreamMetadata.channels, flacStreamMetadata.sampleRate, Util.getPcmEncoding(flacStreamMetadata.bitsPerSample), null, null, 0, null);
    }
}
