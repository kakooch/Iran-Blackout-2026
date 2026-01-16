package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public interface AudioRendererEventListener {
    void onAudioDecoderInitialized(String decoderName, long initializedTimestampMs, long initializationDurationMs);

    void onAudioDisabled(DecoderCounters counters);

    void onAudioEnabled(DecoderCounters counters);

    void onAudioInputFormatChanged(Format format);

    void onAudioSessionId(int audioSessionId);

    void onAudioSinkUnderrun(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs);

    public static final class EventDispatcher {
        private final Handler handler;
        private final AudioRendererEventListener listener;

        public EventDispatcher(Handler handler, AudioRendererEventListener listener) {
            this.handler = listener != null ? (Handler) Assertions.checkNotNull(handler) : null;
            this.listener = listener;
        }

        public void enabled(final DecoderCounters decoderCounters) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$wM6x2yOc7LSRokkOnoNaLS7ezfU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$enabled$0$AudioRendererEventListener$EventDispatcher(decoderCounters);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$enabled$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$enabled$0$AudioRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioEnabled(decoderCounters);
        }

        public void decoderInitialized(final String decoderName, final long initializedTimestampMs, final long initializationDurationMs) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$q590SjkvmhHa8kO2_7jSOgj6fck
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$decoderInitialized$1$AudioRendererEventListener$EventDispatcher(decoderName, initializedTimestampMs, initializationDurationMs);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$decoderInitialized$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$decoderInitialized$1$AudioRendererEventListener$EventDispatcher(String str, long j, long j2) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDecoderInitialized(str, j, j2);
        }

        public void inputFormatChanged(final Format format) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$3B122_IDOrbk9OMXtpVI2PTvhNA
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$inputFormatChanged$2$AudioRendererEventListener$EventDispatcher(format);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$inputFormatChanged$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$inputFormatChanged$2$AudioRendererEventListener$EventDispatcher(Format format) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioInputFormatChanged(format);
        }

        public void audioTrackUnderrun(final int bufferSize, final long bufferSizeMs, final long elapsedSinceLastFeedMs) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$VJuKaDTksQW_YMyDKfTcBxDyGY4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$audioTrackUnderrun$3$AudioRendererEventListener$EventDispatcher(bufferSize, bufferSizeMs, elapsedSinceLastFeedMs);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$audioTrackUnderrun$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$audioTrackUnderrun$3$AudioRendererEventListener$EventDispatcher(int i, long j, long j2) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioSinkUnderrun(i, j, j2);
        }

        public void disabled(final DecoderCounters counters) {
            counters.ensureUpdated();
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$wqoJT2wQ9ahWfVrkm6AklgI9m8s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$disabled$4$AudioRendererEventListener$EventDispatcher(counters);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$disabled$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$disabled$4$AudioRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDisabled(decoderCounters);
        }

        public void audioSessionId(final int audioSessionId) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.-$$Lambda$AudioRendererEventListener$EventDispatcher$kaposdpNP3hzl_K1buexxJ0yWMQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$audioSessionId$5$AudioRendererEventListener$EventDispatcher(audioSessionId);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$audioSessionId$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$audioSessionId$5$AudioRendererEventListener$EventDispatcher(int i) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioSessionId(i);
        }
    }
}
