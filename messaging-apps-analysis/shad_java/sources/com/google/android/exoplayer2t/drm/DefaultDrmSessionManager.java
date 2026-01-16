package com.google.android.exoplayer2t.drm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2t.C;
import com.google.android.exoplayer2t.drm.DefaultDrmSession;
import com.google.android.exoplayer2t.drm.DrmInitData;
import com.google.android.exoplayer2t.drm.DrmSession;
import com.google.android.exoplayer2t.drm.ExoMediaCrypto;
import com.google.android.exoplayer2t.drm.ExoMediaDrm;
import com.google.android.exoplayer2t.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2t.util.Assertions;
import com.google.android.exoplayer2t.util.EventDispatcher;
import com.google.android.exoplayer2t.util.Log;
import com.google.android.exoplayer2t.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class DefaultDrmSessionManager<T extends ExoMediaCrypto> implements DrmSessionManager<T> {
    private final MediaDrmCallback callback;
    private final EventDispatcher<DefaultDrmSessionEventListener> eventDispatcher;
    private ExoMediaDrm<T> exoMediaDrm;
    private final ExoMediaDrm.Provider<T> exoMediaDrmProvider;
    private final HashMap<String, String> keyRequestParameters;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    volatile DefaultDrmSessionManager<T>.MediaDrmHandler mediaDrmHandler;
    private int mode;
    private final boolean multiSession;
    private DefaultDrmSession<T> noMultiSessionDrmSession;
    private byte[] offlineLicenseKeySetId;
    private DefaultDrmSession<T> placeholderDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    private Looper playbackLooper;
    private int prepareCallsCount;
    private final DefaultDrmSessionManager<T>.ProvisioningManagerImpl provisioningManagerImpl;
    private final List<DefaultDrmSession<T>> provisioningSessions;
    private final List<DefaultDrmSession<T>> sessions;
    private final int[] useDrmSessionsForClearContentTrackTypes;
    private final UUID uuid;

    private class ProvisioningManagerImpl implements DefaultDrmSession.ProvisioningManager<T> {
    }

    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    public final void addListener(Handler handler, DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
        this.eventDispatcher.addListener(handler, defaultDrmSessionEventListener);
    }

    @Override // com.google.android.exoplayer2t.drm.DrmSessionManager
    public final void prepare() {
        int i = this.prepareCallsCount;
        this.prepareCallsCount = i + 1;
        if (i == 0) {
            Assertions.checkState(this.exoMediaDrm == null);
            ExoMediaDrm<T> exoMediaDrmAcquireExoMediaDrm = this.exoMediaDrmProvider.acquireExoMediaDrm(this.uuid);
            this.exoMediaDrm = exoMediaDrmAcquireExoMediaDrm;
            exoMediaDrmAcquireExoMediaDrm.setOnEventListener(new MediaDrmEventListener());
        }
    }

    @Override // com.google.android.exoplayer2t.drm.DrmSessionManager
    public final void release() {
        int i = this.prepareCallsCount - 1;
        this.prepareCallsCount = i;
        if (i == 0) {
            ((ExoMediaDrm) Assertions.checkNotNull(this.exoMediaDrm)).release();
            this.exoMediaDrm = null;
        }
    }

    @Override // com.google.android.exoplayer2t.drm.DrmSessionManager
    public boolean canAcquireSession(DrmInitData drmInitData) {
        if (this.offlineLicenseKeySetId != null) {
            return true;
        }
        if (getSchemeDatas(drmInitData, this.uuid, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(C.COMMON_PSSH_UUID)) {
                return false;
            }
            Log.w("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.uuid);
        }
        String str = drmInitData.schemeType;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return !("cbc1".equals(str) || "cbcs".equals(str) || "cens".equals(str)) || Util.SDK_INT >= 25;
    }

    @Override // com.google.android.exoplayer2t.drm.DrmSessionManager
    public DrmSession<T> acquirePlaceholderSession(Looper looper, int i) {
        assertExpectedPlaybackLooper(looper);
        ExoMediaDrm exoMediaDrm = (ExoMediaDrm) Assertions.checkNotNull(this.exoMediaDrm);
        if ((FrameworkMediaCrypto.class.equals(exoMediaDrm.getExoMediaCryptoType()) && FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) || Util.linearSearch(this.useDrmSessionsForClearContentTrackTypes, i) == -1 || exoMediaDrm.getExoMediaCryptoType() == null) {
            return null;
        }
        maybeCreateMediaDrmHandler(looper);
        if (this.placeholderDrmSession == null) {
            DefaultDrmSession<T> defaultDrmSessionCreateNewDefaultSession = createNewDefaultSession(Collections.emptyList(), true);
            this.sessions.add(defaultDrmSessionCreateNewDefaultSession);
            this.placeholderDrmSession = defaultDrmSessionCreateNewDefaultSession;
        }
        this.placeholderDrmSession.acquire();
        return this.placeholderDrmSession;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.android.exoplayer2t.drm.DefaultDrmSession, com.google.android.exoplayer2t.drm.DrmSession<T extends com.google.android.exoplayer2t.drm.ExoMediaCrypto>] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.google.android.exoplayer2t.drm.DefaultDrmSession<T extends com.google.android.exoplayer2t.drm.ExoMediaCrypto>] */
    @Override // com.google.android.exoplayer2t.drm.DrmSessionManager
    public DrmSession<T> acquireSession(Looper looper, DrmInitData drmInitData) {
        List<DrmInitData.SchemeData> schemeDatas;
        assertExpectedPlaybackLooper(looper);
        maybeCreateMediaDrmHandler(looper);
        DefaultDrmSession<T> defaultDrmSessionCreateNewDefaultSession = (DefaultDrmSession<T>) null;
        if (this.offlineLicenseKeySetId == null) {
            schemeDatas = getSchemeDatas(drmInitData, this.uuid, false);
            if (schemeDatas.isEmpty()) {
                final MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.uuid);
                this.eventDispatcher.dispatch(new EventDispatcher.Event() { // from class: com.google.android.exoplayer2t.drm.DefaultDrmSessionManager$$ExternalSyntheticLambda1
                    @Override // com.google.android.exoplayer2t.util.EventDispatcher.Event
                    public final void sendTo(Object obj) {
                        ((DefaultDrmSessionEventListener) obj).onDrmSessionManagerError(missingSchemeDataException);
                    }
                });
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException));
            }
        } else {
            schemeDatas = null;
        }
        if (!this.multiSession) {
            defaultDrmSessionCreateNewDefaultSession = this.noMultiSessionDrmSession;
        } else {
            Iterator<DefaultDrmSession<T>> it = this.sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession<T> next = it.next();
                if (Util.areEqual(next.schemeDatas, schemeDatas)) {
                    defaultDrmSessionCreateNewDefaultSession = next;
                    break;
                }
            }
        }
        if (defaultDrmSessionCreateNewDefaultSession == 0) {
            defaultDrmSessionCreateNewDefaultSession = createNewDefaultSession(schemeDatas, false);
            if (!this.multiSession) {
                this.noMultiSessionDrmSession = defaultDrmSessionCreateNewDefaultSession;
            }
            this.sessions.add(defaultDrmSessionCreateNewDefaultSession);
        }
        ((DefaultDrmSession) defaultDrmSessionCreateNewDefaultSession).acquire();
        return (DrmSession<T>) defaultDrmSessionCreateNewDefaultSession;
    }

    @Override // com.google.android.exoplayer2t.drm.DrmSessionManager
    public Class<T> getExoMediaCryptoType(DrmInitData drmInitData) {
        if (canAcquireSession(drmInitData)) {
            return ((ExoMediaDrm) Assertions.checkNotNull(this.exoMediaDrm)).getExoMediaCryptoType();
        }
        return null;
    }

    private void assertExpectedPlaybackLooper(Looper looper) {
        Looper looper2 = this.playbackLooper;
        Assertions.checkState(looper2 == null || looper2 == looper);
        this.playbackLooper = looper;
    }

    private void maybeCreateMediaDrmHandler(Looper looper) {
        if (this.mediaDrmHandler == null) {
            this.mediaDrmHandler = new MediaDrmHandler(looper);
        }
    }

    private DefaultDrmSession<T> createNewDefaultSession(List<DrmInitData.SchemeData> list, boolean z) {
        Assertions.checkNotNull(this.exoMediaDrm);
        return new DefaultDrmSession<>(this.uuid, this.exoMediaDrm, this.provisioningManagerImpl, new DefaultDrmSession.ReleaseCallback() { // from class: com.google.android.exoplayer2t.drm.DefaultDrmSessionManager$$ExternalSyntheticLambda0
            @Override // com.google.android.exoplayer2t.drm.DefaultDrmSession.ReleaseCallback
            public final void onSessionReleased(DefaultDrmSession defaultDrmSession) {
                this.f$0.onSessionReleased(defaultDrmSession);
            }
        }, list, this.mode, this.playClearSamplesWithoutKeys | z, z, this.offlineLicenseKeySetId, this.keyRequestParameters, this.callback, (Looper) Assertions.checkNotNull(this.playbackLooper), this.eventDispatcher, this.loadErrorHandlingPolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSessionReleased(DefaultDrmSession<T> defaultDrmSession) {
        this.sessions.remove(defaultDrmSession);
        if (this.placeholderDrmSession == defaultDrmSession) {
            this.placeholderDrmSession = null;
        }
        if (this.noMultiSessionDrmSession == defaultDrmSession) {
            this.noMultiSessionDrmSession = null;
        }
        if (this.provisioningSessions.size() > 1 && this.provisioningSessions.get(0) == defaultDrmSession) {
            this.provisioningSessions.get(1).provision();
        }
        this.provisioningSessions.remove(defaultDrmSession);
    }

    private static List<DrmInitData.SchemeData> getSchemeDatas(DrmInitData drmInitData, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i);
            if ((schemeData.matches(uuid) || (C.CLEARKEY_UUID.equals(uuid) && schemeData.matches(C.COMMON_PSSH_UUID))) && (schemeData.data != null || z)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    private class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.sessions) {
                if (defaultDrmSession.hasSessionId(bArr)) {
                    defaultDrmSession.onMediaDrmEvent(message.what);
                    return;
                }
            }
        }
    }

    private class MediaDrmEventListener implements ExoMediaDrm.OnEventListener<T> {
        private MediaDrmEventListener(DefaultDrmSessionManager defaultDrmSessionManager) {
        }
    }
}
