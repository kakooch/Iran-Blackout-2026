package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.ab8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C9811ab8 implements InterfaceC5684Kj7 {
    private final ExecutorC18549oq6 a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final Executor c = new a();

    /* renamed from: ir.nasim.ab8$a */
    class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            C9811ab8.this.d(runnable);
        }
    }

    public C9811ab8(Executor executor) {
        this.a = new ExecutorC18549oq6(executor);
    }

    @Override // ir.nasim.InterfaceC5684Kj7
    public Executor a() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC5684Kj7
    public void b(Runnable runnable) {
        this.a.execute(runnable);
    }

    @Override // ir.nasim.InterfaceC5684Kj7
    public ExecutorC18549oq6 c() {
        return this.a;
    }

    public void d(Runnable runnable) {
        this.b.post(runnable);
    }
}
