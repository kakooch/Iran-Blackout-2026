package ir.nasim;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: ir.nasim.cd2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11035cd2 {

    /* renamed from: ir.nasim.cd2$a */
    private static class a implements Executor {
        private final Handler a;

        a(Handler handler) {
            this.a = (Handler) AbstractC4980Hj5.g(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.a.post((Runnable) AbstractC4980Hj5.g(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.a + " is shutting down");
        }
    }

    public static Executor a(Handler handler) {
        return new a(handler);
    }
}
