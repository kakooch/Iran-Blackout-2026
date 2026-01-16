package androidx.work;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import ir.nasim.C5314Iu6;
import ir.nasim.InterfaceFutureC15215jC3;

/* loaded from: classes2.dex */
public abstract class Worker extends ListenableWorker {
    C5314Iu6 f;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Worker.this.f.p(Worker.this.r());
            } catch (Throwable th) {
                Worker.this.f.q(th);
            }
        }
    }

    @Keep
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public final InterfaceFutureC15215jC3 p() {
        this.f = C5314Iu6.t();
        c().execute(new a());
        return this.f;
    }

    public abstract ListenableWorker.a r();
}
