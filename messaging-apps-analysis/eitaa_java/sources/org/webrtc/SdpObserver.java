package org.webrtc;

/* loaded from: classes3.dex */
public interface SdpObserver {
    @CalledByNative
    void onCreateFailure(String error);

    @CalledByNative
    void onCreateSuccess(SessionDescription sdp);

    @CalledByNative
    void onSetFailure(String error);

    @CalledByNative
    void onSetSuccess();
}
