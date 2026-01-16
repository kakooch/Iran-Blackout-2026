package com.pedro.rtplibrary.view;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* loaded from: classes3.dex */
public interface GlInterface {
    void addMediaCodecSurface(Surface surface);

    SurfaceTexture getSurfaceTexture();

    void init();

    void removeMediaCodecSurface();

    void setEncoderSize(int i, int i2);

    void setFps(int i);

    void setRotation(int i);

    void start();

    void stop();
}
