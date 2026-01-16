package com.google.android.exoplayer2t.drm;

import com.google.android.exoplayer2t.drm.ExoMediaCrypto;
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

    /* renamed from: com.google.android.exoplayer2t.drm.DrmSession$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static <T extends ExoMediaCrypto> void replaceSession(DrmSession<T> drmSession, DrmSession<T> drmSession2) {
            if (drmSession == drmSession2) {
                return;
            }
            if (drmSession2 != null) {
                drmSession2.acquire();
            }
            if (drmSession != null) {
                drmSession.release();
            }
        }
    }

    public static class DrmSessionException extends IOException {
        public DrmSessionException(Throwable th) {
            super(th);
        }
    }
}
