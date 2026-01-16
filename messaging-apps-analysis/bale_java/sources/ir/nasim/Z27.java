package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import ir.nasim.AbstractC16967mA0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class Z27 {
    public static final Range p = androidx.camera.core.impl.w.a;
    private final Object a = new Object();
    private final Size b;
    private final C15116j22 c;
    private final Range d;
    private final InterfaceC15221jD0 e;
    private final boolean f;
    final InterfaceFutureC15215jC3 g;
    private final AbstractC16967mA0.a h;
    private final InterfaceFutureC15215jC3 i;
    private final AbstractC16967mA0.a j;
    private final AbstractC16967mA0.a k;
    private final DeferrableSurface l;
    private h m;
    private i n;
    private Executor o;

    class a implements MB2 {
        final /* synthetic */ AbstractC16967mA0.a a;
        final /* synthetic */ InterfaceFutureC15215jC3 b;

        a(AbstractC16967mA0.a aVar, InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
            this.a = aVar;
            this.b = interfaceFutureC15215jC3;
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            AbstractC4980Hj5.i(this.a.c(null));
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
            if (th instanceof f) {
                AbstractC4980Hj5.i(this.b.cancel(false));
            } else {
                AbstractC4980Hj5.i(this.a.c(null));
            }
        }
    }

    class b extends DeferrableSurface {
        b(Size size, int i) {
            super(size, i);
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        protected InterfaceFutureC15215jC3 r() {
            return Z27.this.g;
        }
    }

    class c implements MB2 {
        final /* synthetic */ InterfaceFutureC15215jC3 a;
        final /* synthetic */ AbstractC16967mA0.a b;
        final /* synthetic */ String c;

        c(InterfaceFutureC15215jC3 interfaceFutureC15215jC3, AbstractC16967mA0.a aVar, String str) {
            this.a = interfaceFutureC15215jC3;
            this.b = aVar;
            this.c = str;
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Surface surface) {
            WB2.u(this.a, this.b);
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
            if (!(th instanceof CancellationException)) {
                this.b.c(null);
                return;
            }
            AbstractC4980Hj5.i(this.b.f(new f(this.c + " cancelled.", th)));
        }
    }

    class d implements MB2 {
        final /* synthetic */ InterfaceC25043ze1 a;
        final /* synthetic */ Surface b;

        d(InterfaceC25043ze1 interfaceC25043ze1, Surface surface) {
            this.a = interfaceC25043ze1;
            this.b = surface;
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r3) {
            this.a.accept(g.c(0, this.b));
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
            AbstractC4980Hj5.j(th instanceof f, "Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th);
            this.a.accept(g.c(1, this.b));
        }
    }

    private static final class f extends RuntimeException {
        f(String str, Throwable th) {
            super(str, th);
        }
    }

    public static abstract class g {
        g() {
        }

        static g c(int i, Surface surface) {
            return new HT(i, surface);
        }

        public abstract int a();

        public abstract Surface b();
    }

    public static abstract class h {
        h() {
        }

        public static h g(Rect rect, int i, int i2, boolean z, Matrix matrix, boolean z2) {
            return new IT(rect, i, i2, z, matrix, z2);
        }

        public abstract Rect a();

        public abstract int b();

        public abstract Matrix c();

        public abstract int d();

        public abstract boolean e();

        public abstract boolean f();
    }

    public interface i {
        void a(h hVar);
    }

    public Z27(Size size, InterfaceC15221jD0 interfaceC15221jD0, boolean z, C15116j22 c15116j22, Range range, Runnable runnable) {
        this.b = size;
        this.e = interfaceC15221jD0;
        this.f = z;
        this.c = c15116j22;
        this.d = range;
        final String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + "]";
        final AtomicReference atomicReference = new AtomicReference(null);
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3A = AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.U27
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return Z27.t(atomicReference, str, aVar);
            }
        });
        AbstractC16967mA0.a aVar = (AbstractC16967mA0.a) AbstractC4980Hj5.g((AbstractC16967mA0.a) atomicReference.get());
        this.k = aVar;
        final AtomicReference atomicReference2 = new AtomicReference(null);
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3A2 = AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.V27
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar2) {
                return Z27.u(atomicReference2, str, aVar2);
            }
        });
        this.i = interfaceFutureC15215jC3A2;
        WB2.g(interfaceFutureC15215jC3A2, new a(aVar, interfaceFutureC15215jC3A), AbstractC20567sE0.a());
        AbstractC16967mA0.a aVar2 = (AbstractC16967mA0.a) AbstractC4980Hj5.g((AbstractC16967mA0.a) atomicReference2.get());
        final AtomicReference atomicReference3 = new AtomicReference(null);
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3A3 = AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.W27
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar3) {
                return Z27.v(atomicReference3, str, aVar3);
            }
        });
        this.g = interfaceFutureC15215jC3A3;
        this.h = (AbstractC16967mA0.a) AbstractC4980Hj5.g((AbstractC16967mA0.a) atomicReference3.get());
        b bVar = new b(size, 34);
        this.l = bVar;
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3K = bVar.k();
        WB2.g(interfaceFutureC15215jC3A3, new c(interfaceFutureC15215jC3K, aVar2, str), AbstractC20567sE0.a());
        interfaceFutureC15215jC3K.j(new Runnable() { // from class: ir.nasim.X27
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w();
            }
        }, AbstractC20567sE0.a());
        this.j = p(AbstractC20567sE0.a(), runnable);
    }

    private AbstractC16967mA0.a p(Executor executor, Runnable runnable) {
        final AtomicReference atomicReference = new AtomicReference(null);
        WB2.g(AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.Y27
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return this.a.s(atomicReference, aVar);
            }
        }), new e(runnable), executor);
        return (AbstractC16967mA0.a) AbstractC4980Hj5.g((AbstractC16967mA0.a) atomicReference.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(AtomicReference atomicReference, AbstractC16967mA0.a aVar) {
        atomicReference.set(aVar);
        return "SurfaceRequest-surface-recreation(" + hashCode() + Separators.RPAREN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object t(AtomicReference atomicReference, String str, AbstractC16967mA0.a aVar) {
        atomicReference.set(aVar);
        return str + "-cancellation";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object u(AtomicReference atomicReference, String str, AbstractC16967mA0.a aVar) {
        atomicReference.set(aVar);
        return str + "-status";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object v(AtomicReference atomicReference, String str, AbstractC16967mA0.a aVar) {
        atomicReference.set(aVar);
        return str + "-Surface";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        this.g.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(InterfaceC25043ze1 interfaceC25043ze1, Surface surface) {
        interfaceC25043ze1.accept(g.c(3, surface));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(InterfaceC25043ze1 interfaceC25043ze1, Surface surface) {
        interfaceC25043ze1.accept(g.c(4, surface));
    }

    public void B(final Surface surface, Executor executor, final InterfaceC25043ze1 interfaceC25043ze1) throws ExecutionException, InterruptedException {
        if (this.h.c(surface) || this.g.isCancelled()) {
            WB2.g(this.i, new d(interfaceC25043ze1, surface), executor);
            return;
        }
        AbstractC4980Hj5.i(this.g.isDone());
        try {
            this.g.get();
            executor.execute(new Runnable() { // from class: ir.nasim.R27
                @Override // java.lang.Runnable
                public final void run() {
                    Z27.x(interfaceC25043ze1, surface);
                }
            });
        } catch (InterruptedException | ExecutionException unused) {
            executor.execute(new Runnable() { // from class: ir.nasim.S27
                @Override // java.lang.Runnable
                public final void run() {
                    Z27.y(interfaceC25043ze1, surface);
                }
            });
        }
    }

    public void C(Executor executor, final i iVar) {
        final h hVar;
        synchronized (this.a) {
            this.n = iVar;
            this.o = executor;
            hVar = this.m;
        }
        if (hVar != null) {
            executor.execute(new Runnable() { // from class: ir.nasim.Q27
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.a(hVar);
                }
            });
        }
    }

    public void D(final h hVar) {
        final i iVar;
        Executor executor;
        synchronized (this.a) {
            this.m = hVar;
            iVar = this.n;
            executor = this.o;
        }
        if (iVar == null || executor == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: ir.nasim.T27
            @Override // java.lang.Runnable
            public final void run() {
                iVar.a(hVar);
            }
        });
    }

    public boolean E() {
        return this.h.f(new DeferrableSurface.SurfaceUnavailableException("Surface request will not complete."));
    }

    public void j(Executor executor, Runnable runnable) {
        this.k.a(runnable, executor);
    }

    public void k() {
        synchronized (this.a) {
            this.n = null;
            this.o = null;
        }
    }

    public InterfaceC15221jD0 l() {
        return this.e;
    }

    public DeferrableSurface m() {
        return this.l;
    }

    public C15116j22 n() {
        return this.c;
    }

    public Size o() {
        return this.b;
    }

    public boolean q() {
        E();
        return this.j.c(null);
    }

    public boolean r() {
        return this.f;
    }

    class e implements MB2 {
        final /* synthetic */ Runnable a;

        e(Runnable runnable) {
            this.a = runnable;
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r1) {
            this.a.run();
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
        }
    }
}
