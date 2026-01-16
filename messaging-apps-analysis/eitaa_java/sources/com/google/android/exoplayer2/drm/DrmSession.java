package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public interface DrmSession<T extends ExoMediaCrypto> {
    void acquire();

    DrmSessionException getError();

    T getMediaCrypto();

    int getState();

    boolean playClearSamplesWithoutKeys();

    Map<String, String> queryKeyStatus();

    void release();

    /* renamed from: com.google.android.exoplayer2.drm.DrmSession$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static <T extends ExoMediaCrypto> void replaceSession(DrmSession<T> previousSession, DrmSession<T> newSession) {
            if (previousSession == newSession) {
                return;
            }
            if (newSession != null) {
                newSession.acquire();
            }
            if (previousSession != null) {
                previousSession.release();
            }
        }
    }

    public static class DrmSessionException extends IOException {
        public DrmSessionException(Throwable cause) {
            super(cause);
        }
    }
}
