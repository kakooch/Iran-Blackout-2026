package org.webrtc;

import java.util.IdentityHashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class VideoTrack extends MediaStreamTrack {
    private final IdentityHashMap<VideoSink, Long> sinks;

    private static native void nativeAddSink(long track, long nativeSink);

    private static native void nativeFreeSink(long sink);

    private static native void nativeRemoveSink(long track, long nativeSink);

    private static native long nativeWrapSink(VideoSink sink);

    public VideoTrack(long nativeTrack) {
        super(nativeTrack);
        this.sinks = new IdentityHashMap<>();
    }

    public void addSink(VideoSink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("The VideoSink is not allowed to be null");
        }
        if (this.sinks.containsKey(sink)) {
            return;
        }
        long jNativeWrapSink = nativeWrapSink(sink);
        this.sinks.put(sink, Long.valueOf(jNativeWrapSink));
        nativeAddSink(getNativeMediaStreamTrack(), jNativeWrapSink);
    }

    public void removeSink(VideoSink sink) {
        Long lRemove = this.sinks.remove(sink);
        if (lRemove != null) {
            nativeRemoveSink(getNativeMediaStreamTrack(), lRemove.longValue());
            nativeFreeSink(lRemove.longValue());
        }
    }

    @Override // org.webrtc.MediaStreamTrack
    public void dispose() {
        Iterator<Long> it = this.sinks.values().iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            nativeRemoveSink(getNativeMediaStreamTrack(), jLongValue);
            nativeFreeSink(jLongValue);
        }
        this.sinks.clear();
        super.dispose();
    }

    long getNativeVideoTrack() {
        return getNativeMediaStreamTrack();
    }
}
