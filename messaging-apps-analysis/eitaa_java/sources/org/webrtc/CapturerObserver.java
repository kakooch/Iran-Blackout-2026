package org.webrtc;

/* loaded from: classes3.dex */
public interface CapturerObserver {
    void onCapturerStarted(boolean success);

    void onCapturerStopped();

    void onFrameCaptured(VideoFrame frame);
}
