package com.google.android.exoplayer2t.drm;

import com.google.android.exoplayer2t.drm.DrmSession;
import com.google.android.exoplayer2t.drm.ExoMediaCrypto;
import com.google.android.exoplayer2t.util.Assertions;
import java.util.Map;

/* loaded from: classes.dex */
public final class ErrorStateDrmSession<T extends ExoMediaCrypto> implements DrmSession<T> {
    private final DrmSession.DrmSessionException error;

    @Override // com.google.android.exoplayer2t.drm.DrmSession
    public void acquire() {
    }

    @Override // com.google.android.exoplayer2t.drm.DrmSession
    public T getMediaCrypto() {
        return null;
    }

    @Override // com.google.android.exoplayer2t.drm.DrmSession
    public int getState() {
        return 1;
    }

    @Override // com.google.android.exoplayer2t.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return false;
    }

    @Override // com.google.android.exoplayer2t.drm.DrmSession
    public Map<String, String> queryKeyStatus() {
        return null;
    }

    @Override // com.google.android.exoplayer2t.drm.DrmSession
    public void release() {
    }

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        this.error = (DrmSession.DrmSessionException) Assertions.checkNotNull(drmSessionException);
    }

    @Override // com.google.android.exoplayer2t.drm.DrmSession
    public DrmSession.DrmSessionException getError() {
        return this.error;
    }
}
