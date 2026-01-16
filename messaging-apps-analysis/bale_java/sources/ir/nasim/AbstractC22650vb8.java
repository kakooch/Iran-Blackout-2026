package ir.nasim;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;

/* renamed from: ir.nasim.vb8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22650vb8 {
    private static final String a = HI3.f("WorkerFactory");

    /* renamed from: ir.nasim.vb8$a */
    class a extends AbstractC22650vb8 {
        a() {
        }

        @Override // ir.nasim.AbstractC22650vb8
        public ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
            return null;
        }
    }

    public static AbstractC22650vb8 c() {
        return new a();
    }

    public abstract ListenableWorker a(Context context, String str, WorkerParameters workerParameters);

    public final ListenableWorker b(Context context, String str, WorkerParameters workerParameters) {
        Class clsAsSubclass;
        ListenableWorker listenableWorkerA = a(context, str, workerParameters);
        if (listenableWorkerA == null) {
            try {
                clsAsSubclass = Class.forName(str).asSubclass(ListenableWorker.class);
            } catch (Throwable th) {
                HI3.c().b(a, "Invalid class: " + str, th);
                clsAsSubclass = null;
            }
            if (clsAsSubclass != null) {
                try {
                    listenableWorkerA = (ListenableWorker) clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
                } catch (Throwable th2) {
                    HI3.c().b(a, "Could not instantiate " + str, th2);
                }
            }
        }
        if (listenableWorkerA == null || !listenableWorkerA.l()) {
            return listenableWorkerA;
        }
        throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", getClass().getName(), str));
    }
}
