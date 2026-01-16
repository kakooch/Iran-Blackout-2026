package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import ir.nasim.AbstractC18832pK2;
import ir.nasim.AbstractC9579aC2;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import livekit.org.webrtc.EglBase;

/* renamed from: ir.nasim.aL4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C9662aL4 {
    protected Thread c;
    protected EGLConfig g;
    protected Surface i;
    protected final AtomicBoolean a = new AtomicBoolean(false);
    protected final Map b = new HashMap();
    protected EGLDisplay d = EGL14.EGL_NO_DISPLAY;
    protected EGLContext e = EGL14.EGL_NO_CONTEXT;
    protected int[] f = AbstractC9579aC2.a;
    protected EGLSurface h = EGL14.EGL_NO_SURFACE;
    protected Map j = Collections.emptyMap();
    protected AbstractC9579aC2.f k = null;
    protected AbstractC9579aC2.e l = AbstractC9579aC2.e.UNKNOWN;
    private int m = -1;

    private void a(int i) {
        GLES20.glActiveTexture(33984);
        AbstractC9579aC2.g("glActiveTexture");
        GLES20.glBindTexture(36197, i);
        AbstractC9579aC2.g("glBindTexture");
    }

    private void b(C15116j22 c15116j22, AbstractC18832pK2.a aVar) {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.d = eGLDisplayEglGetDisplay;
        if (Objects.equals(eGLDisplayEglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            throw new IllegalStateException("Unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.d, iArr, 0, iArr, 1)) {
            this.d = EGL14.EGL_NO_DISPLAY;
            throw new IllegalStateException("Unable to initialize EGL14");
        }
        if (aVar != null) {
            aVar.c(iArr[0] + Separators.DOT + iArr[1]);
        }
        int i = c15116j22.d() ? 10 : 8;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.d, new int[]{12324, i, 12323, i, 12322, i, 12321, c15116j22.d() ? 2 : 8, 12325, 0, 12326, 0, 12352, c15116j22.d() ? 64 : 4, EglBase.EGL_RECORDABLE_ANDROID, c15116j22.d() ? -1 : 1, 12339, 5, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new IllegalStateException("Unable to find a suitable EGLConfig");
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.d, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, c15116j22.d() ? 3 : 2, 12344}, 0);
        AbstractC9579aC2.f("eglCreateContext");
        this.g = eGLConfig;
        this.e = eGLContextEglCreateContext;
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.d, eGLContextEglCreateContext, 12440, iArr2, 0);
        Log.d("OpenGlRenderer", "EGLContext created, client version " + iArr2[0]);
    }

    private void d() {
        EGLDisplay eGLDisplay = this.d;
        EGLConfig eGLConfig = this.g;
        Objects.requireNonNull(eGLConfig);
        this.h = AbstractC9579aC2.n(eGLDisplay, eGLConfig, 1, 1);
    }

    private YV4 e(C15116j22 c15116j22) {
        AbstractC9579aC2.i(this.a, false);
        try {
            b(c15116j22, null);
            d();
            i(this.h);
            String strGlGetString = GLES20.glGetString(7939);
            String strEglQueryString = EGL14.eglQueryString(this.d, 12373);
            if (strGlGetString == null) {
                strGlGetString = "";
            }
            if (strEglQueryString == null) {
                strEglQueryString = "";
            }
            return new YV4(strGlGetString, strEglQueryString);
        } catch (IllegalStateException e) {
            PI3.m("OpenGlRenderer", "Failed to get GL or EGL extensions: " + e.getMessage(), e);
            return new YV4("", "");
        } finally {
            l();
        }
    }

    private void l() {
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            ((AbstractC9579aC2.f) it.next()).b();
        }
        this.j = Collections.emptyMap();
        this.k = null;
        if (!Objects.equals(this.d, EGL14.EGL_NO_DISPLAY)) {
            EGLDisplay eGLDisplay = this.d;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            for (HN4 hn4 : this.b.values()) {
                if (!Objects.equals(hn4.a(), EGL14.EGL_NO_SURFACE) && !EGL14.eglDestroySurface(this.d, hn4.a())) {
                    AbstractC9579aC2.e("eglDestroySurface");
                }
            }
            this.b.clear();
            if (!Objects.equals(this.h, EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.d, this.h);
                this.h = EGL14.EGL_NO_SURFACE;
            }
            if (!Objects.equals(this.e, EGL14.EGL_NO_CONTEXT)) {
                EGL14.eglDestroyContext(this.d, this.e);
                this.e = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.d);
            this.d = EGL14.EGL_NO_DISPLAY;
        }
        this.g = null;
        this.m = -1;
        this.l = AbstractC9579aC2.e.UNKNOWN;
        this.i = null;
        this.c = null;
    }

    private void q(ByteBuffer byteBuffer, Size size, float[] fArr) {
        AbstractC4980Hj5.b(byteBuffer.capacity() == (size.getWidth() * size.getHeight()) * 4, "ByteBuffer capacity is not equal to width * height * 4.");
        AbstractC4980Hj5.b(byteBuffer.isDirect(), "ByteBuffer is not direct.");
        int iU = AbstractC9579aC2.u();
        GLES20.glActiveTexture(33985);
        AbstractC9579aC2.g("glActiveTexture");
        GLES20.glBindTexture(3553, iU);
        AbstractC9579aC2.g("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6407, size.getWidth(), size.getHeight(), 0, 6407, 5121, null);
        AbstractC9579aC2.g("glTexImage2D");
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        int iT = AbstractC9579aC2.t();
        GLES20.glBindFramebuffer(36160, iT);
        AbstractC9579aC2.g("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iU, 0);
        AbstractC9579aC2.g("glFramebufferTexture2D");
        GLES20.glActiveTexture(33984);
        AbstractC9579aC2.g("glActiveTexture");
        GLES20.glBindTexture(36197, this.m);
        AbstractC9579aC2.g("glBindTexture");
        this.i = null;
        GLES20.glViewport(0, 0, size.getWidth(), size.getHeight());
        GLES20.glScissor(0, 0, size.getWidth(), size.getHeight());
        AbstractC9579aC2.f fVar = (AbstractC9579aC2.f) AbstractC4980Hj5.g(this.k);
        if (fVar instanceof AbstractC9579aC2.g) {
            ((AbstractC9579aC2.g) fVar).h(fArr);
        }
        GLES20.glDrawArrays(5, 0, 4);
        AbstractC9579aC2.g("glDrawArrays");
        GLES20.glReadPixels(0, 0, size.getWidth(), size.getHeight(), 6408, 5121, byteBuffer);
        AbstractC9579aC2.g("glReadPixels");
        GLES20.glBindFramebuffer(36160, 0);
        AbstractC9579aC2.s(iU);
        AbstractC9579aC2.r(iT);
        a(this.m);
    }

    protected HN4 c(Surface surface) {
        try {
            EGLDisplay eGLDisplay = this.d;
            EGLConfig eGLConfig = this.g;
            Objects.requireNonNull(eGLConfig);
            EGLSurface eGLSurfaceQ = AbstractC9579aC2.q(eGLDisplay, eGLConfig, surface, this.f);
            Size sizeX = AbstractC9579aC2.x(this.d, eGLSurfaceQ);
            return HN4.d(eGLSurfaceQ, sizeX.getWidth(), sizeX.getHeight());
        } catch (IllegalArgumentException | IllegalStateException e) {
            PI3.m("OpenGlRenderer", "Failed to create EGL surface: " + e.getMessage(), e);
            return null;
        }
    }

    protected HN4 f(Surface surface) {
        AbstractC4980Hj5.j(this.b.containsKey(surface), "The surface is not registered.");
        HN4 hn4 = (HN4) this.b.get(surface);
        Objects.requireNonNull(hn4);
        return hn4;
    }

    public int g() {
        AbstractC9579aC2.i(this.a, true);
        AbstractC9579aC2.h(this.c);
        return this.m;
    }

    public AbstractC18832pK2 h(C15116j22 c15116j22, Map map) throws Throwable {
        AbstractC9579aC2.i(this.a, false);
        AbstractC18832pK2.a aVarA = AbstractC18832pK2.a();
        try {
            if (c15116j22.d()) {
                YV4 yv4E = e(c15116j22);
                String str = (String) AbstractC4980Hj5.g((String) yv4E.a);
                String str2 = (String) AbstractC4980Hj5.g((String) yv4E.b);
                if (!str.contains("GL_EXT_YUV_target")) {
                    PI3.l("OpenGlRenderer", "Device does not support GL_EXT_YUV_target. Fallback to SDR.");
                    c15116j22 = C15116j22.d;
                }
                this.f = AbstractC9579aC2.k(str2, c15116j22);
                aVarA.d(str);
                aVarA.b(str2);
            }
            b(c15116j22, aVarA);
            d();
            i(this.h);
            aVarA.e(AbstractC9579aC2.w());
            this.j = AbstractC9579aC2.o(c15116j22, map);
            int iP = AbstractC9579aC2.p();
            this.m = iP;
            s(iP);
            this.c = Thread.currentThread();
            this.a.set(true);
            return aVarA.a();
        } catch (IllegalArgumentException e) {
            e = e;
            l();
            throw e;
        } catch (IllegalStateException e2) {
            e = e2;
            l();
            throw e;
        }
    }

    protected void i(EGLSurface eGLSurface) {
        AbstractC4980Hj5.g(this.d);
        AbstractC4980Hj5.g(this.e);
        if (!EGL14.eglMakeCurrent(this.d, eGLSurface, eGLSurface, this.e)) {
            throw new IllegalStateException("eglMakeCurrent failed");
        }
    }

    public void j(Surface surface) {
        AbstractC9579aC2.i(this.a, true);
        AbstractC9579aC2.h(this.c);
        if (this.b.containsKey(surface)) {
            return;
        }
        this.b.put(surface, AbstractC9579aC2.l);
    }

    public void k() {
        if (this.a.getAndSet(false)) {
            AbstractC9579aC2.h(this.c);
            l();
        }
    }

    protected void m(Surface surface, boolean z) {
        if (this.i == surface) {
            this.i = null;
            i(this.h);
        }
        HN4 hn4 = z ? (HN4) this.b.remove(surface) : (HN4) this.b.put(surface, AbstractC9579aC2.l);
        if (hn4 == null || hn4 == AbstractC9579aC2.l) {
            return;
        }
        try {
            EGL14.eglDestroySurface(this.d, hn4.a());
        } catch (RuntimeException e) {
            PI3.m("OpenGlRenderer", "Failed to destroy EGL surface: " + e.getMessage(), e);
        }
    }

    public void n(long j, float[] fArr, Surface surface) {
        AbstractC9579aC2.i(this.a, true);
        AbstractC9579aC2.h(this.c);
        HN4 hn4F = f(surface);
        if (hn4F == AbstractC9579aC2.l) {
            hn4F = c(surface);
            if (hn4F == null) {
                return;
            } else {
                this.b.put(surface, hn4F);
            }
        }
        if (surface != this.i) {
            i(hn4F.a());
            this.i = surface;
            GLES20.glViewport(0, 0, hn4F.c(), hn4F.b());
            GLES20.glScissor(0, 0, hn4F.c(), hn4F.b());
        }
        AbstractC9579aC2.f fVar = (AbstractC9579aC2.f) AbstractC4980Hj5.g(this.k);
        if (fVar instanceof AbstractC9579aC2.g) {
            ((AbstractC9579aC2.g) fVar).h(fArr);
        }
        GLES20.glDrawArrays(5, 0, 4);
        AbstractC9579aC2.g("glDrawArrays");
        EGLExt.eglPresentationTimeANDROID(this.d, hn4F.a(), j);
        if (EGL14.eglSwapBuffers(this.d, hn4F.a())) {
            return;
        }
        PI3.l("OpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        m(surface, false);
    }

    public void o(AbstractC9579aC2.e eVar) {
        AbstractC9579aC2.i(this.a, true);
        AbstractC9579aC2.h(this.c);
        if (this.l != eVar) {
            this.l = eVar;
            s(this.m);
        }
    }

    public Bitmap p(Size size, float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(size.getWidth() * size.getHeight() * 4);
        q(byteBufferAllocateDirect, size, fArr);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), Bitmap.Config.ARGB_8888);
        byteBufferAllocateDirect.rewind();
        ImageProcessingUtil.g(bitmapCreateBitmap, byteBufferAllocateDirect, size.getWidth() * 4);
        return bitmapCreateBitmap;
    }

    public void r(Surface surface) {
        AbstractC9579aC2.i(this.a, true);
        AbstractC9579aC2.h(this.c);
        m(surface, true);
    }

    protected void s(int i) {
        AbstractC9579aC2.f fVar = (AbstractC9579aC2.f) this.j.get(this.l);
        if (fVar == null) {
            throw new IllegalStateException("Unable to configure program for input format: " + this.l);
        }
        if (this.k != fVar) {
            this.k = fVar;
            fVar.f();
            Log.d("OpenGlRenderer", "Using program for input format " + this.l + ": " + this.k);
        }
        a(i);
    }
}
