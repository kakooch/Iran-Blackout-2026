package ir.nasim.features.libphotovideo.Paint;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.opengl.GLES20;
import ir.nasim.AbstractC17682nN7;
import ir.nasim.AbstractC5332Iw6;
import ir.nasim.C14036hE6;
import ir.nasim.C16983mB7;
import ir.nasim.C18530oo7;
import ir.nasim.C19462qO5;
import ir.nasim.InterfaceC13156fl0;
import ir.nasim.NN5;
import ir.nasim.W05;
import ir.nasim.YB2;
import ir.nasim.features.media.components.Size;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.zip.DataFormatException;

/* loaded from: classes3.dex */
public class a {
    private g a;
    private W05 b;
    private RenderView d;
    private Size e;
    private RectF f;
    private InterfaceC13156fl0 g;
    private C18530oo7 h;
    private C18530oo7 i;
    private ByteBuffer j;
    private ByteBuffer k;
    private int l;
    private int m;
    private Map n;
    private int o;
    private ByteBuffer q;
    private boolean r;
    private C14036hE6 s;
    private float[] t;
    private float[] u;
    private int[] p = new int[1];
    private C19462qO5 c = new C19462qO5();

    /* renamed from: ir.nasim.features.libphotovideo.Paint.a$a, reason: collision with other inner class name */
    class RunnableC1173a implements Runnable {
        final /* synthetic */ W05 a;
        final /* synthetic */ boolean b;
        final /* synthetic */ Runnable c;

        RunnableC1173a(W05 w05, boolean z, Runnable runnable) {
            this.a = w05;
            this.b = z;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            RectF rectFD;
            a.this.b = this.a;
            GLES20.glBindFramebuffer(36160, a.this.F());
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, a.this.D(), 0);
            AbstractC17682nN7.a();
            if (GLES20.glCheckFramebufferStatus(36160) == 36053) {
                GLES20.glViewport(0, 0, (int) a.this.e.width, (int) a.this.e.height);
                if (this.b) {
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    GLES20.glClear(16384);
                }
                if (a.this.n == null) {
                    return;
                }
                ir.nasim.features.libphotovideo.Paint.b bVar = (ir.nasim.features.libphotovideo.Paint.b) a.this.n.get(a.this.g.d() ? "brushLight" : "brush");
                if (bVar == null) {
                    return;
                }
                GLES20.glUseProgram(bVar.a);
                if (a.this.h == null) {
                    a aVar = a.this;
                    aVar.h = new C18530oo7(aVar.g.f());
                }
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, a.this.h.d());
                GLES20.glUniformMatrix4fv(bVar.e("mvpMatrix"), 1, false, FloatBuffer.wrap(a.this.t));
                GLES20.glUniform1i(bVar.e("texture"), 0);
                rectFD = NN5.d(this.a, a.this.c);
            } else {
                rectFD = null;
            }
            GLES20.glBindFramebuffer(36160, 0);
            if (a.this.a != null) {
                a.this.a.b();
            }
            if (a.this.f != null) {
                a.this.f.union(rectFD);
            } else {
                a.this.f = rectFD;
            }
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ int a;

        /* renamed from: ir.nasim.features.libphotovideo.Paint.a$b$a, reason: collision with other inner class name */
        class RunnableC1174a implements Runnable {
            RunnableC1174a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.n == null) {
                    return;
                }
                ir.nasim.features.libphotovideo.Paint.b bVar = (ir.nasim.features.libphotovideo.Paint.b) a.this.n.get(a.this.g.d() ? "compositeWithMaskLight" : "compositeWithMask");
                if (bVar == null) {
                    return;
                }
                GLES20.glUseProgram(bVar.a);
                GLES20.glUniformMatrix4fv(bVar.e("mvpMatrix"), 1, false, FloatBuffer.wrap(a.this.t));
                GLES20.glUniform1i(bVar.e("mask"), 0);
                ir.nasim.features.libphotovideo.Paint.b.a(bVar.e("color"), b.this.a);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, a.this.D());
                GLES20.glBlendFuncSeparate(770, 771, 770, 1);
                GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) a.this.j);
                GLES20.glEnableVertexAttribArray(0);
                GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) a.this.k);
                GLES20.glEnableVertexAttribArray(1);
                GLES20.glDrawArrays(5, 0, 4);
            }
        }

        b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.N(aVar.f);
            a.this.y();
            a.this.Y(new RunnableC1174a());
            a.this.B();
            a.this.c.f();
            a.this.f = null;
            a.this.b = null;
        }
    }

    class c implements Runnable {
        final /* synthetic */ C14036hE6 a;

        c(C14036hE6 c14036hE6) {
            this.a = c14036hE6;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.R(this.a);
        }
    }

    class d implements Runnable {
        final /* synthetic */ C14036hE6 a;

        d(C14036hE6 c14036hE6) {
            this.a = c14036hE6;
        }

        @Override // java.lang.Runnable
        public void run() throws DataFormatException, IOException {
            ByteBuffer byteBufferB = this.a.b();
            GLES20.glBindTexture(3553, a.this.H());
            GLES20.glTexSubImage2D(3553, 0, this.a.e(), this.a.f(), this.a.d(), this.a.c(), 6408, 5121, byteBufferB);
            if (!a.this.J() && a.this.a != null) {
                a.this.a.b();
            }
            this.a.a();
        }
    }

    class e implements Runnable {
        final /* synthetic */ Runnable a;

        e(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.r = true;
            a aVar = a.this;
            f fVarE = aVar.E(aVar.C(), true);
            a aVar2 = a.this;
            aVar2.s = new C14036hE6(fVarE.b, aVar2.C());
            a.this.z(false);
            Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public class f {
        public Bitmap a;
        public ByteBuffer b;

        f(Bitmap bitmap, ByteBuffer byteBuffer) {
            this.a = bitmap;
            this.b = byteBuffer;
        }
    }

    public interface g {
        C16983mB7 a();

        void b();
    }

    public a(Size size) {
        this.e = size;
        this.q = ByteBuffer.allocateDirect(((int) size.width) * ((int) size.height) * 4);
        Size size2 = this.e;
        this.t = YB2.b(0.0f, size2.width, 0.0f, size2.height, -1.0f, 1.0f);
        if (this.j == null) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
            this.j = byteBufferAllocateDirect;
            byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        }
        this.j.putFloat(0.0f);
        this.j.putFloat(0.0f);
        this.j.putFloat(this.e.width);
        this.j.putFloat(0.0f);
        this.j.putFloat(0.0f);
        this.j.putFloat(this.e.height);
        this.j.putFloat(this.e.width);
        this.j.putFloat(this.e.height);
        this.j.rewind();
        if (this.k == null) {
            ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(32);
            this.k = byteBufferAllocateDirect2;
            byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
            this.k.putFloat(0.0f);
            this.k.putFloat(0.0f);
            this.k.putFloat(1.0f);
            this.k.putFloat(0.0f);
            this.k.putFloat(0.0f);
            this.k.putFloat(1.0f);
            this.k.putFloat(1.0f);
            this.k.putFloat(1.0f);
            this.k.rewind();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.o--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D() {
        if (this.m == 0) {
            this.m = C18530oo7.b(this.e);
        }
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F() {
        if (this.l == 0) {
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.l = iArr[0];
            AbstractC17682nN7.a();
        }
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int H() {
        C18530oo7 c18530oo7 = this.i;
        if (c18530oo7 != null) {
            return c18530oo7.d();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J() {
        return this.o > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(RectF rectF) {
        if (rectF != null && rectF.setIntersect(rectF, C())) {
            this.a.a().d(UUID.randomUUID(), new c(new C14036hE6(E(rectF, true).b, rectF)));
        }
    }

    private void P(int i, int i2) {
        ir.nasim.features.libphotovideo.Paint.b bVar = (ir.nasim.features.libphotovideo.Paint.b) this.n.get(this.g.d() ? "blitWithMaskLight" : "blitWithMask");
        if (bVar == null) {
            return;
        }
        GLES20.glUseProgram(bVar.a);
        GLES20.glUniformMatrix4fv(bVar.e("mvpMatrix"), 1, false, FloatBuffer.wrap(this.u));
        GLES20.glUniform1i(bVar.e("texture"), 0);
        GLES20.glUniform1i(bVar.e("mask"), 1);
        ir.nasim.features.libphotovideo.Paint.b.a(bVar.e("color"), i2);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, H());
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i);
        GLES20.glBlendFunc(1, 771);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) this.j);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) this.k);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glDrawArrays(5, 0, 4);
        AbstractC17682nN7.a();
    }

    private void Q() {
        ir.nasim.features.libphotovideo.Paint.b bVar = (ir.nasim.features.libphotovideo.Paint.b) this.n.get("blit");
        if (bVar == null) {
            return;
        }
        GLES20.glUseProgram(bVar.a);
        GLES20.glUniformMatrix4fv(bVar.e("mvpMatrix"), 1, false, FloatBuffer.wrap(this.u));
        GLES20.glUniform1i(bVar.e("texture"), 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, H());
        GLES20.glBlendFunc(1, 771);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) this.j);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) this.k);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glDrawArrays(5, 0, 4);
        AbstractC17682nN7.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(C14036hE6 c14036hE6) {
        this.d.q(new d(c14036hE6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Runnable runnable) {
        g gVar;
        GLES20.glBindFramebuffer(36160, F());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, H(), 0);
        if (GLES20.glCheckFramebufferStatus(36160) == 36053) {
            Size size = this.e;
            GLES20.glViewport(0, 0, (int) size.width, (int) size.height);
            runnable.run();
        }
        GLES20.glBindFramebuffer(36160, 0);
        if (J() || (gVar = this.a) == null) {
            return;
        }
        gVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.o++;
    }

    public void A(int i) {
        this.d.q(new b(i));
    }

    public RectF C() {
        Size size = this.e;
        return new RectF(0.0f, 0.0f, size.width, size.height);
    }

    public f E(RectF rectF, boolean z) {
        f fVar;
        int i = (int) rectF.left;
        int i2 = (int) rectF.top;
        int iWidth = (int) rectF.width();
        int iHeight = (int) rectF.height();
        GLES20.glGenFramebuffers(1, this.p, 0);
        int i3 = this.p[0];
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glGenTextures(1, this.p, 0);
        int i4 = this.p[0];
        GLES20.glBindTexture(3553, i4);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, iWidth, iHeight, 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i4, 0);
        Size size = this.e;
        GLES20.glViewport(0, 0, (int) size.width, (int) size.height);
        Map map = this.n;
        if (map == null) {
            return null;
        }
        ir.nasim.features.libphotovideo.Paint.b bVar = (ir.nasim.features.libphotovideo.Paint.b) map.get(z ? "nonPremultipliedBlit" : "blit");
        if (bVar == null) {
            return null;
        }
        GLES20.glUseProgram(bVar.a);
        Matrix matrix = new Matrix();
        matrix.preTranslate(-i, -i2);
        GLES20.glUniformMatrix4fv(bVar.e("mvpMatrix"), 1, false, FloatBuffer.wrap(YB2.c(this.t, YB2.a(matrix))));
        if (z) {
            GLES20.glUniform1i(bVar.e("texture"), 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, H());
        } else {
            GLES20.glUniform1i(bVar.e("texture"), 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.i.d());
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, H());
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glBlendFunc(1, 771);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 8, (Buffer) this.j);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 8, (Buffer) this.k);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glDrawArrays(5, 0, 4);
        this.q.limit(iWidth * iHeight * 4);
        GLES20.glReadPixels(0, 0, iWidth, iHeight, 6408, 5121, this.q);
        if (z) {
            fVar = new f(null, this.q);
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.copyPixelsFromBuffer(this.q);
            fVar = new f(bitmapCreateBitmap, null);
        }
        int[] iArr = this.p;
        iArr[0] = i3;
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        int[] iArr2 = this.p;
        iArr2[0] = i4;
        GLES20.glDeleteTextures(1, iArr2, 0);
        return fVar;
    }

    public Size G() {
        return this.e;
    }

    public boolean I() {
        return this.r;
    }

    public void K(Runnable runnable) {
        this.d.q(new e(runnable));
    }

    public void L() {
        R(this.s);
        this.s = null;
        this.r = false;
    }

    public void M(W05 w05, boolean z, Runnable runnable) {
        this.d.q(new RunnableC1173a(w05, z, runnable));
    }

    public void O() {
        if (this.n == null) {
            return;
        }
        if (this.b != null) {
            P(D(), this.b.c());
        } else {
            Q();
        }
    }

    public void S(Bitmap bitmap) {
        if (this.i != null) {
            return;
        }
        this.i = new C18530oo7(bitmap);
    }

    public void T(InterfaceC13156fl0 interfaceC13156fl0) {
        this.g = interfaceC13156fl0;
        C18530oo7 c18530oo7 = this.h;
        if (c18530oo7 != null) {
            c18530oo7.a(true);
            this.h = null;
        }
    }

    public void U(g gVar) {
        this.a = gVar;
    }

    public void V(float[] fArr) {
        this.u = fArr;
    }

    public void W(RenderView renderView) {
        this.d = renderView;
    }

    public void X() {
        this.n = AbstractC5332Iw6.b();
    }

    public void z(boolean z) {
        int i = this.l;
        if (i != 0) {
            int[] iArr = this.p;
            iArr[0] = i;
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            this.l = 0;
        }
        this.i.a(z);
        int i2 = this.m;
        if (i2 != 0) {
            int[] iArr2 = this.p;
            iArr2[0] = i2;
            GLES20.glDeleteTextures(1, iArr2, 0);
            this.m = 0;
        }
        C18530oo7 c18530oo7 = this.h;
        if (c18530oo7 != null) {
            c18530oo7.a(true);
            this.h = null;
        }
        Map map = this.n;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((ir.nasim.features.libphotovideo.Paint.b) it.next()).b();
            }
            this.n = null;
        }
    }
}
