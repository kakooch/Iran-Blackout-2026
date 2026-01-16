package androidx.work;

import ir.nasim.AbstractC18733p93;
import ir.nasim.AbstractC22650vb8;
import ir.nasim.C73;
import ir.nasim.InterfaceC16352l76;
import ir.nasim.OE1;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class a {
    final Executor a;
    final Executor b;
    final AbstractC22650vb8 c;
    final AbstractC18733p93 d;
    final InterfaceC16352l76 e;
    final String f;
    final int g;
    final int h;
    final int i;
    final int j;
    private final boolean k;

    /* renamed from: androidx.work.a$a, reason: collision with other inner class name */
    class ThreadFactoryC0135a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(0);
        final /* synthetic */ boolean b;

        ThreadFactoryC0135a(boolean z) {
            this.b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, (this.b ? "WM.task-" : "androidx.work-") + this.a.incrementAndGet());
        }
    }

    public static final class b {
        Executor a;
        AbstractC22650vb8 b;
        AbstractC18733p93 c;
        Executor d;
        InterfaceC16352l76 e;
        String f;
        int g = 4;
        int h = 0;
        int i = Integer.MAX_VALUE;
        int j = 20;

        public a a() {
            return new a(this);
        }
    }

    a(b bVar) {
        Executor executor = bVar.a;
        if (executor == null) {
            this.a = a(false);
        } else {
            this.a = executor;
        }
        Executor executor2 = bVar.d;
        if (executor2 == null) {
            this.k = true;
            this.b = a(true);
        } else {
            this.k = false;
            this.b = executor2;
        }
        AbstractC22650vb8 abstractC22650vb8 = bVar.b;
        if (abstractC22650vb8 == null) {
            this.c = AbstractC22650vb8.c();
        } else {
            this.c = abstractC22650vb8;
        }
        AbstractC18733p93 abstractC18733p93 = bVar.c;
        if (abstractC18733p93 == null) {
            this.d = AbstractC18733p93.c();
        } else {
            this.d = abstractC18733p93;
        }
        InterfaceC16352l76 interfaceC16352l76 = bVar.e;
        if (interfaceC16352l76 == null) {
            this.e = new OE1();
        } else {
            this.e = interfaceC16352l76;
        }
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.f = bVar.f;
    }

    private Executor a(boolean z) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(z));
    }

    private ThreadFactory b(boolean z) {
        return new ThreadFactoryC0135a(z);
    }

    public String c() {
        return this.f;
    }

    public C73 d() {
        return null;
    }

    public Executor e() {
        return this.a;
    }

    public AbstractC18733p93 f() {
        return this.d;
    }

    public int g() {
        return this.i;
    }

    public int h() {
        return this.j;
    }

    public int i() {
        return this.h;
    }

    public int j() {
        return this.g;
    }

    public InterfaceC16352l76 k() {
        return this.e;
    }

    public Executor l() {
        return this.b;
    }

    public AbstractC22650vb8 m() {
        return this.c;
    }
}
