package ir.nasim;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.uD1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class ExecutorC21836uD1 implements Executor {
    public final /* synthetic */ Handler a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
