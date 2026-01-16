package io.antmedia.android.broadcaster.encoder.gles;

import android.view.Surface;

/* loaded from: classes.dex */
public class WindowSurface extends EglSurfaceBase {
    private boolean mReleaseSurface;
    private Surface mSurface;

    public WindowSurface(EglCore eglCore, Surface surface, boolean releaseSurface) {
        super(eglCore);
        createWindowSurface(surface);
        this.mSurface = surface;
        this.mReleaseSurface = releaseSurface;
    }

    public void release() {
        releaseEglSurface();
        Surface surface = this.mSurface;
        if (surface != null) {
            if (this.mReleaseSurface) {
                surface.release();
            }
            this.mSurface = null;
        }
    }

    public void recreate(EglCore newEglCore) {
        Surface surface = this.mSurface;
        if (surface == null) {
            throw new RuntimeException("not yet implemented for SurfaceTexture");
        }
        this.mEglCore = newEglCore;
        createWindowSurface(surface);
    }
}
