package livekit.org.webrtc;

import android.content.Context;

/* loaded from: classes8.dex */
public class ApplicationContextProvider {
    @CalledByNative
    public static Context getApplicationContext() {
        return ContextUtils.getApplicationContext();
    }
}
