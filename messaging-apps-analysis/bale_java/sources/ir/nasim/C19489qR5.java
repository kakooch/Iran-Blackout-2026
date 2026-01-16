package ir.nasim;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.GlideException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: ir.nasim.qR5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C19489qR5 implements PB2, IT5 {
    private static final a k = new a();
    private final int a;
    private final int b;
    private final boolean c;
    private final a d;
    private Object e;
    private RP5 f;
    private boolean g;
    private boolean h;
    private boolean i;
    private GlideException j;

    /* renamed from: ir.nasim.qR5$a */
    static class a {
        a() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void b(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }
    }

    public C19489qR5(int i, int i2) {
        this(i, i2, true, k);
    }

    private synchronized Object m(Long l) {
        try {
            if (this.c && !isDone()) {
                YM7.a();
            }
            if (this.g) {
                throw new CancellationException();
            }
            if (this.i) {
                throw new ExecutionException(this.j);
            }
            if (this.h) {
                return this.e;
            }
            if (l == null) {
                this.d.b(this, 0L);
            } else if (l.longValue() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jLongValue = l.longValue() + jCurrentTimeMillis;
                while (!isDone() && jCurrentTimeMillis < jLongValue) {
                    this.d.b(this, jLongValue - jCurrentTimeMillis);
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.i) {
                throw new ExecutionException(this.j);
            }
            if (this.g) {
                throw new CancellationException();
            }
            if (!this.h) {
                throw new TimeoutException();
            }
            return this.e;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public synchronized void a(Object obj, InterfaceC22855vv7 interfaceC22855vv7) {
    }

    @Override // ir.nasim.IT5
    public synchronized boolean b(Object obj, Object obj2, InterfaceC21549tj7 interfaceC21549tj7, EnumC21012sz1 enumC21012sz1, boolean z) {
        this.h = true;
        this.e = obj;
        this.d.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.g = true;
                this.d.a(this);
                RP5 rp5 = null;
                if (z) {
                    RP5 rp52 = this.f;
                    this.f = null;
                    rp5 = rp52;
                }
                if (rp5 != null) {
                    rp5.clear();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.IT5
    public synchronized boolean d(GlideException glideException, Object obj, InterfaceC21549tj7 interfaceC21549tj7, boolean z) {
        this.i = true;
        this.j = glideException;
        this.d.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        try {
            return m(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public synchronized RP5 getRequest() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public void h(YD6 yd6) {
        yd6.d(this.a, this.b);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0012  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.g     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.h     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.i     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Le
            goto L12
        Le:
            r0 = 0
            goto L13
        L10:
            r0 = move-exception
            goto L15
        L12:
            r0 = 1
        L13:
            monitor-exit(r1)
            return r0
        L15:
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19489qR5.isDone():boolean");
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public synchronized void k(Drawable drawable) {
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public synchronized void l(RP5 rp5) {
        this.f = rp5;
    }

    public String toString() {
        RP5 rp5;
        String str;
        String str2 = super.toString() + "[status=";
        synchronized (this) {
            try {
                rp5 = null;
                if (this.g) {
                    str = "CANCELLED";
                } else if (this.i) {
                    str = "FAILURE";
                } else if (this.h) {
                    str = "SUCCESS";
                } else {
                    str = "PENDING";
                    rp5 = this.f;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (rp5 == null) {
            return str2 + str + "]";
        }
        return str2 + str + ", request=[" + rp5 + "]]";
    }

    C19489qR5(int i, int i2, boolean z, a aVar) {
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = aVar;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return m(Long.valueOf(timeUnit.toMillis(j)));
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void f() {
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void i() {
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void onDestroy() {
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public void c(YD6 yd6) {
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public void e(Drawable drawable) {
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public void g(Drawable drawable) {
    }
}
