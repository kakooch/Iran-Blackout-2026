package ir.nasim;

import java.util.Iterator;
import java.util.LinkedHashSet;
import livekit.org.webrtc.CapturerObserver;
import livekit.org.webrtc.VideoFrame;
import livekit.org.webrtc.VideoSink;

/* loaded from: classes3.dex */
public final class HF0 implements CapturerObserver {
    private final LinkedHashSet a = new LinkedHashSet();
    private final LinkedHashSet b = new LinkedHashSet();

    public final synchronized void a(CapturerObserver capturerObserver) {
        AbstractC13042fc3.i(capturerObserver, "observer");
        this.a.add(capturerObserver);
    }

    public final synchronized void b(VideoSink videoSink) {
        AbstractC13042fc3.i(videoSink, "sink");
        this.b.add(videoSink);
    }

    public final synchronized void c(VideoSink videoSink) {
        AbstractC13042fc3.i(videoSink, "sink");
        this.b.remove(videoSink);
    }

    @Override // livekit.org.webrtc.CapturerObserver
    public synchronized void onCapturerStarted(boolean z) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((CapturerObserver) it.next()).onCapturerStarted(z);
        }
    }

    @Override // livekit.org.webrtc.CapturerObserver
    public synchronized void onCapturerStopped() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((CapturerObserver) it.next()).onCapturerStopped();
        }
    }

    @Override // livekit.org.webrtc.CapturerObserver
    public synchronized void onFrameCaptured(VideoFrame videoFrame) {
        try {
            AbstractC13042fc3.i(videoFrame, "frame");
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((CapturerObserver) it.next()).onFrameCaptured(videoFrame);
            }
            Iterator it2 = this.b.iterator();
            while (it2.hasNext()) {
                ((VideoSink) it2.next()).onFrame(videoFrame);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
