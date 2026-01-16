package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.uT2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class ExecutorC21981uT2 implements Executor {
    private final Handler a;

    public ExecutorC21981uT2(Looper looper) {
        this.a = new Vp8(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
