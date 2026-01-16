package ir.nasim;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.sj3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20858sj3 implements InterfaceFutureC15215jC3 {
    private final InterfaceC13730gj3 a;
    private final C5314Iu6 b;

    /* renamed from: ir.nasim.sj3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(Throwable th) {
            if (th == null) {
                if (!C20858sj3.this.b.isDone()) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else {
                if (th instanceof CancellationException) {
                    C20858sj3.this.b.cancel(true);
                    return;
                }
                C5314Iu6 c5314Iu6 = C20858sj3.this.b;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                c5314Iu6.q(th);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    public C20858sj3(InterfaceC13730gj3 interfaceC13730gj3, C5314Iu6 c5314Iu6) {
        AbstractC13042fc3.i(interfaceC13730gj3, "job");
        AbstractC13042fc3.i(c5314Iu6, "underlying");
        this.a = interfaceC13730gj3;
        this.b = c5314Iu6;
        interfaceC13730gj3.s(new a());
    }

    public final void b(Object obj) {
        this.b.p(obj);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.b.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.b.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.b.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.b.isDone();
    }

    @Override // ir.nasim.InterfaceFutureC15215jC3
    public void j(Runnable runnable, Executor executor) {
        this.b.j(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return this.b.get(j, timeUnit);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C20858sj3(InterfaceC13730gj3 interfaceC13730gj3, C5314Iu6 c5314Iu6, int i, ED1 ed1) {
        if ((i & 2) != 0) {
            c5314Iu6 = C5314Iu6.t();
            AbstractC13042fc3.h(c5314Iu6, "create()");
        }
        this(interfaceC13730gj3, c5314Iu6);
    }
}
