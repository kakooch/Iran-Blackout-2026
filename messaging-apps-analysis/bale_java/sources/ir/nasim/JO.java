package ir.nasim;

import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import livekit.org.webrtc.AudioTrackSink;
import livekit.org.webrtc.audio.JavaAudioDeviceModule;

/* loaded from: classes3.dex */
public final class JO implements JavaAudioDeviceModule.SamplesReadyCallback {
    private final Set a = new LinkedHashSet();

    private final int a(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Bad audio format " + i);
        }
        int i2 = 1;
        if (i == 1 || i == 2) {
            return 2;
        }
        if (i != 3) {
            i2 = 4;
            if (i != 4) {
                if (i == 13) {
                    return 2;
                }
                throw new IllegalArgumentException("Bad audio format " + i);
            }
        }
        return i2;
    }

    public final synchronized void b(AudioTrackSink audioTrackSink) {
        AbstractC13042fc3.i(audioTrackSink, "sink");
        this.a.remove(audioTrackSink);
    }

    @Override // livekit.org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
    public synchronized void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
        AbstractC13042fc3.i(audioSamples, "samples");
        int iA = a(audioSamples.getAudioFormat()) * 8;
        int sampleRate = audioSamples.getSampleRate() / 100;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((AudioTrackSink) it.next()).onData(ByteBuffer.wrap(audioSamples.getData()), iA, audioSamples.getSampleRate(), audioSamples.getChannelCount(), sampleRate, jElapsedRealtime);
        }
    }
}
