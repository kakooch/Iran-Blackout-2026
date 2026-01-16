package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public interface VideoRendererEventListener {
    void onDroppedFrames(int count, long elapsedMs);

    void onRenderedFirstFrame(Surface surface);

    void onVideoDecoderInitialized(String decoderName, long initializedTimestampMs, long initializationDurationMs);

    void onVideoDisabled(DecoderCounters counters);

    void onVideoEnabled(DecoderCounters counters);

    void onVideoInputFormatChanged(Format format);

    void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio);

    public static final class EventDispatcher {
        private final Handler handler;
        private final VideoRendererEventListener listener;

        public EventDispatcher(Handler handler, VideoRendererEventListener listener) {
            this.handler = listener != null ? (Handler) Assertions.checkNotNull(handler) : null;
            this.listener = listener;
        }

        public void enabled(final DecoderCounters decoderCounters) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$RxBEN-RwvFErOnQM84ZS2H2saCQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$enabled$0$VideoRendererEventListener$EventDispatcher(decoderCounters);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$enabled$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$enabled$0$VideoRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoEnabled(decoderCounters);
        }

        public void decoderInitialized(final String decoderName, final long initializedTimestampMs, final long initializationDurationMs) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$c5PVgyPI6cEJjS0i6dHp--T5aag
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$decoderInitialized$1$VideoRendererEventListener$EventDispatcher(decoderName, initializedTimestampMs, initializationDurationMs);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$decoderInitialized$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$decoderInitialized$1$VideoRendererEventListener$EventDispatcher(String str, long j, long j2) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDecoderInitialized(str, j, j2);
        }

        public void inputFormatChanged(final Format format) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$05e0co9JH0Zk3WjiY6L0QcYlWpk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$inputFormatChanged$2$VideoRendererEventListener$EventDispatcher(format);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$inputFormatChanged$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$inputFormatChanged$2$VideoRendererEventListener$EventDispatcher(Format format) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoInputFormatChanged(format);
        }

        public void droppedFrames(final int droppedFrameCount, final long elapsedMs) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$b2kGnP5SrIEYRC-Qyhf39twFppI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$droppedFrames$3$VideoRendererEventListener$EventDispatcher(droppedFrameCount, elapsedMs);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$droppedFrames$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$droppedFrames$3$VideoRendererEventListener$EventDispatcher(int i, long j) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onDroppedFrames(i, j);
        }

        public void videoSizeChanged(final int width, final int height, final int unappliedRotationDegrees, final float pixelWidthHeightRatio) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$sTReXAG5SqkM60dXhmjTIfRWGak
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$videoSizeChanged$4$VideoRendererEventListener$EventDispatcher(width, height, unappliedRotationDegrees, pixelWidthHeightRatio);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$videoSizeChanged$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$videoSizeChanged$4$VideoRendererEventListener$EventDispatcher(int i, int i2, int i3, float f) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoSizeChanged(i, i2, i3, f);
        }

        public void renderedFirstFrame(final Surface surface) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$c5XbtqPlisiwZ6nSji956XxdaHo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$renderedFirstFrame$5$VideoRendererEventListener$EventDispatcher(surface);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$renderedFirstFrame$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$renderedFirstFrame$5$VideoRendererEventListener$EventDispatcher(Surface surface) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onRenderedFirstFrame(surface);
        }

        public void disabled(final DecoderCounters counters) {
            counters.ensureUpdated();
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.-$$Lambda$VideoRendererEventListener$EventDispatcher$gGxMZQ0TZK-KSL4tXLV0_uA06sQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$disabled$6$VideoRendererEventListener$EventDispatcher(counters);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$disabled$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$disabled$6$VideoRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDisabled(decoderCounters);
        }
    }
}
