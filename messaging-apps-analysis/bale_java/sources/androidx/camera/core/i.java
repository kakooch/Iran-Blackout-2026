package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.e;
import ir.nasim.O23;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class i implements O23 {
    private final O23 d;
    private final Surface e;
    private e.a f;
    private final Object a = new Object();
    private int b = 0;
    private boolean c = false;
    private final e.a g = new e.a() { // from class: ir.nasim.i96
        @Override // androidx.camera.core.e.a
        public final void a(androidx.camera.core.f fVar) {
            this.a.j(fVar);
        }
    };

    public i(O23 o23) {
        this.d = o23;
        this.e = o23.getSurface();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(f fVar) {
        e.a aVar;
        synchronized (this.a) {
            try {
                int i = this.b - 1;
                this.b = i;
                if (this.c && i == 0) {
                    close();
                }
                aVar = this.f;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            aVar.a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(O23.a aVar, O23 o23) {
        aVar.a(this);
    }

    private f n(f fVar) {
        if (fVar == null) {
            return null;
        }
        this.b++;
        k kVar = new k(fVar);
        kVar.a(this.g);
        return kVar;
    }

    @Override // ir.nasim.O23
    public f b() {
        f fVarN;
        synchronized (this.a) {
            fVarN = n(this.d.b());
        }
        return fVarN;
    }

    @Override // ir.nasim.O23
    public int c() {
        int iC;
        synchronized (this.a) {
            iC = this.d.c();
        }
        return iC;
    }

    @Override // ir.nasim.O23
    public void close() {
        synchronized (this.a) {
            try {
                Surface surface = this.e;
                if (surface != null) {
                    surface.release();
                }
                this.d.close();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.O23
    public void d() {
        synchronized (this.a) {
            this.d.d();
        }
    }

    @Override // ir.nasim.O23
    public int e() {
        int iE;
        synchronized (this.a) {
            iE = this.d.e();
        }
        return iE;
    }

    @Override // ir.nasim.O23
    public void f(final O23.a aVar, Executor executor) {
        synchronized (this.a) {
            this.d.f(new O23.a() { // from class: ir.nasim.h96
                @Override // ir.nasim.O23.a
                public final void a(O23 o23) {
                    this.a.k(aVar, o23);
                }
            }, executor);
        }
    }

    @Override // ir.nasim.O23
    public f g() {
        f fVarN;
        synchronized (this.a) {
            fVarN = n(this.d.g());
        }
        return fVarN;
    }

    @Override // ir.nasim.O23
    public int getHeight() {
        int height;
        synchronized (this.a) {
            height = this.d.getHeight();
        }
        return height;
    }

    @Override // ir.nasim.O23
    public Surface getSurface() {
        Surface surface;
        synchronized (this.a) {
            surface = this.d.getSurface();
        }
        return surface;
    }

    @Override // ir.nasim.O23
    public int getWidth() {
        int width;
        synchronized (this.a) {
            width = this.d.getWidth();
        }
        return width;
    }

    public int i() {
        int iE;
        synchronized (this.a) {
            iE = this.d.e() - this.b;
        }
        return iE;
    }

    public void l() {
        synchronized (this.a) {
            try {
                this.c = true;
                this.d.d();
                if (this.b == 0) {
                    close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void m(e.a aVar) {
        synchronized (this.a) {
            this.f = aVar;
        }
    }
}
