package androidx.camera.core.impl;

import android.gov.nist.core.Separators;
import android.util.Log;
import android.util.Size;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.AbstractC20567sE0;
import ir.nasim.InterfaceFutureC15215jC3;
import ir.nasim.PI3;
import ir.nasim.WB2;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class DeferrableSurface {
    public static final Size k = new Size(0, 0);
    private static final boolean l = PI3.f("DeferrableSurface");
    private static final AtomicInteger m = new AtomicInteger(0);
    private static final AtomicInteger n = new AtomicInteger(0);
    private final Object a;
    private int b;
    private boolean c;
    private AbstractC16967mA0.a d;
    private final InterfaceFutureC15215jC3 e;
    private AbstractC16967mA0.a f;
    private final InterfaceFutureC15215jC3 g;
    private final Size h;
    private final int i;
    Class j;

    public static final class SurfaceClosedException extends Exception {
        DeferrableSurface a;

        public SurfaceClosedException(String str, DeferrableSurface deferrableSurface) {
            super(str);
            this.a = deferrableSurface;
        }

        public DeferrableSurface a() {
            return this.a;
        }
    }

    public static final class SurfaceUnavailableException extends Exception {
        public SurfaceUnavailableException(String str) {
            super(str);
        }
    }

    public DeferrableSurface() {
        this(k, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(AbstractC16967mA0.a aVar) {
        synchronized (this.a) {
            this.d = aVar;
        }
        return "DeferrableSurface-termination(" + this + Separators.RPAREN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(AbstractC16967mA0.a aVar) {
        synchronized (this.a) {
            this.f = aVar;
        }
        return "DeferrableSurface-close(" + this + Separators.RPAREN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(String str) throws ExecutionException, InterruptedException {
        try {
            this.e.get();
            q("Surface terminated", n.decrementAndGet(), m.get());
        } catch (Exception e) {
            PI3.c("DeferrableSurface", "Unexpected surface termination for " + this + "\nStack Trace:\n" + str);
            synchronized (this.a) {
                throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", this, Boolean.valueOf(this.c), Integer.valueOf(this.b)), e);
            }
        }
    }

    private void q(String str, int i, int i2) {
        if (!l && PI3.f("DeferrableSurface")) {
            PI3.a("DeferrableSurface", "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        }
        PI3.a("DeferrableSurface", str + "[total_surfaces=" + i + ", used_surfaces=" + i2 + "](" + this + "}");
    }

    public void d() {
        AbstractC16967mA0.a aVar;
        synchronized (this.a) {
            try {
                if (this.c) {
                    aVar = null;
                } else {
                    this.c = true;
                    this.f.c(null);
                    if (this.b == 0) {
                        aVar = this.d;
                        this.d = null;
                    } else {
                        aVar = null;
                    }
                    if (PI3.f("DeferrableSurface")) {
                        PI3.a("DeferrableSurface", "surface closed,  useCount=" + this.b + " closed=true " + this);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            aVar.c(null);
        }
    }

    public void e() {
        AbstractC16967mA0.a aVar;
        synchronized (this.a) {
            try {
                int i = this.b;
                if (i == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                int i2 = i - 1;
                this.b = i2;
                if (i2 == 0 && this.c) {
                    aVar = this.d;
                    this.d = null;
                } else {
                    aVar = null;
                }
                if (PI3.f("DeferrableSurface")) {
                    PI3.a("DeferrableSurface", "use count-1,  useCount=" + this.b + " closed=" + this.c + Separators.SP + this);
                    if (this.b == 0) {
                        q("Surface no longer in use", n.get(), m.decrementAndGet());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            aVar.c(null);
        }
    }

    public InterfaceFutureC15215jC3 f() {
        return WB2.t(this.g);
    }

    public Class g() {
        return this.j;
    }

    public Size h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public final InterfaceFutureC15215jC3 j() {
        synchronized (this.a) {
            try {
                if (this.c) {
                    return WB2.j(new SurfaceClosedException("DeferrableSurface already closed.", this));
                }
                return r();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public InterfaceFutureC15215jC3 k() {
        return WB2.t(this.e);
    }

    public void l() {
        synchronized (this.a) {
            try {
                int i = this.b;
                if (i == 0 && this.c) {
                    throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);
                }
                this.b = i + 1;
                if (PI3.f("DeferrableSurface")) {
                    if (this.b == 1) {
                        q("New surface in use", n.get(), m.incrementAndGet());
                    }
                    PI3.a("DeferrableSurface", "use count+1, useCount=" + this.b + Separators.SP + this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean m() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    protected abstract InterfaceFutureC15215jC3 r();

    public void s(Class cls) {
        this.j = cls;
    }

    public DeferrableSurface(Size size, int i) {
        this.a = new Object();
        this.b = 0;
        this.c = false;
        this.h = size;
        this.i = i;
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3A = AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.tG1
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return this.a.n(aVar);
            }
        });
        this.e = interfaceFutureC15215jC3A;
        this.g = AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.uG1
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return this.a.o(aVar);
            }
        });
        if (PI3.f("DeferrableSurface")) {
            q("Surface created", n.incrementAndGet(), m.get());
            final String stackTraceString = Log.getStackTraceString(new Exception());
            interfaceFutureC15215jC3A.j(new Runnable() { // from class: ir.nasim.vG1
                @Override // java.lang.Runnable
                public final void run() throws ExecutionException, InterruptedException {
                    this.a.p(stackTraceString);
                }
            }, AbstractC20567sE0.a());
        }
    }
}
