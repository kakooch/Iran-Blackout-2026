package livekit.org.webrtc;

import android.content.Context;
import livekit.org.webrtc.NetworkChangeDetector;

/* loaded from: classes8.dex */
public interface NetworkChangeDetectorFactory {
    NetworkChangeDetector create(NetworkChangeDetector.Observer observer, Context context);
}
