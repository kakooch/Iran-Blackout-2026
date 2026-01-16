package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.EventDispatcher;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@TargetApi(18)
/* loaded from: classes.dex */
class DefaultDrmSession<T extends ExoMediaCrypto> implements DrmSession<T> {
    final MediaDrmCallback callback;
    private ExoMediaDrm.KeyRequest currentKeyRequest;
    private ExoMediaDrm.ProvisionRequest currentProvisionRequest;
    private final EventDispatcher<DefaultDrmSessionEventListener> eventDispatcher;
    private final boolean isPlaceholderSession;
    private final HashMap<String, String> keyRequestParameters;
    private DrmSession.DrmSessionException lastException;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private T mediaCrypto;
    private final ExoMediaDrm<T> mediaDrm;
    private final int mode;
    private byte[] offlineLicenseKeySetId;
    private final boolean playClearSamplesWithoutKeys;
    private final ProvisioningManager<T> provisioningManager;
    private int referenceCount;
    private final ReleaseCallback<T> releaseCallback;
    private DefaultDrmSession<T>.RequestHandler requestHandler;
    private HandlerThread requestHandlerThread;
    final DefaultDrmSession<T>.ResponseHandler responseHandler;
    public final List<DrmInitData.SchemeData> schemeDatas;
    private byte[] sessionId;
    private int state;
    final UUID uuid;

    public interface ProvisioningManager<T extends ExoMediaCrypto> {
        void onProvisionCompleted();

        void onProvisionError(Exception error);

        void provisionRequired(DefaultDrmSession<T> session);
    }

    public interface ReleaseCallback<T extends ExoMediaCrypto> {
        void onSessionReleased(DefaultDrmSession<T> session);
    }

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(Throwable cause) {
            super("Unexpected " + cause.getClass().getSimpleName() + ": " + cause.getMessage(), cause);
        }
    }

    public DefaultDrmSession(UUID uuid, ExoMediaDrm<T> mediaDrm, ProvisioningManager<T> provisioningManager, ReleaseCallback<T> releaseCallback, List<DrmInitData.SchemeData> schemeDatas, int mode, boolean playClearSamplesWithoutKeys, boolean isPlaceholderSession, byte[] offlineLicenseKeySetId, HashMap<String, String> keyRequestParameters, MediaDrmCallback callback, Looper playbackLooper, EventDispatcher<DefaultDrmSessionEventListener> eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        if (mode == 1 || mode == 3) {
            Assertions.checkNotNull(offlineLicenseKeySetId);
        }
        this.uuid = uuid;
        this.provisioningManager = provisioningManager;
        this.releaseCallback = releaseCallback;
        this.mediaDrm = mediaDrm;
        this.mode = mode;
        this.playClearSamplesWithoutKeys = playClearSamplesWithoutKeys;
        this.isPlaceholderSession = isPlaceholderSession;
        if (offlineLicenseKeySetId != null) {
            this.offlineLicenseKeySetId = offlineLicenseKeySetId;
            this.schemeDatas = null;
        } else {
            this.schemeDatas = Collections.unmodifiableList((List) Assertions.checkNotNull(schemeDatas));
        }
        this.keyRequestParameters = keyRequestParameters;
        this.callback = callback;
        this.eventDispatcher = eventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.state = 2;
        this.responseHandler = new ResponseHandler(playbackLooper);
    }

    public boolean hasSessionId(byte[] sessionId) {
        return Arrays.equals(this.sessionId, sessionId);
    }

    public void onMediaDrmEvent(int what) {
        if (what != 2) {
            return;
        }
        onKeysRequired();
    }

    public void provision() {
        this.currentProvisionRequest = this.mediaDrm.getProvisionRequest();
        ((RequestHandler) Util.castNonNull(this.requestHandler)).post(0, Assertions.checkNotNull(this.currentProvisionRequest), true);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return this.playClearSamplesWithoutKeys;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final DrmSession.DrmSessionException getError() {
        if (this.state == 1) {
            return this.lastException;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final T getMediaCrypto() {
        return this.mediaCrypto;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public Map<String, String> queryKeyStatus() {
        byte[] bArr = this.sessionId;
        if (bArr == null) {
            return null;
        }
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void acquire() {
        Assertions.checkState(this.referenceCount >= 0);
        int i = this.referenceCount + 1;
        this.referenceCount = i;
        if (i == 1) {
            Assertions.checkState(this.state == 2);
            HandlerThread handlerThread = new HandlerThread("DrmRequestHandler");
            this.requestHandlerThread = handlerThread;
            handlerThread.start();
            this.requestHandler = new RequestHandler(this.requestHandlerThread.getLooper());
            if (openInternal(true)) {
                doLicense(true);
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void release() {
        int i = this.referenceCount - 1;
        this.referenceCount = i;
        if (i == 0) {
            this.state = 0;
            ((ResponseHandler) Util.castNonNull(this.responseHandler)).removeCallbacksAndMessages(null);
            ((RequestHandler) Util.castNonNull(this.requestHandler)).removeCallbacksAndMessages(null);
            this.requestHandler = null;
            ((HandlerThread) Util.castNonNull(this.requestHandlerThread)).quit();
            this.requestHandlerThread = null;
            this.mediaCrypto = null;
            this.lastException = null;
            this.currentKeyRequest = null;
            this.currentProvisionRequest = null;
            byte[] bArr = this.sessionId;
            if (bArr != null) {
                this.mediaDrm.closeSession(bArr);
                this.sessionId = null;
                this.eventDispatcher.dispatch(new EventDispatcher.Event() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$9STE4WweA1ja3LYN4Cj-oh79EpI
                    @Override // com.google.android.exoplayer2.util.EventDispatcher.Event
                    public final void sendTo(Object obj) {
                        ((DefaultDrmSessionEventListener) obj).onDrmSessionReleased();
                    }
                });
            }
            this.releaseCallback.onSessionReleased(this);
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean openInternal(boolean z) {
        if (isOpen()) {
            return true;
        }
        try {
            byte[] bArrOpenSession = this.mediaDrm.openSession();
            this.sessionId = bArrOpenSession;
            this.mediaCrypto = (T) this.mediaDrm.createMediaCrypto(bArrOpenSession);
            this.eventDispatcher.dispatch(new EventDispatcher.Event() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$xnYHXT1EAxDtobyYzPwdBGy2FxI
                @Override // com.google.android.exoplayer2.util.EventDispatcher.Event
                public final void sendTo(Object obj) {
                    ((DefaultDrmSessionEventListener) obj).onDrmSessionAcquired();
                }
            });
            this.state = 3;
            Assertions.checkNotNull(this.sessionId);
            return true;
        } catch (NotProvisionedException e) {
            if (z) {
                this.provisioningManager.provisionRequired(this);
                return false;
            }
            onError(e);
            return false;
        } catch (Exception e2) {
            onError(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProvisionResponse(Object request, Object response) {
        if (request == this.currentProvisionRequest) {
            if (this.state == 2 || isOpen()) {
                this.currentProvisionRequest = null;
                if (response instanceof Exception) {
                    this.provisioningManager.onProvisionError((Exception) response);
                    return;
                }
                try {
                    this.mediaDrm.provideProvisionResponse((byte[]) response);
                    this.provisioningManager.onProvisionCompleted();
                } catch (Exception e) {
                    this.provisioningManager.onProvisionError(e);
                }
            }
        }
    }

    @RequiresNonNull({"sessionId"})
    private void doLicense(boolean allowRetry) {
        if (this.isPlaceholderSession) {
            return;
        }
        byte[] bArr = (byte[]) Util.castNonNull(this.sessionId);
        int i = this.mode;
        if (i != 0 && i != 1) {
            if (i == 2) {
                if (this.offlineLicenseKeySetId == null || restoreKeys()) {
                    postKeyRequest(bArr, 2, allowRetry);
                    return;
                }
                return;
            }
            if (i != 3) {
                return;
            }
            Assertions.checkNotNull(this.offlineLicenseKeySetId);
            Assertions.checkNotNull(this.sessionId);
            if (restoreKeys()) {
                postKeyRequest(this.offlineLicenseKeySetId, 3, allowRetry);
                return;
            }
            return;
        }
        if (this.offlineLicenseKeySetId == null) {
            postKeyRequest(bArr, 1, allowRetry);
            return;
        }
        if (this.state == 4 || restoreKeys()) {
            long licenseDurationRemainingSec = getLicenseDurationRemainingSec();
            if (this.mode != 0 || licenseDurationRemainingSec > 60) {
                if (licenseDurationRemainingSec <= 0) {
                    onError(new KeysExpiredException());
                    return;
                } else {
                    this.state = 4;
                    this.eventDispatcher.dispatch($$Lambda$b7p2kvKEv4ml6CtjEMLOAsjpwFs.INSTANCE);
                    return;
                }
            }
            Log.d("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + licenseDurationRemainingSec);
            postKeyRequest(bArr, 2, allowRetry);
        }
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    private boolean restoreKeys() {
        try {
            this.mediaDrm.restoreKeys(this.sessionId, this.offlineLicenseKeySetId);
            return true;
        } catch (Exception e) {
            Log.e("DefaultDrmSession", "Error trying to restore keys.", e);
            onError(e);
            return false;
        }
    }

    private long getLicenseDurationRemainingSec() {
        if (!C.WIDEVINE_UUID.equals(this.uuid)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) Assertions.checkNotNull(WidevineUtil.getLicenseDurationRemainingSec(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    private void postKeyRequest(byte[] scope, int type, boolean allowRetry) {
        try {
            this.currentKeyRequest = this.mediaDrm.getKeyRequest(scope, this.schemeDatas, type, this.keyRequestParameters);
            ((RequestHandler) Util.castNonNull(this.requestHandler)).post(1, Assertions.checkNotNull(this.currentKeyRequest), allowRetry);
        } catch (Exception e) {
            onKeysError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyResponse(Object request, Object response) {
        if (request == this.currentKeyRequest && isOpen()) {
            this.currentKeyRequest = null;
            if (response instanceof Exception) {
                onKeysError((Exception) response);
                return;
            }
            try {
                byte[] bArr = (byte[]) response;
                if (this.mode == 3) {
                    this.mediaDrm.provideKeyResponse((byte[]) Util.castNonNull(this.offlineLicenseKeySetId), bArr);
                    this.eventDispatcher.dispatch($$Lambda$b7p2kvKEv4ml6CtjEMLOAsjpwFs.INSTANCE);
                    return;
                }
                byte[] bArrProvideKeyResponse = this.mediaDrm.provideKeyResponse(this.sessionId, bArr);
                int i = this.mode;
                if ((i == 2 || (i == 0 && this.offlineLicenseKeySetId != null)) && bArrProvideKeyResponse != null && bArrProvideKeyResponse.length != 0) {
                    this.offlineLicenseKeySetId = bArrProvideKeyResponse;
                }
                this.state = 4;
                this.eventDispatcher.dispatch(new EventDispatcher.Event() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$gnKjgO1Jisd0Ubl3PC_N2NcI53k
                    @Override // com.google.android.exoplayer2.util.EventDispatcher.Event
                    public final void sendTo(Object obj) {
                        ((DefaultDrmSessionEventListener) obj).onDrmKeysLoaded();
                    }
                });
            } catch (Exception e) {
                onKeysError(e);
            }
        }
    }

    private void onKeysRequired() {
        if (this.mode == 0 && this.state == 4) {
            Util.castNonNull(this.sessionId);
            doLicense(false);
        }
    }

    private void onKeysError(Exception e) {
        if (e instanceof NotProvisionedException) {
            this.provisioningManager.provisionRequired(this);
        } else {
            onError(e);
        }
    }

    private void onError(final Exception e) {
        this.lastException = new DrmSession.DrmSessionException(e);
        this.eventDispatcher.dispatch(new EventDispatcher.Event() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$DefaultDrmSession$nx_CrL4sJ7SN7A4COE03qTCMO4o
            @Override // com.google.android.exoplayer2.util.EventDispatcher.Event
            public final void sendTo(Object obj) {
                ((DefaultDrmSessionEventListener) obj).onDrmSessionManagerError(e);
            }
        });
        if (this.state != 4) {
            this.state = 1;
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean isOpen() {
        int i = this.state;
        return i == 3 || i == 4;
    }

    @SuppressLint({"HandlerLeak"})
    private class ResponseHandler extends Handler {
        public ResponseHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Pair pair = (Pair) msg.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = msg.what;
            if (i == 0) {
                DefaultDrmSession.this.onProvisionResponse(obj, obj2);
            } else {
                if (i != 1) {
                    return;
                }
                DefaultDrmSession.this.onKeyResponse(obj, obj2);
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    private class RequestHandler extends Handler {
        public RequestHandler(Looper backgroundLooper) {
            super(backgroundLooper);
        }

        void post(int what, Object request, boolean allowRetry) {
            obtainMessage(what, new RequestTask(allowRetry, SystemClock.elapsedRealtime(), request)).sendToTarget();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Exception excExecuteProvisionRequest;
            RequestTask requestTask = (RequestTask) message.obj;
            try {
                int i = message.what;
                if (i == 0) {
                    DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                    excExecuteProvisionRequest = defaultDrmSession.callback.executeProvisionRequest(defaultDrmSession.uuid, (ExoMediaDrm.ProvisionRequest) requestTask.request);
                } else if (i == 1) {
                    DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                    excExecuteProvisionRequest = defaultDrmSession2.callback.executeKeyRequest(defaultDrmSession2.uuid, (ExoMediaDrm.KeyRequest) requestTask.request);
                } else {
                    throw new RuntimeException();
                }
            } catch (Exception e) {
                boolean zMaybeRetryRequest = maybeRetryRequest(message, e);
                excExecuteProvisionRequest = e;
                if (zMaybeRetryRequest) {
                    return;
                }
            }
            DefaultDrmSession.this.responseHandler.obtainMessage(message.what, Pair.create(requestTask.request, excExecuteProvisionRequest)).sendToTarget();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v3, types: [java.io.IOException] */
        private boolean maybeRetryRequest(Message originalMsg, Exception e) {
            RequestTask requestTask = (RequestTask) originalMsg.obj;
            if (!requestTask.allowRetry) {
                return false;
            }
            int i = requestTask.errorCount + 1;
            requestTask.errorCount = i;
            if (i > DefaultDrmSession.this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(3)) {
                return false;
            }
            long retryDelayMsFor = DefaultDrmSession.this.loadErrorHandlingPolicy.getRetryDelayMsFor(3, SystemClock.elapsedRealtime() - requestTask.startTimeMs, e instanceof IOException ? (IOException) e : new UnexpectedDrmSessionException(e), requestTask.errorCount);
            if (retryDelayMsFor == -9223372036854775807L) {
                return false;
            }
            sendMessageDelayed(Message.obtain(originalMsg), retryDelayMsFor);
            return true;
        }
    }

    private static final class RequestTask {
        public final boolean allowRetry;
        public int errorCount;
        public final Object request;
        public final long startTimeMs;

        public RequestTask(boolean allowRetry, long startTimeMs, Object request) {
            this.allowRetry = allowRetry;
            this.startTimeMs = startTimeMs;
            this.request = request;
        }
    }
}
