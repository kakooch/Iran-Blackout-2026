package com.pedro.encoder.input.gl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import com.pedro.encoder.utils.gl.GlUtil;
import org.webrtc.EglBase;

/* loaded from: classes3.dex */
public class SurfaceManager {
    private EGLContext eglContext = null;
    private EGLSurface eglSurface = null;
    private EGLDisplay eglDisplay = null;

    public SurfaceManager(Surface surface, SurfaceManager surfaceManager) {
        eglSetup(surface, surfaceManager.eglContext);
    }

    public SurfaceManager() {
        eglSetup(null, null);
    }

    public void makeCurrent() {
        EGLDisplay eGLDisplay = this.eglDisplay;
        EGLSurface eGLSurface = this.eglSurface;
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
            return;
        }
        Log.e("Error", "eglMakeCurrent failed");
    }

    public void swapBuffer() {
        EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
    }

    private void eglSetup(Surface surface, EGLContext eGLContext) {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.eglDisplay = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            throw new RuntimeException("unable to initialize EGL14");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        EGL14.eglChooseConfig(this.eglDisplay, eGLContext == null ? new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344} : new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
        GlUtil.checkEglError("eglCreateContext RGB888+recordable ES2");
        int[] iArr2 = {12440, 2, 12344};
        EGLDisplay eGLDisplay = this.eglDisplay;
        EGLConfig eGLConfig = eGLConfigArr[0];
        if (eGLContext == null) {
            eGLContext = EGL14.EGL_NO_CONTEXT;
        }
        this.eglContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr2, 0);
        GlUtil.checkEglError("eglCreateContext");
        if (surface == null) {
            this.eglSurface = EGL14.eglCreatePbufferSurface(this.eglDisplay, eGLConfigArr[0], new int[]{12375, 1, 12374, 1, 12344}, 0);
        } else {
            this.eglSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, eGLConfigArr[0], surface, new int[]{12344}, 0);
        }
        GlUtil.checkEglError("eglCreateWindowSurface");
    }

    public void release() {
        EGLDisplay eGLDisplay = this.eglDisplay;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.eglDisplay, this.eglSurface);
            EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.eglDisplay);
        }
        this.eglDisplay = EGL14.EGL_NO_DISPLAY;
        this.eglContext = EGL14.EGL_NO_CONTEXT;
        this.eglSurface = EGL14.EGL_NO_SURFACE;
    }
}
