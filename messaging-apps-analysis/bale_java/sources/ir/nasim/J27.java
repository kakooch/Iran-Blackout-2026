package ir.nasim;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.Size;
import android.view.Surface;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.G27;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
final class J27 implements G27 {
    private final Surface b;
    private final int c;
    private final int d;
    private final Size e;
    private final G27.a f;
    private final G27.a g;
    private final float[] h;
    private final float[] i;
    private final float[] j;
    private final float[] k;
    private InterfaceC25043ze1 l;
    private Executor m;
    private final InterfaceFutureC15215jC3 p;
    private AbstractC16967mA0.a q;
    private Matrix r;
    private final Object a = new Object();
    private boolean n = false;
    private boolean o = false;

    J27(Surface surface, int i, int i2, Size size, G27.a aVar, G27.a aVar2, Matrix matrix) {
        float[] fArr = new float[16];
        this.h = fArr;
        float[] fArr2 = new float[16];
        this.i = fArr2;
        float[] fArr3 = new float[16];
        this.j = fArr3;
        float[] fArr4 = new float[16];
        this.k = fArr4;
        this.b = surface;
        this.c = i;
        this.d = i2;
        this.e = size;
        this.f = aVar;
        this.g = aVar2;
        this.r = matrix;
        c(fArr, fArr3, aVar);
        c(fArr2, fArr4, aVar2);
        this.p = AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.H27
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar3) {
                return this.a.g(aVar3);
            }
        });
    }

    private static void c(float[] fArr, float[] fArr2, G27.a aVar) {
        android.opengl.Matrix.setIdentityM(fArr, 0);
        if (aVar == null) {
            return;
        }
        DV3.d(fArr, 0.5f);
        DV3.c(fArr, aVar.e(), 0.5f, 0.5f);
        if (aVar.d()) {
            android.opengl.Matrix.translateM(fArr, 0, 1.0f, 0.0f, 0.0f);
            android.opengl.Matrix.scaleM(fArr, 0, -1.0f, 1.0f, 1.0f);
        }
        Matrix matrixE = AbstractC14447hv7.e(AbstractC14447hv7.r(aVar.c()), AbstractC14447hv7.r(AbstractC14447hv7.o(aVar.c(), aVar.e())), aVar.e(), aVar.d());
        RectF rectF = new RectF(aVar.b());
        matrixE.mapRect(rectF);
        float width = rectF.left / r1.getWidth();
        float height = ((r1.getHeight() - rectF.height()) - rectF.top) / r1.getHeight();
        float fWidth = rectF.width() / r1.getWidth();
        float fHeight = rectF.height() / r1.getHeight();
        android.opengl.Matrix.translateM(fArr, 0, width, height, 0.0f);
        android.opengl.Matrix.scaleM(fArr, 0, fWidth, fHeight, 1.0f);
        d(fArr2, aVar.a());
        android.opengl.Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr, 0);
    }

    private static void d(float[] fArr, InterfaceC15221jD0 interfaceC15221jD0) {
        android.opengl.Matrix.setIdentityM(fArr, 0);
        DV3.d(fArr, 0.5f);
        if (interfaceC15221jD0 != null) {
            AbstractC4980Hj5.j(interfaceC15221jD0.p(), "Camera has no transform.");
            DV3.c(fArr, interfaceC15221jD0.a().a(), 0.5f, 0.5f);
            if (interfaceC15221jD0.l()) {
                android.opengl.Matrix.translateM(fArr, 0, 1.0f, 0.0f, 0.0f);
                android.opengl.Matrix.scaleM(fArr, 0, -1.0f, 1.0f, 1.0f);
            }
        }
        android.opengl.Matrix.invertM(fArr, 0, fArr, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object g(AbstractC16967mA0.a aVar) {
        this.q = aVar;
        return "SurfaceOutputImpl close future complete";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(AtomicReference atomicReference) {
        ((InterfaceC25043ze1) atomicReference.get()).accept(G27.b.c(0, this));
    }

    @Override // ir.nasim.G27
    public int C() {
        return this.d;
    }

    @Override // ir.nasim.G27
    public void Q(float[] fArr, float[] fArr2, boolean z) {
        android.opengl.Matrix.multiplyMM(fArr, 0, fArr2, 0, z ? this.h : this.i, 0);
    }

    @Override // ir.nasim.G27
    public void V0(float[] fArr, float[] fArr2) {
        Q(fArr, fArr2, true);
    }

    @Override // ir.nasim.G27, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.a) {
            try {
                if (!this.o) {
                    this.o = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.q.c(null);
    }

    public InterfaceFutureC15215jC3 e() {
        return this.p;
    }

    @Override // ir.nasim.G27
    public Size f() {
        return this.e;
    }

    @Override // ir.nasim.G27
    public Surface g0(Executor executor, InterfaceC25043ze1 interfaceC25043ze1) {
        boolean z;
        synchronized (this.a) {
            this.m = executor;
            this.l = interfaceC25043ze1;
            z = this.n;
        }
        if (z) {
            k();
        }
        return this.b;
    }

    public void k() {
        Executor executor;
        InterfaceC25043ze1 interfaceC25043ze1;
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (this.a) {
            try {
                if (this.m == null || (interfaceC25043ze1 = this.l) == null) {
                    this.n = true;
                } else if (!this.o) {
                    atomicReference.set(interfaceC25043ze1);
                    executor = this.m;
                    this.n = false;
                }
                executor = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (executor != null) {
            try {
                executor.execute(new Runnable() { // from class: ir.nasim.I27
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.j(atomicReference);
                    }
                });
            } catch (RejectedExecutionException e) {
                PI3.b("SurfaceOutputImpl", "Processor executor closed. Close request not posted.", e);
            }
        }
    }
}
