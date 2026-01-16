package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import ir.nasim.HI3;
import ir.nasim.PK4;
import ir.nasim.Ya8;

/* loaded from: classes2.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    private static final String a = HI3.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        HI3.c().a(a, "Requesting diagnostics", new Throwable[0]);
        try {
            Ya8.d(context).b(PK4.d(DiagnosticsWorker.class));
        } catch (IllegalStateException e) {
            HI3.c().b(a, "WorkManager is not initialized", e);
        }
    }
}
