package ir.nasim;

import livekit.org.webrtc.VideoFrame;
import livekit.org.webrtc.VideoProcessor;
import livekit.org.webrtc.VideoSink;

/* renamed from: ir.nasim.iI0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC14668iI0 implements VideoProcessor {
    private VideoSink a;
    private VideoProcessor b;

    protected final void a(VideoFrame videoFrame) {
        AbstractC13042fc3.i(videoFrame, "frame");
        VideoProcessor videoProcessor = this.b;
        if (videoProcessor != null) {
            videoProcessor.onFrameCaptured(videoFrame);
            return;
        }
        VideoSink videoSink = this.a;
        if (videoSink != null) {
            videoSink.onFrame(videoFrame);
        }
    }

    public final void b(VideoProcessor videoProcessor) {
        if (videoProcessor != null) {
            videoProcessor.setSink(this.a);
        }
        this.b = videoProcessor;
    }

    @Override // livekit.org.webrtc.CapturerObserver
    public void onCapturerStarted(boolean z) {
        VideoProcessor videoProcessor = this.b;
        if (videoProcessor != null) {
            videoProcessor.onCapturerStarted(z);
        }
    }

    @Override // livekit.org.webrtc.CapturerObserver
    public void onCapturerStopped() {
        VideoProcessor videoProcessor = this.b;
        if (videoProcessor != null) {
            videoProcessor.onCapturerStopped();
        }
    }

    @Override // livekit.org.webrtc.VideoProcessor
    public final void setSink(VideoSink videoSink) {
        VideoProcessor videoProcessor = this.b;
        if (videoProcessor != null) {
            videoProcessor.setSink(videoSink);
        }
        this.a = videoSink;
    }
}
