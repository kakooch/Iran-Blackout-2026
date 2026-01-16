package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public interface DrmSession {
    void acquire(DrmSessionEventListener.EventDispatcher eventDispatcher);

    DrmSessionException getError();

    ExoMediaCrypto getMediaCrypto();

    int getState();

    boolean playClearSamplesWithoutKeys();

    Map<String, String> queryKeyStatus();

    void release(DrmSessionEventListener.EventDispatcher eventDispatcher);

    /* renamed from: com.google.android.exoplayer2.drm.DrmSession$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void replaceSession(DrmSession drmSession, DrmSession drmSession2) {
            if (drmSession == drmSession2) {
                return;
            }
            if (drmSession2 != null) {
                drmSession2.acquire(null);
            }
            if (drmSession != null) {
                drmSession.release(null);
            }
        }
    }

    public static class DrmSessionException extends IOException {
        public DrmSessionException(Throwable th) {
            super(th);
        }
    }
}
