package livekit.org.webrtc;

import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public interface AudioTrackSink {
    @CalledByNative
    void onData(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j);
}
