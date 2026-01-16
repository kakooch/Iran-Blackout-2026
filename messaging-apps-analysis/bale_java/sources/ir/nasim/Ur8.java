package ir.nasim;

import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
final class Ur8 implements Runnable {
    final /* synthetic */ Task a;
    final /* synthetic */ C24596ys8 b;

    Ur8(C24596ys8 c24596ys8, Task task) {
        this.b = c24596ys8;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.b) {
            try {
                C24596ys8 c24596ys8 = this.b;
                if (c24596ys8.c != null) {
                    c24596ys8.c.onSuccess(this.a.l());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
