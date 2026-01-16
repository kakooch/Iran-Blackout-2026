package com.google.android.exoplayer2t.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import com.google.android.exoplayer2t.drm.DrmInitData;
import com.google.android.exoplayer2t.drm.ExoMediaCrypto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public interface ExoMediaDrm<T extends ExoMediaCrypto> {

    public static final class KeyRequest {
    }

    public interface OnEventListener<T extends ExoMediaCrypto> {
    }

    public interface Provider<T extends ExoMediaCrypto> {
        ExoMediaDrm<T> acquireExoMediaDrm(UUID uuid);
    }

    public static final class ProvisionRequest {
    }

    void closeSession(byte[] bArr);

    T createMediaCrypto(byte[] bArr) throws MediaCryptoException;

    Class<T> getExoMediaCryptoType();

    KeyRequest getKeyRequest(byte[] bArr, List<DrmInitData.SchemeData> list, int i, HashMap<String, String> map) throws NotProvisionedException;

    ProvisionRequest getProvisionRequest();

    byte[] openSession() throws MediaDrmException;

    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException;

    void provideProvisionResponse(byte[] bArr) throws DeniedByServerException;

    Map<String, String> queryKeyStatus(byte[] bArr);

    void release();

    void restoreKeys(byte[] bArr, byte[] bArr2);

    void setOnEventListener(OnEventListener<? super T> onEventListener);
}
