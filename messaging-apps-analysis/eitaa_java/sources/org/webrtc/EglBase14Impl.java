package org.webrtc;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build;
import android.view.Surface;
import org.webrtc.EglBase;
import org.webrtc.EglBase14;

@TargetApi(18)
/* loaded from: classes3.dex */
class EglBase14Impl implements EglBase14 {
    private static final int CURRENT_SDK_VERSION = Build.VERSION.SDK_INT;
    private static final int EGLExt_SDK_VERSION = 18;
    private static final String TAG = "EglBase14Impl";
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private EGLSurface eglSurfaceBackground;

    public static boolean isEGL14Supported() {
        StringBuilder sb = new StringBuilder();
        sb.append("SDK version: ");
        int i = CURRENT_SDK_VERSION;
        sb.append(i);
        sb.append(". isEGL14Supported: ");
        sb.append(i >= 18);
        Logging.d(TAG, sb.toString());
        return i >= 18;
    }

    public static class Context implements EglBase14.Context {
        private final EGLContext egl14Context;

        @Override // org.webrtc.EglBase14.Context
        public EGLContext getRawContext() {
            return this.egl14Context;
        }

        @Override // org.webrtc.EglBase.Context
        @TargetApi(21)
        public long getNativeEglContext() {
            return EglBase14Impl.CURRENT_SDK_VERSION >= 21 ? this.egl14Context.getNativeHandle() : this.egl14Context.getHandle();
        }

        public Context(EGLContext eglContext) {
            this.egl14Context = eglContext;
        }
    }

    public EglBase14Impl(EGLContext sharedContext, int[] configAttributes) {
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        this.eglSurface = eGLSurface;
        this.eglSurfaceBackground = eGLSurface;
        EGLDisplay eglDisplay = getEglDisplay();
        this.eglDisplay = eglDisplay;
        this.eglConfig = getEglConfig(eglDisplay, configAttributes);
        int openGlesVersionFromConfig = EglBase.CC.getOpenGlesVersionFromConfig(configAttributes);
        Logging.d(TAG, "Using OpenGL ES version " + openGlesVersionFromConfig);
        this.eglContext = createEglContext(sharedContext, this.eglDisplay, this.eglConfig, openGlesVersionFromConfig);
    }

    @Override // org.webrtc.EglBase
    public void createSurface(Surface surface) {
        createSurfaceInternal(surface, false);
    }

    @Override // org.webrtc.EglBase
    public void createBackgroundSurface(SurfaceTexture surface) {
        createSurfaceInternal(surface, true);
    }

    @Override // org.webrtc.EglBase
    public void createSurface(SurfaceTexture surfaceTexture) {
        createSurfaceInternal(surfaceTexture, false);
    }

    private void createSurfaceInternal(Object surface, boolean background) {
        if (!(surface instanceof Surface) && !(surface instanceof SurfaceTexture)) {
            throw new IllegalStateException("Input must be either a Surface or SurfaceTexture");
        }
        checkIsNotReleased();
        if (background) {
            if (this.eglSurfaceBackground != EGL14.EGL_NO_SURFACE) {
                throw new RuntimeException("Already has an EGLSurface");
            }
            EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, surface, new int[]{12344}, 0);
            this.eglSurfaceBackground = eGLSurfaceEglCreateWindowSurface;
            if (eGLSurfaceEglCreateWindowSurface != EGL14.EGL_NO_SURFACE) {
                return;
            }
            throw new RuntimeException("Failed to create window surface: 0x" + Integer.toHexString(EGL14.eglGetError()));
        }
        if (this.eglSurface != EGL14.EGL_NO_SURFACE) {
            throw new RuntimeException("Already has an EGLSurface");
        }
        EGLSurface eGLSurfaceEglCreateWindowSurface2 = EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, surface, new int[]{12344}, 0);
        this.eglSurface = eGLSurfaceEglCreateWindowSurface2;
        if (eGLSurfaceEglCreateWindowSurface2 != EGL14.EGL_NO_SURFACE) {
            return;
        }
        throw new RuntimeException("Failed to create window surface: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    @Override // org.webrtc.EglBase
    public void createDummyPbufferSurface() {
        createPbufferSurface(1, 1);
    }

    @Override // org.webrtc.EglBase
    public void createPbufferSurface(int width, int height) {
        checkIsNotReleased();
        if (this.eglSurface != EGL14.EGL_NO_SURFACE) {
            throw new RuntimeException("Already has an EGLSurface");
        }
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{12375, width, 12374, height, 12344}, 0);
        this.eglSurface = eGLSurfaceEglCreatePbufferSurface;
        if (eGLSurfaceEglCreatePbufferSurface != EGL14.EGL_NO_SURFACE) {
            return;
        }
        throw new RuntimeException("Failed to create pixel buffer surface with size " + width + "x" + height + ": 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    @Override // org.webrtc.EglBase
    public Context getEglBaseContext() {
        return new Context(this.eglContext);
    }

    @Override // org.webrtc.EglBase
    public boolean hasSurface() {
        return this.eglSurface != EGL14.EGL_NO_SURFACE;
    }

    @Override // org.webrtc.EglBase
    public int surfaceWidth() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, iArr, 0);
        return iArr[0];
    }

    @Override // org.webrtc.EglBase
    public int surfaceHeight() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, iArr, 0);
        return iArr[0];
    }

    @Override // org.webrtc.EglBase
    public void releaseSurface(boolean background) {
        if (background) {
            EGLSurface eGLSurface = this.eglSurfaceBackground;
            if (eGLSurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.eglDisplay, eGLSurface);
                this.eglSurfaceBackground = EGL14.EGL_NO_SURFACE;
                return;
            }
            return;
        }
        EGLSurface eGLSurface2 = this.eglSurface;
        if (eGLSurface2 != EGL14.EGL_NO_SURFACE) {
            EGL14.eglDestroySurface(this.eglDisplay, eGLSurface2);
            this.eglSurface = EGL14.EGL_NO_SURFACE;
        }
    }

    private void checkIsNotReleased() {
        if (this.eglDisplay == EGL14.EGL_NO_DISPLAY || this.eglContext == EGL14.EGL_NO_CONTEXT || this.eglConfig == null) {
            throw new RuntimeException("This object has been released");
        }
    }

    @Override // org.webrtc.EglBase
    public void release() {
        checkIsNotReleased();
        releaseSurface(false);
        releaseSurface(true);
        detachCurrent();
        synchronized (EglBase.lock) {
            EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
        }
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.eglDisplay);
        this.eglContext = EGL14.EGL_NO_CONTEXT;
        this.eglDisplay = EGL14.EGL_NO_DISPLAY;
        this.eglConfig = null;
    }

    @Override // org.webrtc.EglBase
    public void makeCurrent() {
        checkIsNotReleased();
        if (this.eglSurface == EGL14.EGL_NO_SURFACE) {
            throw new RuntimeException("No EGLSurface - can't make current");
        }
        synchronized (EglBase.lock) {
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface = this.eglSurface;
            if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                throw new RuntimeException("eglMakeCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
            }
        }
    }

    @Override // org.webrtc.EglBase
    public void makeBackgroundCurrent() {
        checkIsNotReleased();
        if (this.eglSurfaceBackground == EGL14.EGL_NO_SURFACE) {
            throw new RuntimeException("No EGLSurface - can't make current");
        }
        synchronized (EglBase.lock) {
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface = this.eglSurfaceBackground;
            if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                throw new RuntimeException("eglMakeCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
            }
        }
    }

    @Override // org.webrtc.EglBase
    public boolean hasBackgroundSurface() {
        return this.eglSurfaceBackground != EGL14.EGL_NO_SURFACE;
    }

    @Override // org.webrtc.EglBase
    public void detachCurrent() {
        synchronized (EglBase.lock) {
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
                throw new RuntimeException("eglDetachCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
            }
        }
    }

    @Override // org.webrtc.EglBase
    public void swapBuffers(boolean background) {
        checkIsNotReleased();
        EGLSurface eGLSurface = background ? this.eglSurfaceBackground : this.eglSurface;
        if (eGLSurface == EGL14.EGL_NO_SURFACE) {
            throw new RuntimeException("No EGLSurface - can't swap buffers");
        }
        synchronized (EglBase.lock) {
            EGL14.eglSwapBuffers(this.eglDisplay, eGLSurface);
        }
    }

    @Override // org.webrtc.EglBase
    public void swapBuffers(long timeStampNs, boolean background) {
        checkIsNotReleased();
        EGLSurface eGLSurface = background ? this.eglSurfaceBackground : this.eglSurface;
        if (eGLSurface == EGL14.EGL_NO_SURFACE) {
            throw new RuntimeException("No EGLSurface - can't swap buffers");
        }
        synchronized (EglBase.lock) {
            EGLExt.eglPresentationTimeANDROID(this.eglDisplay, eGLSurface, timeStampNs);
            EGL14.eglSwapBuffers(this.eglDisplay, eGLSurface);
        }
    }

    private static EGLDisplay getEglDisplay() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("Unable to get EGL14 display: 0x" + Integer.toHexString(EGL14.eglGetError()));
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            return eGLDisplayEglGetDisplay;
        }
        throw new RuntimeException("Unable to initialize EGL14: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    private static EGLConfig getEglConfig(EGLDisplay eglDisplay, int[] configAttributes) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        if (!EGL14.eglChooseConfig(eglDisplay, configAttributes, 0, eGLConfigArr, 0, 1, iArr, 0)) {
            throw new RuntimeException("eglChooseConfig failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
        }
        if (iArr[0] <= 0) {
            throw new RuntimeException("Unable to find any matching EGL config");
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        if (eGLConfig != null) {
            return eGLConfig;
        }
        throw new RuntimeException("eglChooseConfig returned null");
    }

    private static EGLContext createEglContext(EGLContext sharedContext, EGLDisplay eglDisplay, EGLConfig eglConfig, int openGlesVersion) {
        EGLContext eGLContextEglCreateContext;
        if (sharedContext != null && sharedContext == EGL14.EGL_NO_CONTEXT) {
            throw new RuntimeException("Invalid sharedContext");
        }
        int[] iArr = {12440, openGlesVersion, 12344};
        if (sharedContext == null) {
            sharedContext = EGL14.EGL_NO_CONTEXT;
        }
        synchronized (EglBase.lock) {
            eGLContextEglCreateContext = EGL14.eglCreateContext(eglDisplay, eglConfig, sharedContext, iArr, 0);
        }
        if (eGLContextEglCreateContext != EGL14.EGL_NO_CONTEXT) {
            return eGLContextEglCreateContext;
        }
        throw new RuntimeException("Failed to create EGL context: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }
}
