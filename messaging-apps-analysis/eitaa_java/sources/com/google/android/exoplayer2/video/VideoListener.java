package com.google.android.exoplayer2.video;

import android.graphics.SurfaceTexture;

/* loaded from: classes.dex */
public interface VideoListener {
    void onRenderedFirstFrame();

    boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture);

    void onSurfaceSizeChanged(int width, int height);

    void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture);

    void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio);
}
