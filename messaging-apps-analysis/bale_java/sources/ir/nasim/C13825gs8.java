package ir.nasim;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.FutureTask;

/* renamed from: ir.nasim.gs8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C13825gs8 extends FutureTask {
    final /* synthetic */ Bs8 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C13825gs8(Bs8 bs8, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.a = bs8;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a.a.f;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 37);
            sb.append("MeasurementExecutor: job failed with ");
            sb.append(strValueOf);
            Log.e("GAv4", sb.toString());
        }
        super.setException(th);
    }
}
