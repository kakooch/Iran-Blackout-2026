package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.jv8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class ExecutorC15646jv8 implements Executor {
    private final Handler a = new Og8(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
