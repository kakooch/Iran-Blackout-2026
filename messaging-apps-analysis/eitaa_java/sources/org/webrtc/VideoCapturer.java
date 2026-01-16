package org.webrtc;

import android.content.Context;

/* loaded from: classes3.dex */
public interface VideoCapturer {
    void changeCaptureFormat(int width, int height, int framerate);

    void dispose();

    void initialize(SurfaceTextureHelper surfaceTextureHelper, Context applicationContext, CapturerObserver capturerObserver);

    boolean isScreencast();

    void startCapture(int width, int height, int framerate);

    void stopCapture() throws InterruptedException;
}
