package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.kS, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15946kS {
    public static final a m = new a(null);
    public InterfaceC13330g27 a;
    private final Handler b;
    private Runnable c;
    private final Object d;
    private long e;
    private final Executor f;
    private int g;
    private long h;
    private InterfaceC12694f27 i;
    private boolean j;
    private final Runnable k;
    private final Runnable l;

    /* renamed from: ir.nasim.kS$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C15946kS(long j, TimeUnit timeUnit, Executor executor) {
        AbstractC13042fc3.i(timeUnit, "autoCloseTimeUnit");
        AbstractC13042fc3.i(executor, "autoCloseExecutor");
        this.b = new Handler(Looper.getMainLooper());
        this.d = new Object();
        this.e = timeUnit.toMillis(j);
        this.f = executor;
        this.h = SystemClock.uptimeMillis();
        this.k = new Runnable() { // from class: ir.nasim.iS
            @Override // java.lang.Runnable
            public final void run() {
                C15946kS.f(this.a);
            }
        };
        this.l = new Runnable() { // from class: ir.nasim.jS
            @Override // java.lang.Runnable
            public final void run() {
                C15946kS.c(this.a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C15946kS c15946kS) {
        C19938rB7 c19938rB7;
        AbstractC13042fc3.i(c15946kS, "this$0");
        synchronized (c15946kS.d) {
            try {
                if (SystemClock.uptimeMillis() - c15946kS.h < c15946kS.e) {
                    return;
                }
                if (c15946kS.g != 0) {
                    return;
                }
                Runnable runnable = c15946kS.c;
                if (runnable != null) {
                    runnable.run();
                    c19938rB7 = C19938rB7.a;
                } else {
                    c19938rB7 = null;
                }
                if (c19938rB7 == null) {
                    throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568".toString());
                }
                InterfaceC12694f27 interfaceC12694f27 = c15946kS.i;
                if (interfaceC12694f27 != null && interfaceC12694f27.isOpen()) {
                    interfaceC12694f27.close();
                }
                c15946kS.i = null;
                C19938rB7 c19938rB72 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(C15946kS c15946kS) {
        AbstractC13042fc3.i(c15946kS, "this$0");
        c15946kS.f.execute(c15946kS.l);
    }

    public final void d() {
        synchronized (this.d) {
            try {
                this.j = true;
                InterfaceC12694f27 interfaceC12694f27 = this.i;
                if (interfaceC12694f27 != null) {
                    interfaceC12694f27.close();
                }
                this.i = null;
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        synchronized (this.d) {
            try {
                int i = this.g;
                if (i <= 0) {
                    throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement".toString());
                }
                int i2 = i - 1;
                this.g = i2;
                if (i2 == 0) {
                    if (this.i == null) {
                        return;
                    } else {
                        this.b.postDelayed(this.k, this.e);
                    }
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object g(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "block");
        try {
            return ua2.invoke(j());
        } finally {
            e();
        }
    }

    public final InterfaceC12694f27 h() {
        return this.i;
    }

    public final InterfaceC13330g27 i() {
        InterfaceC13330g27 interfaceC13330g27 = this.a;
        if (interfaceC13330g27 != null) {
            return interfaceC13330g27;
        }
        AbstractC13042fc3.y("delegateOpenHelper");
        return null;
    }

    public final InterfaceC12694f27 j() {
        synchronized (this.d) {
            this.b.removeCallbacks(this.k);
            this.g++;
            if (!(!this.j)) {
                throw new IllegalStateException("Attempting to open already closed database.".toString());
            }
            InterfaceC12694f27 interfaceC12694f27 = this.i;
            if (interfaceC12694f27 != null && interfaceC12694f27.isOpen()) {
                return interfaceC12694f27;
            }
            InterfaceC12694f27 interfaceC12694f27E = i().E();
            this.i = interfaceC12694f27E;
            return interfaceC12694f27E;
        }
    }

    public final void k(InterfaceC13330g27 interfaceC13330g27) {
        AbstractC13042fc3.i(interfaceC13330g27, "delegateOpenHelper");
        n(interfaceC13330g27);
    }

    public final boolean l() {
        return !this.j;
    }

    public final void m(Runnable runnable) {
        AbstractC13042fc3.i(runnable, "onAutoClose");
        this.c = runnable;
    }

    public final void n(InterfaceC13330g27 interfaceC13330g27) {
        AbstractC13042fc3.i(interfaceC13330g27, "<set-?>");
        this.a = interfaceC13330g27;
    }
}
