package org.webrtc;

/* loaded from: classes3.dex */
public interface VideoSink {

    /* renamed from: org.webrtc.VideoSink$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setParentSink(VideoSink videoSink, VideoSink videoSink2) {
        }
    }

    @CalledByNative
    void onFrame(VideoFrame frame);

    void setParentSink(VideoSink parent);
}
