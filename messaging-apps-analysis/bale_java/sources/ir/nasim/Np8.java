package ir.nasim;

import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
final class Np8 implements Runnable {
    final /* synthetic */ Task a;
    final /* synthetic */ Jq8 b;

    Np8(Jq8 jq8, Task task) {
        this.b = jq8;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.b) {
            try {
                Jq8 jq8 = this.b;
                if (jq8.c != null) {
                    jq8.c.onComplete(this.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
