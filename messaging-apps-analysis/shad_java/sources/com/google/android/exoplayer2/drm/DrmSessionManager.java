package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;

/* loaded from: classes.dex */
public interface DrmSessionManager {
    public static final DrmSessionManager DUMMY = new DrmSessionManager() { // from class: com.google.android.exoplayer2.drm.DrmSessionManager.1
        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        public /* synthetic */ void prepare() {
            CC.$default$prepare(this);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        public /* synthetic */ void release() {
            CC.$default$release(this);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        public DrmSession acquireSession(Looper looper, DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
            if (format.drmInitData == null) {
                return null;
            }
            return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1)));
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        public Class<UnsupportedMediaCrypto> getExoMediaCryptoType(Format format) {
            if (format.drmInitData != null) {
                return UnsupportedMediaCrypto.class;
            }
            return null;
        }
    };

    DrmSession acquireSession(Looper looper, DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    Class<? extends ExoMediaCrypto> getExoMediaCryptoType(Format format);

    void prepare();

    void release();

    /* renamed from: com.google.android.exoplayer2.drm.DrmSessionManager$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$prepare(DrmSessionManager drmSessionManager) {
        }

        public static void $default$release(DrmSessionManager drmSessionManager) {
        }

        static {
            DrmSessionManager drmSessionManager = DrmSessionManager.DUMMY;
        }

        public static DrmSessionManager getDummyDrmSessionManager() {
            return DrmSessionManager.DUMMY;
        }
    }
}
