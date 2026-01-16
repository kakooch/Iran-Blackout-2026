package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
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

    void closeSession(byte[] sessionId);

    T createMediaCrypto(byte[] sessionId) throws MediaCryptoException;

    Class<T> getExoMediaCryptoType();

    KeyRequest getKeyRequest(byte[] scope, List<DrmInitData.SchemeData> schemeDatas, int keyType, HashMap<String, String> optionalParameters) throws NotProvisionedException;

    ProvisionRequest getProvisionRequest();

    byte[] openSession() throws MediaDrmException;

    byte[] provideKeyResponse(byte[] scope, byte[] response) throws DeniedByServerException, NotProvisionedException;

    void provideProvisionResponse(byte[] response) throws DeniedByServerException;

    Map<String, String> queryKeyStatus(byte[] sessionId);

    void release();

    void restoreKeys(byte[] sessionId, byte[] keySetId);

    void setOnEventListener(OnEventListener<? super T> listener);
}
