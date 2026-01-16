package ir.nasim;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import ir.nasim.AbstractC9579aC2;
import java.util.Map;

/* renamed from: ir.nasim.y12, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C24086y12 extends C9662aL4 {
    private int n = -1;
    private int o = -1;
    private final C6012Lu3 p;
    private final C6012Lu3 q;

    public C24086y12(C6012Lu3 c6012Lu3, C6012Lu3 c6012Lu32) {
        this.p = c6012Lu3;
        this.q = c6012Lu32;
    }

    private static float[] u(Size size, Size size2, C6012Lu3 c6012Lu3) {
        float[] fArrL = AbstractC9579aC2.l();
        float[] fArrL2 = AbstractC9579aC2.l();
        float[] fArrL3 = AbstractC9579aC2.l();
        Matrix.scaleM(fArrL, 0, size.getWidth() / size2.getWidth(), size.getHeight() / size2.getHeight(), 1.0f);
        Matrix.translateM(fArrL2, 0, c6012Lu3.c() / c6012Lu3.e(), c6012Lu3.d() / c6012Lu3.b(), 0.0f);
        Matrix.multiplyMM(fArrL3, 0, fArrL, 0, fArrL2, 0);
        return fArrL3;
    }

    private void w(HN4 hn4, G27 g27, SurfaceTexture surfaceTexture, C6012Lu3 c6012Lu3, int i, boolean z) {
        s(i);
        GLES20.glViewport(0, 0, hn4.c(), hn4.b());
        GLES20.glScissor(0, 0, hn4.c(), hn4.b());
        float[] fArr = new float[16];
        surfaceTexture.getTransformMatrix(fArr);
        float[] fArr2 = new float[16];
        g27.Q(fArr2, fArr, z);
        AbstractC9579aC2.f fVar = (AbstractC9579aC2.f) AbstractC4980Hj5.g(this.k);
        if (fVar instanceof AbstractC9579aC2.g) {
            ((AbstractC9579aC2.g) fVar).h(fArr2);
        }
        fVar.e(u(new Size((int) (hn4.c() * c6012Lu3.e()), (int) (hn4.b() * c6012Lu3.b())), new Size(hn4.c(), hn4.b()), c6012Lu3));
        fVar.d(c6012Lu3.a());
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 771);
        GLES20.glDrawArrays(5, 0, 4);
        AbstractC9579aC2.g("glDrawArrays");
        GLES20.glDisable(3042);
    }

    @Override // ir.nasim.C9662aL4
    public AbstractC18832pK2 h(C15116j22 c15116j22, Map map) throws Throwable {
        AbstractC18832pK2 abstractC18832pK2H = super.h(c15116j22, map);
        this.n = AbstractC9579aC2.p();
        this.o = AbstractC9579aC2.p();
        return abstractC18832pK2H;
    }

    @Override // ir.nasim.C9662aL4
    public void k() {
        super.k();
        this.n = -1;
        this.o = -1;
    }

    public int t(boolean z) {
        AbstractC9579aC2.i(this.a, true);
        AbstractC9579aC2.h(this.c);
        return z ? this.n : this.o;
    }

    public void v(long j, Surface surface, G27 g27, SurfaceTexture surfaceTexture, SurfaceTexture surfaceTexture2) {
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
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        HN4 hn4 = hn4F;
        w(hn4, g27, surfaceTexture, this.p, this.n, true);
        w(hn4, g27, surfaceTexture2, this.q, this.o, true);
        EGLExt.eglPresentationTimeANDROID(this.d, hn4F.a(), j);
        if (EGL14.eglSwapBuffers(this.d, hn4F.a())) {
            return;
        }
        PI3.l("DualOpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        m(surface, false);
    }
}
