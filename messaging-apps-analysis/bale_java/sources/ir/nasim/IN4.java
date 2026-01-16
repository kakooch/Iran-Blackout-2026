package ir.nasim;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.l;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: classes7.dex */
public class IN4 implements SurfaceTexture.OnFrameAvailableListener {
    private EGL10 a;
    private SurfaceTexture e;
    private Surface f;
    private boolean h;
    private C19712qo7 i;
    private EGLDisplay b = null;
    private EGLContext c = null;
    private EGLSurface d = null;
    private final Object g = new Object();

    public IN4(MediaController.n nVar, String str, String str2, ArrayList arrayList, MediaController.i iVar, int i, int i2, int i3, int i4, int i5, float f, boolean z, Integer num, Integer num2, l.b bVar, ArrayList arrayList2) {
        C19712qo7 c19712qo7 = new C19712qo7(nVar, str, str2, arrayList, iVar, i, i2, i3, i4, i5, f, z, num, num2, bVar, arrayList2);
        this.i = c19712qo7;
        c19712qo7.o();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.i.k());
        this.e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f = new Surface(this.e);
    }

    public void a() {
        synchronized (this.g) {
            while (!this.h) {
                try {
                    this.g.wait(2500L);
                    if (!this.h) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.h = false;
        }
        this.e.updateTexImage();
    }

    public void b(String str, String str2, boolean z) {
        this.i.d(str, str2, z);
    }

    public void c() {
        this.i.g(this.e);
    }

    public Surface d() {
        return this.f;
    }

    public void e() throws InterruptedException {
        EGL10 egl10 = this.a;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.c)) {
                EGL10 egl102 = this.a;
                EGLDisplay eGLDisplay = this.b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            }
            this.a.eglDestroySurface(this.b, this.d);
            this.a.eglDestroyContext(this.b, this.c);
        }
        C19712qo7 c19712qo7 = this.i;
        if (c19712qo7 != null) {
            c19712qo7.m();
        }
        this.f.release();
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = null;
        this.i = null;
        this.f = null;
        this.e = null;
    }

    public boolean f() {
        try {
            return GLES20.glGetString(7939).contains("GL_EXT_YUV_target");
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
            return false;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.g) {
            try {
                if (this.h) {
                    throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
                }
                this.h = true;
                this.g.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
