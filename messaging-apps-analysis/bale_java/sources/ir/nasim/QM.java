package ir.nasim;

import java.nio.ByteBuffer;
import livekit.org.webrtc.audio.JavaAudioDeviceModule;

/* loaded from: classes3.dex */
public final class QM implements JavaAudioDeviceModule.AudioBufferCallback {
    @Override // livekit.org.webrtc.audio.JavaAudioDeviceModule.AudioBufferCallback
    public long onBuffer(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j) {
        AbstractC13042fc3.i(byteBuffer, "buffer");
        return 0L;
    }
}
