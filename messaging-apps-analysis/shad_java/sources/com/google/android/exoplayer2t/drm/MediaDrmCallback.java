package com.google.android.exoplayer2t.drm;

import com.google.android.exoplayer2t.drm.ExoMediaDrm;
import java.util.UUID;

/* loaded from: classes.dex */
public interface MediaDrmCallback {
    byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws Exception;

    byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws Exception;
}
