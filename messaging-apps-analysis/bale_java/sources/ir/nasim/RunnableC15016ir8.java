package ir.nasim;

import com.google.android.gms.tasks.Task;

/* renamed from: ir.nasim.ir8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC15016ir8 implements Runnable {
    final /* synthetic */ Task a;
    final /* synthetic */ Mr8 b;

    RunnableC15016ir8(Mr8 mr8, Task task) {
        this.b = mr8;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.b) {
            try {
                Mr8 mr8 = this.b;
                if (mr8.c != null) {
                    mr8.c.a((Exception) AbstractC3795Cj5.j(this.a.k()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
