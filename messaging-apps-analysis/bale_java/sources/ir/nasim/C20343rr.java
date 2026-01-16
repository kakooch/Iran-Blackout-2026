package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.rr, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20343rr extends AbstractC13778go1 {
    public static final c m = new c(null);
    public static final int n = 8;
    private static final InterfaceC9173Yu3 o = AbstractC13269fw3.a(a.e);
    private static final ThreadLocal p = new b();
    private final Choreographer c;
    private final Handler d;
    private final Object e;
    private final BJ f;
    private List g;
    private List h;
    private boolean i;
    private boolean j;
    private final d k;
    private final InterfaceC15522jj4 l;

    /* renamed from: ir.nasim.rr$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        /* renamed from: ir.nasim.rr$a$a, reason: collision with other inner class name */
        static final class C1523a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;

            C1523a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1523a(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return Choreographer.getInstance();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1523a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC11938do1 invoke() {
            C20343rr c20343rr = new C20343rr(AbstractC20934sr.b() ? Choreographer.getInstance() : (Choreographer) AbstractC9323Zl0.e(C12366eV1.c(), new C1523a(null)), AbstractC18913pT2.a(Looper.getMainLooper()), null);
            return c20343rr.X(c20343rr.S0());
        }
    }

    /* renamed from: ir.nasim.rr$b */
    public static final class b extends ThreadLocal {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC11938do1 initialValue() {
            Choreographer choreographer = Choreographer.getInstance();
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                throw new IllegalStateException("no Looper on this thread".toString());
            }
            C20343rr c20343rr = new C20343rr(choreographer, AbstractC18913pT2.a(looperMyLooper), null);
            return c20343rr.X(c20343rr.S0());
        }
    }

    /* renamed from: ir.nasim.rr$c */
    public static final class c {
        private c() {
        }

        public final InterfaceC11938do1 a() {
            if (AbstractC20934sr.b()) {
                return b();
            }
            InterfaceC11938do1 interfaceC11938do1 = (InterfaceC11938do1) C20343rr.p.get();
            if (interfaceC11938do1 != null) {
                return interfaceC11938do1;
            }
            throw new IllegalStateException("no AndroidUiDispatcher for this thread".toString());
        }

        public final InterfaceC11938do1 b() {
            return (InterfaceC11938do1) C20343rr.o.getValue();
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.rr$d */
    public static final class d implements Choreographer.FrameCallback, Runnable {
        d() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            C20343rr.this.d.removeCallbacks(this);
            C20343rr.this.b1();
            C20343rr.this.X0(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            C20343rr.this.b1();
            Object obj = C20343rr.this.e;
            C20343rr c20343rr = C20343rr.this;
            synchronized (obj) {
                try {
                    if (c20343rr.g.isEmpty()) {
                        c20343rr.R0().removeFrameCallback(this);
                        c20343rr.j = false;
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public /* synthetic */ C20343rr(Choreographer choreographer, Handler handler, ED1 ed1) {
        this(choreographer, handler);
    }

    private final Runnable W0() {
        Runnable runnable;
        synchronized (this.e) {
            runnable = (Runnable) this.f.W();
        }
        return runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(long j) {
        synchronized (this.e) {
            if (this.j) {
                this.j = false;
                List list = this.g;
                this.g = this.h;
                this.h = list;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ((Choreographer.FrameCallback) list.get(i)).doFrame(j);
                }
                list.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1() {
        boolean z;
        do {
            Runnable runnableW0 = W0();
            while (runnableW0 != null) {
                runnableW0.run();
                runnableW0 = W0();
            }
            synchronized (this.e) {
                if (this.f.isEmpty()) {
                    z = false;
                    this.i = false;
                } else {
                    z = true;
                }
            }
        } while (z);
    }

    public final Choreographer R0() {
        return this.c;
    }

    public final InterfaceC15522jj4 S0() {
        return this.l;
    }

    public final void d1(Choreographer.FrameCallback frameCallback) {
        synchronized (this.e) {
            try {
                this.g.add(frameCallback);
                if (!this.j) {
                    this.j = true;
                    this.c.postFrameCallback(this.k);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h1(Choreographer.FrameCallback frameCallback) {
        synchronized (this.e) {
            this.g.remove(frameCallback);
        }
    }

    @Override // ir.nasim.AbstractC13778go1
    public void x0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        synchronized (this.e) {
            try {
                this.f.addLast(runnable);
                if (!this.i) {
                    this.i = true;
                    this.d.post(this.k);
                    if (!this.j) {
                        this.j = true;
                        this.c.postFrameCallback(this.k);
                    }
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private C20343rr(Choreographer choreographer, Handler handler) {
        this.c = choreographer;
        this.d = handler;
        this.e = new Object();
        this.f = new BJ();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.k = new d();
        this.l = new C21621tr(choreographer, this);
    }
}
