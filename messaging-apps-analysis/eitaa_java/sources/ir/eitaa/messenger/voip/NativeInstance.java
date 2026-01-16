package ir.eitaa.messenger.voip;

import android.graphics.Point;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.voip.Instance;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import org.webrtc.ContextUtils;
import org.webrtc.VideoSink;

/* loaded from: classes.dex */
public class NativeInstance {
    private AudioLevelsCallback audioLevelsCallback;
    private RequestBroadcastPartCallback cancelRequestBroadcastPartCallback;
    private Instance.FinalState finalState;
    private boolean isGroup;
    private long nativePtr;
    private Instance.OnRemoteMediaStateUpdatedListener onRemoteMediaStateUpdatedListener;
    private Instance.OnSignalBarsUpdatedListener onSignalBarsUpdatedListener;
    private Instance.OnSignalingDataListener onSignalDataListener;
    private Instance.OnStateUpdatedListener onStateUpdatedListener;
    private PayloadCallback payloadCallback;
    private String persistentStateFilePath;
    private RequestBroadcastPartCallback requestBroadcastPartCallback;
    private CountDownLatch stopBarrier;
    private float[] temp = new float[1];
    private VideoSourcesCallback unknownParticipantsCallback;

    public interface AudioLevelsCallback {
        void run(int[] uids, float[] levels, boolean[] voice);
    }

    public interface PayloadCallback {
        void run(int ssrc, String value);
    }

    public interface RequestBroadcastPartCallback {
        void run(long timestamp, long duration, int videoChannel, int quality);
    }

    public static class SsrcGroup {
        public String semantics;
        public int[] ssrcs;
    }

    public interface VideoSourcesCallback {
        void run(long taskPtr, int[] ssrcs);
    }

    public static native long createVideoCapturer(VideoSink localSink, int type);

    public static native void destroyVideoCapturer(long videoCapturer);

    private static native long makeGroupNativeInstance(NativeInstance instance, String persistentStateFilePath, boolean highQuality, long videoCapturer, boolean screencast, boolean noiseSupression);

    private static native long makeNativeInstance(String version, NativeInstance instance, Instance.Config config, String persistentStateFilePath, Instance.Endpoint[] endpoints, Instance.Proxy proxy, int networkType, Instance.EncryptionKey encryptionKey, VideoSink remoteSink, long videoCapturer, float aspectRatio);

    public static native void setVideoStateCapturer(long videoCapturer, int videoState);

    private native void stopGroupNative();

    private native void stopNative();

    public static native void switchCameraCapturer(long videoCapturer, boolean front);

    public native void activateVideoCapturer(long videoCapturer);

    public native long addIncomingVideoOutput(int quality, String endpointId, SsrcGroup[] ssrcGroups, VideoSink remoteSink);

    public native void clearVideoCapturer();

    public native String getDebugInfo();

    public native String getLastError();

    public int getPeerCapabilities() {
        return 0;
    }

    public native byte[] getPersistentState();

    public native long getPreferredRelayId();

    public native Instance.TrafficStats getTrafficStats();

    public native String getVersion();

    public native boolean hasVideoCapturer();

    public native void onMediaDescriptionAvailable(long taskPtr, int[] ssrcs);

    public native void onSignalingDataReceive(byte[] data);

    public native void onStreamPartAvailable(long ts, ByteBuffer buffer, int size, long timestamp, int videoChannel, int quality);

    public native void prepareForStream();

    public native void removeIncomingVideoOutput(long nativeRemoteSink);

    public native void resetGroupInstance(boolean set, boolean disconnect);

    public native void sendBitrateUpdated(boolean enableHighBitrate);

    public native void setAudioOutputGainControlEnabled(boolean enabled);

    public native void setBufferSize(int size);

    public native void setEchoCancellationStrength(int strength);

    public native void setGlobalServerConfig(String serverConfigJson);

    public native void setJoinResponsePayload(String payload);

    public native void setMuteMicrophone(boolean muteMicrophone);

    public native void setNetworkType(int networkType);

    public native void setNoiseSuppressionEnabled(boolean value);

    public native void setVideoEndpointQuality(String endpointId, int quality);

    public native void setVideoState(int videoState);

    public native void setVolume(int ssrc, double volume);

    public native void setupOutgoingVideo(VideoSink localSink, int type);

    public native void setupOutgoingVideoCreated(long videoCapturer);

    public native void switchCamera(boolean front);

    public static NativeInstance make(String version, Instance.Config config, String path, Instance.Endpoint[] endpoints, Instance.Proxy proxy, int networkType, Instance.EncryptionKey encryptionKey, VideoSink remoteSink, long videoCapturer, AudioLevelsCallback audioLevelsCallback) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("create new tgvoip instance, version " + version);
        }
        NativeInstance nativeInstance = new NativeInstance();
        nativeInstance.persistentStateFilePath = path;
        nativeInstance.audioLevelsCallback = audioLevelsCallback;
        Point point = AndroidUtilities.displaySize;
        float fMin = Math.min(point.x, point.y);
        Point point2 = AndroidUtilities.displaySize;
        nativeInstance.nativePtr = makeNativeInstance(version, nativeInstance, config, path, endpoints, proxy, networkType, encryptionKey, remoteSink, videoCapturer, fMin / Math.max(point2.x, point2.y));
        return nativeInstance;
    }

    public static NativeInstance makeGroup(String logPath, long videoCapturer, boolean screencast, boolean noiseSupression, PayloadCallback payloadCallback, AudioLevelsCallback audioLevelsCallback, VideoSourcesCallback unknownParticipantsCallback, RequestBroadcastPartCallback requestBroadcastPartCallback, RequestBroadcastPartCallback cancelRequestBroadcastPartCallback) {
        ContextUtils.initialize(ApplicationLoader.applicationContext);
        NativeInstance nativeInstance = new NativeInstance();
        nativeInstance.payloadCallback = payloadCallback;
        nativeInstance.audioLevelsCallback = audioLevelsCallback;
        nativeInstance.unknownParticipantsCallback = unknownParticipantsCallback;
        nativeInstance.requestBroadcastPartCallback = requestBroadcastPartCallback;
        nativeInstance.cancelRequestBroadcastPartCallback = cancelRequestBroadcastPartCallback;
        nativeInstance.isGroup = true;
        nativeInstance.nativePtr = makeGroupNativeInstance(nativeInstance, logPath, SharedConfig.disableVoiceAudioEffects, videoCapturer, screencast, noiseSupression);
        return nativeInstance;
    }

    public boolean isGroup() {
        return this.isGroup;
    }

    public void setOnStateUpdatedListener(Instance.OnStateUpdatedListener listener) {
        this.onStateUpdatedListener = listener;
    }

    public void setOnSignalBarsUpdatedListener(Instance.OnSignalBarsUpdatedListener listener) {
        this.onSignalBarsUpdatedListener = listener;
    }

    public void setOnSignalDataListener(Instance.OnSignalingDataListener listener) {
        this.onSignalDataListener = listener;
    }

    public void setOnRemoteMediaStateUpdatedListener(Instance.OnRemoteMediaStateUpdatedListener listener) {
        this.onRemoteMediaStateUpdatedListener = listener;
    }

    private void onStateUpdated(int state) {
        Instance.OnStateUpdatedListener onStateUpdatedListener = this.onStateUpdatedListener;
        if (onStateUpdatedListener != null) {
            onStateUpdatedListener.onStateUpdated(state, false);
        }
    }

    private void onSignalBarsUpdated(int signalBars) {
        Instance.OnSignalBarsUpdatedListener onSignalBarsUpdatedListener = this.onSignalBarsUpdatedListener;
        if (onSignalBarsUpdatedListener != null) {
            onSignalBarsUpdatedListener.onSignalBarsUpdated(signalBars);
        }
    }

    private void onSignalingData(byte[] data) {
        Instance.OnSignalingDataListener onSignalingDataListener = this.onSignalDataListener;
        if (onSignalingDataListener != null) {
            onSignalingDataListener.onSignalingData(data);
        }
    }

    private void onRemoteMediaStateUpdated(int audioState, int videoState) {
        Instance.OnRemoteMediaStateUpdatedListener onRemoteMediaStateUpdatedListener = this.onRemoteMediaStateUpdatedListener;
        if (onRemoteMediaStateUpdatedListener != null) {
            onRemoteMediaStateUpdatedListener.onMediaStateUpdated(audioState, videoState);
        }
    }

    private void onNetworkStateUpdated(final boolean connected, final boolean inTransition) {
        if (this.onStateUpdatedListener != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$NativeInstance$a5Cz4yLL8OrbRueW_3sy-i0-vXQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNetworkStateUpdated$0$NativeInstance(connected, inTransition);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onNetworkStateUpdated$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onNetworkStateUpdated$0$NativeInstance(boolean z, boolean z2) {
        this.onStateUpdatedListener.onStateUpdated(z ? 1 : 0, z2);
    }

    private void onAudioLevelsUpdated(final int[] uids, final float[] levels, final boolean[] voice) {
        if (this.isGroup && uids != null && uids.length == 0) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$NativeInstance$QodPwiWYNESWGdIOEMa9kzBDsBg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAudioLevelsUpdated$1$NativeInstance(uids, levels, voice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onAudioLevelsUpdated$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onAudioLevelsUpdated$1$NativeInstance(int[] iArr, float[] fArr, boolean[] zArr) {
        this.audioLevelsCallback.run(iArr, fArr, zArr);
    }

    private void onParticipantDescriptionsRequired(final long taskPtr, final int[] ssrcs) {
        if (this.unknownParticipantsCallback == null) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$NativeInstance$ovleGbB3RSIDaFdAWYvVFa245aI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onParticipantDescriptionsRequired$2$NativeInstance(taskPtr, ssrcs);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onParticipantDescriptionsRequired$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onParticipantDescriptionsRequired$2$NativeInstance(long j, int[] iArr) {
        this.unknownParticipantsCallback.run(j, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onEmitJoinPayload$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onEmitJoinPayload$3$NativeInstance(int i, String str) {
        this.payloadCallback.run(i, str);
    }

    private void onEmitJoinPayload(final String json, final int ssrc) {
        try {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$NativeInstance$OzzfEgpumBqcW9p9J3x2F284dpI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onEmitJoinPayload$3$NativeInstance(ssrc, json);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void onRequestBroadcastPart(long timestamp, long duration, int videoChannel, int quality) {
        this.requestBroadcastPartCallback.run(timestamp, duration, videoChannel, quality);
    }

    private void onCancelRequestBroadcastPart(long timestamp, int videoChannel, int quality) {
        this.cancelRequestBroadcastPartCallback.run(timestamp, 0L, 0, 0);
    }

    private void onStop(Instance.FinalState state) {
        this.finalState = state;
        CountDownLatch countDownLatch = this.stopBarrier;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public Instance.FinalState stop() throws InterruptedException {
        this.stopBarrier = new CountDownLatch(1);
        stopNative();
        try {
            this.stopBarrier.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        return this.finalState;
    }

    public void stopGroup() {
        stopGroupNative();
    }
}
