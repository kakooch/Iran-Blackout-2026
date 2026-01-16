package ir.nasim;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class LD0 {
    public static LD0 a(Executor executor, Handler handler) {
        return new VS(executor, handler);
    }

    public abstract Executor b();

    public abstract Handler c();
}
