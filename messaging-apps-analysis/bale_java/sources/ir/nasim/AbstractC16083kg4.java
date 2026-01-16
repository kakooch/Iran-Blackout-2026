package ir.nasim;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ir.nasim.kg4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC16083kg4 {
    private static final ThreadFactory f;
    private static final BlockingQueue g;
    public static final Executor h;
    private static f i;
    private static volatile Executor j;
    private final h a;
    private final FutureTask b;
    private volatile g c = g.PENDING;
    final AtomicBoolean d = new AtomicBoolean();
    final AtomicBoolean e = new AtomicBoolean();

    /* renamed from: ir.nasim.kg4$a */
    static class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.a.getAndIncrement());
        }
    }

    /* renamed from: ir.nasim.kg4$b */
    class b extends h {
        b() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            AbstractC16083kg4.this.e.set(true);
            Object objB = null;
            try {
                Process.setThreadPriority(10);
                objB = AbstractC16083kg4.this.b(this.a);
                Binder.flushPendingCommands();
                return objB;
            } finally {
            }
        }
    }

    /* renamed from: ir.nasim.kg4$c */
    class c extends FutureTask {
        c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                AbstractC16083kg4.this.l(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (CancellationException unused) {
                AbstractC16083kg4.this.l(null);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* renamed from: ir.nasim.kg4$d */
    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g.values().length];
            a = iArr;
            try {
                iArr[g.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: ir.nasim.kg4$e */
    private static class e {
        final AbstractC16083kg4 a;
        final Object[] b;

        e(AbstractC16083kg4 abstractC16083kg4, Object... objArr) {
            this.a = abstractC16083kg4;
            this.b = objArr;
        }
    }

    /* renamed from: ir.nasim.kg4$f */
    private static class f extends Handler {
        f() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i = message.what;
            if (i == 1) {
                eVar.a.d(eVar.b[0]);
            } else {
                if (i != 2) {
                    return;
                }
                eVar.a.j(eVar.b);
            }
        }
    }

    /* renamed from: ir.nasim.kg4$g */
    public enum g {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: ir.nasim.kg4$h */
    private static abstract class h implements Callable {
        Object[] a;

        h() {
        }
    }

    static {
        a aVar = new a();
        f = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        g = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        h = threadPoolExecutor;
        j = threadPoolExecutor;
    }

    AbstractC16083kg4() {
        b bVar = new b();
        this.a = bVar;
        this.b = new c(bVar);
    }

    private static Handler e() {
        f fVar;
        synchronized (AbstractC16083kg4.class) {
            try {
                if (i == null) {
                    i = new f();
                }
                fVar = i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public final boolean a(boolean z) {
        this.d.set(true);
        return this.b.cancel(z);
    }

    protected abstract Object b(Object... objArr);

    public final AbstractC16083kg4 c(Executor executor, Object... objArr) {
        if (this.c == g.PENDING) {
            this.c = g.RUNNING;
            i();
            this.a.a = objArr;
            executor.execute(this.b);
            return this;
        }
        int i2 = d.a[this.c.ordinal()];
        if (i2 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i2 != 2) {
            throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    void d(Object obj) {
        if (f()) {
            g(obj);
        } else {
            h(obj);
        }
        this.c = g.FINISHED;
    }

    public final boolean f() {
        return this.d.get();
    }

    protected abstract void g(Object obj);

    protected abstract void h(Object obj);

    Object k(Object obj) {
        e().obtainMessage(1, new e(this, obj)).sendToTarget();
        return obj;
    }

    void l(Object obj) {
        if (this.e.get()) {
            return;
        }
        k(obj);
    }

    protected void i() {
    }

    protected void j(Object... objArr) {
    }
}
